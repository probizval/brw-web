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

        $scope.kitchenInputList = [
          {id:1, label: "Hood Size", model: "business.kitchen.hoodSize", placeholder: "Sq. Ft.", tooltip: "Hood Size"},
          {id:2, label: "Kitchen Size", model: "business.kitchen.kitchenSize", placeholder: "", tooltip: ""},
          {id:3, label:"Dish Capacity", model:"business.kitchen.dishCapacity", placeholder:"", tooltip: ""},
          {id:4, label:"Number of Ovens", model:"business.kitchen.numberOfOvens", placeholder:"", tooltip: ""},
          {id:5, label:"Number of Cooking Range", model:"business.kitchen.numberOfCookingRange", placeholder:"", tooltip: ""},
          {id:6, label:"Exhaust Type", model:"business.kitchen.exhaustType", placeholder:"", tooltip: ""},
          {id:7, label:"Dry Storage", model:"business.kitchen.dryStorage", placeholder:"Sq. Ft.", tooltip: ""}
        ];

        $scope.kitchenAppliancesList = [
          {id:1, label: "Dishwasher", model: "business.Kitchen.Dishwasher", placeholder: "", checked: "true"},
          {id:2, label: "Range/Oven", model: "business.Kitchen.rangeOven", placeholder: "", checked: "true"},
          {id:3, label: "Walk in Freezer", model: "business.Kitchen.walkInFreezer", placeholder: "", checked: "true"},
          {id:4, label: "Refrigerator", model: "business.Kitchen.refrigerator", placeholder: "", checked: "true"}
        ];

        $scope.interiorInputList = [
          {id:1, label: "Interior Area", model: "business.interior.interiorArea", placeholder: "Sq. Ft.", tooltip: "Interior Area"},
          {id:2, label: "Seating Capacity", model: "business.interior.seatingCapacity", placeholder: "", tooltip: ""},
          {id:3, label: "Approx Furniture cost", model: "business.interior.furnitureCost", placeholder: "", tooltip: ""},
          {id:4, label:"Number of Restroom", model:"business.interior.numberOfRestroom", placeholder:"", tooltip: ""},
          {id:5, label:"Last Renovated Date", model:'business.interior.lastRenovatedDate', placeholder:"", tooltip: ""},
          {id:6, label:"Waiting Area Capacity", model:'business.interior.waitingAreaCapacity', placeholder:"", tooltip: ""}
        ];

        $scope.expensesList = [
          {id:1, label:"Rent", model:"business.expenses.rent", placeholder:"$", tooltip:""},
          {id:2, label:"NNN", model:"business.expenses.nnn", placeholder:"$", tooltip:""},
          {id:3, label:"Garbage", model:"business.expenses.garbage", placeholder:"$", tooltip:""},
          {id:4, label:"Utilities", model:"business.expenses.utilities", placeholder:"$", tooltip:""},
        ];

        $scope.revenuePerMonthList = [
          {id:1, label:"In Restaurant", model:"business.revenue.restaurant", placeholder:"$", tooltip:""},
          {id:2, label:"To Go", model:"business.revenue.toGo", placeholder:"$", tooltip:""},
          {id:3, label:"Catering", model:"business.revenue.catering", placeholder:"$", tooltip:""}
        ];

        $scope.employeesList = [
          {id:1, label:"Number of Full Time Employees", model:"business.employee.fullTimeEmployees", placeholder:"", tooltip:""},
          {id:2, label:"Number of Part Time Employees", model:"business.employee.partTimeEmployees", placeholder:"", tooltip:""},
          {id:3, label:"Number of Certified Employees", model:"business.employee.certifiedEmployees", placeholder:"", tooltip:""}
        ];

        $scope.laundryMachineDetailsList = [
          {id:1, label:"Maintenance Contract", model:"business.laundry.maintenanceContract", placeholder:"", tooltip:""},
          {id:2, label:"Machine Manufacturers", model:"business.laundry.machineManufacturers", placeholder:"", tooltip:""},
          {id:3, label:"Machine Efficiencies", model:"business.laundry.machineEfficiencies", placeholder:"", tooltip:""},
          {id:4, label:"Machine Lifespan", model:"business.laundry.machineLifeSpan", placeholder:"", tooltip:""}
        ];

      $scope.dryCleanersEquipmentsList = [
        {id:1, label: "Dry Cleaning", model: "business.dryCleaners.dryCleaningMachine", placeholder: "", checked: "true"},
        {id:2, label: "Laundry Machine", model: "business.dryCleaners.laundryMachine", placeholder: "", checked: "true"},
        {id:3, label: "Pressing Machine", model: "business.dryCleaners.pressingMachine", placeholder: "", checked: "true"},
        {id:4, label: "Dryer Machine", model: "business.dryCleaners.dryer", placeholder: "", checked: "true"},
        {id:4, label: "Shirt Machine", model: "business.dryCleaners.shirtMachine", placeholder: "", checked: "true"}
      ];

      $scope.dryCleanersTypeOfServiceList = [
        {id:1, label: "Full Service", model: "business.dryCleaners.fullService", placeholder: "", checked: "true"},
        {id:2, label: "Same Day", model: "business.dryCleaners.sameDayService", placeholder: "", checked: "true"},
        {id:3, label: "Pick up/Drop", model: "business.dryCleaners.pickUpDrop", placeholder: "", checked: "true"},
        {id:4, label: "Alteration", model: "business.dryCleaners.alteration", placeholder: "", checked: "true"},
      ];

      $scope.liquorStoreInteriorInputList = [
        {id:1, label: "Number of Cabinets", model: "business.liquorStoreInterior.numberOfCabinets", placeholder: "", tooltip: "Interior Area"},
        {id:2, label: "Number of vending Machines", model: "business.liquorStoreInterior.numberOfVendingMachines", placeholder: "", tooltip: ""},
      ];

      $scope.beautySalonServiceList = [
        {id:1, label: "Nail Care", model: "business.beautySalon.nailCare", placeholder: "", checked: "true"},
        {id:2, label: "Skin Care", model: "business.beautySalon.skinCare", placeholder: "", checked: "true"},
        {id:3, label: "Lash Extension", model: "business.beautySalon.lashExtension", placeholder: "", checked: "true"},
        {id:4, label: "Massage", model: "business.beautySalon.massage", placeholder: "", checked: "true"},
        {id:4, label: "Body Treatments", model: "business.beautySalon.bodyTreatments", placeholder: "", checked: "true"},
      ];
      $scope.beautySalonEquipmentsList = [
        {id:1, label: "Number of Manicure Tables", model: "business.beautySalon.manicureTables", placeholder: ""},
        {id:2, label: "Number of Nail Dryers", model: "business.beautySalon.nailDryers", placeholder: ""},
        {id:3, label: "Number of Portable Pedicure Spa", model: "business.beautySalon.pedicureSpa", placeholder: ""},
        {id:4, label: "Pedicure Spa Chairs", model: "business.beautySalon.spaChairs", placeholder: ""},
        {id:4, label: "Portable Trolleys", model: "business.beautySalon.trolleys", placeholder: ""}
      ];

      $scope.property = {
                "propertyTitle": "",
                "image_url": "",
                "display_phone": 0,
                "propertyDescription": "",
                "bedrooms": "",
                "bathrooms": "",
                "price": 0,
                "address": "",
                "city": "",
                "state": "",
                "country": "",
                "zipcode": 0,
                "lat": 0,
                "lng": 0,
                "userName": "",
                "rentSale": "Buy",
                "sqFt": 0,
                "pricePerSqFt": 0,
                "mlsNumber": 0,
                "type": "",
                "rest": {
                    "cuisineType": "Indo",
                    "desc": "Indo Restaurant"
                },
                "gas": {
                    "brand": "Shell",
                    "fuelType": ""
                },
                "uploaded_image_aws_urls": []
        };
        
        
        
        $scope.bedrooms = [
                         {numberofbeds:'0'},
                         {numberofbeds:'1'},
                         {numberofbeds:'2'}
                       ];
        $scope.bathrooms = [
                         {numberofbathrooms:'0'},
                         {numberofbathrooms:'1'},
                         {numberofbathrooms:'2'}
                       ];
        $scope.types = [
                         {name:'Restaurants and Food', code:'b_type_1'},
                         {name:'Gas Station', code:'b_type_2'},
                         {name:'Liquor Store', code:'b_type_3'},
                         {name:'Beauty Salon/Spa/Nail', code:'b_type_4'},
                         {name:'Convenience store', code:'b_type_5'},
                         {name:'Auto Service Shop', code:'b_type_6'},
                         {name:'Laundry', code:'b_type_7'},
                         {name:'Cafe', code:'b_type_8'},
                         {name:'Dry Cleaners', code:'b_type_9'}
        ];
        $scope.property.type = $scope.types[0];

        
        
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
            $scope.property.lng = document.getElementById("lng").value;
            $scope.property.lat = document.getElementById("lat").value;
            $scope.property.city = document.getElementById("locality").value;
            $scope.property.zipcode = document.getElementById("postal_code").value;
            $scope.property.state = document.getElementById("administrative_area_level_1").value;
            $scope.property.country = document.getElementById("country").value;
            $scope.property.address = document.getElementById("address").value;
            $scope.property.userName = localStorage.getItem('userName');
            $scope.uploadPhotoOnAWS();

            console.log($scope.property);
            $scope.property.userProfile = JSON.parse(localStorage.getItem('userprofile'));
            propertyService.savePropertyDetails($scope.property)
            .success(function(res) {
                 console.log("res "+ res);
                 console.log("res "+ res.status);
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

         $scope.change = function() {
            console.log($scope.property.type.name);
        };

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
              $scope.property.uploaded_image_aws_urls.push(data.Location);
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
