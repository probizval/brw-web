(function() {

  'use strict';

  angular
    .module('myApp')
    .controller('searchController', searchController);

    searchController.$inject = ['$rootScope', '$scope', '$state', 'propertyService', 'propList'];

		var allPriceList = [
				{id: 1, price: "$50k"},
				{id: 2, price: "$75k"},
				{id: 3, price: "$100k"},
				{id: 4, price: "$125k"},
				{id: 5, price: "$150k"},
				{id: 6, price: "$175k"},
				{id: 7, price: "$200k"},
				{id: 8, price: "$225k"},
				{id: 9, price: "$250k"},
				{id: 10, price: "$275k"},
				{id: 11, price: "$300k"},
				{id: 12, price: "$325k"},
				{id: 13, price: "$350k"},
				{id: 14, price: "$375k"},
				{id: 15, price: "$400k"},
				{id: 16, price: "$425k"},
				{id: 17, price: "$450k"},
				{id: 18, price: "$475k"},
				{id: 19, price: "$500k"},
				{id: 20, price: "$600k"},
				{id: 21, price: "$700k"},
				{id: 22, price: "$800k"},
				{id: 23, price: "$900k"},
				{id: 24, price: "$1M"},
				{id: 25, price: "$2M"},
				{id: 26, price: "$3M"},
				{id: 27, price: "$4M"},
				{id: 28, price: "$5M"}];

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

			$scope.searchList = propList.data.data.propertyList;

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

      $scope.filterByMinPrice = function(){
				var key = allPriceList.indexOf($scope.$$childTail.minPrice);
				$scope.maxPriceList = allPriceList.slice(key + 1);
        console.log("filterByMinPrice", $scope);
        //TODO call search business api with price range filter
      };

      $scope.filterByMaxPrice = function(){
          var key = allPriceList.indexOf($scope.$$childTail.maxPrice);
          $scope.minPriceList = allPriceList.slice(0, key);
          console.log("filterByMaxPrice", $scope);
        	//TODO call search business api with price range filter
      };

			$scope.filterByBusinessType = function () {
				console.log("filterByBusinessType", $scope.$$childTail.businessType);
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

    	$scope.applyFilters = function () {
				console.log('Apply Filters');
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

    			$scope.initialize = function(dataset) {
        	  var i;
        	  var arrDestinations = [];
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
        	  for(var i=0;i<dataset.length;i = i + 1) {
        		  arrDestinations.push({'lat':dataset[i].latitude,'lon':dataset[i].longitude,'title':dataset[i].propertyName,'description':dataset[i].propertyName,'image_url': 'https://capi.myleasestar.com/v2/dimg-crop/17153218/300x438/17153218.jpg'});
        	  }

            var searchAddress = JSON.parse(localStorage.getItem('searchAddress'));
        	  
        	  var myOptions = {
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
        	  
        	  var map = new google.maps.Map(document.getElementById("map_canvas"), myOptions);
        	  
        	  var infowindow =  new google.maps.InfoWindow({
        	    content: ''
        	  });
            // map.fitBounds(searchAddress.viewport);
						// console.log("map bounds", map.getBounds());
        	  // loop over our array
        	  for (i = 0; i < arrDestinations.length; i++) {
        	    // create a marker
                var marker = new google.maps.Marker({
                  title: arrDestinations[i].title,
                  icon: 'http://labs.google.com/ridefinder/images/mm_20_blue.png',
                  position: new google.maps.LatLng(arrDestinations[i].lat, arrDestinations[i].lon),
                  map: map
                });
                
                // add an event listener for this marker
                bindInfoWindow(marker, map, infowindow, "<p> <a href=\"#prop"+i+"\"><img src=\""+arrDestinations[i].image_url+"\" style=\"width:40px;height:40px\" class=\"img-fluid\" alt=\"\"> " + arrDestinations[i].description + "</p>");

        	    }
						console.log("Initial zoom", map.getZoom());
            map.addListener('idle', function() {
            		var bounds = map.getCenter();
            		console.log(bounds.lat(), bounds.lng());
                var searchAddress = {
                  type: "All",
                  postal_code: 0,
                  latitude: bounds.lat(),
                  longitude: bounds.lng()
                };

                propertyService.getPropertyList(JSON.stringify(searchAddress))
                  .success(function(res) {
                    arrDestinations = res;
           
                    console.log("res ", res.length);
                    // console.log("res ", res.status);

                  })
                  .error(function (error) {
                    $scope.status = 'Unable to load store data: ' + error.message;
                    console.log("res ", $scope.status);
                  });
            		console.log("Zoom changes",map.getZoom() , map, arrDestinations);
								setTimeout(function(){
									$scope.$apply(function(){
                    $scope.searchList = arrDestinations.data.propertyList;
									})
								}, 100);
								var bounds1 =  map.getBounds();
								var ne = bounds1.getNorthEast();
								var sw = bounds1.getSouthWest();
								console.log("ne, sw", ne.lat(), ne.lng(), sw.lat(), sw.lng());
                // arrDestinations = [{title: 'test', lat:37.55621007689943, lon:-121.9509967554608}];
				arrDestinations = arrDestinations.data.propertyList;
                for (i = 0; i < arrDestinations.length; i++) {
                  var marker = new google.maps.Marker({
                    title: arrDestinations[i].title,
                    icon: 'http://labs.google.com/ridefinder/images/mm_20_blue.png',
                    position: new google.maps.LatLng(arrDestinations[i].lat, arrDestinations[i].lon),
                    map: map
                  });
                  // marker.setMap(map);
                  // add an event listener for this marker
                  bindInfoWindow(marker, map, infowindow, "<p> <a href=\"#prop" + i + "\"><img src=\"" + arrDestinations[i].image_url + "\" style=\"width:40px;height:40px\" class=\"img-fluid\" alt=\"\"> " + arrDestinations[i].description + "</p>");
                }

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
        	  
					};
    	
    	

        	function bindInfoWindow(marker, map, infowindow, html) { 
        	  google.maps.event.addListener(marker, 'click', function() { 
        	    infowindow.setContent(html); 
        	    infowindow.open(map, marker); 
        	  }); 
        	} 

        	$scope.initialize(propList.data.data.propertyList);

	}

})();
