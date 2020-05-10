(function() {

  'use strict';

  angular
    .module('myApp')
    .controller('contactUsController', contactUsController);

  contactUsController.$inject = ['$document', '$scope', '$state', 'propertyService', '$timeout'];
    function contactUsController($document, $scope, $state, propertyService, $timeout) {

        $scope.contactUsData = {};
        $scope.contactUsData.emailSent = false
        $scope.sendContactUsEmail = function(contactUs) {
            if (contactUs.$invalid) {
              if (angular.element($document[0].querySelector('input.ng-invalid'))[0]) {
                angular.element($document[0].querySelector('input.ng-invalid'))[0].focus();
                return false
              } else if (angular.element($document[0].querySelector('textarea.ng-invalid'))[0]) {
                angular.element($document[0].querySelector('textarea.ng-invalid'))[0].focus();
                return false
              }
            }
            var userProfile = JSON.parse(sessionStorage.getItem('profile'));
            var emailInformation = {
                invokerId: 1001,
                name: $scope.contactUsData.name,
                from: $scope.contactUsData.email,
                toList: ["sp@proswift.com"],
                subject: $scope.contactUsData.subject,
                content: $scope.contactUsData.message,
                emailPurpose: "CONTACT_US"
            }
            if (userProfile.id) {
                emailInformation.invokerId = userProfile.id
            }
            propertyService.sendEmail(emailInformation)
            .success(function(res) {
              $scope.contactUsData.emailSent = true
            })
            .error(function (error) {
             $scope.status = 'Unable to load store data: ' + error.message;
            });
        };
        
        $scope.initialize = function() {};
        $scope.initialize();
    }
})();
