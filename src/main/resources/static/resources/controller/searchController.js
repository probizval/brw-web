(function() {

  'use strict';

  angular
    .module('myApp')
    .controller('searchController', searchController);

    searchController.$inject = ['$rootScope', '$scope', '$state', 'propertyService', 'propList'];

		var allPriceList = [
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
				{id: 28, price: "$5M", actualPrice: 5000000}];

			var allSqFeet = [
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
				{id: 19, size: 5000}];

			var allLotSizeList = [
				{id: 1, size: '2,000 sq ft'},
				{id: 2, size: '4,000 sq ft'},
				{id: 3, size: '6,000 sq ft'},
				{id: 4, size: '8,000 sq ft'},
				{id: 5, size: '.5 acres'},
				{id: 6, size: '1 acres'},
				{id: 7, size: '2 acres'},
				{id: 8, size: '3 acres'},
				{id: 9, size: '5 acres'}];

			var allMaxHoaFeesList = [
				{id: 1, price: '$100/month'},
				{id: 2, price: '$200/month'},
				{id: 3, price: '$300/month'},
				{id: 4, price: '$400/month'},
				{id: 5, price: '$500/month'}];

			var allYearBuiltList = [
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
				{id: 15, year: 1930}];

			var allTimeListedList = [
				{id: 1, time: '1 day'},
				{id: 2, time: '7 Days'},
				{id: 3, time: '14 days'},
				{id: 4, time: '30 days'},
				{id: 5, time: '45 days'},
        {id: 6, time: '60 days'},
        {id: 7, time: '90 days'},
        {id: 8, time: '120 days'}];

  function searchController($rootScope, $scope, $state, propertyService, propList) {

			$scope.searchList = propList.data.data.businessList;

    	$scope.minPriceList = allPriceList;
      $scope.maxPriceList = allPriceList;
			$scope.minSqFeetList = allSqFeet;
    	$scope.maxSqFeetList = allSqFeet;
			$scope.minLotSizeList = allLotSizeList;
			$scope.maxLotSizeList = allLotSizeList;
			$scope.minYearBuiltList = allYearBuiltList;
			$scope.maxYearBuiltList = allYearBuiltList;
			$scope.maxHoaFeesList = allMaxHoaFeesList;
			$scope.timeListedList = allTimeListedList;

      $scope.filterByMinPrice = function(price){
    	  //var key = allPriceList.indexOf($scope.$$childTail.minPrice);
    	  $scope.maxPriceList = allPriceList.slice(price.id + 1);

        //console.log("filterByMinPrice" + price.actualPrice);
			var searchAddress = JSON.parse(localStorage.getItem('searchBusinessAttributes'));
			searchAddress['minPrice'] = price && price.actualPrice || null;
			localStorage.setItem('searchAddress', JSON.stringify(searchAddress));
			updateSearchResult(searchAddress);
		
      };

      $scope.filterByMaxPrice = function(price){
    	  //var key = allPriceList.indexOf($scope.$$childTail.maxPrice);
    	  $scope.minPriceList = allPriceList.slice(0, price.id - 1);
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

      $scope.filterByMinSqFeet = function(){
        var key = allSqFeet.indexOf($scope.$$childTail.minSqFeet);
        $scope.maxSqFeetList = allSqFeet.slice(key + 1);
        console.log("filterByMinSqFeet", $scope);
        //TODO call search business api with minSqFeet filter
      };

			$scope.filterByMaxSqFeet = function(){
				var key = allSqFeet.indexOf($scope.$$childTail.maxSqFeet);
        $scope.minSqFeetList = allSqFeet.slice(0, key);
				console.log("filterByMaxSqFeet", $scope);
        //TODO call search business api with maxSqFeet filter
      };

			$scope.filterByMinLotSize = function(){
				var key = allLotSizeList.indexOf($scope.$$childTail.minLotSize);
				$scope.maxLotSizeList = allLotSizeList.slice(key + 1);
				console.log("filterByMinLotSize", $scope);
				////TODO call search business api with minLotSize filter
			};

			$scope.filterByMaxLotSize = function(){
				var key = allLotSizeList.indexOf($scope.$$childTail.maxLotSize);
				$scope.minLotSizeList = allLotSizeList.slice(0, key);
				console.log("filterByMaxLotSize", $scope);
        //TODO call search business api with maxSqFeet filter
			};

			$scope.filterByMinYearBuilt = function(){
				var key = allYearBuiltList.indexOf($scope.$$childTail.minYearBuilt);
				$scope.maxYearBuiltList = allYearBuiltList.slice(0, key);
				console.log("filterByMinYearBuilt", $scope);
        //TODO call search business api with minYearBuilt filter
			};

			$scope.filterByMaxYearBuilt = function(){
				var key = allYearBuiltList.indexOf($scope.$$childTail.maxYearBuilt);
				$scope.minYearBuiltList = allYearBuiltList.slice(key + 1);
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
				console.log('Apply Filters'+filter);
			};
			
			$scope.bookMarked = function (obj, index) {
				console.log("Book marked "+obj.id);
				var userid = JSON.parse(sessionStorage.getItem('profile'));
				if(userid) {
					!obj.isBookMarked && propertyService.bookMarkedProperty({"userId":userid.id,"propertyDetailsId":obj.id})
		  		.success(function(res) {
		  			$scope.searchList[index].isBookMarked = true;
		         })
		         .error(function (error) {
		             $scope.status = 'Unable to load business list: ' + error.message;
		         });
				obj.isBookMarked && propertyService.removeBookMarkedProperty({"userId":userid.id,"propertyDetailsId":obj.id})
		  		.success(function(res) {
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
              if(addressType === 'postal_code') {
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

          $state.go('search', {type: "Sale"}, { reload: 'search' });
        }
			};

			var map;
    	var markers = [];
			var infowindow =  new google.maps.InfoWindow({
				content: ''
			});
			$scope.initialize = function(dataset) {
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
				console.log("dataset",dataset);
				var mapOptions = {
					zoom: 12,
					center: new google.maps.LatLng(searchAddress.latitude,searchAddress.longitude),
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
					maxZoom: 20,
					zoomControl: true,
					zoomControlOptions: {
						position: google.maps.ControlPosition.RIGHT_TOP
					},
					gestureHandling: 'greedy'
				};

				map = new google.maps.Map(document.getElementById("map_canvas"), mapOptions);
				addMarker(dataset);
				showMarkers();
				// When map becomes idle after zoom ing or panning
        console.log("Initial zoom", map.getZoom());
        map.addListener('idle', function(e) {
          mapZoomPanChangeListeners();
        });

        function mapWindow() {
          var windowHeight = $(window).height();
          var windowWidth = $(window).width();
          var menuHeight = $('#menu').height();
          var advanceFilterMenuHeight = $(".menu-bar-with-background").height() || 40;
          var heightD = windowHeight;
          if(windowWidth > 767) {
            $('#map_wrapper').height(heightD - menuHeight - advanceFilterMenuHeight);
            $('.search-results').height(heightD - menuHeight - advanceFilterMenuHeight);

          } else {
            $('#map_wrapper').height('auto');
            $('.search-results').height('auto');
          }
        }
        mapWindow();
        $(window).resize(function() {
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
				var bounds = map.getCenter();
				deleteMarkers();
				console.log(bounds.lat(), bounds.lng());
				var search_address = JSON.parse(localStorage.getItem('searchBusinessAttributes'));
				search_address['latitude'] = bounds.lat();
				search_address["longitude"] = bounds.lng();
				updateSearchResult(search_address);
				// var response = [];
        // setTimeout(function () {
        //   response = propertyService.getPropertyList(JSON.stringify(searchAddress));
        // }, 100);
        // // var response = propertyService.getPropertyList(JSON.stringify(searchAddress));
        // arrDestinations = response;
        // console.log("res ", response, response.length);
        // addMarker(arrDestinations);
        // showMarkers();

				/*propertyService.getPropertyList(JSON.stringify(searchAddress))
					.success(function(res) {
            console.log("res ", res, res.length);
            arrDestinations = res.data.propertyList;
						addMarker(arrDestinations);
						showMarkers();
            $scope.searchList = arrDestinations;
						// console.log("res ", res.status);
					})
					.error(function (error) {
						$scope.status = 'Unable to load store data: ' + error.message;
						console.log("res ", $scope.status);
					});*/
				// setTimeout(function(){
				// 	$scope.$apply(function(){
         //    $scope.searchList = arrDestinations;
         //  })
				// }, 100);
				// var bounds1 =  map.getBounds();
				// var ne = bounds1.getNorthEast();
				// var sw = bounds1.getSouthWest();
				// console.log("ne, sw", ne.lat(), ne.lng(), sw.lat(), sw.lng());
				// arrDestinations = [{title: 'test', lat:37.55621007689943, lon:-121.9509967554608}];

			}
			
			function updateSearchResult(filter) {
				var arrDestinations = [];
				localStorage.setItem('searchAddress', JSON.stringify(filter));
				propertyService.getBusinessList(JSON.stringify(filter))
				.success(function(res) {
			        arrDestinations = res.data.businessList;
					addMarker(arrDestinations);
					showMarkers();
        $scope.searchList = arrDestinations;
					// console.log("res ", res.status);
				})
				.error(function (error) {
					$scope.status = 'Unable to load store data: ' + error.message;
					console.log("res ", $scope.status);
				});
			}

			function addMarker(arrDestinations) {
				console.log("Add markers", arrDestinations);
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
				google.maps.event.addListener(marker, 'click', function() {
					infowindow.setContent(html);
					infowindow.open(map, marker);
				});
			}

        	$scope.initialize(propList.data.data.businessList);

	}

})();
