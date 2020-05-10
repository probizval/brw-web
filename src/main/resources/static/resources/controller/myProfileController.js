(function() {

  'use strict';

  angular
    .module('myApp')
    .controller('myProfileController', myProfileController)
    .directive('ngFileSelect', ngFileSelect)
    .factory('fileReader', fileReader);

  myProfileController.$inject = ['$scope', '$state', 'fileReader', 'authService','profileDetails', 'propertyService'];
    function myProfileController($scope, $state, fileReader, authService, profileDetails, propertyService) {
      $scope.imageSrc = "";
      $scope.profileDetails = profileDetails.data;
      
      $scope.uploadPicture = function (profile) {
        profile.picture = $scope.imageSrc;
        $scope.imageSrc = "";
        authService.setUserProfile(profile);
        // TODO update profile picture in database
      };
      $scope.cancelUpload = function () {
        $scope.imageSrc = "";
      };
      $scope.updateProfile = function() {
    	  $scope.profileDetails.city = document.getElementById("locality").value;
    	  $scope.profileDetails.address = document.getElementById("address").value;
    	  $scope.profileDetails.location = document.getElementById("location").value;
    	  $scope.profileDetails.state = document.getElementById("administrative_area_level_1").value;
    	  $scope.profileDetails.country = document.getElementById("country").value;
    	  $scope.profileDetails.zipcode = document.getElementById("postal_code").value;
    	  
    	  
    	  propertyService.updateProfile($scope.profileDetails)
          .success(function(res) {
                 $state.go("profileconfirmation", {status: res.status});
                 //$state.go("business.confirmation");
            })
            .error(function (error) {
                $scope.status = 'Unable to load store data: ' + error.message;
            });
      };

      var autocomplete = new google.maps.places.Autocomplete(
	            /** @type {!HTMLInputElement} */(document.getElementById('location')),
	            {types: ['geocode']});

	        // When the user selects an address from the dropdown, populate the address
	        // fields in the form.
	        autocomplete.addListener('place_changed', fillInAddress);

	      function fillInAddress() {
	        // Get the place details from the autocomplete object.
	        var place = autocomplete.getPlace();

	        var lat = place.geometry.location.lat();
	        var lng = place.geometry.location.lng();
	        var componentForm = {
	    	        locality: 'long_name',
	    	        administrative_area_level_1: 'short_name',
	    	        country: 'long_name',
	    	        postal_code: 'short_name'
	    	      };
	        
	        /*for (var component in componentForm) {
 	    	   if(document.getElementById(component)) {
 	    		   document.getElementById(component).value = '';
 	    		   document.getElementById(component).disabled = false;
 	    	   }
 	        }*/

	        for (var i = 0; i < place.address_components.length; i++) {
  	          var addressType = place.address_components[i].types[0];
  	          if (componentForm[addressType] && document.getElementById(addressType)) {
  	            var val = place.address_components[i][componentForm[addressType]];
  	            document.getElementById(addressType).value = val;
  	          }
  	        }
	        document.getElementById("address").value  = place.formatted_address;
	        
	       
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
