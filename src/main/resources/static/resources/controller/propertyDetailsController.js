(function() {

  'use strict';

  angular
    .module('myApp')
    .controller('propertyDetailsController', propertyDetailsController);

    propertyDetailsController.$inject = ['$rootScope', '$scope', '$state', 'propDetails', 'propertyService', 'similarProps', 'authService'];

    function propertyDetailsController($rootScope, $scope, $state, propDetails, propertyService, similarProps, authService) {
    	$rootScope.authService = authService;
        $rootScope.isAuthenticated = authService.isAuthenticated();

        if (authService.getCachedProfile()) {
        	$rootScope.profile = authService.getCachedProfile();
        } else {
          authService.getProfile(function(err, profile) {
        	  $rootScope.profile = profile;
            propertyService.saveProfile(profile).success(function(res) {
                 console.log("In propertyDetailsController saveProfile "+ res);
                 if(res) {
                    localStorage.setItem('userprofile',JSON.stringify(res[0]));
                 }
            })
            .error(function (error) {
                $scope.status = 'Unable to get profile: ' + error.message;
            });
            $scope.$apply();
          });
        }
        console.log("here-----", propDetails.data.data, similarProps.data.data.propertyList);
        $scope.similarPropertyList = similarProps.data.data.propertyList;
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
              // galleryTop.params.control = galleryThumbs;
              // galleryThumbs.params.control = galleryTop;
		    }, 100);

        setTimeout(function() {
          var swiper = new Swiper('.swiper-container-per-group', {
            slidesPerView: 4,
            spaceBetween: 10,
            slidesPerGroup: 4,
            loop: true,
            loopFillGroupWithBlank: true,
            pagination: {
              el: '.swiper-pagination',
              clickable: true,
            },
            navigation: {
              nextEl: '.swiper-button-next',
              prevEl: '.swiper-button-prev',
            },
          });
        },100);

    }

})();
