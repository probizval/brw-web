
var propertyService = angular.module('propertyService', [])
propertyService.factory('propertyService', ['$http', 'authService', function ($http, authService) {

	var urlBase = window.location.origin + window.location.pathname + 'api/v1/';
  var businessUrl = window.location.origin + window.location.pathname + 'api/business/v1/';
  var estimateUrl = window.location.origin + window.location.pathname + 'api/estimates/v1/';
  var additionAttributesUrl = window.location.origin + window.location.pathname + 'api/additionalAttributes/v1/';
  var propertyDataOp = {};

  propertyDataOp.getBusinessList = function (searchBusinessAttributes) {
      searchBusinessAttributes = JSON.parse(searchBusinessAttributes);
      var userId = JSON.parse(sessionStorage.getItem('profile'));
      console.log("--------getBusinesslist", searchBusinessAttributes);
      return $http.post(businessUrl + 'searchBusiness', {
            "name": searchBusinessAttributes.businessName || "",
            "type": searchBusinessAttributes.businessType || "",
            "street1": searchBusinessAttributes.street1 || "",
            "street2": searchBusinessAttributes.street2 || "",
            "city": searchBusinessAttributes.city || "Fremont",
            "stateCode": searchBusinessAttributes.state || "CA",
            "zip": searchBusinessAttributes.zipCode || "94536",
            "county": "",
      }).success(function(res) {
        console.log("getBusinessList", JSON.stringify(res));
        return res.data;
      }).error(function (error) {
          return 'Unable to load store data: ' + error.message;
      });
  };

  propertyDataOp.getPropertyList = function (type) {
    	type = JSON.parse(type);
    	var userid = JSON.parse(sessionStorage.getItem('profile'));
        console.log("--------getBuyPropertylist" + "Bearer "+localStorage.getItem('id_token') );
        return $http.post(urlBase + 'propertyList', /*{
                          "latitude": type.latitude,
                          "longitude": type.longitude,
                          "zipCode": type.postal_code || null,
                          "userId": (userid && userid.id ) || null
                        }*/ type).success(function(res) {
          // console.log("getBuyPropertylist", JSON.stringify(res));
          return res.data;
        })
        .error(function (error) {
            return 'Unable to load store data: ' + error.message;
        });
    };

    propertyDataOp.getBusinessDetails = function (id) {
        return $http.post(businessUrl + 'getBusinessDetails', {
            "businessId": id,
            "isVendorCall": "Y",
            "isEstimate": "Y"
        }).success(function(res) {
            console.log("getBusinessDetails", JSON.stringify(res));
            return res.data;
        }).error(function (error) {
            return 'Unable to load store data: ' + error.message;
        });
    };

    propertyDataOp.getEstimates = function (id) {
        return $http.post(estimateUrl + 'getEstimates', {
            "businessId": id,
        }).success(function(res) {
            console.log("getEstimates", JSON.stringify(res));
            return res.data;
        }).error(function (error) {
            return 'Unable to load store data: ' + error.message;
        });
    };

    propertyDataOp.getAdditionalAttributes = function (businessId) {
        return $http.post(additionAttributesUrl + 'getAdditionalAttributes', {
            "businessId": businessId
        }).success(function(res) {
            console.log("getAdditionalAttributes", JSON.stringify(res));
            return res.data;
        }).error(function (error) {
            return 'Unable to load store data: ' + error.message;
        });
    };


    propertyDataOp.getPropertyDetails =  function (id) {
        return $http.get(urlBase + 'propertydetails/'+id).success(function(res) {
            return  res.data;
        })
        .error(function (error) {
            return 'Unable to load store data: ' + error.message;
        });
    };

    propertyDataOp.getImagesByPropertyCode =  function (property_code) {
      return $http.get(urlBase + 'getImagesByPropertyCode/'+property_code).success(function(res) {
        // console.log("getImagesByPropertyCode", JSON.stringify(res) );
        return  JSON.stringify(res);
      })
        .error(function (error) {
          return 'Unable to load store data: ' + error.message;
        });
    };

    propertyDataOp.savePropertyDetails =  function (typeOfBusiness, obj) {
        return $http.post(urlBase + 'property/'+typeOfBusiness, obj).success(function(res) {
            return  JSON.stringify(res);
        })
        .error(function (error) {
            return 'Unable to load store data: ' + error.message;
        });
    };
    /*propertyDataOp.savePropertyDetails =  function (obj) {
        return $http.post('/saveProp', obj).success(function(res) {
            return  JSON.parse(res);
        })
        .error(function (error) {
            return 'Unable to load store data: ' + error.message;
        });
    };*/
   //  propertyDataOp.getPropertyListByUser = function () {
   //  	var obj = {userName: localStorage.getItem('userName')};
   //      return $http.post('/getPropertyListByUser', obj).success(function(res) {
			// return  JSON.parse(res);
   //      })
   //      .error(function (error) {
   //          return 'Unable to load store data: ' + error.message;
   //      });
   //  };
   propertyDataOp.getPropertyListByUser = function (pageNumber) {
        var obj = JSON.parse(localStorage.getItem('userprofile'));
        var userid = JSON.parse(sessionStorage.getItem('profile'));
        return $http.get(urlBase + 'userprofile/propertyList/'+userid.id+'/'+pageNumber).success(function(res) {
            return  JSON.stringify(res.data);
        })
        .error(function (error) {
            return 'Unable to load store data: ' + error.message;
        });
    };
    propertyDataOp.getBookMarkedPropertyListByUser = function (pageNumber) {
        var obj = JSON.parse(localStorage.getItem('userprofile'));
        var userid = JSON.parse(sessionStorage.getItem('profile'));
        return $http.get(urlBase + 'userprofile/bookmarksPropertyList/'+userid.id+'/'+pageNumber).success(function(res) {
            return  JSON.stringify(res.data);
        })
        .error(function (error) {
            return 'Unable to load store data: ' + error.message;
        });
    };
    
    propertyDataOp.bookMarkedProperty = function (obj) {
        return $http.post(urlBase + 'property/bookmarks', obj).success(function(res) {
            return  JSON.stringify(res.data);
        })
        .error(function (error) {
            return 'Unable to load store data: ' + error.message;
        });
    };
    propertyDataOp.removeBookMarkedProperty = function (obj) {
        return $http.post(urlBase + 'property/removebookmarks', obj).success(function(res) {
            return  JSON.stringify(res.data);
        })
        .error(function (error) {
            return 'Unable to load store data: ' + error.message;
        });
    };
    propertyDataOp.updatePropertyDetails =  function (typeOfBusiness, obj) {
      return $http.put(urlBase + 'property/'+typeOfBusiness, obj).success(function(res) {
          return  JSON.stringify(res);
      })
      .error(function (error) {
          return 'Unable to load store data: ' + error.message;
      });
    };
    // propertyDataOp.updatePropertyDetails = function (obj) {
    //     return $http.post('/updatePropertyListByUser', obj).success(function(res) {
    //         return  JSON.parse(res);
    //     })
    //     .error(function (error) {
    //         return 'Unable to load store data: ' + error.message;
    //     });
    // };
    propertyDataOp.saveProfile = function (obj) {

        console.log("save profile ", obj);
        return $http.post(urlBase + 'createProfile', obj).success(function(res) {
            return  JSON.stringify(res);
        })
        .error(function (error) {
            return 'Unable to load store data: ' + error.message;
        });
    };
    
    propertyDataOp.getProfile = function (obj) {

        console.log("get profile ", obj);
        return $http.post(urlBase + 'userprofile', obj).success(function(res) {
            return  JSON.stringify(res);
        })
        .error(function (error) {
            return 'Unable to load store data: ' + error.message;
        });
    };
    
    propertyDataOp.updateProfile = function (obj) {

        console.log("update profile ", obj);
        return $http.put(urlBase +'userprofile', obj).success(function(res) {
            return  JSON.stringify(res);
        })
        .error(function (error) {
            return 'Unable to load store data: ' + error.message;
        });
    };

    propertyDataOp.sendEmailWithBuyRequirements = function (obj) {
      console.log("------sendEmailWithBuyRequirements------", obj);
      return $http.post(urlBase + 'property/businessrequirement', obj).success(function(res) {
          return  JSON.stringify(res);
      })
      .error(function (error) {
          return 'Unable to load store data: ' + error.message;
      });
    };

    propertyDataOp.saveBuyBusinessRequirements = function (obj) {
      console.log("------saveBuyBusinessRequirements------", obj);
    	return $http.post(urlBase + 'saveBuyBusinessRequirement', obj).success(function(res) {
			     return  JSON.stringify(res);
        })
        .error(function (error) {
            console.log("--------------error-------------", error);
            return 'Unable to load store data: ' + error.message;
        });
    };
    propertyDataOp.getAgentsList = function (type) {
      console.log("--------getAgentsList");
      return $http.get(urlBase + 'getAgentsList/'+type).success(function(res) {
        return  JSON.stringify(res);
      })
        .error(function (error) {
          return 'Unable to load store data: ' + error.message;
        });
    };
    return propertyDataOp;

}]);
