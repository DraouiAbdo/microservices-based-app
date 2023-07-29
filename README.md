In this demo, a simple web app is developped using the **microservice approach**(as opposed to monolithic)
As a gateway for the app, **Spring Cloud** gateway is used and **Eureka** discovery service is implemented for providing the gateway with ip address and port nbr of  the available microservices.

At first, microservices has been created. made as REST API Using **Spring Data REST**, the gateway configured **statically** by providing the ip address and port 
nbr of each microservice and that is by declaring settings of microservices either in a yaml text file format or alternatively by a Bean 
containig uri and path of each microservice.

Then, a Eureka discovery service is configured to provide the gateway with the available instances of our created microservices. In that case,
the gateway can request the Eureka for ip address  and port number of specified microservice in the uri of the client's request. the gateway
plays the role of a load balancer in case of existence of many instances of a the requested microservice.

A billing service has been added to demonstrate how to use **OpenFeign** which is used to communicate microservices with each other.

Note: for sake of focusing the microservice approach, the presentation layer of each microservice has been made to communicate directly with the Data Access layer.

The goal of this simple app is to learn how different microservices of the app interact with each other.
