(function() {

  'use strict';

  angular
    .module('myApp')
    .controller('addListingController', addListingController);

  addListingController.$inject = ['$document', '$scope', '$state', 'propertyService', '$timeout'];
    function addListingController($document, $scope, $state, propertyService, $timeout) {
        $scope.imageFiles = [];
        $scope.businessMetaData = {};
        $scope.businessDetails = {};
        $scope.businessImages = [];
        $scope.equipments = [];
        $scope.imagesAsDataURL = [];

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

        $scope.property = {
          'rest':          {},
          'gas':          {},
          'beautySalon':  {},
          'laundry':      {},
          'dryCleaners':  {},
          'liquorStore':  {}
        };
        
        $scope.types = [
             {name:'Restaurants and Food', code:'b_type_1', apiName: "RESTAURANT"},
             {name:'Gas Station', code:'b_type_2', apiName: "GAS_STATION"},
             {name:'Liquor Store', code:'b_type_3', apiName: "LIQUOR_STORE"},
             {name:'Beauty Salon/Spa/Nail', code:'b_type_4', apiName: "BEAUTY"},
             {name:'Convenience store', code:'b_type_5', apiName: "MERCHANDISE_STORE"},
             {name:'Auto Service Shop', code:'b_type_6', apiName: "autoservice"},
             {name:'Laundry', code:'b_type_7', apiName: "LAUNDRY"},
             {name:'Cafe', code:'b_type_8', apiName: "CAFE"},
             {name:'Dry Cleaners', code:'b_type_9', apiName: "drycleaners"},
             {name:'Other', code:'b_type_9', apiName: "OTHER"}
        ];
        $scope.ownerClaimed = "N";
        
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

        $scope.removePhoto = function(image){
        var itemIndex = $scope.imagesAsDataURL.indexOf(image);
        $scope.imagesAsDataURL.splice(itemIndex, 1);
        $scope.imageFiles.splice(itemIndex, 1);
        };

        $scope.uploadPhotos = function(businessId){
        var imageList = [];
        for (var i=0; i < $scope.imagesAsDataURL.length; i++) {
            var photo = $scope.imagesAsDataURL[i];
            imageList.push({
                "title": $scope.imageFiles[0].name,
                "imageBase64": photo
            })
        }
        // Upload base64 images
        propertyService.uploadBusinessImages(businessId, $scope.businessDetails.invokerId, imageList)
        .success(function(res) {
             console.log("uploadBusinessImages res ", res);
        })
        .error(function (error) {
            $scope.status = 'Unable to load store data: ' + error.message;
        });

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

        $scope.saveEquipments = function(businessId) {
        propertyService.addAdditionalAttributes(businessId, $scope.businessDetails.invokerId, $scope.equipments)
        .success(function(res) {
             console.log("saveEquipments res ", res);
             $state.go("business.confirmation");
        })
        .error(function (error) {
            $scope.status = 'Unable to load store data: ' + error.message;
        });
        }

        $scope.addEquipments = function() {
        var equipment = {attribType: "", attribSubType: "", valueType: "", value: "", quantity: "", pricePerUnit: "", monthlyMaintExpense: ""}
        $scope.equipments.push(equipment)
        console.log("add Equipments: ", $scope.equipments)
        };

        $scope.removeEquipment = function($event, equipment){
        var index = $scope.equipments.indexOf(equipment);
          if($event.which == 1) {
             $scope.equipments.splice(index,1);
          }
          console.log("Remove Equipments: ", $scope.equipments)
        };

        $scope.saveBusiness = function(addListingForm) {
            if (addListingForm.$invalid) {
              if (angular.element($document[0].querySelector('input.ng-invalid'))[0]) {
                console.log("Input focus", angular.element($document[0].querySelector('input.ng-invalid'))[0]);
                angular.element($document[0].querySelector('input.ng-invalid'))[0].focus();
                return false
              } else {
                console.log("Select focus", angular.element($document[0].querySelector('select.ng-invalid'))[0]);
                angular.element($document[0].querySelector('select.ng-invalid'))[0].focus();
                return false;
              }
            }


            if ($scope.buRelationship === "OWNER") {
                $scope.ownerClaimed = "Y";
            }
            if ($scope.type.apiName !== "Other") {
                $scope.subType = $scope.type.apiName;
            }
            $scope.businessDetails = {
                legalName: $scope.legalName,
                name: $scope.name,
                firstOwnerName: $scope.firstOwnerName,
                secondOwnerName: $scope.secondOwnerName,
                brandName: $scope.brandName || "",
                type: $scope.type.apiName,
                subType: $scope.subType,
                isOwnerClaimed: $scope.ownerClaimed,
                buRelationship: $scope.buRelationship,
//                "regCityName": "Fremont",
//                "regCityCode": "044095",
//                "regCityDate": "2009-09-04 12:00",
//                "regStateName": "CA",
//                "regStateCode": "20090801202",
//                "regStateDate": "2009-10-30 12:00",
//                "dataCompletionScore": 80,
                isforSell: $scope.isforSell,
                forSellPrice: $scope.forSellPrice,
                imageLogo: "",
                imageFirst: "https://s3-media1.fl.yelpcdn.com/bphoto/3oEbIFTQpS0-TdSpZoTz1g/o.jpg",
                street1: document.getElementById("address").value,
                street2: "",
                city: $scope.city,
                stateCode: $scope.stateCode,
                county: "Alameda", //TODO Need to ask from user
//                county: $scope.county,
                zip: $scope.zipCode,
                latitude: document.getElementById("lat").value,
                longitude: document.getElementById("lng").value,
                phone: $scope.phone,
                email: $scope.email,
                website: $scope.website,
                description: $scope.description,
                isFranchise: $scope.isFranchise,
                sqftIndoor: $scope.sqftIndoor,
                sqftOutdoor: $scope.sqftOutdoor,
                sqftLot: $scope.sqftLot,
                buildingType: $scope.buildingType,
                isBuildingOwned: $scope.isBuildingOwned,
                revenueMonthly: $scope.revenueMonthly,
                expenseMonthlyRent: $scope.expenseMonthlyRent,
                expenseMonthlyMortgage: $scope.expenseMonthlyMortgage,
                expenseMonthlyMaterial: $scope.expenseMonthlyMortgage,
                expenseMonthlyEmp: $scope.expenseMonthlyEmp,
                expenseMonthlyUtility: $scope.expenseMonthlyUtility,
                expenseMonthlyOther: $scope.expenseMonthlyOther,
                valueTotalEquipment: $scope.valueTotalEquipment,
                valueTotalFurniture: $scope.valueTotalFurniture,
                valueIndoorDeco: $scope.valueIndoorDeco,
                valueOutdoorDeco: $scope.valueOutdoorDeco,
                yearEquipment: $scope.yearEquipment,
                yearFurniture: $scope.yearFurniture,
                yearIndoorDeco: $scope.yearIndoorDeco,
                yearOutdoorDeco: $scope.yearOutdoorDeco,
                empFullTimeNum: $scope.empFullTimeNum,
                empPartTimeNum: $scope.empPartTimeNum,
                dailyPeoplAtDoorNum: $scope.dailyPeoplAtDoorNum,
                dailyCarsAtParklotNum: $scope.dailyCarsAtParklotNum,
                yearEstablished: $scope.yearEstablished.year,
                naicsnum: $scope.naicsnum,
                naicsdescription: $scope.naicsdescription,
                numberOfParkings: $scope.numberOfParkings
            }

//            $scope.businessMetaData.longitude = document.getElementById("lng").value;
//            $scope.businessMetaData.latitude = document.getElementById("lat").value;
//            $scope.businessMetaData.city = document.getElementById("locality").value;
//            $scope.businessMetaData.zipCode = document.getElementById("postal_code").value;
//            $scope.businessMetaData.state = document.getElementById("administrative_area_level_1").value;
//            $scope.businessMetaData.country = document.getElementById("country").value;
//            $scope.businessMetaData.businessAddress = document.getElementById("address").value;
//            $scope.businessMetaData.location = document.getElementById("autocomplete").value;
//            $scope.businessMetaData.businessType = $scope.type.name;
            // $scope.businessMetaData.imageUrl = "https://s3-us-east-1.amazonaws.com/bizrealworth-image/2.jpg";

//            $scope.business = angular.extend($scope.property.rest, $scope.property.gas, $scope.property.beautySalon,
//              $scope.property.laundry, $scope.property.dryCleaners, $scope.property.liquorStore);
//            $scope.business.businessImages = $scope.businessImages;
//            $scope.business.businessMetaData = $scope.businessMetaData;
//            console.log($scope.businessImages, $scope.businessMetaData, $scope.business, $scope.businessDetails);
            console.log($scope.businessDetails)
            //TODO need to get userid
            var userProfile = JSON.parse(sessionStorage.getItem('profile'));
            $scope.businessDetails.invokerId = userProfile.id;
            $scope.businessDetails.invokerId = 1001;
            propertyService.addBusinessDetails($scope.businessDetails)
            .success(function(res) {
                 console.log("addBusinessDetails ", res);
                 $scope.uploadPhotos(res.businessId);
                 $scope.saveEquipments(res.businessId);
            })
            .error(function (error) {
                $scope.status = 'Unable to load store data: ' + error.message;
            });
        };

        $scope.initialize();
        //      $scope.uploadPhotoOnAWS = function(){
        //        for (var i=0; i < $scope.imageFiles.length; i++) {
        //          var photo = $scope.imageFiles[i];
        //          console.log("-here-----", photo.name, photo.type);
        //          //amazon aws credentials
        //          AWS.config.update({
        //            accessKeyId: 'AKIAJJFDVJ7R234QR6ZA',
        //            secretAccessKey: '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'
        //          });
        //          //amazon s3 region
        //          AWS.config.region = 'us-east-1';
        //          //amazon s3 bucket name
        //          var bucket = new AWS.S3({params: {Bucket: 'bizrealworth-image'}});
        //          var params = { Key: photo.name, ContentType: photo.type, Body: photo};
        //          bucket.upload(params).on('httpUploadProgress', function (evt) {
        //            //logs the image uploading progress
        //            console.log("Uploaded :: " + parseInt((evt.loaded * 100) / evt.total) + '%');
        //            var progress = parseInt((evt.loaded * 100) / evt.total);
        //            if (progress === 100) {
        //              console.log("photo uploaded successfully");
        //            }
        //          }).send(function (err, data) {
        //            if (data) {
        //              //displays the image location on amazon s3 bucket
        //              console.log(data.Location);
        //              $scope.businessImages.push(data.Location);
        //            }
        //          });
        //          // bucket.putObject(params, function(err, data) {
        //          //   if(err) {
        //          //     // There Was An Error With Your S3 Config
        //          //     alert(err.message);
        //          //     return false;
        //          //   }
        //          //   else {
        //          //     // Success!
        //          //     console.log(data);
        //          //     alert('Upload Done', data);
        //          //   }
        //          // })
        //          // .on('httpUploadProgress',function(progress) {
        //          //   // Log Progress Information
        //          //   console.log(Math.round(progress.loaded / progress.total * 100) + '% done');
        //          // });
        //        }
        //      };

    }    

})();
