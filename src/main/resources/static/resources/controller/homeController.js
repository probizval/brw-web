(function () {

    'use strict';

    angular
        .module('myApp')
        .controller('homeController', homeController);

    homeController.$inject = ['$document', '$rootScope', '$scope', '$state', 'authService', 'propertyService', 'constants'];

    function homeController($document, $rootScope, $scope, $state, authService, propertyService, constants) {
        var postal_code = '', latitude = '', longitude = '';
        $scope.businessTypes = constants.searchBusinessTypes;
        $scope.businessStates = constants.businessStates;
        $scope.businessState = $scope.businessStates[4]; // california
        $scope.priceRangeList = constants.priceRangeList;
		$scope.priceRange = $scope.priceRangeList[0];
		propertyService.getStateCounties({'stateName': $scope.businessState.name})
	        .success(function(res) {
				$scope.businessCounties = res.data.countyList;
				$scope.businessCounty = $scope.businessCounties[0];
	        })
	        .error(function (error) {
	            $scope.status = 'Unable to load store data: ' + error.message;
	        });
        $scope.initialize = function () {
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
//            autocomplete = new google.maps.places.Autocomplete(
//                /** @type {!HTMLInputElement} */(document.getElementById('autocomplete')),
//                {types: ['geocode']});

            // When the user selects an address from the dropdown, populate the address
            // fields in the form.
//            autocomplete.addListener('place_changed', fillInAddress);

            function fillInAddress() {
                // Get the place details from the autocomplete object.
                var place = autocomplete.getPlace();
                var lat = place.geometry.location.lat();
                var lng = place.geometry.location.lng();
                latitude = lat;
                longitude = lng;
                for (var i = 0; i < place.address_components.length; i++) {
                    var addressType = place.address_components[i].types[0];
                    if (componentForm[addressType]) {
                        let val = place.address_components[i][componentForm[addressType]];
                        if (addressType === "locality") {
                            $scope.businessCity = $scope.businessCities.find( city  => city.label === val );
                            $scope.$apply();
                        }
                        if (addressType === "administrative_area_level_1") {
                            $scope.businessState = $scope.businessStates.find( state  => state.label === val );
                            $scope.$apply();
                        }
                    }
                }
                document.getElementById("address").value = place.name;
            }

            // Bias the autocomplete object to the user's geographical location,
            // as supplied by the browser's 'navigator.geolocation' object.
            function geolocate() {
                if (navigator.geolocation) {
                    navigator.geolocation.getCurrentPosition(function (position) {
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
        };
        $scope.getCounties = function () {
            propertyService.getStateCounties({'stateName': $scope.businessState.name})
            .success(function(res) {
              $scope.businessCounties = res.data.countyList;
              $scope.businessCounty = $scope.businessCounties[0];
            })
            .error(function (error) {
             $scope.status = 'Unable to load store data: ' + error.message;
            });
        }
        function getLatLng(address) {
            if (!address){
                return
            }
            var geocoder =  new google.maps.Geocoder();
            geocoder.geocode( { 'address': address}, function(results, status) {
              if (status === 'OK') {
                var existingAddress = localStorage.getItem('searchBusinessAttributes');
                existingAddress = existingAddress ? JSON.parse(existingAddress) : {};
                existingAddress['latitude'] = results[0].geometry.location.lat();
                existingAddress['longitude'] = results[0].geometry.location.lng();
                localStorage.setItem('searchBusinessAttributes', JSON.stringify(existingAddress));
              } else {
                console.log("Something got wrong " + status);
              }
            });
        }
        $scope.search = function (searchBusinessForm) {
            var businessType = "buy";
            // localStorage.setItem('searchAddress',JSON.stringify({
            //     type: businessType,
            //     postal_code: postal_code,
            //     latitude: latitude,
            //     longitude: longitude
            // }));
//            if (!latitude || !longitude && document.getElementById('autocomplete').value != null) {
//                getLatLng(document.getElementById('autocomplete').value);
//            }
//            var address = $scope.businessCity.label + ',' +$scope.businessState.code + ',' + $scope.businessZipcode;
//            getLatLng(address);
			latitude = $scope.businessCounty.latitude;
			longitude = $scope.businessCounty.longitude;
            localStorage.setItem('searchBusinessAttributes', JSON.stringify({
                businessName: document.getElementById("businessName").value,
                businessType: $scope.businessType.apiName,
                street1: document.getElementById("address").value,
                //street2:
                county: $scope.businessCounty.countyName,
                state: $scope.businessState.code,
//                zip: document.getElementById("postal_code").value,
                isForSell: $scope.isForSell,
                latitude: latitude,
                longitude: longitude,
                priceLow: $scope.priceRange.minPrice,
                priceHigh: $scope.priceRange.maxPrice,
            }));
            $state.go('search', {
                type: businessType
            });


            /*SET @location_lat = 37.4938,
                    @location_lon = -121.93;

                SELECT zip_code, ( 3959 * acos( cos( radians(@location_lat) ) * cos( radians( latitude ) ) * cos( radians( longitude ) - radians(@location_lon) ) + sin( radians(@location_lat) ) * sin( radians( latitude ) ) ) ) AS distance
                FROM property_details
                HAVING distance < 25;
                */
        };
        $scope.subscribe = function (subscribeBusiness) {
		    if (subscribeBusiness.$invalid) {
				if (angular.element($document[0].querySelector('input.ng-invalid'))[0]) {
					angular.element($document[0].querySelector('input.ng-invalid'))[0].focus();
					return false
				} else if (angular.element($document[0].querySelector('textarea.ng-invalid'))[0]) {
					angular.element($document[0].querySelector('textarea.ng-invalid'))[0].focus();
					return false
				}
            }
			$state.go('business.createSearchAgent', {fromSignIn: true, email: $scope.subscribeEmail}, {reload: true})
        }
//        $scope.initialize();
    }

})();
