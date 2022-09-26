# Book Service

This is a simple book service that gives you book information.

The project uses a hexagonal architecture and uses the Gradle multi-module way to enforce the architecture by stopping
dependencies from the adapter layer entering into the application layer and also stopping dependencies from the
application layer entering into the domain layer.

## Pre-requisites

* Java 11+

### The Hexagonal Architecture


#### The Intent
The main goal of this architecture is to abstract(loosely-couple) your business logic from external technologies or
frameworks and their rules through the use of ports and adapters. These interfaces define the inputs and outputs of your
application but most importantly they are the gateway for anything external to interact with the business logic or _the
hexagonal_.

<img src="https://user-images.githubusercontent.com/29547780/192382644-89b26727-ee9b-467d-9487-823ac9f52e10.png" alt="hexagonal-architecture-image" title="hexagonal-architecture-image">

Below is a visual representation of the hexagonal architecture: 
<img src="https://user-images.githubusercontent.com/29547780/192381776-fbe649ea-6c3a-49a4-995d-5adbd19050b5.png">

#### Enforcing the architecture

##### Packages vs Modules

##### Gradle Modules

##### Arch Unit

#### Testing

### Resources

* [The Principles of Clean Architecture by Uncle Bob Martin](https://www.youtube.com/watch?v=o_TH-Y78tt4)
* [Hexagonal Architecture (Ports and Adapters) with Alistair Cockburn](https://www.youtube.com/watch?v=AOIWUPjal60)
* [Boundary Control Entity Architecture Pattern](https://vaclavkosar.com/software/Boundary-Control-Entity-Architecture-The-Pattern-to-Structure-Your-Classes)
* [Entity-control-boundary](https://en.wikipedia.org/wiki/Entity-control-boundary)
* [Clean Architecture with Spring by Tom Hombergs @ Spring I/O 2019](https://www.youtube.com/watch?v=cPH5AiqLQTo)
