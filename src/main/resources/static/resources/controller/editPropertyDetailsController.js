(function() {

  'use strict';

  angular
    .module('myApp')
    .controller('editPropertyDetailsController', editPropertyDetailsController);

  editPropertyDetailsController.$inject = ['$document', '$scope', 'propDetails', 'propertyService', '$state'];

    function editPropertyDetailsController($document, $scope, propDetails, propertyService, $state) {
         

			var prop = propDetails.data.data;
      $scope.propDetails = propDetails.data.data;
			$scope.propertyMetaData = $scope.propDetails.propertyMetaData;
      $scope.propertyImages = propDetails.data.data.propertyImages || [];

      console.log($scope.propDetails, $scope.propertyMetaData);
      $scope.types = [
        {name:'Restaurants and Food', code:'b_type_1', apiName: "restaurant"},
        {name:'Gas Station', code:'b_type_2', apiName: "gasstation"},
        {name:'Liquor Store', code:'b_type_3', apiName: "liquorstore"},
        {name:'Beauty Salon/Spa/Nail', code:'b_type_4', apiName: "salonstore"},
        {name:'Convenience store', code:'b_type_5', apiName: "conveniencestore"},
        {name:'Auto Service Shop', code:'b_type_6', apiName: "autoservice"},
        {name:'Laundry', code:'b_type_7', apiName: "laundry"},
        {name:'Cafe', code:'b_type_8', apiName: "cafe"},
        {name:'Dry Cleaners', code:'b_type_9', apiName: "drycleaners"}
      ];
      for (var j=0; j<$scope.types.length; j++) {
				if ($scope.types[j]["name"] === $scope.propertyMetaData.businessType) {
					$scope.propertyMetaData.businessType = $scope.types[j];
				}
      }

			$scope.updateBusiness = function(editListingForm) {
				if (editListingForm.$invalid) {
					if (angular.element($document[0].querySelector('select.ng-invalid'))[0]) {
						console.log("Select focus", angular.element($document[0].querySelector('select.ng-invalid'))[0]);
						angular.element($document[0].querySelector('select.ng-invalid'))[0].focus();
						return false;
					} else {
						console.log("Input focus", angular.element($document[0].querySelector('input.ng-invalid'))[0]);
						angular.element($document[0].querySelector('input.ng-invalid'))[0].focus();
						return false
					}
				}

				$scope.uploadPhotoOnAWS();
				var apiName = $scope.propertyMetaData.businessType.apiName;
				$scope.propertyMetaData.longitude = document.getElementById("lng").value;
				$scope.propertyMetaData.latitude = document.getElementById("lat").value;
				$scope.propertyMetaData.city = document.getElementById("locality").value;
				$scope.propertyMetaData.zipCode = document.getElementById("postal_code").value;
				$scope.propertyMetaData.state = document.getElementById("administrative_area_level_1").value;
				$scope.propertyMetaData.country = document.getElementById("country").value;
				$scope.propertyMetaData.propertyAddress = document.getElementById("address").value;
				$scope.propertyMetaData.location = document.getElementById("autocomplete").value;
				$scope.propertyMetaData.businessType = $scope.propertyMetaData.businessType.name;
				if ($scope.propertyImages) {
					$scope.propertyMetaData.imageUrl = $scope.propertyImages[0].imageUrl;
				}

				console.log($scope.propertyMetaData,$scope.propDetails.propertyMetaData);
				$scope.business = angular.extend($scope.propDetails);
				$scope.business.propertyMetaData = $scope.propertyMetaData;
				$scope.business.propertyImages = $scope.propertyImages;
				console.log($scope.business, apiName);
				propertyService.updatePropertyDetails(apiName, $scope.business)
					.success(function(res) {
						console.log("res ", res);
						console.log("res ", res.status);
						// TODO need to show some success model
						$state.go("business.myListing");
					})
					.error(function (error) {
						$scope.status = 'Unable to load store data: ' + error.message;
					});
			};
			
			$scope.cancelBusinessUpdate = function (editListingForm) {
        $state.go("business.myListing");
      };
	
      $scope.imagesAsDataURL = [];
      $scope.imageFiles = [];
      for (var i = 0; i < $scope.propertyImages.length; i++) {
        $scope.imagesAsDataURL.push($scope.propertyImages[i].imageUrl)
      }

      $scope.imageUpload = function(event){
        var files = event.target.files;
        for (var i = 0; i < files.length; i++) {
          var file = files[i];
          $scope.imageFiles.push(file);
          var reader = new FileReader();
          reader.onload = $scope.imageIsLoaded;
          reader.readAsDataURL(file);
        }
      };

      $scope.imageIsLoaded = function(e){
        $scope.$apply(function() {
          $scope.imagesAsDataURL.push(e.target.result);
        });
      };

      $scope.removePhoto = function(imageUrl){
        console.log("$scope.imagesAsDataURL image",$scope.imagesAsDataURL, imageUrl);
        var itemIndex = $scope.imagesAsDataURL.indexOf(imageUrl);
        $scope.imagesAsDataURL.splice(itemIndex, 1);
        $scope.imageFiles.splice(itemIndex, 1);
      };

      $scope.progress=0;
      var counter = $scope.propertyImages.length;
      $scope.uploadPhotoOnAWS = function(){
        for (var i=0; i < $scope.imageFiles.length; i++) {
          var photo = $scope.imageFiles[i];
          console.log("-here-----", photo.name, photo.type);
          //amazon aws credentials
          AWS.config.update({
            accessKeyId: 'AKIAJJFDVJ7R234QR6ZA',
            secretAccessKey: '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'
          });
          //amazon s3 region
          AWS.config.region = 'us-east-1';
          //amazon s3 bucket name
          var bucket = new AWS.S3({params: {Bucket: 'bizrealworth-image'}});
          var params = { Key: photo.name, ContentType: photo.type, Body: photo};
          bucket.upload(params).on('httpUploadProgress', function (evt) {
            //logs the image uploading progress
            console.log("Uploaded :: " + parseInt((evt.loaded * 100) / evt.total) + '%');
            var progress = parseInt((evt.loaded * 100) / evt.total);
            if (progress === 100) {
              console.log("photo uploaded successfully");
            }
          }).send(function (err, data) {
            if (data) {
              //displays the image location on amazon s3 bucket
              console.log(data.Location);
              counter += 1;
              var propertyImage = {
              	// "id": counter,
								"imageUrl": data.location,
								"propertyCode": $scope.propertyMetaData.propertyCode,
								"propertyDetailsId": $scope.propertyMetaData.id
							};
              $scope.propertyImages.push(propertyImage);
            }
          });
        }
      };

      $scope.initialize = function() {
        // This example displays an address form, using the autocomplete feature
        // of the Google Places API to help users fill in the information.

        // This example requires the Places library. Include the libraries=places
        // parameter when you first load the API. For example:
        // <script src="https://maps.googleapis.com/maps/api/js?key=YOUR_API_KEY&libraries=places">

        var placeSearch, autocomplete;
        var componentForm = {
          locality: 'long_name',
          administrative_area_level_1: 'short_name',
          country: 'short_name',
          postal_code: 'short_name'
        };

        // Create the autocomplete object, restricting the search to geographical
        // location types.
        autocomplete = new google.maps.places.Autocomplete(
          /** @type {!HTMLInputElement} */(document.getElementById('autocomplete')),
          {types: ['geocode']});

        // When the user selects an address from the dropdown, populate the address
        // fields in the form.
        autocomplete.addListener('place_changed', fillInAddress);

        function fillInAddress() {
          // Get the place details from the autocomplete object.
          var place = autocomplete.getPlace();

          var lat = place.geometry.location.lat();
          var lng = place.geometry.location.lng();


          for (var component in componentForm) {
            if(document.getElementById(component)) {
              document.getElementById(component).value = '';
              document.getElementById(component).disabled = false;
            }
          }

          // Get each component of the address from the place details
          // and fill the corresponding field on the form.
          for (var i = 0; i < place.address_components.length; i++) {
            var addressType = place.address_components[i].types[0];
            if (componentForm[addressType] && document.getElementById(addressType)) {
              var val = place.address_components[i][componentForm[addressType]];
              document.getElementById(addressType).value = val;
            }
          }
          document.getElementById("address").value = place.name;
          document.getElementById("lat").value = lat;
          document.getElementById("lng").value = lng;
        }

        // Bias the autocomplete object to the user's geographical location,
        // as supplied by the browser's 'navigator.geolocation' object.
        function geolocate() {
          if (navigator.geolocation) {
            navigator.geolocation.getCurrentPosition(function(position) {
              var geolocation = {
                lat: position.coords.latitude,
                lng: position.coords.longitude
              };
              var circle = new google.maps.Circle({
                center: geolocation,
                radius: position.coords.accuracy
              });
              autocomplete.setBounds(circle.getBounds());
            });
          }
        }

      };
			$scope.initialize()
    }

})();
