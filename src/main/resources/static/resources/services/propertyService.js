
var propertyService = angular.module('propertyService', [])
propertyService.factory('propertyService', ['$http', function ($http) {

    var urlBase = '/MyCarts/category';
    var propertyDataOp = {};

    /*propertyDataOp.getPropertyList = function (type) {
      console.log("--------getBuyPropertylist" );
        return $http.get('/getBuyPropertylist/'+type).success(function(res) {
          // console.log("getBuyPropertylist", JSON.stringify(res));
			return  JSON.stringify(res);
        })
        .error(function (error) {
            return 'Unable to load store data: ' + error.message;
        });
    };*/

    propertyDataOp.getPropertyList = function (type) {
    	type = JSON.parse(type);
      console.log("--------getBuyPropertylist" );
        return $http.post('/api/v1/propertyList', {
                          "latitude": type.latitude,
                          "longitude": type.longitude,
                          "zipCode": type.postal_code || null
                        } 
                        ,{
                          headers: {"Access-Control-Allow-Origin": "*", "Access-Control-Allow-Headers": "Origin, X-Requested-With, Content-Type, Accept", "authorization": 'Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsImtpZCI6IlFVUkNPVU5HT1RJME1FWkdPREpFTmpBMk1VWTBRak13UWtaRFJESTRPVGN4TmpaQk1USXlOZyJ9.eyJpc3MiOiJodHRwczovL215Y2FydC5hdXRoMC5jb20vIiwic3ViIjoiYXV0aDB8NWMwNzU2YjIyM2RkODUyZGQ3MjFmNTA5IiwiYXVkIjoiaHR0cHM6Ly9teWNhcnQuYXV0aDAuY29tL2FwaS92Mi8iLCJpYXQiOjE1NDQ3NTY3NjgsImV4cCI6MTU0NDg0MzE2OCwiYXpwIjoiRE5SamVjWUFicmxyMGd0NWlaajFBRTB5NUFwYmxjblYiLCJzY29wZSI6InJlYWQ6Y3VycmVudF91c2VyIHVwZGF0ZTpjdXJyZW50X3VzZXJfbWV0YWRhdGEgZGVsZXRlOmN1cnJlbnRfdXNlcl9tZXRhZGF0YSBjcmVhdGU6Y3VycmVudF91c2VyX21ldGFkYXRhIGNyZWF0ZTpjdXJyZW50X3VzZXJfZGV2aWNlX2NyZWRlbnRpYWxzIGRlbGV0ZTpjdXJyZW50X3VzZXJfZGV2aWNlX2NyZWRlbnRpYWxzIHVwZGF0ZTpjdXJyZW50X3VzZXJfaWRlbnRpdGllcyIsImd0eSI6InBhc3N3b3JkIn0.eppcUPyzZdqaS7A9nwO9hhO8l4qZ-gMzu8NYgQzR6rmbKXCvNrEi6nJ0oGL4_ljF9boHIrRn5uyIPxKLMtGSUDVWJW0SQbElYzcxEw2sH0rT7jzCvgLTK9V_neSKt64OoOvBXkfdOdKx2Heyqt9bKacNZCKrQpy7qi5uPWOTZgChdVmEjXzZNS8YoWPYJTni5s79l9vIPLVIEC4ZqRIgkhw-Pmx1XQxsu3zZzuU_P2aheqY2_yIjehP9iRNrYnJpoW9bcY_0RLXYEjQvUSaPMoeUcyW3b2z37HKVScb4rjh9D-u-S2Fsq0UN1QusZyq_edc9MnQMj3elp21nLbpkTA'
                         }
        }).success(function(res) {
          // console.log("getBuyPropertylist", JSON.stringify(res));
        return  res;
        })
        .error(function (error) {
            return 'Unable to load store data: ' + error.message;
        });
    };

    

    propertyDataOp.getPropertyDetails =  function (id) {
        return $http.get('/api/v1/propertydetails/26').success(function(res) {
            return  res.data;
        })
        .error(function (error) {
            return 'Unable to load store data: ' + error.message;
        });
    };

    propertyDataOp.getImagesByPropertyCode =  function (property_code) {
      return $http.get('/getImagesByPropertyCode/'+property_code).success(function(res) {
        // console.log("getImagesByPropertyCode", JSON.stringify(res) );
        return  JSON.stringify(res);
      })
        .error(function (error) {
          return 'Unable to load store data: ' + error.message;
        });
    };

    propertyDataOp.savePropertyDetails =  function (obj) {
        return $http.post('/savePropertyDetails', obj).success(function(res) {
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
   propertyDataOp.getPropertyListByUser = function () {
        var obj = JSON.parse(localStorage.getItem('userprofile'));
        return $http.get('/getPropertyListByUser/'+obj.id).success(function(res) {
            return  JSON.stringify(res);
        })
        .error(function (error) {
            return 'Unable to load store data: ' + error.message;
        });
    };
    propertyDataOp.updatePropertyDetails = function (obj) {
    	return $http.post('/updatePropertyDetails', obj).success(function(res) {
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
        return $http.post('/createProfile', obj).success(function(res) {
            return  JSON.stringify(res);
        })
        .error(function (error) {
            return 'Unable to load store data: ' + error.message;
        });
    };

    propertyDataOp.sendEmailWithBuyRequirements = function (obj) {
      console.log("------sendEmailWithBuyRequirements------", obj);
      return $http.post('/sendEmailWithBuyRequirements', obj).success(function(res) {
          return  JSON.stringify(res);
      })
      .error(function (error) {
          return 'Unable to load store data: ' + error.message;
      });
    };

    propertyDataOp.saveBuyBusinessRequirements = function (obj) {
      console.log("------saveBuyBusinessRequirements------", obj);
    	return $http.post('/saveBuyBusinessRequirement', obj).success(function(res) {
			     return  JSON.stringify(res);
        })
        .error(function (error) {
            console.log("--------------error-------------", error);
            return 'Unable to load store data: ' + error.message;
        });
    };
    propertyDataOp.getAgentsList = function (type) {
      console.log("--------getAgentsList");
      return $http.get('/getAgentsList/'+type).success(function(res) {
        return  JSON.stringify(res);
      })
        .error(function (error) {
          return 'Unable to load store data: ' + error.message;
        });
    };
    return propertyDataOp;

}]);
