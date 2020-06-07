(function() {

  'use strict';

  angular
    .module('myApp')
    .controller('subscriptionController', subscriptionController);

  subscriptionController.$inject = ['$document', '$scope', '$state', 'propertyService', '$timeout', '$stateParams', 'constants'];
    function subscriptionController($document, $scope, $state, propertyService, $timeout, $stateParams, constants) {
//		$(window).on('load',function(){
//	        $('#createSubscriptionModal').modal('show');
//	    });
	    $(document).ready(function(){
	        $('#createSubscriptionModal').modal('show');
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
        $scope.saveSearchAgent = function(subscription) {
            if (subscription.$invalid) {
              if (angular.element($document[0].querySelector('input.ng-invalid'))[0]) {
                angular.element($document[0].querySelector('input.ng-invalid'))[0].focus();
                return false
              } else if (angular.element($document[0].querySelector('textarea.ng-invalid'))[0]) {
                angular.element($document[0].querySelector('textarea.ng-invalid'))[0].focus();
                return false
              }
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
				county: $scope.businessCounty,
				city: $scope.businessCity.name,
            }
            propertyService.addSearchAgent(searchAgentDetails)
                .success(function(res) {
                    console.log("Search saved", res)
                    $state.go('home',null, {'reload':true});
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
