(function() {

  'use strict';

  angular
    .module('myApp')
    .controller('editPropertyDetailsController_new', editPropertyDetailsController_new);

  editPropertyDetailsController_new.$inject = ['$rootScope', '$scope', 'propDetails', 'propertyService', '$state'];

  function editPropertyDetailsController_new($rootScope, $scope, propDetails, propertyService, $state) {

    var prop = propDetails.data.data;
    $scope.propDetails = propDetails.data.data;
    $scope.imageArray = propDetails.data.data.propertyImages || [];
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
    $scope.property = {
      // "propertyTitle": prop.property_name,
      // "image_url": prop.img_url,
      // "display_phone": prop.phone_number,
      // //"propertyDescription": prop.propertyDescription,
      // "bedrooms": "",
      // "bathrooms": "",
      // "price": prop.price,
      // "rentSale": prop.property_available_for,
      // "address": prop.property_address,
      // "city": prop.city,
      // "state": prop.state,
      // //"country": prop.country,
      // "zipcode": prop.zip_code,
      // "lat": prop.latitude,
      // "lng": prop.longitude,
      // //"userName": prop.userName,
      // //"rentSale": prop.rentSale,
      // "sqFt": prop.lot_size,
      // //"pricePerSqFt": prop.pricePerSqFt,
      // //"type": prop.type,
      // "mlsNumber": prop.mls_number,
      // "id": prop.id,
      // "type": ""
    };

    $scope.property.type = prop.type === 'Commercial' ? $scope.types[0] : $scope.types[1];
    $scope.updateBusinessDesc = function() {
      $scope.oldBusinessDescription = $scope.propDetails.description;
      updateProperty()
    };

    $scope.cancelUpdateBusinessDesc = function(oldBusinessDescription) {
      $scope.propDetails.description = oldBusinessDescription;
    };

    $scope.updateBusinessFeatures = function() {
      $scope.oldLotSize = $scope.propDetails.propertyMetaData.lotSize;
      $scope.oldYearBuilt = $scope.propDetails.propertyMetaData.yearBuilt;
      updateProperty()
    };

    $scope.cancelUpdateBusinessFeatures = function(oldLotSize, oldYearBuilt) {
      $scope.propDetails.propertyMetaData.lotSize = oldLotSize;
      $scope.propDetails.propertyMetaData.yearBuilt = oldYearBuilt;
    };


    $scope.updateRestDetails = function() {
      $scope.oldType = $scope.propDetails.type;
      $scope.oldDesciption = $scope.propDetails.description;
      // updateProperty()
    };

    $scope.cancelUpdateRestDetails = function(oldRest) {
      // $scope.propDetails.type = oldType;
      // $scope.propDetails.description = oldDescription;
    };

    function updateProperty () {
      // save images to aws
      $scope.uploadPhotoOnAWS();
      var apiName;
      for (var i=0; i < $scope.types.length-1; i++) {
        if ($scope.types[i].name === $scope.propDetails.propertyMetaData.businessType) {
          apiName = $scope.types[i].apiName
        }
      }
      propertyService.updatePropertyDetails(apiName, $scope.propDetails)
        .success(function(res) {
          // TODO need to show some success model
        })
        .error(function (error) {
          $scope.status = 'Unable to load store data: ' + error.message;
        });

    };


    $scope.imagesAsDataURL = [];
    $scope.imageFiles = [];
    for (var i = 0; i < $scope.imageArray.length; i++) {
      $scope.imagesAsDataURL.push($scope.imageArray[i].imageUrl)
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
      var itemIndex = $scope.imagesAsDataURL.indexOf(imageUrl);
      $scope.imagesAsDataURL.splice(itemIndex, 1);
      $scope.imageFiles.splice(itemIndex, 1);
    };

    $scope.progress=0;
    $scope.uploadPhotoOnAWS = function(){
      for (var i=0; i < $scope.imageFiles.length; i++) {
        var photo = $scope.imageFiles[i];
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
          var progress = parseInt((evt.loaded * 100) / evt.total);
          if (progress === 100) {
            console.log("photo uploaded successfully");
          }
        }).send(function (err, data) {
          if (data) {
            //displays the image location on amazon s3 bucket
            $scope.propertyImages.push(data.Location);
          }
        });
      }
    };

  }

})();
