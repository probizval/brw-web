(function() {

  'use strict';

  angular
    .module('myApp')
    .controller('addListingController', addListingController);

  addListingController.$inject = ['$document', '$scope', '$state', 'propertyService', '$timeout', 'constants'];
    function addListingController($document, $scope, $state, propertyService, $timeout, constants) {
        $scope.imageFiles = [];
        $scope.businessMetaData = {};
        $scope.businessDetails = {};
        $scope.businessImages = [];
        $scope.equipments = [];
        $scope.imagesAsDataURL = [];
        $scope.businessStates = constants.businessStates;
        $scope.yearEstablishedList = constants.allYearBuiltList;
        $scope.businessTypes = constants.addBusinessTypes;
        $scope.ownerClaimed = "N";
        var userProfile = JSON.parse(sessionStorage.getItem('profile'));
        if (userProfile && userProfile.email) {
            $scope.email = userProfile.email
        }

        $(document).ready(function(){
          $('[data-toggle="tooltip"]').tooltip();
        });

        $scope.initialize = function() {
            $scope.businessState = $scope.businessStates[0];
            // This example displays an address form, using the autocomplete feature
              // of the Google Places API to help users fill in the information.

              // This example requires the Places library. Include the libraries=places
              // parameter when you first load the API. For example:
              // <script src="https://maps.googleapis.com/maps/api/js?key=YOUR_API_KEY&libraries=places">

//              var placeSearch, autocomplete;
//              var componentForm = {
//                locality: 'long_name',
//                administrative_area_level_1: 'short_name',
//                country: 'short_name',
//                postal_code: 'short_name'
//              };

                // Create the autocomplete object, restricting the search to geographical
                // location types.
//                autocomplete = new google.maps.places.Autocomplete(
//                    /** @type {!HTMLInputElement} */(document.getElementById('autocomplete')),
//                    {types: ['geocode']});

                // When the user selects an address from the dropdown, populate the address
                // fields in the form.
//                autocomplete.addListener('place_changed', fillInAddress);

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
            if (imageList.length > 0)
            {
                // Upload base64 images
                propertyService.uploadBusinessImages(businessId, $scope.businessDetails.invokerId, imageList)
                .success(function(res) {
                     console.log("uploadBusinessImages res ", res);
                })
                .error(function (error) {
                    $scope.status = 'Unable to load store data: ' + error.message;
                });
            }
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
            if ($scope.equipments.length > 0) {
                propertyService.addAdditionalAttributes(businessId, $scope.businessDetails.invokerId, $scope.equipments)
                    .success(function(res) {
                         $state.go("business.confirmation");
                    })
                    .error(function (error) {
                        $scope.status = 'Unable to load store data: ' + error.message;
                    });
            }
        }

        $scope.addEquipments = function() {
            var equipment = {
                attribType: "",
                attribSubType: "",
                valueType: "",
                value: "",
                quantity: "",
                pricePerUnit: "",
                monthlyMaintExpense: ""
            }
            $scope.equipments.push(equipment)
        };

        $scope.removeEquipment = function($event, equipment){
        var index = $scope.equipments.indexOf(equipment);
          if($event.which == 1) {
             $scope.equipments.splice(index,1);
          }
        };

        $scope.saveBusiness = function(addListingForm) {
            if (addListingForm.$invalid) {
              if (angular.element($document[0].querySelector('input.ng-invalid'))[0]) {
                angular.element($document[0].querySelector('input.ng-invalid'))[0].focus();
                return false
              } else {
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
                isforSell: $scope.isForSell,
                isHidden: $scope.isHidden,
                forSellPrice: $scope.forSellPrice,
                imageLogo: "",
                imageFirst: "https://s3-media1.fl.yelpcdn.com/bphoto/3oEbIFTQpS0-TdSpZoTz1g/o.jpg",
                street1: $scope.street1,
                street2: $scope.street2,
                city: $scope.city,
                stateCode: $scope.businessState.code,
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
            //TODO need to get userid
            $scope.businessDetails.invokerId = userProfile.userId;
//            $scope.businessDetails.invokerId = 1001;
            propertyService.addBusinessDetails($scope.businessDetails)
            .success(function(res) {
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
        //            var progress = parseInt((evt.loaded * 100) / evt.total);
        //            if (progress === 100) {
        //              console.log("photo uploaded successfully");
        //            }
        //          }).send(function (err, data) {
        //            if (data) {
        //              //displays the image location on amazon s3 bucket
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
