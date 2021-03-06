(function () {

  'use strict';

  angular
    .module('myApp')
    .service('authService', authService);

  authService.$inject = ['$state', 'angularAuth0', '$timeout', '$location'];

  function authService($state, angularAuth0, $timeout, $location) {

    var userProfile;

    function login() {
      angularAuth0.authorize();
    }
    
    function handleAuthentication() {
      angularAuth0.parseHash(function(err, authResult) {
        if (authResult && authResult.idToken) {
          setSession(authResult);
          //$state.go('propertyDetails',{id:3}, {'reload':false});
          var redirect_location = sessionStorage.getItem("redirect_location");
          sessionStorage.removeItem('redirect_location');
          $location.path(redirect_location);
        } else if (err) {
          $timeout(function() {
            $state.go('home',null, {'reload':true});
          });
          console.log(err);
          alert('Error: ' + err.error + '. Check the console for further details.');
        }
      });
    }

    function getProfile(cb) {
      var accessToken = localStorage.getItem('access_token');
      if (!accessToken) {
        //throw new Error('Access token must exist to fetch profile');
      } else {
        angularAuth0.client.userInfo(accessToken, function(err, profile) {
          if (profile) {
            setUserProfile(profile);
          }
          cb(err, profile);
        });
      }
    }

    function setUserProfile(profile) {
      userProfile = profile;
    }

    function getCachedProfile() {
      return userProfile;
    }

    function setSession(authResult) {
      // Set the time that the access token will expire at
      let expiresAt = JSON.stringify((authResult.expiresIn * 1000) + new Date().getTime());
      localStorage.setItem('access_token', authResult.accessToken);
      localStorage.setItem('id_token', authResult.idToken);
      localStorage.setItem('expires_at', expiresAt);
      localStorage.setItem('userName', authResult.idTokenPayload.name);
      sessionStorage.setItem('usermetadata',  JSON.stringify(authResult.idTokenPayload));
      //location.reload();
    }
    
    function logout() {
      // Remove tokens and expiry time from localStorage
      localStorage.removeItem('access_token');
      localStorage.removeItem('id_token');
      localStorage.removeItem('expires_at');
      localStorage.removeItem('userName');
      sessionStorage.removeItem('usermetadata');
      sessionStorage.removeItem('profile');
      location.reload();
    }
    
    function isAuthenticated() {
      // Check whether the current time is past the 
      // access token's expiry time
      let expiresAt = JSON.parse(localStorage.getItem('expires_at'));
      return new Date().getTime() < expiresAt;
    }

    return {
      login: login,
      getProfile: getProfile,
      getCachedProfile: getCachedProfile,
      handleAuthentication: handleAuthentication,
      logout: logout,
      isAuthenticated: isAuthenticated
    }
  }
})();
