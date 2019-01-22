(function() {

  'use strict';

  angular
    .module('myApp')
    .controller('myProfileController', myProfileController)
    .directive('ngFileSelect', ngFileSelect)
    .factory('fileReader', fileReader);

  myProfileController.$inject = ['$scope', 'fileReader', 'authService'];
    function myProfileController($scope, fileReader, authService) {
      $scope.imageSrc = "";
      //$scope.profile = $rootScope.profile;
      
      $scope.uploadPicture = function (profile) {
        console.log("uploadPicture", profile);
        profile.picture = $scope.imageSrc;
        $scope.imageSrc = "";
        authService.setUserProfile(profile);
        // TODO update profile picture in database
      };
      $scope.cancelUpload = function () {
        $scope.imageSrc = "";
      };
      $scope.updateProfile = function() {
    	  console.log("update profile"+$scope.profile);
      };
      console.log('In myProfileController', fileReader);
      
      var autocomplete = new google.maps.places.Autocomplete(
	            /** @type {!HTMLInputElement} */(document.getElementById('autocomplete')),
	            {types: ['geocode']});

	        // When the user selects an address from the dropdown, populate the address
	        // fields in the form.
	        autocomplete.addListener('place_changed', fillInAddress);

	      function fillInAddress() {
	        // Get the place details from the autocomplete object.
	        var place = autocomplete.getPlace();

	        var lat = place.geometry.location.lat();
	        var lng = place.geometry.location.lng();


	       
        console.log("-------place----", place);
	      }

	      // Bias the autocomplete object to the user's geographical location,
	      // as supplied by the browser's 'navigator.geolocation' object.
	      function geolocate() {
	        if (navigator.geolocation) {
	          navigator.geolocation.getCurrentPosition(function(position) {
	            var geolocation = {
	              lat: position.coords.latitude,
	              lng: position.coords.longitude
	            };
	            var circle = new google.maps.Circle({
	              center: geolocation,
	              radius: position.coords.accuracy
	            });
	            autocomplete.setBounds(circle.getBounds());
	          });
	        }
	      }
    }

  ngFileSelect.$inject = ['fileReader', '$timeout'];
    function ngFileSelect(fileReader, $timeout) {
      return {
        scope: {
          ngModel: '='
        },
        link: function($scope, el) {
          function getFile(file) {
            fileReader.readAsDataUrl(file, $scope)
              .then(function(result) {
                $timeout(function() {
                  $scope.ngModel = result;
                });
              });
          }

          el.bind("change", function(e) {
            var file = (e.srcElement || e.target).files[0];
            getFile(file);
          });
        }
      };
    }

    fileReader.$inject = ['$q', '$log'];
    function fileReader($q, $log) {
      var onLoad = function(reader, deferred, scope) {
        return function() {
          scope.$apply(function() {
            deferred.resolve(reader.result);
          });
        };
      };

      var onError = function(reader, deferred, scope) {
        return function() {
          scope.$apply(function() {
            deferred.reject(reader.result);
          });
        };
      };

      var onProgress = function(reader, scope) {
        return function(event) {
          scope.$broadcast("fileProgress", {
            total: event.total,
            loaded: event.loaded
          });
        };
      };

      var getReader = function(deferred, scope) {
        var reader = new FileReader();
        reader.onload = onLoad(reader, deferred, scope);
        reader.onerror = onError(reader, deferred, scope);
        reader.onprogress = onProgress(reader, scope);
        return reader;
      };

      var readAsDataURL = function(file, scope) {
        var deferred = $q.defer();

        var reader = getReader(deferred, scope);
        reader.readAsDataURL(file);

        return deferred.promise;
      };

      return {
        readAsDataUrl: readAsDataURL
      };

    }

})();
