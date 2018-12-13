(function() {

  'use strict';

  angular
    .module('myApp')
    .controller('searchAgentsController', searchAgentsController);

  searchAgentsController.$inject = ['$document', '$rootScope', '$scope', '$state', 'authService' ,'propertyService'];
  var allServicesNeeded = [
												{id: 1, name: "Buying or Selling"},
												{id: 2, name: "Buying a Business"},
												{id: 3, name: "Selling a Business"}
											 ];

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

  var allSpecialities = [
    {id: 1, name: "Any"},
    {id: 2, name: "Buyer's Agent"},
    {id: 3, name: "Listing Agent"},
    {id: 4, name: "Foreclosure"},
    {id: 5, name: "Short sale"},
    {id: 6, name: "Consulting"},
    {id: 7, name: "Other"}];

  var yearOptions = ["2 Year", "5 year", "10 Year", "15+ Years"];
  var allLanguages = ["English", "Arabic", "Bengali", "Farsi", "Filipino", "French", "German", "Greek", "Hindi", "Hungarian",
    "Italian", "Japanese", "Korean", "Mandarin", "Polish", "Portuguese", "Russian", "Spanish", "Thai", "Turkish", "Vietnamese"];

  function searchAgentsController($document, $rootScope, $scope, $state, authService, propertyService) {
    var postal_code = '', latitude = '', longitude = '';
    $scope.servicesNeeded = allServicesNeeded;
    $scope.specialities = allSpecialities;
    $scope.yearsOfExperience = yearOptions;
    $scope.languages = allLanguages;
    $scope.businessCategories = allBusinessCategories;
    $scope.businessTypes = [];
    $scope.getBusinessType = function(){
      var key = $scope.businessCategories.indexOf($scope.businessCategory);
      var myNewOptions = allBusinessTypes[key];
      $scope.businessTypes = myNewOptions;
    };

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

    };
    $scope.searchAgents = function(searchAgentsForm) {
      if (searchAgentsForm.$invalid) {
        if (angular.element($document[0].querySelector('input.ng-invalid'))[0]) {
          console.log("Input focus", angular.element($document[0].querySelector('input.ng-invalid'))[0]);
          angular.element($document[0].querySelector('input.ng-invalid'))[0].focus();
          return false
        } else {
          console.log("Select focus", angular.element($document[0].querySelector('select.ng-invalid'))[0]);
          angular.element($document[0].querySelector('select.ng-invalid'))[0].focus();
          return false;
        }
      }
      console.log("postal_code " + postal_code + " latitude " + latitude + " longitude "+ longitude);
      var serviceNeededElement = document.getElementById("serviceNeeded");
      var propertyFor = serviceNeededElement.options[serviceNeededElement.selectedIndex].text;
      localStorage.setItem('searchAddress',JSON.stringify({
        type: propertyFor,
        postal_code: postal_code,
        latitude: latitude,
        longitude: longitude
      }));
      $state.go('listAgents', {
        type: propertyFor
      });
    };

    $scope.initialize();



  }

})();
