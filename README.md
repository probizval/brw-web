# BRW Spring Boot Web Application

You Need:

1. Java 1.8
2. Maven 3.6
3. Tomcat v9.0

PB Bearer Token: 
{
    "access_DBtoken": "HDYnCWRnjn8qxTA81y3iNAikCeCJ",
    "tokenType": "BearerToken",
    "issuedAt": "1575502638056",
    "expiresIn": "35999",
    "clientAWID": "fUMoAOl6wPbiLfLQMtygfCiwX007lVGY",
    "org": "pitneybowes"
}

Open your terminal then type this : `mvn clean spring-boot:run`

Open your browser then type this : `http://localhost:8080/`

Stripe BackUp Code Key - knuk-glcz-utcs-bgxp-scuc

BRW MongoDB Credentials
user: “app_mongo”
pwd: “appUser123”
AuthDB — brwdev
IP — 54.198.119.109


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