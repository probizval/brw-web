
1. Install the application: `npm install`
2. Start the server: `node start.js`
3. View in browser at `http://localhost:8080`

Create token
https://mycart.auth0.com/oauth/token

POST
{
  "grant_type":"password",
  "username": "user@test.com",
  "password": "123123",
  "audience": "https://mycart.auth0.com/api/v2/",
  "client_id": "DNRjecYAbrlr0gt5iZj1AE0y5ApblcnV",
  "client_secret": "SoCWPLAkcJjwEqOSCjaPNyVjjDvr4JJ4PoNJ__vuCb4wk5i4gP7mwH2JwvulUURU"
}


Property List based on latitude and longitude
http://localhost:8080/api/v1/propertyList

//zipCode is optional, we can add more optional attributes

POST
{
	"latitude": 37.57613630000001,
	"longitude": -122.03861259999996,
	"zipCode": 94555
}

Create new gas Station
http://localhost:8080/api/v1/property/gasstation
POST
{
        "brand": "Chevron",
        "fuelType": "ALL",
        "frannchise": "Last mile",
        "numberOfPumps": "5",
        "gasolineCapacity": "1000 ML",
        "diselCapacity": "500 ML",
        "storeBrand": "Last Mile",
        "storeApproxInventoryCost": "1M",
        "foodCourtSeatingCapacity": "20 People",
        "carWashEquipCost": "NA",
        "atm": "YES",
        "restroom": "YES",
        "lotSize": "40,000 SQFT",
        "numberOfParking": "10",
        "fireEquip": "",
        "fireCapacity": "",
        "autoSupplyRepairMaintShop": "",
        "propertyMetaData": {
            "propertyName": "Chevron2",
            "propertyType": null,
            "businessType": "Gas Station",
            "city": "Fremont",
            "currentOwner": "",
            "estatesEstimatedValue": 0,
            "imageUrl": "https://capi.myleasestar.com/v2/dimg-crop/17153218/300x438/17153218.jpg",
            "latitude": 37.5761,
            "longitude": -122.039,
            "lotSize": 213213,
            "propertyAddress": "34077 Paseo Padre Pkwy",
            "state": "CA",
            "zipCode": 94555,
            "zoningCategory": ""
        }
    }
