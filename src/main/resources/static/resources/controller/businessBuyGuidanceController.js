(function() {

  'use strict';

  angular
    .module('myApp')
    .controller('businessBuyGuidanceController', businessBuyGuidanceController);

  businessBuyGuidanceController.$inject = ['$document', '$scope', '$state'];
    function businessBuyGuidanceController($document, $scope, $state) {

        $scope.businessType = "gasstation"
        $scope.submit = function(businessType) {
            $scope.businessType = businessType
        }
        
        $scope.initialize = function() {};
        $scope.initialize();
    }
})();
