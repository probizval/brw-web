(function() {

  'use strict';

  angular
    .module('myApp')
    .controller('addListingController', addListingController);

  addListingController.$inject = ['$scope', '$state', 'propertyService'];
    function addListingController($scope, $state, propertyService) {
        
        $scope.property = {
                "propertyTitle": "",
                "image_url": "",
                "display_phone": 0,
                "propertyDescription": "",
                "bedrooms": "",
                "bathrooms": "",
                "price": 0,
                "address": "",
                "city": "",
                "state": "",
                "country": "",
                "zipcode": 0,
                "lat": 0,
                "lng": 0,
                "userName": "",
                "rentSale": "Buy",
                "sqFt": 0,
                "pricePerSqFt": 0,
                "mlsNumber": 0,
                "type": "",
                "rest": {
                    "cuisineType": "Indo",
                    "desc": "Indo Restaurant"
                },
                "gas": {
                    "brand": "SHELL",
                    "fuelType": "GAS"
                }
        };
        
        
        
        $scope.bedrooms = [
                         {numberofbeds:'0'},
                         {numberofbeds:'1'},
                         {numberofbeds:'2'}
                       ];
        $scope.bathrooms = [
                         {numberofbathrooms:'0'},
                         {numberofbathrooms:'1'},
                         {numberofbathrooms:'2'}
                       ];
        $scope.types = [
                         {name:'Restaurant', code:'b_type_1'},
                         {name:'Gas station', code:'b_type_2'},
                         {name:'Grocery store', code:'b_type_5'},
                         {name:'Liquor store', code:'b_type_3'},
                         {name:'Motels', code:'b_type_9'}
                       ];
        $scope.property.type = $scope.types[0];

        
        
        $scope.saveProperty = function() {
            
            $scope.property.lng = document.getElementById("lng").value;
            $scope.property.lat = document.getElementById("lat").value;
            $scope.property.city = document.getElementById("locality").value;
            $scope.property.zipcode = document.getElementById("postal_code").value;
            $scope.property.state = document.getElementById("administrative_area_level_1").value;
            $scope.property.country = document.getElementById("country").value;
            $scope.property.address = document.getElementById("address").value;
            $scope.property.userName = localStorage.getItem('userName');

            console.log($scope.property);
            $scope.property.userProfile = JSON.parse(localStorage.getItem('userprofile'));
            propertyService.savePropertyDetails($scope.property)
            .success(function(res) {
                 console.log("res "+ res);
                 console.log("res "+ res.status);
                 //$state.go("property.confirmation", {status: res.status});
                 $state.go("property.confirmation");
            })
            .error(function (error) {
                $scope.status = 'Unable to load store data: ' + error.message;
            });;
        }
        
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
                document.getElementById("address").value = place.name;
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

         $scope.change = function() {
            console.log($scope.property.type.name);
        };

        $scope.initialize();
        
      console.log('In addListingController');
    }    

})();
