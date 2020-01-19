(function() {

    'use strict';

    angular
        .module('myApp')
        .controller('businessDetailsController', businessDetailsController);

    businessDetailsController.$inject = ['$rootScope', '$scope', '$state', 'details', 'estimates', 'additionalAttributes',
        'propImages', 'propertyService', 'similarProps', 'authService', 'constants'];

    function businessDetailsController($rootScope, $scope, $state, details, estimates, additionalAttributes, propImages,
                                       propertyService, similarProps, authService, constants) {
        $rootScope.authService = authService;
        $rootScope.isAuthenticated = authService.isAuthenticated();

        if (authService.getCachedProfile()) {
            $rootScope.profile = authService.getCachedProfile();
        } else {
            authService.getProfile(function(err, profile) {
                $rootScope.profile = profile;
                propertyService.saveProfile(profile).success(function(res) {
                    console.log("In businessDetailsController saveProfile "+ res);
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
        $scope.similarPropertyList = similarProps.data.data.propertyList;
        $scope.businessDetails = details.data.data;
        $scope.businessDetails.createDate = details.data.data.createDate.split('T')[0];
        $scope.estimates = estimates.data.data.estimatesList;
        $scope.imageArray = details.data.data.propertyImages || [];
        $scope.businessCommonFeatures =  [
            {id:1, label: "Lot Size", model: $scope.businessDetails.sqftLot + " Sq. Ft.", tooltip: "Lot Size"},
            {id:2, label: "Business Type", model: constants.businessDefinition[$scope.businessDetails.type].label, tooltip: "Business Type"},
            {id:3, label: "Year Established", model: $scope.businessDetails.yearEstablished, tooltip: "Year Established"},
            // {id:4, label: "Price/sqft", model: $scope.businessDetails.propertyMetaData.pricePerSqft, tooltip: "Price per square feet"},
            // {id:5, label: "Days on BRW", model: $scope.businessDetails.propertyMetaData.daysOnBrw, tooltip: "Days on BRW"},
        ];
        $scope.additionalAttributes = additionalAttributes.data.data.addAttributesList;
        $scope.estimateList = [];
        $scope.equipmentList = [];
        var label = "";
        for (let i=0; i < $scope.estimates.length; i++) {
            if ($scope.estimates[i].estimateType === "ASSET_BASED") {
                label = "Asset Based";
            } else if ($scope.estimates[i].estimateType === "MARKET_BASED") {
                label = "Market Based";
            } else if ($scope.estimates[i].estimateType === "INCOME_BASED") {
                label = "Income Based";
            }
            $scope.estimateList.push({
                id: i+1,
                label: label,
                model: "$" + $scope.estimates[i].estimatedAmount,
                range: "$" + $scope.estimates[i].estimatedAmountLow + " - $" + $scope.estimates[i].estimatedAmountHigh,
                tooltip: label + " estimate"})
        }

        for (let i=0; i<$scope.additionalAttributes.length; i++ ) {
            if ($scope.additionalAttributes[i].attribType === 'EQUIPMENT') {
                $scope.equipmentList.push({
                    id: i+1,
                    label: constants.equipmentListMapping[$scope.additionalAttributes[i].attribSubType],
                    quantity: $scope.additionalAttributes[i].quantity,
                    pricePerUnit: $scope.additionalAttributes[i].pricePerUnit,
                    maintenanceCost: $scope.additionalAttributes[i].monthlyMaintExpense,
                })
            }
        }

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