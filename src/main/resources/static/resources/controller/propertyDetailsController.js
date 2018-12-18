(function() {

  'use strict';

  angular
    .module('myApp')
    .controller('propertyDetailsController', propertyDetailsController);

    propertyDetailsController.$inject = ['$rootScope', '$scope', '$state', 'propDetails', 'propertyService'];

    function propertyDetailsController($rootScope, $scope, $state, propDetails, propertyService) {

        $scope.propDetails = propDetails.data.data;
        $scope.imageArray = propDetails.data.data.propertyImages || [];
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
