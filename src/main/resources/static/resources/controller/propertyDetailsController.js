(function() {

  'use strict';

  angular
    .module('myApp')
    .controller('propertyDetailsController', propertyDetailsController);

    propertyDetailsController.$inject = ['$rootScope', '$scope', '$state', 'propDetails', 'propImages', 'propertyService'];

    function propertyDetailsController($rootScope, $scope, $state, propDetails, propImages, propertyService) {

        $scope.propDetails = propDetails.data[0];
        $scope.imageArray = propImages.data;
        console.log($scope.propDetails, $scope.imageArray);
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
    }

})();
