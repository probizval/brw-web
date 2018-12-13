(function() {

  'use strict';

  angular
    .module('myApp')
    .controller('homeController', homeController);

    homeController.$inject = ['$rootScope', '$scope', '$state', 'authService' ,'propertyService'];

    function homeController($rootScope, $scope, $state, authService, propertyService) {
    	var postal_code = '', latitude = '', longitude = '';
    	$scope.initialize = function() {
    		// This example displays an address form, using the autocomplete feature
    	      // of the Google Places API to help users fill in the information.

    	      // This example requires the Places library. Include the libraries=places
    	      // parameter when you first load the API. For example:
    	      // <script src="https://maps.googleapis.com/maps/api/js?key=YOUR_API_KEY&libraries=places">

    	      var placeSearch, autocomplete;
    	      var componentForm = {
    	        street_number: 'short_name',
    	        route: 'long_name',
    	        locality: 'long_name',
    	        administrative_area_level_1: 'short_name',
    	        country: 'long_name',
    	        postal_code: 'short_name'
    	      };

    	        // Create the autocomplete object, restricting the search to geographical
    	        // location types.
    	        autocomplete = new google.maps.places.Autocomplete(
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
                latitude = lat;
                longitude = lng;
    	       /* for (var component in componentForm) {
    	          document.getElementById(component).value = '';
    	          document.getElementById(component).disabled = false;
    	        }*/

    	        // Get each component of the address from the place details
    	        // and fill the corresponding field on the form.
    	        for (var i = 0; i < place.address_components.length; i++) {
    	          var addressType = place.address_components[i].types[0];
    	          if (componentForm[addressType]) {
    	            var val = place.address_components[i][componentForm[addressType]];
                    if(addressType === 'postal_code') {
                        console.log('Postal code : '+val);
                        postal_code = val;
                    }
    	            //document.getElementById(addressType).value = val;
    	          }
    	        }
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
    	            $scope.$apply();
    	          });
    	        }
    	        
         }
           $scope.search = function() {
            console.log("postal_code " + postal_code + " latitude " + latitude + " longitude "+ longitude);
            var propertyFor = document.querySelector('input[name="searchin"]:checked').value;
            localStorage.setItem('searchAddress',JSON.stringify({
                type: propertyFor,
                postal_code: postal_code,
                latitude: latitude,
                longitude: longitude
            }));
            $state.go('search', {
                type: propertyFor
            });

            

            /*SET @location_lat = 37.4938, 
                    @location_lon = -121.93; 

                SELECT zip_code, ( 3959 * acos( cos( radians(@location_lat) ) * cos( radians( latitude ) ) * cos( radians( longitude ) - radians(@location_lon) ) + sin( radians(@location_lat) ) * sin( radians( latitude ) ) ) ) AS distance
                FROM property_details
                HAVING distance < 25;
                */
        }
         
    	$scope.initialize();

      

    }

})();
