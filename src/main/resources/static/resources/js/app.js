var myapp = angular.module('myApp', ['auth0.auth0', 'ui.router', 'propertyService', 'ngSanitize']);
myapp.config.$inject = ['$routeProvider', '$httpProvider', 'angularAuth0Provider', 'propertyService'];
myapp.config(function ($stateProvider, $urlRouterProvider, $uiViewScrollProvider, $httpProvider, $locationProvider,
	angularAuth0Provider) {

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
    $uiViewScrollProvider.useAnchorScroll();
//    $locationProvider.html5Mode(true);
    $urlRouterProvider.otherwise('/');
    $stateProvider


    //adpages
        .state('home', {
            url: '/',
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
            templateUrl: 'resources/pages/search_business.html',
            controller: 'searchController',
            reload: true,
            resolve: {
                propList: function (propertyService, $stateParams) {
                    var obj = (localStorage.getItem('searchBusinessAttributes')) || {};
                    return propertyService.getBusinessList(obj);
                }
            }
        })
        .state('post_buy', {
            url: '/post_buy',
            templateUrl: 'resources/pages/postBuyRequirements.html',
            controller: 'postBuyRequirementsController',
            reload: true,
            requireLogin: true
        })
        .state('business_details', {
            url: '/business_details/:id',
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
        .state('my_profile', {
            url: '/my_profile',
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

        .state('account_settings', {
            url: '/account_settings',
            templateUrl: 'resources/pages/accountSettings.html'
        })
        .state('account_settings.change_password', {
            url: '/change_password',
            templateUrl: 'resources/pages/changepassword.html'
        })
        .state('account_settings.notification', {
            url: '/notification',
            templateUrl: 'resources/pages/notification.html'
        })
        .state('account_settings.social_accounts', {
            url: '/social_accounts',
            templateUrl: 'resources/pages/socialAccounts.html'
        })

        .state('business', {
            url: '/business',
            templateUrl: 'resources/pages/nav.html'
        })
        .state('business.add_listing', {
            url: '/add_listing',
            templateUrl: 'resources/pages/addListingForm.html',
            controller: 'addListingController',
            reload: true,
            requireLogin: true
        })
        .state('business.bookmarked_listing', {
            url: '/bookmarked_listing',
            templateUrl: 'resources/pages/bookmarkedListing.html',
            controller: 'bookmarkedListingController',
            reload: true,
            resolve: {
                propList: function (propertyService) {
                    return propertyService.getBookMarkedPropertyListByUser(0);
                }
            }
        })
        .state('business.my_listing', {
            url: '/my_listing',
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
        .state('business.create_search_agent', {
            url: '/create_search_agent',
            templateUrl: 'resources/pages/createSearchAgentModal.html',
            controller: 'createSearchAgentController',
            reload: true,
            params: {
                fromSignIn: {squash: true, value: true},
                email: {squash: true, value: null},
            }
        })
        .state('business.list_search_agent', {
            url: '/list_search_agent',
            templateUrl: 'resources/pages/listSearchAgents.html',
            controller: 'listSearchAgentController',
            reload: true,
            resolve: {
                propDetails: function (propertyService) {
                    return propertyService.getSearchAgents();
                }
            }
        })

        .state('business.edit_business', {
            url: '/edit_business/:id',
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

        .state('membership_payment', {
            url: '/membership_payment',
            templateUrl: 'resources/pages/membershipPayment.html'
        })
        .state('membership_payment.membership', {
            url: '/membership',
            templateUrl: 'resources/pages/membership.html'
        })
        .state('membership_payment.payment', {
            url: '/payment',
            templateUrl: 'resources/pages/payment.html'
        })

        .state('search_agents', {
            url: '/search_agents',
            templateUrl: 'resources/pages/searchAgents.html',
            controller: 'searchAgentsController',
            reload: true
        })
        .state('list_agents', {
            url: '/list_agents/:type',
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
        .state('business_buying_guidance', {
            url: '/business_buying_guidance',
            templateUrl: 'resources/pages/business_buying_guidance.html',
            controller: 'businessBuyGuidanceController',
            reload: true
        })
        .state('business_selling_guidance', {
            url: '/business_selling_guidance',
            templateUrl: 'resources/pages/business_selling_guidance.html'
        })

        .state('post_buy_confirmation', {
            url: '/post_buy_confirmation',
            templateUrl: 'resources/pages/postbuyconfirmation.html',
            requireLogin: true
        })
        .state('profile_confirmation', {
            url: '/profile_confirmation',
            templateUrl: 'resources/pages/profileconfirmation.html',
            requireLogin: true
        })
		.state('terms_of_service', {
            url: '/terms_of_service',
            templateUrl: 'resources/pages/termsOfService.html',
        })
		.state('privacy_policy', {
            url: '/privacy_policy',
            templateUrl: 'resources/pages/privacyPolicy.html',
        })
        .state('contact_us', {
            url: '/contact_us',
            templateUrl: 'resources/pages/contact_us.html',
            controller: 'contactUsController',
            reload: true,
            params: {
                    businessId: {squash: true, value: null},
                    action: {squash: true, value: null},
                }
        })
        .state('about_us', {
            url: '/about_us',
            templateUrl: 'resources/pages/about_us.html',
        })
        .state('products_and_services', {
            url: '/products_and_services',
            templateUrl: 'resources/pages/products_and_services.html',
        })
	.state('how_to_select_business_valuation_expert', {
            url: '/how_to_select_business_valuation_expert',
            templateUrl: 'resources/pages/how_to_select_business_valuation_expert.html',
        })
	.state('claim_your_business', {
            url: '/claim_your_business',
            templateUrl: 'resources/pages/claimYourBusiness.html',
        })
	.state('find_value_of_business', {
            url: '/find_value_of_business',
            templateUrl: 'resources/pages/find_value_of_business.html',
        })
	.state('register_as_bsps', {
            url: '/register_as_bsps',
            templateUrl: 'resources/pages/registerAsBSPs.html',
        })
	.state('search_business_for_sale', {
            url: '/search_business_for_sale',
            templateUrl: 'resources/pages/search_business_for_sale.html',
        })
	.state('sell_a_business', {
            url: '/sell_a_business',
            templateUrl: 'resources/pages/sell_a_business.html',
        })
	.state('buyers_faq', {
            url: '/buyers_faq',
            templateUrl: 'resources/pages/buyers_faq.html',
        })
	.state('sellers_faq', {
            url: '/sellers_faq',
            templateUrl: 'resources/pages/sellers_faq.html',
        })
	.state('general_faq', {
            url: '/general_faq',
            templateUrl: 'resources/pages/general_faq.html',
        })
	.state('service_fees_faq', {
            url: '/service_fees_faq',
            templateUrl: 'resources/pages/service_fees_faq.html',
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


