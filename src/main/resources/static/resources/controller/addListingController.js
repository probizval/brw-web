(function() {

  'use strict';

  angular
    .module('myApp')
    .controller('addListingController', addListingController);

  addListingController.$inject = ['$document', '$scope', '$state', 'propertyService', '$timeout'];
    function addListingController($document, $scope, $state, propertyService, $timeout) {
        $scope.imageFiles = [];
        $scope.yearEstablishedList = [
          {id: 1, year: 2018},
          {id: 2, year: 2017},
          {id: 3, year: 2016},
          {id: 4, year: 2015},
          {id: 1, year: 2014},
          {id: 2, year: 2013},
          {id: 3, year: 2012},
          {id: 4, year: 2011},
          {id: 5, year: 2010},
          {id: 6, year: 2005},
          {id: 7, year: 2000},
          {id: 8, year: 1995},
          {id: 9, year: 1990},
          {id: 10, year: 1980},
          {id: 11, year: 1970},
          {id: 12, year: 1960},
          {id: 13, year: 1950},
          {id: 14, year: 1940},
          {id: 15, year: 1930}
        ];

      // $scope.property = {
      //           "propertyTitle": "",
      //           "image_url": "",
      //           "display_phone": 0,
      //           "propertyDescription": "",
      //           "bedrooms": "",
      //           "bathrooms": "",
      //           "price": 0,
      //           "address": "",
      //           "city": "",
      //           "state": "",
      //           "country": "",
      //           "zipcode": 0,
      //           "lat": 0,
      //           "lng": 0,
      //           "userName": "",
      //           "rentSale": "Buy",
      //           "sqFt": 0,
      //           "pricePerSqFt": 0,
      //           "mlsNumber": 0,
      //           "type": "",
      //           "rest": {
      //               "cuisineType": "Indo",
      //               "desc": "Indo Restaurant"
      //           },
      //           "gas": {
      //               "brand": "Shell",
      //               "fuelType": ""
      //           },
      //           "uploaded_image_aws_urls": []
      //   };

        $scope.propertyMetaData = {};
        $scope.propertyImages = [];
        $scope.property = {
          'rest':          {},
          'gas':          {},
          'beautySalon':  {},
          'laundry':      {},
          'dryCleaners':  {},
          'liquorStore':  {}
        };
        
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
        // $scope.property.type = $scope.types[0];
        
        $scope.saveBusiness = function(addListingForm) {
            if (addListingForm.$invalid) {
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
            $scope.propertyMetaData.imageUrl = "https://s3-us-west-1.amazonaws.com/proswift/2.jpg";


            $scope.business = angular.extend($scope.property.rest, $scope.property.gas, $scope.property.beautySalon,
              $scope.property.laundry, $scope.property.dryCleaners, $scope.property.liquorStore);
            $scope.business.propertyImages = $scope.propertyImages;
            $scope.business.propertyMetaData = $scope.propertyMetaData;
            console.log($scope.propertyImages, $scope.propertyMetaData, $scope.business);

            //TODO need to get userid
            var userProfile = JSON.parse(sessionStorage.getItem('profile'));
            $scope.propertyMetaData.userId = userProfile.id;

            propertyService.savePropertyDetails(apiName, $scope.business)
            .success(function(res) {
                 console.log("res ", res);
                 console.log("res ", res.status);
                 //$state.go("property.confirmation", {status: res.status});
                 $state.go("property.confirmation");
            })
            .error(function (error) {
                $scope.status = 'Unable to load store data: ' + error.message;
            });
            // TODO Create api for saving uploaded business images to database table
            // propertyService.savePropertyImages($scope.property)
            //   .success(function(res) {
            //     console.log("res "+ res);
            //     console.log("res "+ res.status);
            //     //$state.go("property.confirmation", {status: res.status});
            //     $state.go("property.confirmation");
            //   })
            //   .error(function (error) {
            //     $scope.status = 'Unable to load store data: ' + error.message;
            //   });
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
                
         }

      $scope.imagesAsDataURL = [];

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

      $scope.removePhoto = function(image){
        var itemIndex = $scope.imagesAsDataURL.indexOf(image);
        $scope.imagesAsDataURL.splice(itemIndex, 1);
        $scope.imageFiles.splice(itemIndex, 1);
      };

      $scope.progress=0;
      $scope.uploadPhotoOnAWS = function(){
        for (var i=0; i < $scope.imageFiles.length; i++) {
          var photo = $scope.imageFiles[i];
          // console.log("-here-----", photo.name, photo.type);
          //amazon aws credentials
          AWS.config.update({
            accessKeyId: 'AKIAIRYE5BJ3NCFM6L4Q',
            secretAccessKey: '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'
          });
          //amazon s3 region
          AWS.config.region = 'us-west-1';
          //amazon s3 bucket name
          var bucket = new AWS.S3({params: {Bucket: 'proswift'}});
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
              $scope.propertyImages.push(data.Location);
            }
          });
          // bucket.putObject(params, function(err, data) {
          //   if(err) {
          //     // There Was An Error With Your S3 Config
          //     alert(err.message);
          //     return false;
          //   }
          //   else {
          //     // Success!
          //     console.log(data);
          //     alert('Upload Done', data);
          //   }
          // })
          // .on('httpUploadProgress',function(progress) {
          //   // Log Progress Information
          //   console.log(Math.round(progress.loaded / progress.total * 100) + '% done');
          // });
        }
      };

      $scope.initialize();
        
      console.log('In addListingController');
    }    

})();
