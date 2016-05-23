# Ladok Java integration clients
This repository contains Java based components for communication with the new Ladok API. Both REST-based and events from the ATOM feed.

Since the two new Ladok provided types of API are based on different protocols there is two clients, one for each protocol. 

* ladok3atom-client
* ladok3rest-client

![alt text](https://raw.githubusercontent.com/uppsala-university/ladok/master/docs/ladok.png "Ladok Java integration components")

The Java value objects (data transfer objects - DTO) for the REST-based client is provided in ladok3rest-client. Value objects for the new Ladok events from the ATOM feed is provided in a separate module:

* ladok3atom-dto

För att hantera händelserna i java-kod på ett objektorienterat sätt behövs en översättning mellan XML-representationen och java-koden. Det som inom datavetenskap kallas deserialisering eller marshalling. Den omvända vägen, att ta objektrepresentation ur minnet för att skriva till disk eller transportera kallas serialisering eller unmarshalling. Översättningsrutinerna behövs både för REST och ATOM och gemensamma rutiner finns samlade i projektet

* ladok3-dto-common

