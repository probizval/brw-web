(function() {

    'use strict';

    angular
        .module('myApp')
        .constant('constants', {
            businessDefinition: {
                RESTAURANT: {label: "Restaurants"},
                BEAUTY: {label: "Beauty Salon/Spa/Nail"},
                GAS_STATION: {label: "Gas Station"},
            },
            equipmentListMapping: {
                REGULAR_FREEZER: 'Regular Freezer',
                KITCHEN_HOOD: 'Kitchen Hood',
                OTHER: 'Other',
                DISH_WASHER: 'Dish Washer'
            },
            // businessCommonFeatures: [
            //     {id:1, label: "Lot Size", model: $scope.businessDetails.sqftLot + " Sq. Ft.", tooltip: "Lot Size"},
            //     {id:2, label: "Business Type", model: constants.businessDefinition[$scope.businessDetails.type].label, tooltip: "Business Type"},
            //     {id:3, label: "Year Established", model: $scope.businessDetails.yearEstablished, tooltip: "Year Established"},
            //     // {id:4, label: "Price/sqft", model: $scope.businessDetails.propertyMetaData.pricePerSqft, tooltip: "Price per square feet"},
            //     // {id:5, label: "Days on BRW", model: $scope.businessDetails.propertyMetaData.daysOnBrw, tooltip: "Days on BRW"},
            // ],
            allPriceList: [
                {id: 1, price: "$50k", actualPrice: 50000},
                {id: 2, price: "$75k", actualPrice: 75000},
                {id: 3, price: "$100k", actualPrice: 100000},
                {id: 4, price: "$125k", actualPrice: 125000},
                {id: 5, price: "$150k", actualPrice: 150000},
                {id: 6, price: "$175k", actualPrice: 175000},
                {id: 7, price: "$200k", actualPrice: 200000},
                {id: 8, price: "$225k", actualPrice: 225000},
                {id: 9, price: "$250k", actualPrice: 250000},
                {id: 10, price: "$275k", actualPrice: 275000},
                {id: 11, price: "$300k", actualPrice: 300000},
                {id: 12, price: "$325k", actualPrice: 325000},
                {id: 13, price: "$350k", actualPrice: 350000},
                {id: 14, price: "$375k", actualPrice: 375000},
                {id: 15, price: "$400k", actualPrice: 400000},
                {id: 16, price: "$425k", actualPrice: 425000},
                {id: 17, price: "$450k", actualPrice: 450000},
                {id: 18, price: "$475k", actualPrice: 475000},
                {id: 19, price: "$500k", actualPrice: 500000},
                {id: 20, price: "$600k", actualPrice: 600000},
                {id: 21, price: "$700k", actualPrice: 700000},
                {id: 22, price: "$800k", actualPrice: 800000},
                {id: 23, price: "$900k", actualPrice: 900000},
                {id: 24, price: "$1M", actualPrice: 1000000},
                {id: 25, price: "$2M", actualPrice: 2000000},
                {id: 26, price: "$3M", actualPrice: 3000000},
                {id: 27, price: "$4M", actualPrice: 4000000},
                {id: 28, price: "$5M", actualPrice: 5000000}],
            allSqFeet: [
                {id: 1, size: 500},
                {id: 2, size: 750},
                {id: 3, size: 1000},
                {id: 4, size: 1250},
                {id: 5, size: 1500},
                {id: 6, size: 1750},
                {id: 7, size: 2000},
                {id: 8, size: 2250},
                {id: 9, size: 2500},
                {id: 10, size: 2750},
                {id: 11, size: 3000},
                {id: 12, size: 3250},
                {id: 13, size: 3500},
                {id: 14, size: 3750},
                {id: 15, size: 4000},
                {id: 16, size: 4250},
                {id: 17, size: 4500},
                {id: 18, size: 4750},
                {id: 19, size: 5000}],

            allLotSizeList: [
                {id: 1, size: '2,000 sq ft'},
                {id: 2, size: '4,000 sq ft'},
                {id: 3, size: '6,000 sq ft'},
                {id: 4, size: '8,000 sq ft'},
                {id: 5, size: '.5 acres'},
                {id: 6, size: '1 acres'},
                {id: 7, size: '2 acres'},
                {id: 8, size: '3 acres'},
                {id: 9, size: '5 acres'}],

            allMaxHoaFeesList: [
                {id: 1, price: '$100/month'},
                {id: 2, price: '$200/month'},
                {id: 3, price: '$300/month'},
                {id: 4, price: '$400/month'},
                {id: 5, price: '$500/month'}],

            allYearBuiltList: [
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
                {id: 15, year: 1930}],

            allTimeListedList: [
                {id: 1, time: '1 day'},
                {id: 2, time: '7 Days'},
                {id: 3, time: '14 days'},
                {id: 4, time: '30 days'},
                {id: 5, time: '45 days'},
                {id: 6, time: '60 days'},
                {id: 7, time: '90 days'},
                {id: 8, time: '120 days'}],

})

})();