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
		          $scope.businessCounties = res.data.countyList;
		          $scope.businessCounty = $scope.businessCounties[0];
                  $scope.searchName = 'Business search in ' + $scope.businessState.name;
                  var profile = JSON.parse(sessionStorage.getItem("profile"));
                  if (profile && profile.email) {
                      $scope.email = profile.email
                  }
		        })
		        .error(function (error) {
		         $scope.status = 'Unable to load store data: ' + error.message;
		        });
		}
        $scope.saveSearchAgent = function() {
            var profile = JSON.parse(sessionStorage.getItem("profile"));
			if (profile && profile.email) {
			  $scope.email = profile.email
			}
            var searchAgentDetails = {
	            userId: profile.userId,
				email: $scope.email,
				name: $scope.searchName,
				frequency: $scope.frequency.code,
				bizType: $scope.businessType.apiName,
				priceLow: $scope.priceRange.minPrice,
				priceHigh: $scope.priceRange.maxPrice,
				state: $scope.businessState.code,
				county: $scope.businessCounty.countyName,
				city: $scope.businessCity,
            }
            propertyService.addSearchAgent(searchAgentDetails)
                .success(function(res) {
					if ($stateParams.fromSignIn === true) {
						window.location.href = sessionStorage.getItem("redirect_location");
						location.reload();
					} else {
						$state.go('business.listSearchAgent',null, {'reload':true});
					}
                })
                .error(function (error) {
                 $scope.status = 'Unable to load store data: ' + error.message;
                });
        };
		$scope.skipSearchAgent = function() {
            if ($stateParams.fromSignIn === true) {
                window.location.href = sessionStorage.getItem("redirect_location");
                location.reload();
            } else {
                $state.go('business.listSearchAgent',null, {'reload':true});
            }
        }
        $scope.initialize = function() {
            $scope.businessType = $scope.businessTypes[0];
//            $scope.businessCity = $scope.businessCities[0];
            $scope.businessState = $scope.businessStates[4]; // California
            $scope.priceRange = $scope.priceRangeList[0];
            $scope.frequency = $scope.frequencies[0];
            if (profile && profile.email) {
			  $scope.email = profile.email
			}
            $scope.filterCountyByState()
        };
        $scope.initialize();
    }
})();
