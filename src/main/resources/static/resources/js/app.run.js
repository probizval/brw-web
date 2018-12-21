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
    	var decodedToken = !localStorage.getItem('access_token') || parseJwt(localStorage.getItem('access_token'));
    	if(requireLogin && decodedToken) {
    		authService.login();
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