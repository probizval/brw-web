var myapp = angular.module('myApp', ['auth0.auth0', 'ui.router', 'propertyService', 'ngSanitize']);
myapp.config.$inject = ['$routeProvider', '$httpProvider', 'angularAuth0Provider', 'propertyService'];
myapp.config(function ($stateProvider, $urlRouterProvider, $uiViewScrollProvider, $httpProvider, angularAuth0Provider) {


    var lochash = window.location.hash.substr(1),
        token = localStorage.getItem('access_token');

    if (lochash && token) {
        // $httpProvider.defaults.headers.common['Access-Control-Allow-Origin'] = '*';
        $httpProvider.defaults.headers.common['Content-Type'] = "application/json";
        // $httpProvider.defaults.headers.common['Access-Control-Allow-Headers'] = 'Origin, X-Requested-With, Content-Type, Accept';
        $httpProvider.defaults.headers.common['authorization'] = "Bearer " + token;
    }

    $httpProvider.defaults.useXDomain = true;
    delete $httpProvider.defaults.headers.common['X-Requested-With'];
    //$urlRouterProvider.otherwise('/index');
    $uiViewScrollProvider.useAnchorScroll();
    $urlRouterProvider.otherwise('/home');
    $stateProvider


    //adpages
        .state('home', {
            url: '/home',
            templateUrl: 'resources/pages/home.html',
            controller: 'homeController',
            reload: true
        })
        .state('sell', {
            url: '/sell',
            templateUrl: 'resources/pages/sell.html',
            controller: 'homeController',
            reload: true
        })
        .state('login', {
            url: '/login',
            templateUrl: 'resources/pages/login.html',
            controller: 'loginController',
            reload: true

        })
        .state('search', {
            url: '/search/:type',
            templateUrl: 'resources/pages/search.html',
            controller: 'searchController',
            reload: true,
            resolve: {
                propList: function (propertyService, $stateParams) {
                    var obj = (localStorage.getItem('searchBusinessAttributes')) || {};
                    return propertyService.getBusinessList(obj);
                }
            }
        })
        .state('postBuy', {
            url: '/postBuy',
            templateUrl: 'resources/pages/postBuyRequirements.html',
            controller: 'postBuyRequirementsController',
            reload: true,
            requireLogin: true
        })
        .state('businessDetails', {
            url: '/businessDetails/:id',
            templateUrl: 'resources/pages/businessDetails.html',
            controller: 'businessDetailsController',
            reload: true,
            requireLogin: true,
            resolve: {
                details: function (propertyService, $stateParams) {
                    // return propertyService.getPropertyDetails($stateParams.id);
                    return propertyService.getBusinessDetails($stateParams.id);
                },
//                estimates: function (propertyService, $stateParams) {
//                    return propertyService.getEstimates($stateParams.id)
//                },
                propImages: function (propertyService, $stateParams) {
                    return propertyService.getBusinessImages($stateParams.id)
                },
                // similarProps: function (propertyService) {
                //     //return propertyService.getBusinessDetails($stateParams.type);;
                //     var obj = (localStorage.getItem('searchBusinessAttributes')) || {};
                //     return propertyService.getBusinessDetails(obj);
                // }
            }
        })
        .state('myProfile', {
            url: '/myProfile',
            templateUrl: 'resources/pages/myProfile.html',
            controller: 'myProfileController',
            reload: true,
            resolve: {
                profileDetails: function (propertyService) {
                    let profile = JSON.parse(sessionStorage.getItem('profile'));
                    return propertyService.getUserProfile({"email": profile.email});
                }
            }
        })

        .state('accountSettings', {
            url: '/accountSettings',
            templateUrl: 'resources/pages/accountSettings.html'
        })
        .state('accountSettings.changePassword', {
            url: '/changePassword',
            templateUrl: 'resources/pages/changepassword.html'
        })
        .state('accountSettings.notification', {
            url: '/notification',
            templateUrl: 'resources/pages/notification.html'
        })
        .state('accountSettings.socialAccounts', {
            url: '/socialAccounts',
            templateUrl: 'resources/pages/socialAccounts.html'
        })

        .state('business', {
            url: '/business',
            templateUrl: 'resources/pages/nav.html'
        })
        .state('business.addListing', {
            url: '/addListing',
            templateUrl: 'resources/pages/addListingForm.html',
            controller: 'addListingController',
            reload: true,
            requireLogin: true
        })
        .state('business.bookmarkedListing', {
            url: '/bookmarkedListing',
            templateUrl: 'resources/pages/bookmarkedListing.html',
            controller: 'bookmarkedListingController',
            reload: true,
            resolve: {
                propList: function (propertyService) {
                    return propertyService.getBookMarkedPropertyListByUser(0);
                }
            }
        })
        .state('business.myListing', {
            url: '/myListing',
            templateUrl: 'resources/pages/myListing.html',
            controller: 'myListingController',
            reload: true,
            resolve: {
                propList: function (propertyService) {
//                    return propertyService.getPropertyListByUser(0);
                    return propertyService.getUserBusinesses();
                }
            }
        })
        .state('business.createSearchAgent', {
            url: '/createSearchAgent',
            templateUrl: 'resources/pages/createSearchAgentModal.html',
            controller: 'createSearchAgentController',
            reload: true,
            params: {
                fromSignIn: {squash: true, value: true},
                email: {squash: true, value: null},
            }
        })
        .state('business.listSearchAgent', {
            url: '/listSearchAgent',
            templateUrl: 'resources/pages/listSearchAgents.html',
            controller: 'listSearchAgentController',
            reload: true,
            resolve: {
                propDetails: function (propertyService) {
                    return propertyService.getSearchAgents();
                }
            }
        })

        .state('business.editBusiness', {
            url: '/editBusiness/:id',
            templateUrl: 'resources/pages/editListingForm.html',
            controller: 'editBusinessDetailsController',
            reload: true,
            resolve: {
                propDetails: function (propertyService, $stateParams) {
                    return propertyService.getBusinessDetails($stateParams.id);
                }
            }
        })
        .state('business.editProperty', {
            url: '/editProperty/:id',
            templateUrl: 'resources/pages/editListingForm.html',
            controller: 'editPropertyDetailsController',
            reload: true,
            resolve: {
                propDetails: function (propertyService, $stateParams) {
//                    return propertyService.getPropertyDetails($stateParams.id);
                    return propertyService.getBusinessDetails($stateParams.id);
                }
            }
        })
        .state('business.confirmation', {
            url: '/confirmation',
            templateUrl: 'resources/pages/confirmation.html'
        })

        .state('membershipPayment', {
            url: '/membershipPayment',
            templateUrl: 'resources/pages/membershipPayment.html'
        })
        .state('membershipPayment.membership', {
            url: '/membership',
            templateUrl: 'resources/pages/membership.html'
        })
        .state('membershipPayment.payment', {
            url: '/payment',
            templateUrl: 'resources/pages/payment.html'
        })

        .state('searchAgents', {
            url: '/searchAgents',
            templateUrl: 'resources/pages/searchAgents.html',
            controller: 'searchAgentsController',
            reload: true
        })
        .state('listAgents', {
            url: '/listAgents/:type',
            templateUrl: 'resources/pages/agentsListing.html',
            controller: 'listAgentsController',
            reload: true,
            resolve: {
                propList: function (propertyService, $stateParams) {
                    var obj = (localStorage.getItem('searchAddress')) || {};
                    return propertyService.getAgentsList(obj);
                }
            }
        })
        .state('businessBuyGuidance', {
            url: '/businessBuyGuidance',
            templateUrl: 'resources/pages/businessBuyGuidance.html',
            controller: 'businessBuyGuidanceController',
            reload: true
        })
        .state('businessSellGuidance', {
            url: '/businessSellGuidance',
            templateUrl: 'resources/pages/businessSellGuidance.html'
        })

        .state('postbuyconfirmation', {
            url: '/postbuyconfirmation',
            templateUrl: 'resources/pages/postbuyconfirmation.html',
            requireLogin: true
        })
        .state('profileconfirmation', {
            url: '/profileconfirmation',
            templateUrl: 'resources/pages/profileconfirmation.html',
            requireLogin: true
        })

        .state('contactUs', {
            url: '/contactUs',
            templateUrl: 'resources/pages/contactUs.html',
            controller: 'contactUsController',
            reload: true,
            params: {
                    businessId: {squash: true, value: null},
                    action: {squash: true, value: null},
                }
        })
        .state('aboutUs', {
            url: '/aboutUs',
            templateUrl: 'resources/pages/aboutUs.html',
        })
        .state('productsAndServices', {
            url: '/productsAndServices',
            templateUrl: 'resources/pages/productsAndServices.html',
        })
    ;

    // Initialization for the angular-auth0 library
    angularAuth0Provider.init({
        clientID: AUTH0_CLIENT_ID,
        domain: AUTH0_DOMAIN,
        responseType: 'token id_token',
        //audience: 'https://' + AUTH0_DOMAIN + '/userinfo',
        audience: 'https://' + AUTH0_DOMAIN + '/api/v2/',
        redirectUri: window.location.href,
        scope: 'openid profile email user_metadata app_metadata picture'
    });


});


