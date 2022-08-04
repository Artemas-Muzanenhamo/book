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

<img src="https://user-images.githubusercontent.com/29547780/182962640-8c991acb-a280-4f0f-b130-0a450c34ecf1.png" alt="hexagonal-architecture-image" title="hexagonal-architecture-image">

Below is a visual representation of the hexagonal architecture: 
<img src="https://user-images.githubusercontent.com/29547780/182966067-095adf6b-ee12-40af-95e5-dcd4f6642a7a.png">
