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
        $('body').on('click', 'li', function() {
             $('li.active').removeClass('active');
             $(this).addClass('active');
        });
        $scope.changePage = function(pageNumber) {
            $scope.currentPage = pageNumber - 1
        }
        $scope.disablePrevious = function() {
            if ($scope.currentPage + 1 <= 1){
                return true
            } else {
                $scope.currentPage -= 1
                return false
            }
        };

        $scope.disableNext = function() {
            if ($scope.currentPage + 1 >= $scope.numberOfPages){
                return false
            } else {
                $scope.currentPage += 1
                return true
            }
        };
        $scope.setItemsPerPage = function(num) {
          $scope.itemsPerPage = num;
          $scope.currentPage = 0; //reset to first page
          $scope.numberOfPages = Math.floor($scope.myBizList.length/$scope.itemsPerPage);
          if ($scope.myBizList.length%$scope.itemsPerPage !== 0){
              $scope.numberOfPages += 1
          }
        }
    }

})();
