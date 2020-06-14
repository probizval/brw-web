(function() {

  'use strict';

  angular
    .module('myApp')
    .controller('listSearchAgentController', listSearchAgentController);

  listSearchAgentController.$inject = ['$document', '$scope', '$state', 'propDetails', 'propertyService', '$timeout', '$stateParams', 'constants'];
    function listSearchAgentController($document, $scope, $state, propDetails, propertyService, $timeout, $stateParams, constants) {
        $scope.searchAgentsList = propDetails.data.data.searchAgentsList;
        var profile = JSON.parse(sessionStorage.getItem("profile"));

        $scope.deleteSearchAgent = function(agentId) {
            var searchAgentDetails = {
	            userId: profile.userId,
				agentId: agentId
            }
            propertyService.deleteSearchAgent(searchAgentDetails)
                .success(function(res) {
		          location.reload();
                })
                .error(function (error) {
                 $scope.status = 'Unable to load store data: ' + error.message;
                });
        };

        $scope.createSearchAgent = function() {
            $state.go('business.createSearchAgent', {fromSignIn: false})
        }
    }
})();
