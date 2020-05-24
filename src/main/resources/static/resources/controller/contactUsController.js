(function() {

  'use strict';

  angular
    .module('myApp')
    .controller('contactUsController', contactUsController);

  contactUsController.$inject = ['$document', '$scope', '$state', 'propertyService', '$timeout', '$stateParams'];
    function contactUsController($document, $scope, $state, propertyService, $timeout, $stateParams) {
        $scope.contactUsData = {};
        $scope.contactUsData.emailSent = false
        var profile = JSON.parse(sessionStorage.getItem("profile"));
        if (profile && profile.email) {
            $scope.contactUsData.email = profile.email
        }
        if ($stateParams && $stateParams.businessId !== null && $stateParams.action === "make_offer"){
            $scope.contactUsData.subject = "Make an offer for Listing " + $stateParams.businessId
            document.getElementById("subject").disabled = true;
        }
        if ($stateParams && $stateParams.businessId !== null && $stateParams.action === "contact_selling_agent"){
            $scope.contactUsData.subject = "Contact Agent for Listing " + $stateParams.businessId
            document.getElementById("subject").disabled = true;
        }
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
                invokerId: userProfile.userId,
                name: $scope.contactUsData.name,
                from: $scope.contactUsData.email,
                toList: ["sp@proswift.com"],
                subject: $scope.contactUsData.subject,
                content: $scope.contactUsData.message,
                emailPurpose: "CONTACT_US"
            }
            if (userProfile.id) {
                emailInformation.invokerId = userProfile.userId
            }
            if ($stateParams && $stateParams.businessId !== null) {
                emailInformation.businessId = $stateParams.businessId
                emailInformation.action = $stateParams.action
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
