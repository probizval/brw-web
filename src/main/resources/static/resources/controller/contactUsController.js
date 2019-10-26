(function() {

  'use strict';

  angular
    .module('myApp')
    .controller('contactUsController', contactUsController);

  contactUsController.$inject = ['$document', '$scope', '$state', '$timeout'];
    function addListingController($document, $scope, $state, $timeout) {

        $scope.propertyMetaData = {};

        $scope.sendContactUsEmail = function(contactUs) {
            // if (addListingForm.$invalid) {
            //   if (angular.element($document[0].querySelector('select.ng-invalid'))[0]) {
            //     console.log("Select focus", angular.element($document[0].querySelector('select.ng-invalid'))[0]);
            //     angular.element($document[0].querySelector('select.ng-invalid'))[0].focus();
            //     return false;
            //   } else {
            //     console.log("Input focus", angular.element($document[0].querySelector('input.ng-invalid'))[0]);
            //     angular.element($document[0].querySelector('input.ng-invalid'))[0].focus();
            //     return false
            //   }
            // }
            //
            //
            // $scope.uploadPhotoOnAWS();
            // var apiName = $scope.propertyMetaData.businessType.apiName;
            // $scope.propertyMetaData.longitude = document.getElementById("lng").value;
            // $scope.propertyMetaData.latitude = document.getElementById("lat").value;
            // $scope.propertyMetaData.city = document.getElementById("locality").value;
            // $scope.propertyMetaData.zipCode = document.getElementById("postal_code").value;
            // $scope.propertyMetaData.state = document.getElementById("administrative_area_level_1").value;
            // $scope.propertyMetaData.country = document.getElementById("country").value;
            // $scope.propertyMetaData.propertyAddress = document.getElementById("address").value;
            // $scope.propertyMetaData.location = document.getElementById("autocomplete").value;
            // $scope.propertyMetaData.businessType = $scope.propertyMetaData.businessType.name;
            // // $scope.propertyMetaData.imageUrl = "https://s3-us-east-1.amazonaws.com/bizrealworth-image/2.jpg";
            //
            //
            // $scope.business = angular.extend($scope.property.rest, $scope.property.gas, $scope.property.beautySalon,
            //   $scope.property.laundry, $scope.property.dryCleaners, $scope.property.liquorStore);
            // $scope.business.propertyImages = $scope.propertyImages;
            // $scope.business.propertyMetaData = $scope.propertyMetaData;
            // console.log($scope.propertyImages, $scope.propertyMetaData, $scope.business);
            //
            // //TODO need to get userid
            // var userProfile = JSON.parse(sessionStorage.getItem('profile'));
            // $scope.propertyMetaData.userId = userProfile.id;
            //
            // propertyService.savePropertyDetails(apiName, $scope.business)
            // .success(function(res) {
            //      console.log("res ", res);
            //      console.log("res ", res.status);
            //      //$state.go("property.confirmation", {status: res.status});
            //      $state.go("property.confirmation");
            // })
            // .error(function (error) {
            //     $scope.status = 'Unable to load store data: ' + error.message;
            // });
        };
        
        $scope.initialize = function() {};

      $scope.initialize();
        
      console.log('In contactUsController');
    }    

})();
