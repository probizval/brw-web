(function () {

  'use strict';

  angular
    .module('myApp')
    .service('authService', authService);

  authService.$inject = ['$state', 'angularAuth0', '$timeout', '$location'];

  function authService($state, angularAuth0, $timeout, $location) {

    var userProfile;

    function login() {
      var location_hash = window.location.hash;
      var location = window.location.href;
//      location = location.substring(2, location.length);
      sessionStorage.setItem("redirect_location", location);
      sessionStorage.setItem("redirect_hash", location_hash);
      angularAuth0.authorize({redirectUri: location});
    }
    
    function handleAuthentication() {
      angularAuth0.parseHash(function(err, authResult) {
        if (authResult && authResult.idToken) {
          setSession(authResult);
          var redirect_location = sessionStorage.getItem("redirect_location");
          window.location.href = redirect_location
          location.reload();
//          if (redirect_location.includes("/")){
//            let sub_type = redirect_location.split("/")[1]
//            redirect_location = redirect_location.split("/")[0]
//
//            $state.go(redirect_location, {type: sub_type}, { reload: true })
//          } else {
//            $state.go(redirect_location, {}, { reload: true })
//          }
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
      console.log("getProfile", accessToken)
      if (!accessToken) {
        console.log('Access token must exist to fetch profile');
//        throw new Error('Access token must exist to fetch profile');
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
      localStorage.removeItem('userprofile');
      sessionStorage.removeItem('usermetadata');
      sessionStorage.removeItem('profile');
      var redirect_location = window.location.href
      var redirect_location1 = sessionStorage.getItem("redirect_location");
      sessionStorage.removeItem("redirect_location")
      console.log("------logout------", redirect_location, redirect_location1)
      angularAuth0.logout({
        "returnTo": window.location.href,
        "client_id": AUTH0_CLIENT_ID
      });
    }
    
    function isAuthenticated() {
      // Check whether the current time is past the 
      // access token's expiry time
      let expiresAt = JSON.parse(localStorage.getItem('expires_at'));
      return new Date().getTime() < expiresAt;
    }

    function refreshToken() {
        angularAuth0.checkSession({}, function(err, authResult) {
            if (authResult) {
                setSession(authResult);
                location.reload();
            } else if (err) {
                $timeout(function() {
                   location.reload();
                });
                console.log(err);
            }
      });
    }

    return {
      login: login,
      getProfile: getProfile,
      getCachedProfile: getCachedProfile,
      handleAuthentication: handleAuthentication,
      logout: logout,
      isAuthenticated: isAuthenticated,
      refreshToken: refreshToken,
    }
  }
})();
