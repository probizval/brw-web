(function() {

    'use strict';

    angular
        .module('myApp')
        .controller('businessDetailsController', businessDetailsController);

    businessDetailsController.$inject = ['$rootScope', '$scope', '$state', '$filter', 'details', 'estimates',
        'propImages', 'propertyService', 'authService', 'constants'];

    function businessDetailsController($rootScope, $scope, $state, $filter, details, estimates, propImages,
                                       propertyService, authService, constants) {
        $rootScope.authService = authService;
        $scope.equipmentExpanded = false;
        $rootScope.isAuthenticated = authService.isAuthenticated();
        $scope.isNumber = function isNumber(val) {
            return typeof val === 'number'
        };
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
        // $scope.similarPropertyList = similarProps.data.data.propertyList;
        $scope.businessDetails = details.data.data;
        $scope.businessDetails.createDate = details.data.data.createDate.split('T')[0];
        $scope.estimates = estimates.data.data.estimatesList;
//        $scope.imageArray = propImages.data.imagesList
        $scope.imageArray = [{"imageId": 100, "url": $scope.businessDetails.imageFirst}];
        if (propImages.data.imagesList.length !== 0) {
            $scope.imageArray.push(...propImages.data.imagesList)
        }
        $scope.businessCommonFeatures =  [
            {id:1, label: "Inside SQFT", model: $scope.businessDetails.sqftIndoor},
            {id:2, label: "Open Air SQFT", model: $scope.businessDetails.sqftOutdoor},
            {id:3, label: "Lot Size SQFT", model: $scope.businessDetails.sqftLot},
            {id:4, label: "Average Monthly Revenue", model: "$" + $filter('number')($scope.businessDetails.revenueMonthly)},
            {id:5, label: "Average Monthly Expense", model: "$" +  $filter('number')($scope.businessDetails.expenseMonthlyMaterial)},
            {id:6, label: "Monthly Rent", model: "$" + $filter('number')($scope.businessDetails.expenseMonthlyRent)},
            {id:7, label: "Monthly Mortgage", model: "$" + $filter('number')($scope.businessDetails.expenseMonthlyMortgage)},
            {id:8, label: "Avg Monthly Row Material Cost", model: "$" + $filter('number')($scope.businessDetails.expenseMonthlyMaterial)},
            {id:9, label: "Avg Monthly Utility Cost", model: "$" + $filter('number')($scope.businessDetails.expenseMonthlyUtility)},
            {id:10, label: "Avg Monthly Other Cost", model: "$" + $filter('number')($scope.businessDetails.expenseMonthlyOther)},
            {id:11, label: "Number of Full Time Employees", model: $scope.businessDetails.empFullTimeNum},
            {id:12, label: "Number of Part Time Employees", model: $scope.businessDetails.empPartTimeNum},
            {id:13, label: "Avg Monthly Employee Cost", model: "$" + $filter('number')($scope.businessDetails.expenseMonthlyEmp)},
            {id:14, label: "Est Total Value of Equipment", model: "$" + $filter('number')($scope.businessDetails.valueTotalEquipment)},
            {id:15, label: "Est Total Value of Furniture", model: "$" + $filter('number')($scope.businessDetails.valueTotalFurniture)},
            {id:16, label: "Est Total Value of Indoor Decoration", model: "$" + $filter('number')($scope.businessDetails.valueIndoorDeco)},
            {id:17, label: "Est Total Value of Outdoor Decoration", model: "$" + $filter('number')($scope.businessDetails.valueOutdoorDeco)},
//            {id:5, label: "Number of Parking Spots", model: $scope.businessDetails},
            {id:18, label: "Area Walk Score", model: $scope.businessDetails.areaWalkScore},
            {id:19, label: "Area Crime Score", model: $scope.businessDetails.areaCrimeScore},
            {id:20, label: "Area Attractions Score", model: $scope.businessDetails.areaAttractionsScore},
            {id:21, label: "Area Transit Score", model: $scope.businessDetails.areaTransitScore},
            {id:22, label: "Social Media Score", model: $scope.businessDetails.socialMediaScore},
            {id:23, label: "Population in 1 mile Rad", model: $scope.businessDetails.populationIn1mileRadius},
            {id:24, label: "Population in 3 mile Rad", model: $scope.businessDetails.populationIn3mileRadius},
            {id:25, label: "Population in 5 mile Rad", model: $scope.businessDetails.populationIn5mileRadius},
            {id:26, label: "Yr household income 1 mile Rad", model: "$" + $filter('number')($scope.businessDetails.incomeScoreIn1mileRadius)},
            {id:27, label: "Yr household income 3 mile Rad", model: "$" + $filter('number')($scope.businessDetails.incomeScoreIn3mileRadius)},
            {id:28, label: "Yr household income 5 mile Rad", model: "$" + $filter('number')($scope.businessDetails.incomeScoreIn5mileRadius)},
            {id:29, label: "Avg Daily num of ppl at door front", model: $scope.businessDetails.dailyPeoplAtDoorNum},
            {id:30, label: "Avg Daily number of cars in parking lot", model: $scope.businessDetails.dailyCarsAtParklotNum},
            {id:31, label: "Year Business Started", model: $scope.businessDetails.yearEstablished},
            {id:32, label: "Data Completeness Score", model: $scope.businessDetails.dataCompletionScore},
            {id:33, label: "Website", model: $scope.businessDetails.website},
            {id:34, label: "NAICS", model: $scope.businessDetails.naicsnum},
            {id:35, label: "Claimed by Owner", model: $scope.businessDetails.isOwnerClaimed},
            {id:36, label: "Last Data Update Date", model: $scope.businessDetails.updateDate},
        ];
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

        setTimeout(function(){
            var galleryTop = new Swiper('.gallery-top', {
                spaceBetween: 10,
                navigation: {
                    nextEl: '.swiper-button-next',
                    prevEl: '.swiper-button-prev',
                },
                loop: true,
                loopedSlides: 4
            });
            var galleryThumbs = new Swiper('.gallery-thumbs', {
                spaceBetween: 10,
                slidesPerView: 'auto',
                touchRatio: 0.2,
                slideToClickedSlide: true,
                loop: true,
                loopedSlides: 4,
                watchSlidesVisibility: true,
                centeredSlides: true,
                watchSlidesProgress: true,
            });
            galleryTop.controller.control = galleryThumbs;
            galleryThumbs.controller.control = galleryTop;
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

        $scope.expandEquipments = function(equipmentExpanded) {
            if (!equipmentExpanded){
                $scope.equipmentExpanded = equipmentExpanded;
                $scope.equipmentList = [];
                return
            }
            propertyService.getAdditionalAttributes($state.params.id)
                .then(function (response) {
                    $scope.additionalAttributes = response.data.data.addAttributesList;
                    for (let i=0; i<$scope.additionalAttributes.length; i++ ) {
                        if ($scope.additionalAttributes[i].attribType === 'EQUIPMENT') {
                            $scope.equipmentList.push({
                                id: $scope.additionalAttributes[i].addAttribId,
                                label: constants.equipmentListMapping[$scope.additionalAttributes[i].attribSubType],
                                quantity: $scope.additionalAttributes[i].quantity,
                                pricePerUnit: $scope.additionalAttributes[i].pricePerUnit,
                                maintenanceCost: $scope.additionalAttributes[i].monthlyMaintExpense,
                            })
                        }
                    }
                    $scope.equipmentExpanded = equipmentExpanded;
                }, function (error) {
                    $scope.error = 'Unable to load business additional attributes: ' + error.message;
                });
        }
    }

})();