(function() {

  'use strict';

  angular
    .module('myApp')
    .controller('postBuyRequirementsController', postBuyRequirementsController);

  postBuyRequirementsController.$inject = ['$document', '$scope', '$state', 'propertyService'];

  var allBusinessCategories = [
                                {id: 1, name: "Automotive & Vehicle Related"},
                                {id: 2, name: "Health, Medical, Fitness, Beauty Related"},
                                {id: 3, name: "Restaurant and Food Related Businesses"},
                                {id: 4, name: "Retail Related Businesses"},
                                {id: 5, name: "Service Related Businesses"},
                                {id: 6, name: "Travel & Recreation Related"},
                                {id: 7, name: "Other"}];

  var allBusinessTypes = [
                          ["Auto Repair", "Car Washes, Detailers", "Other"],
                          ["Barber Shop", "Beauty Service", "Salon, Beauty Salon", "Other"],
                          ["Bakery", "Bar, Pub, Sports Bar, Lounge, Tavern", "Cafe, Cafeteria", "Dine In Restaurant", "Other"],
                          ["Convenience Store", "Liquor Store", "Other"],
                          ["Coin Laundry, Laundromat", "Gas Station", "Other"],
                          ["Motel", "Inn", "Other"]];

  function postBuyRequirementsController($document, $scope, $state, propertyService) {
      $scope.businessCategories = allBusinessCategories;
      $scope.businessTypes = [];
      $scope.getBusinessType = function(){
        var key = $scope.businessCategories.indexOf($scope.businessCategory);
        var myNewOptions = allBusinessTypes[key];
        $scope.businessTypes = myNewOptions;
      };

    	$scope.business = {
    	  "userId": 1,
          "businessCategory": "",
          "otherBusinessCategory":  "",
          "otherBusinessType":  "",
          "businessType": "",
          "businessLocation": "",
		  "address": "",
		  "city": "",
		  "state": "",
		  "country": "",
		  "zipCode": 0,
		  "latitude": 0,
		  "longitude": 0,
          "radius": 0,
          "minPrice": 0,
          "maxPrice": 0,
          "minLotSize": 0,
          "maxLotSize": 0,
          "businessDescription": "",
          "firstName": "",
          "lastName": "",
          "contactNumber":  0,
          "emailAdress": "",
          "modeOfContact":  "E-mail",
          "isConnectWithLocalAgents": true,
          "isSendMatchedBusinessesEmail": true
    	};
    	
    	/*{
            "userId": 1,
            "businessCategory": "Automotive",
            "businessType": "Auto",
            "otherBusinessCategory": null,
            "otherBusinessType": null,
            "radius": 20,
            "minPrice": 0,
            "maxPrice": 0,
            "minLotSize": 0,
            "maxLotSize": 0,
            "businessDescription": null,
            "businessLocation": "Fremont",
            "address": null,
            "city": null,
            "state": null,
            "country": null,
            "zip_code": 0,
            "latitude": null,
            "longitude": null,
            "firstName": "Abhi",
            "lastName": null,
            "emailAdress": "gmail",
            "contactNumber": "54655",
            "modeOfContact": "call",
            "isConnectWithLocalAgents": null,
            "isSendMatchedBusinessEmail": null
        }*/

      $scope.contactInformation = {
        "firstName": "",
        "lastName": "",
        "phoneNumber":  0,
        "emailAddress": "",
        "modeOfContact":  "E-mail",
        "connectWithLocalAgents": true,
        "sendMatchedBusinessesEmail": true
      };

     $scope.radius = 25;
     $scope.modeOfContact = "E-mail";
     $scope.isConnectWithLocalAgents = true;
     $scope.isSendMatchedBusinessesEmail = true;

     $scope.initialize = function() {
    		// This example displays an address form, using the autocomplete feature
    	      // of the Google Places API to help users fill in the information.

    	      // This example requires the Places library. Include the libraries=places
    	      // parameter when you first load the API. For example:
    	      // <script src="https://maps.googleapis.com/maps/api/js?key=YOUR_API_KEY&libraries=places">

    	      var placeSearch, autocomplete;
    	      var componentForm = {
    	        locality: 'long_name',
    	        administrative_area_level_1: 'short_name',
    	        country: 'short_name',
    	        postal_code: 'short_name'
    	      };
    	      
    	      var profile = sessionStorage.getItem("profile");
    	      profile = JSON.parse(profile);
    	      $scope.business.firstName = profile.firstName || '';
    	      $scope.business.lastName = profile.lastName || '';
    	      $scope.business.emailAdress = profile.emailId || '';
    	      $scope.business.contactNumber = profile.contactNumber || '';
    	      $scope.business.userId = profile.id || 1;

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


    	       for (var component in componentForm) {
    	    	   if(document.getElementById(component)) {
    	    		   document.getElementById(component).value = '';
    	    		   document.getElementById(component).disabled = false;
    	    	   }
    	        }

    	        // Get each component of the address from the place details
    	        // and fill the corresponding field on the form.
    	        for (var i = 0; i < place.address_components.length; i++) {
    	          var addressType = place.address_components[i].types[0];
    	          if (componentForm[addressType] && document.getElementById(addressType)) {
    	            var val = place.address_components[i][componentForm[addressType]];
    	            document.getElementById(addressType).value = val;
    	          }
    	        }
              console.log("-------place----", place);
    	        document.getElementById("address").value = place.name;
              $scope.location = place.formatted_address;
    	        document.getElementById("lat").value = lat;
    	        document.getElementById("lng").value = lng;
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
         $scope.saveBuyBusinessRequirements = function(postBuyForm) {
            if (postBuyForm.$invalid) {
              if (angular.element($document[0].querySelector('select.ng-invalid'))[0]) {
                console.log("Select focus", angular.element($document[0].querySelector('select.ng-invalid'))[0])
                angular.element($document[0].querySelector('select.ng-invalid'))[0].focus();
                return false;
              } else {
                console.log("Input focus", angular.element($document[0].querySelector('input.ng-invalid'))[0])
                angular.element($document[0].querySelector('input.ng-invalid'))[0].focus();
                return false
              }
            }
            $scope.business.businessCategory = $scope.businessCategory.name;
            $scope.business.businessType = $scope.businessType;

            if ($scope.businessCategory.name && $scope.businessCategory.name != 'Other') {
              $scope.business.otherBusinessCategory = "";
              $scope.business.otherBusinessType = "";
            } else {
              $scope.business.otherBusinessCategory = $scope.otherBusinessCategory;
            }

            if ($scope.businessType && $scope.businessType != 'Other') {
              $scope.business.otherBusinessType = "";
            } else {
              $scope.business.otherBusinessType = $scope.otherBusinessType;
            }

            if ($scope.radius == 'specifiedMiles') {
              $scope.business.radius = $scope.radiusInMiles
            } else {
              $scope.business.radius = $scope.radius;
            }

            /*if (document.getElementById("minPrice").value) {
              $scope.business.minPrice = document.getElementById("minPrice").value;
            }
            if (document.getElementById("maxPrice").value) {
              $scope.business.maxPrice = document.getElementById("maxPrice").value;
            }
            if (document.getElementById("minLotSize").value) {
              $scope.business.minLotSize = document.getElementById("minLotSize").value;
            }
            if (document.getElementById("maxLotSize").value) {
              $scope.business.maxLotSize = document.getElementById("maxLotSize").value;
            }
            if ($scope.businessDescription) {
              $scope.business.businessDescription = $scope.businessDescription;
            }
            */
            if (document.getElementById("lng").value) {
              $scope.business.longitude = document.getElementById("lng").value;
            }
            if (document.getElementById("lat").value){
               $scope.business.latitude = document.getElementById("lat").value;
            }

            $scope.business.city = document.getElementById("locality").value;
            if (document.getElementById("zipCode").value) {
              $scope.business.zipCode = document.getElementById("zipCode").value;
            }
            if ($scope.location) {
                $scope.business.businessLocation = $scope.location
            }

           $scope.business.state = document.getElementById("administrative_area_level_1").value;
           /* $scope.business.country = document.getElementById("country").value;
            $scope.business.address = document.getElementById("address").value;
            $scope.business.userName = localStorage.getItem('userName');
            $scope.business.userId = 10 //TODO need to map with userid
            $scope.business.firstName = document.getElementById("firstName").value
            $scope.business.lastName = document.getElementById("lastName").value
            if (document.getElementById("phoneNumber").value){
              $scope.business.contactNumber = document.getElementById("phoneNumber").value
            }

            $scope.business.emailAddress = document.getElementById("emailAddress").value*/
            //$scope.business.modeOfContact = $scope.modeOfContact
            //$scope.business.isConnectWithLocalAgents = $scope.isConnectWithLocalAgents
            //$scope.business.isSendMatchedBusinessesEmail = $scope.isSendMatchedBusinessesEmail

            console.log($scope.business, $scope.contactInformation, $scope.business.userProfile);
            $scope.business.userProfile = JSON.parse(localStorage.getItem('userprofile'));
            propertyService.sendEmailWithBuyRequirements($scope.business)
              .success(function(res) {
                     console.log("res "+ res);
                     console.log("res "+ res.status);
                     $state.go("postbuyconfirmation", {status: res.status});
                     //$state.go("property.confirmation");
                })
                .error(function (error) {
                    $scope.status = 'Unable to load store data: ' + error.message;
                });
          }

    	$scope.initialize();

      console.log('In postBuyRequirementsController');
    }

})();
