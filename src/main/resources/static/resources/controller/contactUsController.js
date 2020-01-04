(function() {

  'use strict';

  angular
    .module('myApp')
    .controller('contactUsController', contactUsController);

  contactUsController.$inject = ['$document', '$scope', '$state', 'propertyService', '$timeout'];
    function contactUsController($document, $scope, $state, propertyService, $timeout) {

        $scope.contactUsData = {};
        $scope.sendContactUsEmail = function(contactUs) {
            if (contactUs.$invalid) {
              if (angular.element($document[0].querySelector('input.ng-invalid'))[0]) {
                console.log("Input focus", angular.element($document[0].querySelector('input.ng-invalid'))[0]);
                angular.element($document[0].querySelector('input.ng-invalid'))[0].focus();
                return false
              } else if (angular.element($document[0].querySelector('textarea.ng-invalid'))[0]) {
                console.log("Textarea focus", angular.element($document[0].querySelector('textarea.ng-invalid'))[0]);
                angular.element($document[0].querySelector('textarea.ng-invalid'))[0].focus();
                return false
              }
            }
            console.log("contactUs Data ", $scope.contactUsData)
            // propertyService.sendEmail($scope.contactUsData)
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
