(function () {

    'use strict';

    angular
        .module('myApp')
        .controller('searchController', searchController)
        .filter('startFrom', startFrom);
    searchController.$inject = ['$rootScope', '$scope', '$state', 'propertyService', 'propList', 'constants'];

    function searchController($rootScope, $scope, $state, propertyService, propList, constants) {
        $scope.currentPage = 1;
        $scope.viewby = 10;
        $scope.itemsPerPage = $scope.viewby;
        $scope.searchList = propList.data.data.businessList;
        $scope.numberOfPages = Math.floor($scope.searchList.length/$scope.itemsPerPage);

        $scope.minPriceList = constants.allPriceList;
        $scope.maxPriceList = constants.allPriceList;
        $scope.minSqFeetList = constants.allSqFeet;
        $scope.maxSqFeetList = constants.allSqFeet;
        $scope.minLotSizeList = constants.allLotSizeList;
        $scope.maxLotSizeList = constants.allLotSizeList;
        $scope.minYearBuiltList = constants.allYearBuiltList;
        $scope.maxYearBuiltList = constants.allYearBuiltList;
        $scope.maxHoaFeesList = constants.allMaxHoaFeesList;
        $scope.timeListedList = constants.allTimeListedList;
        $('li').click(function() {
            if (1 < $scope.currentPage < $scope.numberOfPages) {
                $(this).addClass('active').siblings().removeClass('active');
            }
        });

        $scope.disablePrevious = function() {
            if ($scope.currentPage <= 1){
                return true
            } else {
                $scope.currentPage -= 1
                return false
            }
        };

        $scope.disableNext = function() {
            if ($scope.currentPage >= $scope.totalPages){
                return false
            } else {
                $scope.currentPage += 1
                return true
            }
        };
        $scope.setItemsPerPage = function(num) {
          $scope.itemsPerPage = num;
          $scope.currentPage = 1; //reset to first page
          $scope.numberOfPages = Math.floor($scope.searchList.length/$scope.itemsPerPage);
        }

        $scope.filterByMinPrice = function (price) {
            //var key = constants.allPriceList.indexOf($scope.$$childTail.minPrice);
            $scope.maxPriceList = constants.allPriceList.slice(price.id + 1);

            //console.log("filterByMinPrice" + price.actualPrice);
            var searchAddress = JSON.parse(localStorage.getItem('searchBusinessAttributes'));
            searchAddress['minPrice'] = price && price.actualPrice || null;
            localStorage.setItem('searchAddress', JSON.stringify(searchAddress));
            updateSearchResult(searchAddress);

        };

        $scope.filterByMaxPrice = function (price) {
            //var key = allPriceList.indexOf($scope.$$childTail.maxPrice);
            $scope.minPriceList = constants.allPriceList.slice(0, price.id - 1);
            //console.log("filterByMaxPrice", $scope);

            var searchAddress = JSON.parse(localStorage.getItem('searchBusinessAttributes'));
            searchAddress['maxPrice'] = price && price.actualPrice || null;
            localStorage.setItem('searchAddress', JSON.stringify(searchAddress));
            updateSearchResult(searchAddress);
        };

        $scope.filterByBusinessType = function (businessType) {
            console.log("filterByBusinessType", $scope.$$childTail.businessType);
            console.log("filterByBusinessType", businessType);
            var searchAddress = JSON.parse(localStorage.getItem('searchBusinessAttributes'));
            searchAddress['businessType'] = businessType || null;
            localStorage.setItem('searchAddress', JSON.stringify(searchAddress));
            updateSearchResult(searchAddress);
            //TODO call search business api with businessType filter
        };

        $scope.filterByListingType = function () {
            console.log("filterByListingType", $scope.$$childTail.listingType);
            //TODO call search business api with listing Type filter
        };

        $scope.filterByMinSqFeet = function () {
            var key = constants.allSqFeet.indexOf($scope.$$childTail.minSqFeet);
            $scope.maxSqFeetList = constants.allSqFeet.slice(key + 1);
            console.log("filterByMinSqFeet", $scope);
            //TODO call search business api with minSqFeet filter
        };

        $scope.filterByMaxSqFeet = function () {
            var key = constants.allSqFeet.indexOf($scope.$$childTail.maxSqFeet);
            $scope.minSqFeetList = constants.allSqFeet.slice(0, key);
            console.log("filterByMaxSqFeet", $scope);
            //TODO call search business api with maxSqFeet filter
        };

        $scope.filterByMinLotSize = function () {
            var key = constants.allLotSizeList.indexOf($scope.$$childTail.minLotSize);
            $scope.maxLotSizeList = constants.allLotSizeList.slice(key + 1);
            console.log("filterByMinLotSize", $scope);
            ////TODO call search business api with minLotSize filter
        };

        $scope.filterByMaxLotSize = function () {
            var key = constants.allLotSizeList.indexOf($scope.$$childTail.maxLotSize);
            $scope.minLotSizeList = constants.allLotSizeList.slice(0, key);
            console.log("filterByMaxLotSize", $scope);
            //TODO call search business api with maxSqFeet filter
        };

        $scope.filterByMinYearBuilt = function () {
            var key = constants.allYearBuiltList.indexOf($scope.$$childTail.minYearBuilt);
            $scope.maxYearBuiltList = constants.allYearBuiltList.slice(0, key);
            console.log("filterByMinYearBuilt", $scope);
            //TODO call search business api with minYearBuilt filter
        };

        $scope.filterByMaxYearBuilt = function () {
            var key = constants.allYearBuiltList.indexOf($scope.$$childTail.maxYearBuilt);
            $scope.minYearBuiltList = constants.allYearBuiltList.slice(key + 1);
            console.log("filterByMaxYearBuilt", $scope);
            //TODO call search business api with maxYearBuilt filter
        };

        $scope.filterByMaxHoaFees = function () {
            console.log("filterByMaxHoaFees", $scope.$$childTail.maxHoaFees);
            //TODO call search business api with maxHoaFees filter
        };

        $scope.filterByTimeListed = function () {
            console.log("filterByTimeListed", $scope.$$childTail.timeListed);
            //TODO call search business api with timeListed filter
        };

        $scope.filterByKeywords = function () {
            console.log("filterByKeywords", $scope.$$childTail.keywords);
            //TODO call search business api with keywords filter
        };

        $scope.applyFilters = function (filter) {
            console.log('Apply Filters' + filter);
        };

        $scope.bookMarked = function (obj, index) {
            console.log("Book marked " + obj.id);
            var userid = JSON.parse(sessionStorage.getItem('profile'));
            if (userid) {
                !obj.isBookMarked && propertyService.bookMarkedProperty({
                    "userId": userid.id,
                    "propertyDetailsId": obj.id
                })
                    .success(function (res) {
                        $scope.searchList[index].isBookMarked = true;
                    })
                    .error(function (error) {
                        $scope.status = 'Unable to load business list: ' + error.message;
                    });
                obj.isBookMarked && propertyService.removeBookMarkedProperty({
                    "userId": userid.id,
                    "propertyDetailsId": obj.id
                })
                    .success(function (res) {
                        $scope.searchList[index].isBookMarked = false;
                    })
                    .error(function (error) {
                        $scope.status = 'Unable to load business list: ' + error.message;
                    });
            }
        };

        var postal_code = '', latitude = '', longitude = '';
        $scope.filterByAddress = function () {
            var autocomplete_search;
            var componentForm = {
                street_number: 'short_name',
                route: 'long_name',
                locality: 'long_name',
                administrative_area_level_1: 'short_name',
                country: 'long_name',
                postal_code: 'short_name'
            };

            autocomplete_search = new google.maps.places.Autocomplete(
                /** @type {!HTMLInputElement} */(document.getElementById('autocomplete_search')),
                {types: ['geocode']});

            autocomplete_search.addListener('place_changed', fillInAddress);

            function fillInAddress() {
                var place = autocomplete_search.getPlace();

                var lat = place.geometry.location.lat();
                var lng = place.geometry.location.lng();
                latitude = lat;
                longitude = lng;
                for (var i = 0; i < place.address_components.length; i++) {
                    var addressType = place.address_components[i].types[0];
                    if (componentForm[addressType]) {
                        var val = place.address_components[i][componentForm[addressType]];
                        if (addressType === 'postal_code') {
                            postal_code = val;
                        }
                    }
                }
                var searchAddress = {
                    type: "Sale",
                    postal_code: postal_code,
                    latitude: latitude,
                    longitude: longitude
                };
                localStorage.setItem('searchAddress', JSON.stringify(searchAddress));

                $state.go('search', {type: "Sale"}, {reload: 'search'});
            }
        };

        var map;
        var markers = [];
        var infowindow = new google.maps.InfoWindow({
            content: ''
        });
        $scope.initialize = function (dataset) {
            // var arrDestinations = [];
            /*
              {
                lat: 37.5044441223145,
                lon: -121.908317565918,
                title: "Brighton Pier",
                description: "Brighton Palace Pier dates to 1899"
              },
              {
                  lat: 37.5495200924684,
                  lon: -121.986431338286,
                  title: "Brighton Pier",
                  description: "Brighton Palace Pier dates to 1899"
                },
                {
                  lat: 37.5330543518066,
                  lon: -122.001739501953,
                  title: "Brighton Pier",
                  description: "Brighton Palace Pier dates to 1899"
                },
                {
                lat: 37.5505241,
                lon: -121.9793462,
                title: "Brighton Pier",
                description: "Brighton Palace Pier dates to 1899"
              },
                {
                  lat: 37.5577268634313,
                  lon: -122.006441241109,
                  title: "Brighton Pier",
                  description: "Brighton Palace Pier dates to 1899"
                },
                {
                  lat: 37.5625444,
                  lon: -122.0098005,
                  title: "Brighton Pier",
                  description: "Brighton Palace Pier dates to 1899"
                }
            ];
            */
            // for(var i=0;i<dataset.length;i = i + 1) {
            //  arrDestinations.push({'lat':dataset[i].latitude,'lon':dataset[i].longitude,'title':dataset[i].property_name,'description':dataset[i].property_name,'image_url': dataset[i].img_url});
            // }

            // var searchAddress = JSON.parse(localStorage.getItem('searchAddress'));
            var searchAddress = JSON.parse(localStorage.getItem('searchBusinessAttributes'));
            var styles = [
                {
                    featureType: 'poi.government',
                    elementType: 'labels',
                    stylers: [{"saturation": -100}]
                },
                {
                    featureType: 'poi.park',
                    elementType: 'labels',
                    stylers: [{"saturation": -100}]
                },
                {
                    featureType: 'poi.attraction',
                    elementType: 'labels',
                    stylers: [{"saturation": -100}]
                },
                {
                    featureType: 'poi.place_of_worship',
                    elementType: 'labels',
                    stylers: [{"saturation": -100}]
                },
                {
                    featureType: 'poi.sports_complex',
                    elementType: 'labels',
                    stylers: [{"saturation": -100}]
                },
                {
                    featureType: 'transit',
                    elementType: 'labels',
                    stylers: [{"saturation": -100}]
                },
                {
                    featureType: 'poi.medical',
                    elementType: 'labels',
                    stylers: [{visibility: 'off'}]
                },
                {
                    featureType: 'poi.business',
                    elementType: 'labels',
                    stylers: [{visibility: 'off'}]
                },
            ];
            var mapOptions = {
                zoom: 13,
                center: new google.maps.LatLng(searchAddress.latitude, searchAddress.longitude),
                mapTypeId: google.maps.MapTypeId.ROADMAP,
                streetViewControl: false,
                fullscreenControl: false,
                scaleControl: false,

                mapTypeControl: true,
                mapTypeControlOptions: {
                    style: google.maps.MapTypeControlStyle.DROPDOWN_MENU,
                    mapTypeIds: ['roadmap', 'satellite', 'hybrid'],
                    position: google.maps.ControlPosition.TOP_RIGHT
                },
                minZoom: 10,
                maxZoom: 17,
                zoomControl: true,
                zoomControlOptions: {
                    position: google.maps.ControlPosition.RIGHT_TOP
                },
                gestureHandling: 'greedy',
                styles: styles,
            };

            map = new google.maps.Map(document.getElementById("map_canvas"), mapOptions);
            addMarker(dataset);
            showMarkers();
            // When map becomes idle after zoom ing or panning
            console.log("Initial zoom", map.getZoom());
            map.addListener('zoom_changed', function (e) {
                mapZoomPanChangeListeners();
            });

            function mapWindow() {
                var windowHeight = $(window).height();
                var windowWidth = $(window).width();
                var menuHeight = $('#menu').height();
                var advanceFilterMenuHeight = $(".menu-bar-with-background").height() || 40;
                var heightD = windowHeight;
                if (windowWidth > 767) {
                    $('#map_wrapper').height(heightD - menuHeight - advanceFilterMenuHeight);
                    $('.search-results').height(heightD - menuHeight - advanceFilterMenuHeight);

                } else {
                    $('#map_wrapper').height('auto');
                    $('.search-results').height('auto');
                }
            }

            mapWindow();
            $(window).resize(function () {
                mapWindow();
            });
            // var geocoder =  new google.maps.Geocoder();
            // geocoder.geocode( { 'address': 'Sunnyvale, CA, USA'}, function(results, status) {
            //   if (status === google.maps.GeocoderStatus.OK) {
            //   	console.log("lat lng result", results)
            //     alert("location : " + results[0].geometry.location.lat() + " " +results[0].geometry.location.lng());
            //   } else {
            //     alert("Something got wrong " + status);
            //   }
            // });
            //
            // var flightPlanCoordinates = [
            //   {lat: 37.66918637046184, lng: -121.81309596319335},
            //   {lat: 37.386020446229786, lng: -122.2608961226477},
            // ];
            // var flightPath = new google.maps.Polyline({
            //   path: flightPlanCoordinates,
            //   geodesic: true,
            //   strokeColor: '#FF0000',
            //   strokeOpacity: 1.0,
            //   strokeWeight: 2,
            // map: map
            // });
            // var cityCircle = new google.maps.Circle({
            //   strokeColor: '#FF0000',
            //   strokeOpacity: 0.8,
            //   strokeWeight: 2,
            //   fillColor: '#FF0000',
            //   fillOpacity: 0.35,
            //   map: map,
            //   center: {lat: searchAddress.latitude, lng: searchAddress.longitude},
            //   radius: 10000,
            // });

            // map.fitBounds(searchAddress.viewport);
            // console.log("map bounds", map.getBounds());
        };

        function mapZoomPanChangeListeners() {
            var arrDestinations = [];
            var center = map.getCenter();
            var bounds = map.getBounds();

            function getBoundsRadius(bounds) {
                // r = radius of the earth in miles
                var r = 3963.0;
                // degrees to radians (divide by 57.2958)
                const ne_lat = bounds.getNorthEast().lat() / 57.2958;
                const ne_lng = bounds.getNorthEast().lng() / 57.2958;
                const c_lat = bounds.getCenter().lat() / 57.2958;
                const c_lng = bounds.getCenter().lng() / 57.2958;
                // distance = circle radius from center to Northeast corner of bounds
                const r_km = r * Math.acos(
                    Math.sin(c_lat) * Math.sin(ne_lat) +
                    Math.cos(c_lat) * Math.cos(ne_lat) * Math.cos(ne_lng - c_lng)
                );
                // return r_km *1000 // radius in meters
                return r_km // radius in miles
            }

            var radius = getBoundsRadius(bounds);
            deleteMarkers();
            console.log(center.lat(), center.lng(), radius);
            var search_address = JSON.parse(localStorage.getItem('searchBusinessAttributes'));
            search_address['latitude'] = center.lat();
            search_address["longitude"] = center.lng();
            search_address["radius"] = radius;
            updateSearchResult(search_address);
        }

        function updateSearchResult(filter) {
            var arrDestinations = [];
            localStorage.setItem('searchAddress', JSON.stringify(filter));
            propertyService.getBusinessList(JSON.stringify(filter))
                .success(function (res) {
                    arrDestinations = res.data.businessList;
                    addMarker(arrDestinations);
                    showMarkers();
                    $scope.searchList = arrDestinations;
                    console.log("$scope.searchList ", $scope.searchList);
                })
                .error(function (error) {
                    $scope.status = 'Unable to load store data: ' + error.message;
                    console.log("res ", $scope.status);
                });
        }

        async function addMarker(arrDestinations) {
            console.log("Add markers", arrDestinations);
            markers = [];
            for (var i = 0; i < arrDestinations.length; i++) {
                var marker = new google.maps.Marker({
                    title: arrDestinations[i].propertyName,
                    icon: 'http://labs.google.com/ridefinder/images/mm_20_blue.png',
                    position: new google.maps.LatLng(arrDestinations[i].latitude, arrDestinations[i].longitude),
                    map: map
                });
                markers.push(marker);
                // add an event listener for this marker
                bindInfoWindow(marker, map, "<p> <a href=\"#propertyDetails/" + arrDestinations[i].id + "\"><img src=\"" + arrDestinations[i].imageUrl + "\" style=\"width:40px;height:40px\" class=\"img-fluid\" alt=\"\"> " + arrDestinations[i].propertyName + "</p>");
            }
        }

        // Sets the map on all markers in the array.
        function setMapOnAll(map) {
            for (var i = 0; i < markers.length; i++) {
                markers[i].setMap(map);
            }
        }

        // Removes the markers from the map, but keeps them in the array.
        function clearMarkers() {
            setMapOnAll(null);
        }

        // Shows any markers currently in the array.
        function showMarkers() {
            setMapOnAll(map);
        }

        // Deletes all markers in the array by removing references to them.
        function deleteMarkers() {
            clearMarkers();
            markers = [];
        }

        function bindInfoWindow(marker, map, html) {
            google.maps.event.addListener(marker, 'click', function () {
                infowindow.setContent(html);
                infowindow.open(map, marker);
            });
        }

        $scope.initialize(propList.data.data.businessList);

    }

        function startFrom() {
        return function(input, start) {
            start = +start;
            return input.slice(start);
        };
    };


})();
