(function() {

  'use strict';

  angular
    .module('myApp')
    .controller('propertyDetailsController', propertyDetailsController);

    propertyDetailsController.$inject = ['$rootScope', '$scope', '$state', 'propDetails', 'propertyService'];

    function propertyDetailsController($rootScope, $scope, $state, propDetails, propertyService) {
        $scope.propDetails = propDetails.data.data;
        $scope.imageArray = propDetails.data.data.propertyImages || [];
        $scope.businessCommonFeatures =  [
            {id:1, label: "Lot Size", model: $scope.propDetails.propertyMetaData.lotSize + " Sq. Ft.", tooltip: "Lot Size"},
            {id:2, label: "Buisness Type", model: $scope.propDetails.propertyMetaData.businessType, tooltip: "Business Type"},
            {id:3, label: "Year Built", model: $scope.propDetails.propertyMetaData.yearBuilt, tooltip: "Year built"},
            {id:4, label: "Price/sqft", model: $scope.propDetails.propertyMetaData.pricePerSqft, tooltip: "Price per square feet"},
            {id:5, label: "Days on BRW", model: $scope.propDetails.propertyMetaData.daysOnBrw, tooltip: "Days on BRW"},

        ];

        setTimeout(function(){
        	var galleryThumbs = new Swiper('.gallery-thumbs', {
                spaceBetween: 10,
                slidesPerView: "auto",
                touchRatio: 0.2,
                loop:true,
                slideToClickedSlide: true,
                loopedSlides: 10,
                freeMode: true,
                watchSlidesVisibility: true,
                watchSlidesProgress: true,
              });

              var galleryTop = new Swiper('.gallery-top', {
                spaceBetween: 10,
                loop: true,
                loopedSlides: 10,
                navigation: {
                  nextEl: '.swiper-button-next',
                  prevEl: '.swiper-button-prev',
                },
                thumbs: {
                  swiper: galleryThumbs
                }
              });
              galleryTop.params.control = galleryThumbs;
              galleryThumbs.params.control = galleryTop;
		}, 100);
        
    }

})();
