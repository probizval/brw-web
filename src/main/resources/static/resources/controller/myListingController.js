(function() {

  'use strict';

  angular
    .module('myApp')
    .controller('myListingController', myListingController);

  myListingController.$inject = ['$scope','propList', 'propertyService'];
    function myListingController($scope, propList, propertyService) {
//      $scope.myBizList = propList.data.data;
		$scope.myBizList = propList.data.data.userBusinessList;
		$scope.currentPage = 0;
		$scope.viewby = 10;
		$scope.itemsPerPage = $scope.viewby;
		$scope.numberOfPages = Math.floor($scope.myBizList.length/$scope.itemsPerPage);
		if ($scope.myBizList.length%$scope.itemsPerPage !== 0){
		    $scope.numberOfPages += 1
		}

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
