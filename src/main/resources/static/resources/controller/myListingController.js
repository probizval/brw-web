(function() {

  'use strict';

  angular
    .module('myApp')
    .controller('myListingController', myListingController);

  myListingController.$inject = ['$scope','propList', 'propertyService'];
    function myListingController($scope, propList, propertyService) {
      $scope.myList = propList.data.data;

      $scope.next = function(pagenumber) {
    	 propertyService.getPropertyListByUser(Number(pagenumber))
  		.success(function(res) {
  			$scope.myList = res.data;
         })
         .error(function (error) {
             $scope.status = 'Unable to load property list: ' + error.message;
         });
      }
    }    

})();
