(function () {

  'use strict';

  angular
    .module('myApp')
    .run(run);

  run.$inject = ['authService', '$rootScope', 'propertyService'];
    
  function run(authService, $rootScope, propertyService) {
    // Handle the authentication result in the hash
    authService.handleAuthentication();
    $rootScope.$on("$stateChangeStart", function(event, toState, toParams) {
        $rootScope.loader = true;
    	var requireLogin = toState.requireLogin;
    	var decodedToken = !localStorage.getItem('access_token') || parseJwt(localStorage.getItem('access_token'));
    	if(requireLogin && decodedToken) {
//    		var location = window.location.hash;
    		var location = window.location.href;
//            location = location.substring(1, location.length);
            sessionStorage.setItem("redirect_location", location);
    		authService.login();
    	}else {
    		let usermetadata = JSON.parse(sessionStorage.getItem('usermetadata'));
    		$rootScope.authService = authService;
	        $rootScope.isAuthenticated = authService.isAuthenticated();
            let cachedProfile = authService.getCachedProfile()
	        if (authService.getCachedProfile()) {
	        	$rootScope.profile = authService.getCachedProfile();
	        	!sessionStorage.getItem("profile") && usermetadata && propertyService.getUserProfile({'email':usermetadata.email})
                    .success(function(res) {
                        sessionStorage.setItem("profile",JSON.stringify(res));
                   })
                   .error(function (error, status) {
                       if (status == 404) {
                          propertyService.addUserProfile(profile).success(function(res) {
                                   if(res) {
                                      sessionStorage.setItem("profile",JSON.stringify(res));
                                   }
                              })
                          }
                   });
	        } else {
	          authService.getProfile(function(err, profile) {
	            $rootScope.profile = profile;
	        	!sessionStorage.getItem("profile") && usermetadata && propertyService.getUserProfile({'email':usermetadata.email})
                    .success(function(res) {
                        sessionStorage.setItem("profile",JSON.stringify(res));
                   })
                   .error(function (error, status) {
                        if (status == 404) {
                          propertyService.addUserProfile(profile).success(function(res) {
                                   if(res) {
                                      sessionStorage.setItem("profile",JSON.stringify(res));
                                   }
                              })
                        }
                       // roles is not in access_token
                       if (status == 401) {
                         return authService.refreshToken();
                       }
                   });
	          });
	        }
    	}
    });
    $rootScope.$on('$stateChangeSuccess', function(event, toState, toParams, fromState, fromParams){
        $rootScope.loader = false;
    });

  }

  function parseJwt (token) {
      var base64Url = token.split('.')[1];
      var base64 = base64Url.replace('-', '+').replace('_', '/');
      var isExpiredToken = false;
      var seconds = 1000;
      var d = new Date();
      var t= d.getTime();
      var decoded = JSON.parse(window.atob(base64));
      
      if (decoded.exp < Math.round(t / seconds)) {
    	  // code...
    	  isExpiredToken = true;
    	}
      return isExpiredToken;
  };

})();