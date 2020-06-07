(function() {

  'use strict';

  angular
    .module('myApp')
    .controller('createSearchAgentController', createSearchAgentController);

  createSearchAgentController.$inject = ['$document', '$scope', '$state', 'propertyService', '$timeout', '$stateParams', 'constants'];
    function createSearchAgentController($document, $scope, $state, propertyService, $timeout, $stateParams, constants) {
	    $(document).ready(function(){
	        $('#createSearchAgentModal').modal('show');
        });
        $scope.businessTypes = constants.searchBusinessTypes;
        $scope.businessCities = constants.businessCities;
        $scope.businessStates = constants.businessStates;
        $scope.frequencies = constants.subscriptionFrequencies;
        $scope.businessCounties = [];
        $scope.searchName = "";
        $scope.priceRangeList = constants.priceRangeList;
        var profile = JSON.parse(sessionStorage.getItem("profile"));
        if (profile && profile.email) {
            $scope.email = profile.email
        }

		$scope.filterCountyByState = function() {
            propertyService.getStateCounties({'stateName': $scope.businessState.name})
		        .success(function(res) {
		          $scope.businessCounties = res.data.listsOfCounties.sort();
		          $scope.businessCounty = $scope.businessCounties[0];
                  $scope.searchName = 'Business search in ' + $scope.businessState.name;
		        })
		        .error(function (error) {
		         $scope.status = 'Unable to load store data: ' + error.message;
		        });
		}
        $scope.saveSearchAgent = function() {
            var searchAgentDetails = {
	            userId: profile.userId,
				email: $scope.email,
				name: $scope.searchName,
				frequency: $scope.frequency.code,
				bizType: $scope.businessType.apiName,
				priceLow: $scope.priceRange.minPrice,
				priceHigh: $scope.priceRange.maxPrice,
				state: $scope.businessState.code,
				county: $scope.businessCounty,
				city: $scope.businessCity.name,
            }
            propertyService.addSearchAgent(searchAgentDetails)
                .success(function(res) {
//                    $state.go('home',null, {'reload':true});
		          var redirect_location = sessionStorage.getItem("redirect_location");
		          window.location.href = redirect_location
		          location.reload();

                })
                .error(function (error) {
                 $scope.status = 'Unable to load store data: ' + error.message;
                });
        };

        $scope.initialize = function() {
            $scope.businessType = $scope.businessTypes[0];
            $scope.businessCity = $scope.businessCities[0];
            $scope.businessState = $scope.businessStates[0];
            $scope.priceRange = $scope.priceRangeList[0];
            $scope.frequency = $scope.frequencies[0];
            $scope.filterCountyByState()
        };
        $scope.initialize();
    }
})();
