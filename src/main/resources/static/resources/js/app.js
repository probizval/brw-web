var myapp = angular.module('myApp', ['auth0.auth0', 'ui.router', 'propertyService']);
    //.config(config);

myapp.config.$inject = ['$routeProvider', '$httpProvider','angularAuth0Provider', 'propertyService'];


myapp.config(function($stateProvider, $urlRouterProvider, $uiViewScrollProvider, $httpProvider, angularAuth0Provider) {
	
	
	var lochash    = window.location.hash.substr(1),
    token =  localStorage.getItem('access_token') || lochash.substr(lochash.search(/(?<=^|&)access_token=/))
                  .split('&')[0]
                  .split('=')[1];
	
	if(lochash && token) {
		$httpProvider.defaults.headers.common['Access-Control-Allow-Origin'] = '*';
		$httpProvider.defaults.headers.common['Access-Control-Allow-Headers'] = 'Origin, X-Requested-With, Content-Type, Accept';
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
            requireLogin: true,
            resolve: {
            	propList: function(propertyService, $stateParams) {
            		 //return propertyService.getPropertyList($stateParams.type);
                     var obj = (localStorage.getItem('searchAddress')) || {};
                     return propertyService.getPropertyList(obj);
            	}
            }
        })
				.state('postBuy', {
					url: '/postBuy',
					templateUrl: 'resources/pages/postBuyRequirements.html',
					controller: 'postBuyRequirementsController',
					reload: true
				})
				.state('propertyDetails', {
            url: '/propertyDetails/:id',
            templateUrl: 'resources/pages/propertyDetails.html',
            controller: 'propertyDetailsController',
            reload: true,
            resolve: {
                propDetails: function(propertyService, $stateParams) {
                     return propertyService.getPropertyDetails($stateParams.id);
                },
                propImages: function(propertyService, propDetails) {
                		//return propertyService.getImagesByPropertyCode(propDetails.data[0].property_code)
                	return [];//Need to add service
								}
            }
        })
				.state('myProfile', {
            url: '/myProfile',
            templateUrl: 'resources/pages/myProfile.html',
            controller: 'myProfileController',
            reload: true
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

        .state('property', {
            url: '/property',
            templateUrl: 'resources/pages/nav.html'
        })
		        .state('property.addListing', {
		            url: '/addListing',
		            templateUrl: 'resources/pages/addListing.html',
		            controller: 'addListingController',
		            reload: true
		        })
		        .state('property.bookmarkedListing', {
		            url: '/bookmarkedListing',
		            templateUrl: 'resources/pages/bookmarkedListing.html',
		            controller: 'bookmarkedListingController',
		            reload: true
		        })
		        .state('property.myListing', {
		            url: '/myListing',
		            templateUrl: 'resources/pages/myListing.html',
		            controller: 'myListingController',
		            reload: true,
		            resolve: {
		            	propList: function(propertyService) {
		            		 return propertyService.getPropertyListByUser();
		            	}
		            }
		        })
		        .state('property.editProperty', {
		        	 url: '/editProperty/:id',
		             templateUrl: 'resources/pages/editListing.html',
		             controller: 'editPropertyDetailsController',
		             reload: true,
		             resolve: {
		                 propDetails: function(propertyService, $stateParams) {
		                      return propertyService.getPropertyDetails($stateParams.id);
		                 }
		             }
		        })
						.state('property.confirmation', {
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
						propList: function(propertyService, $stateParams) {
							var obj = (localStorage.getItem('searchAddress')) || {};
							return propertyService.getAgentsList(obj);
						}
					}
				})
        .state('businessBuyGuidance', {
            url: '/businessBuyGuidance',
            templateUrl: 'resources/pages/businessBuyGuidance.html'
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


