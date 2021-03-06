
var propertyService = angular.module('propertyService', [])
propertyService.factory('propertyService', ['$http', 'authService', function ($http, authService) {

	var urlBase = window.location.origin + window.location.pathname + 'api/v1/';
    var propertyDataOp = {};

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
