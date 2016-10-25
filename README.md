# Ladok Java integration clients
This repository contains Java based components for communicating with the new Ladok API. One is REST-based and one gets events from the ATOM feed.

Since the two new Ladok provided API:s are based on different protocols there are two clients, one for each protocol: 

* ladok3-atom-client
* ladok3-rest-client

The Java value objects (data transfer objects - DTO) is provided in a separate module:

* ladok3-dto

The DTOs for marshalling/un-marshalling are generated from Ladok3 schema definitions. 

## Build and install
Build and install the new Ladok clients with Maven using

    mvn clean install
