
var propertyService = angular.module('propertyService', [])
propertyService.factory('propertyService', ['$http', 'authService', function ($http, authService) {

  var urlBase = window.location.origin + window.location.pathname + 'api/v1/';
  var userUrl = window.location.origin + window.location.pathname + 'api/user/v1/';
  var businessUrl = window.location.origin + window.location.pathname + 'api/business/v1/';
  var imageUrl = window.location.origin + window.location.pathname + 'api/image/v1/';
  var estimateUrl = window.location.origin + window.location.pathname + 'api/estimates/v1/';
  var additionAttributesUrl = window.location.origin + window.location.pathname + 'api/additionalAttributes/v1/';
  var emailUrl = window.location.origin + window.location.pathname + 'api/email/v1/';
  var searchAgentUrl = window.location.origin + window.location.pathname + 'api/searchAgent/v1/';
  var propertyDataOp = {};

  propertyDataOp.getBusinessList = function (searchBusinessAttributes) {
      searchBusinessAttributes = JSON.parse(searchBusinessAttributes);
      var userId = JSON.parse(sessionStorage.getItem('profile'));
      return $http.post(businessUrl + 'searchBusiness', {
            "name": searchBusinessAttributes.businessName || "",
            "type": searchBusinessAttributes.businessType || "",
            "street1": searchBusinessAttributes.street1 || "",
            "street2": searchBusinessAttributes.street2 || "",
//            "city": searchBusinessAttributes.city || "Fremont",
            "stateCode": searchBusinessAttributes.state || "CA",
            "zip": searchBusinessAttributes.zip || "94536",
            "latitude": searchBusinessAttributes.latitude || 37.7749,
            "longitude": searchBusinessAttributes.longitude || -122.4194,
            "rangeMile": searchBusinessAttributes.rangeMile || 5,
            "county": searchBusinessAttributes.county || "",
            "isFranchise": searchBusinessAttributes.isFranchise || "N",
            "isForSell": searchBusinessAttributes.isForSell || "N"
      }).success(function(res) {
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
            return res.data;
        }).error(function (error) {
            return 'Unable to load store data: ' + error.message;
        });
    };

    propertyDataOp.getBusinessImages = function (id) {
        return $http.post(imageUrl + 'getImages', {
            "businessId": id,
        }).success(function(res) {
            return res.data;
        }).error(function (error) {
            return 'Unable to load store data: ' + error.message;
        });
    };

    propertyDataOp.getEstimates = function (id) {
        return $http.post(estimateUrl + 'getEstimates', {
            "businessId": id,
        }).success(function(res) {
            return res.data;
        }).error(function (error) {
            return 'Unable to load store data: ' + error.message;
        });
    };

    propertyDataOp.getAdditionalAttributes = function (businessId) {
        return $http.post(additionAttributesUrl + 'getAdditionalAttributes', {
            "businessId": businessId
        }).success(function(res) {
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
            return res.data;
        }).error(function (error) {
            return 'Unable to load store data: ' + error.message;
        });
    };

    propertyDataOp.addBusinessDetails = function (businessDetails) {
        return $http.post(businessUrl + 'addBusinessDetails', businessDetails).success(function(res) {
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
            return res.data;
        }).error(function (error) {
            return 'Unable to load store data: ' + error.message;
        });
    };

    propertyDataOp.updateBusinessDetails = function (businessDetails) {
        return $http.post(businessUrl + 'UpdateBusinessDetails', businessDetails).success(function(res) {
            return res.data;
        }).error(function (error) {
            return 'Unable to load store data: ' + error.message;
        });
    };

    propertyDataOp.sendEmail = function (emailInformation) {
        return $http.post(emailUrl + 'sendEmail', emailInformation).success(function(res) {
            return res.data;
        }).error(function (error) {
            return 'Unable to load store data: ' + error.message;
        });
    };
    propertyDataOp.getStateCounties = function (state) {
        return $http.post(additionAttributesUrl + 'getStateCounties', state).success(function(res) {
            return res.data;
        }).error(function (error) {
            return 'Unable to load store data: ' + error.message;
        });
    };
    propertyDataOp.addSearchAgent = function (obj) {
        return $http.post(searchAgentUrl + 'addSearchAgent', obj).success(function(res) {
            return res.data;
        }).error(function (error) {
            return 'Unable to load store data: ' + error.message;
        });
    };

    propertyDataOp.getSearchAgents = function () {
        var profile = JSON.parse(sessionStorage.getItem('profile'));
        var obj = {"userId": profile.userId}
        return $http.post(searchAgentUrl + 'getSearchAgents', obj).success(function(res) {
            return res.data;
        }).error(function (error) {
            return 'Unable to load store data: ' + error.message;
        });
    };

    propertyDataOp.deleteSearchAgent = function (obj) {
        return $http.post(searchAgentUrl + 'deleteSearchAgent', obj).success(function(res) {
            return res.data;
        }).error(function (error) {
            return 'Unable to load store data: ' + error.message;
        });
    };

    propertyDataOp.getUserBusinesses = function () {
        var profile = JSON.parse(sessionStorage.getItem('profile'));
        var obj = {"userId": profile.userId}
        var obj = {"userId": 1001}
        return $http.post(userUrl + 'getUserBusinesses', obj).success(function(res) {
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
        return $http.post(userUrl + 'addUserProfile', userProfile).success(function(res) {
            return res.data;
        }).error(function (error, status) {
            console.log("Unable to load store data", error, status)
            return status;
        });
    };

    propertyDataOp.getUserProfile = function (userDetails) {
        return $http.post(userUrl + 'getUserProfile', userDetails).success(function(res) {
            return res.data;
        }).error(function (error, status) {
            console.log("Unable to load store data", error, status)
            return status;
        });
    };

    propertyDataOp.updateUserProfile = function (userDetails) {
        return $http.post(userUrl + 'updateUserProfile', userDetails).success(function(res) {
            return res.data;
        }).error(function (error) {
            return 'Unable to load store data: ' + error.message;
        });
    };
    propertyDataOp.saveProfile = function (obj) {
        return $http.post(urlBase + 'createProfile', obj).success(function(res) {
            return  JSON.stringify(res);
        })
        .error(function (error) {
            return 'Unable to load store data: ' + error.message;
        });
    };
    
    propertyDataOp.getProfile = function (obj) {

        return $http.post(urlBase + 'userprofile', obj).success(function(res) {
            return  JSON.stringify(res);
        })
        .error(function (error) {
            return 'Unable to load store data: ' + error.message;
        });
    };
    
    propertyDataOp.updateProfile = function (obj) {

        return $http.put(urlBase +'userprofile', obj).success(function(res) {
            return  JSON.stringify(res);
        })
        .error(function (error) {
            return 'Unable to load store data: ' + error.message;
        });
    };

    propertyDataOp.sendEmailWithBuyRequirements = function (obj) {
      return $http.post(urlBase + 'property/businessrequirement', obj).success(function(res) {
          return  JSON.stringify(res);
      })
      .error(function (error) {
          return 'Unable to load store data: ' + error.message;
      });
    };

    propertyDataOp.saveBuyBusinessRequirements = function (obj) {
    	return $http.post(urlBase + 'saveBuyBusinessRequirement', obj).success(function(res) {
			     return  JSON.stringify(res);
        })
        .error(function (error) {
            return 'Unable to load store data: ' + error.message;
        });
    };
    propertyDataOp.getAgentsList = function (type) {
      return $http.get(urlBase + 'getAgentsList/'+type).success(function(res) {
        return  JSON.stringify(res);
      })
        .error(function (error) {
          return 'Unable to load store data: ' + error.message;
        });
    };
    return propertyDataOp;

}]);
