### Weather API
---
A simple weather API that retrieves the weather data from different locations.

### Running locally
---
Make sure you have docker installed and running, then execute the deploy script. 
Swagger should be accessible through [http://localhost:8080/swagger-ui/](http://localhost:8080/swagger-ui/).

### Endpoints
---

| HTTP Method  | Endpoint | Authorization |
| ------------- |:-------------:| ------------- |
|   GET   |  /api/weather  |  Required  |
| GET    |   /api/health   |  Not required  |


Access https://openweathermap.org/ to get your own API key.

Request example: `curl -X GET "http://localhost:8080/api/weather?params=London%2Cuk" -H  "accept: */*" -H  "Authorization: API_KEY"`

### Useful Information
---

You can call by city name or city name, state code and country code. Please note that searching by states available only for the USA locations. The API has no case-sensitive.

API response example:

```
{
    "id": 4736286,
    "coordinates": {
        "lon": -99.2506,
        "lat": 31.2504
    },
    "locationName": "Texas",
    "weather": [
        {
            "condition": "overcast clouds"
        }
    ],
    "values": {
        "temp": 15.0,
        "feelsLike": 14.07,
        "tempMin": 15.0,
        "tempMax": 15.0,
        "humidity": 58.0
    },
    "country": {
        "id": 3395,
        "countryCode": "US"
    },
    "date": 1618302993
}
```

#### Fields in API response

+ `id` City ID.
+ `coordinates`
  - `lon` City geo location, longitude.
  - `lat` City geo location, latitude.
+ `locationName` City name.
+ `weather`
  - `condition` Weather condition.
+ `values`
  - `temp`  Temperature, unit is Metric.
  - `tempMin` Temperature. This temperature parameter accounts for the human perception of weather. Unit is Metric.
  - `tempMax` Maximum temperature at the moment. This is maximal currently observed temperature (within large megalopolises and urban areas). Unit is Metric.
  - `humidity` Humidity, unit is percentage.
+ `country`
  - `id` Internal parameter.
  - `countryCode` Country code (GB, JP etc.).
+ `date` Time of data calculation, unix, UTC.

### Built With
---
* [Spring](https://spring.io/) - Framework
* [Gradle](https://gradle.org/) - Build Tool
* [Tomcat](https://tomcat.apache.org/) - Servlet Container
* [Redis](https://redis.io/) - In-Memory Database

### Credits
---
Powered by [OpenWeatherMap](https://openweathermap.org/)
