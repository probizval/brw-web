(function () {

  'use strict';

  angular
    .module('myApp')
    .run(run);

  run.$inject = ['authService', '$rootScope'];
    
  function run(authService, $rootScope) {
    // Handle the authentication
    // result in the hash
    authService.handleAuthentication();
    $rootScope.$on("$stateChangeStart", function(event, toState, toParams) { 
    	var requireLogin = toState.requireLogin;
    	if(requireLogin && !localStorage.getItem('access_token')) {
    		authService.login();
    	}   
    });
  }

})();