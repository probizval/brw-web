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
      
      $scope.bookMarked = function (obj, index, pagenumber) {
			console.log("Book marked "+obj.id);
			var userid = JSON.parse(sessionStorage.getItem('profile'));
			if(userid) {
			obj.isBookMarked && propertyService.removeBookMarkedProperty({"userId":userid.id,"propertyDetailsId":obj.id})
	  		.success(function(res) {
	  			$scope.next(pagenumber);
	         })
	         .error(function (error) {
	             $scope.status = 'Unable to load property list: ' + error.message;
	         });
			}
		};
		
    }    

})();