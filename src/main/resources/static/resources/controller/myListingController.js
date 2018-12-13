(function() {

  'use strict';

  angular
    .module('myApp')
    .controller('myListingController', myListingController);

  myListingController.$inject = ['$scope','propList'];
    function myListingController($scope, propList) {
      $scope.myList = propList.data;
      console.log('In myListingController');
    }    

})();
