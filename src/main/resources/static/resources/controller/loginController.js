(function() {

  'use strict';

  angular
    .module('myApp')
    .controller('loginController', loginController);

    loginController.$inject = ['$scope'];
    console.log('In login ... Controller');
    function loginController($scope) {

      console.log('In loginController');
    }    

})();
