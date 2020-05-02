
var propertyService = angular.module('propertyService', [])
propertyService.factory('propertyService', ['$http', 'authService', function ($http, authService) {

  var urlBase = window.location.origin + window.location.pathname + 'api/v1/';
  var userUrl = window.location.origin + window.location.pathname + 'api/user/v1/';
  var businessUrl = window.location.origin + window.location.pathname + 'api/business/v1/';
  var imageUrl = window.location.origin + window.location.pathname + 'api/image/v1/';
  var estimateUrl = window.location.origin + window.location.pathname + 'api/estimates/v1/';
  var additionAttributesUrl = window.location.origin + window.location.pathname + 'api/additionalAttributes/v1/';
  var emailUrl = window.location.origin + window.location.pathname + 'api/email/v1/';
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
            "zip": searchBusinessAttributes.zip || "94536",
            "latitude": searchBusinessAttributes.latitude || 37.7749,
            "longitude": searchBusinessAttributes.longitude || -122.4194,
            "rangeMile": searchBusinessAttributes.rangeMile || 5,
            "county": searchBusinessAttributes.county || "",
            "isFranchise": searchBusinessAttributes.isFranchise || "N",
            "isForSell": searchBusinessAttributes.isForSell || "N"
      }).success(function(res) {
        console.log("getBusinessList", JSON.stringify(res));
        return res.data;
      }).error(function (error) {
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

    propertyDataOp.getBusinessImages = function (id) {
        return $http.post(imageUrl + 'getImages', {
            "businessId": id,
        }).success(function(res) {
            console.log("getBusinessImages", JSON.stringify(res));
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

    propertyDataOp.addBusinessImages = function (businessId, invokerId, imageList) {
        return $http.post(imageUrl + 'addImages', {
            "businessId": businessId,
            "invokerId": invokerId,
            "imagesList": imageList
        }).success(function(res) {
            console.log("addBusinessImages", JSON.stringify(res));
            return res.data;
        }).error(function (error) {
            return 'Unable to load store data: ' + error.message;
        });
    };

    propertyDataOp.uploadBusinessImages = function (businessId, invokerId, imageList) {
        return $http.post(imageUrl + 'uploadImages', {
            "businessId": businessId,
            "invokerId": invokerId,
            "uploadImagesList": imageList
        }).success(function(res) {
            console.log("uploadBusinessImages", JSON.stringify(res));
            return res.data;
        }).error(function (error) {
            return 'Unable to load store data: ' + error.message;
        });
    };

    propertyDataOp.addBusinessDetails = function (businessDetails) {
        return $http.post(businessUrl + 'addBusinessDetails', businessDetails).success(function(res) {
            console.log("addBusinessDetails", JSON.stringify(res));
            return res.data;
        }).error(function (error) {
            return 'Unable to load store data: ' + error.message;
        });
    };

    propertyDataOp.addAdditionalAttributes = function (businessId, invokerId, additionalAttributes) {
        return $http.post(additionAttributesUrl + 'addAdditionalAttributes', {
            "businessId": businessId,
            "invokerId": invokerId,
            "addAttributesList": additionalAttributes
        }).success(function(res) {
            console.log("addAdditionalAttributes", JSON.stringify(res));
            return res.data;
        }).error(function (error) {
            return 'Unable to load store data: ' + error.message;
        });
    };

    propertyDataOp.sendEmail = function (emailInformation) {
        return $http.post(emailUrl + 'sendEmail', emailInformation).success(function(res) {
            console.log("sendEmail", JSON.stringify(res));
            return res.data;
        }).error(function (error) {
            return 'Unable to load store data: ' + error.message;
        });
    };

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

    propertyDataOp.addUserProfile = function (userDetails) {
        userProfile = {"invokerId": 1001, "email": userDetails.email, "user_type": "USER"}
        console.log("addUserProfile ", userProfile);
        return $http.post(userUrl + 'addUserProfile', userProfile).success(function(res) {
            console.log("addUserProfile", JSON.stringify(res));
            return res.data;
        }).error(function (error, status) {
            console.log("Unable to load store data", error, status)
            return status;
        });
    };

    propertyDataOp.getUserProfile = function (userDetails) {
        console.log("getUserProfile ", userDetails);
        return $http.post(userUrl + 'getUserProfile', userDetails).success(function(res) {
            console.log("getUserProfile", JSON.stringify(res));
            return res.data;
        }).error(function (error, status) {
            console.log("Unable to load store data", error, status)
            return status;
        });
    };

    propertyDataOp.updateUserProfile = function (userDetails) {
        console.log("updateUserProfile ", obj);
        return $http.post(userUrl + 'updateUserProfile', userDetails).success(function(res) {
            console.log("updateUserProfile", JSON.stringify(res));
            return res.data;
        }).error(function (error) {
            return 'Unable to load store data: ' + error.message;
        });
    };
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
