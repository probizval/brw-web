(function () {

  'use strict';

  angular
    .module('myApp')
    .run(run);

  run.$inject = ['authService', '$rootScope', 'propertyService'];
    
  function run(authService, $rootScope, propertyService) {
    // Handle the authentication
    // result in the hash
    authService.handleAuthentication();
    $rootScope.$on("$stateChangeStart", function(event, toState, toParams) { 
    	var requireLogin = toState.requireLogin;
    	var decodedToken = !localStorage.getItem('access_token') || parseJwt(localStorage.getItem('access_token'));
    	if(requireLogin && decodedToken) {
    		var location = window.location.hash;
    		    location = location.substring(1, location.length);
    		    sessionStorage.setItem("redirect_location",location);
    		authService.login();
    	}else {
    		let usermetadata = JSON.parse(sessionStorage.getItem('usermetadata'));
    		$rootScope.authService = authService;
	        $rootScope.isAuthenticated = authService.isAuthenticated();

	        if (authService.getCachedProfile()) {
	        	$rootScope.profile = authService.getCachedProfile();
	        } else {
	          authService.getProfile(function(err, profile) {
	        	  $rootScope.profile = profile;
                propertyService.saveProfile(profile).success(function(res) {
                     console.log("In homeController saveProfile "+ res);
                     if(res) {
                        localStorage.setItem('userprofile',JSON.stringify(res[0]));
                     }
                })
                .error(function (error) {
                    $scope.status = 'Unable to get profile: ' + error.message;
                });
	          });
	        }
    		!sessionStorage.getItem("profile") && usermetadata && propertyService.getProfile({'emailId':usermetadata.email,'firstName':usermetadata.given_name || '','lastName': usermetadata.family_name || '' })
    		.success(function(res) {
                sessionStorage.setItem("profile",JSON.stringify(res));
           })
           .error(function (error) {
               $scope.status = 'Unable to load user profile: ' + error.message;
           });
    	}
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