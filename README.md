# Ladok Java integration clients
This repository contains Java based components for communication with the new Ladok API. Both REST-based and events from the ATOM feed.

Since the two new Ladok provided types of API are based on different protocols there is two clients, one for each protocol. 

* ladok3atom-client
* ladok3rest-client

The Java value objects (data transfer objects - DTO) is provided in a separate module:

* ladok3-dto

The DTOs for marshalling/un-marshalling are generated from Ladok3 schema definitions. 

## Build and deploy
Build and deploy the new Ladok clients with Maven using

	mvn install
