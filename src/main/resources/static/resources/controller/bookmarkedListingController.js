(function() {

  'use strict';

  angular
    .module('myApp')
    .controller('bookmarkedListingController', bookmarkedListingController);

  bookmarkedListingController.$inject = ['$scope'];
    function bookmarkedListingController($scope) {

      console.log('In bookmarkedListingController');
    }    

})();
