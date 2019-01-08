(function() {

  'use strict';

  angular
    .module('myApp')
    .controller('bookmarkedListingController', bookmarkedListingController);

  bookmarkedListingController.$inject = ['$scope','propList', 'propertyService'];
    function bookmarkedListingController($scope, propList, propertyService) {
      $scope.myList = propList.data.data;
      console.log('In bookmarkedListingController');
      
      $scope.next = function(pagenumber) {
    	 propertyService.getBookMarkedPropertyListByUser(Number(pagenumber))
  		.success(function(res) {
  			$scope.myList = res.data;
         })
         .error(function (error) {
             $scope.status = 'Unable to load property list: ' + error.message;
         });
      }
    }    

})();