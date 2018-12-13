(function() {

  'use strict';

  angular
    .module('myApp')
    .controller('editPropertyDetailsController', editPropertyDetailsController);

  editPropertyDetailsController.$inject = ['$rootScope', '$scope', 'propDetails', 'propertyService', '$state'];

    function editPropertyDetailsController($rootScope, $scope, propDetails, propertyService, $state) {
         
        console.log(propDetails.data);
        var prop = propDetails.data[0];
        $scope.types = [
    	                 {name:'Restaurant'},
    	                 {name:'Gas station'},
    	                 {name:'Grocery store'},
    	                 {name:'Liquor store'},
    	                 {name:'Motels'}
    	               ];
        $scope.property = {
    			"propertyTitle": prop.property_name,
    			"image_url": prop.img_url,
    			"display_phone": prop.phone_number,
    			//"propertyDescription": prop.propertyDescription,
    			"bedrooms": "",
    			"bathrooms": "",
    			"price": prop.price,
    			"rentSale": prop.property_available_for,
    			"address": prop.property_address,
    			"city": prop.city,
    			"state": prop.state,
    			//"country": prop.country,
    			"zipcode": prop.zip_code,
    			"lat": prop.latitude,
    			"lng": prop.longitude,
    			//"userName": prop.userName,
    			//"rentSale": prop.rentSale,
    			"sqFt": prop.lot_size,
    			//"pricePerSqFt": prop.pricePerSqFt,
    			//"type": prop.type,
    			"mlsNumber": prop.mls_number,
    			"id": prop.id,
                "type": ""
    	};
        
        $scope.property.type = prop.type === 'Commercial' ? $scope.types[0] : $scope.types[1];
        
        $scope.updateProperty = function() {
        	$scope.property.lng = document.getElementById("lng").value;
    		$scope.property.lat = document.getElementById("lat").value;
    		$scope.property.city = document.getElementById("locality").value;
    		$scope.property.zipcode = document.getElementById("postal_code").value;
    		$scope.property.state = document.getElementById("administrative_area_level_1").value;
    		$scope.property.country = document.getElementById("country").value;
    		$scope.property.address = document.getElementById("address").value;
    		$scope.property.userName = localStorage.getItem('userName');
            $scope.property.id =  document.getElementById("id").value;
    		$scope.property.type = $scope.property.type.name;
    		
    		console.log($scope.property);
    		propertyService.updatePropertyDetails($scope.property)
    		.success(function(res) {
	             console.log("res "+ res);
	             console.log("res "+ res.status);
	             //$state.go("property.confirmation", {status: res.status});
	             $state.go("property.confirmation");
	        })
	        .error(function (error) {
	            $scope.status = 'Unable to load store data: ' + error.message;
	        });
        }

    }

})();
