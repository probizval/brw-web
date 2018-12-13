(function() {

  'use strict';

  angular
    .module('myApp')
    .controller('listAgentsController', listAgentsController);

  listAgentsController.$inject = ['$rootScope', '$scope', 'propertyService', 'propList'];

    function listAgentsController($rootScope, $scope, propertyService, propList) {
         
    	$scope.agentsList = propList.data;
    	$scope.initialize = function(dataset) {
				console.log("-----listAgentsController-----",$scope.agentsList );
			};

			$scope.initialize(propList.data);

    }

})();
