# Book Service

This is a simple book service that gives you book information.

The project uses a hexagonal architecture and uses the Gradle multi-module way to enforce the architecture by stopping
dependencies from the adapter layer entering into the application layer and also stopping dependencies from the
application layer entering into the domain layer.

## Pre-requisites

* Java 11+
* Gradle

## Application Commands
* `./gradlew bootR` - Starts up the Spring Boot application.
* `./gradlew clean build` - Builds the application including running integration + unit tests.
* `http://localhost:8080/swagger-ui/index.html` - Swagger UI which shows the application API endpoints.

### The Hexagonal Architecture

#### The Intent
The main goal of this architecture is to abstract(loosely-couple) your business logic from external technologies or
frameworks and their rules through the use of ports and adapters. These interfaces define the inputs and outputs of your
application but most importantly they are the gateway for anything external to interact with the business logic or _the
hexagonal_.

<img src="https://user-images.githubusercontent.com/29547780/192382644-89b26727-ee9b-467d-9487-823ac9f52e10.png" alt="hexagonal-architecture-image" title="hexagonal-architecture-image">

Below is a visual representation of the hexagonal architecture: 

<img src="https://user-images.githubusercontent.com/29547780/192381776-fbe649ea-6c3a-49a4-995d-5adbd19050b5.png" alt="hexagonal-architecture-full-picture-image">

#### Enforcing the architecture

##### Packages vs Modules

Using packages and modules, such as Gradle Modules, to build an application based on the Hexagonal Architecture , each have their own advantages and disadvantages.

With Packages:

Pros:
<details>
    <summary>Simplicity:</summary> Using packages is straightforward and doesn't require additional tools or configuration. It's a native way of organizing code in many programming languages.
</details>
<details>
    <summary>
        Ease of Use:
    </summary>
    Developers are already familiar with packages, as they are a fundamental part of most programming languages. There's no need for them to learn a new tool or framework for managing modules.
</details>
<details> 
    <summary>
        Flexibility:
    </summary>
    Packages allow for a flexible organization of code. You can decide on your package structure based on the needs of your application.
</details>
<details>
    <summary>
        Compatibility:
    </summary>
    Packages work well with most development environments and tools, making it easier to integrate with existing workflows.
</details>

Cons:
<details>
    <summary>
        Limited Encapsulation:
    </summary>
    Packages may not provide as strong encapsulation as modules. In some languages, classes within the same package can access each other's internals, which can lead to accidental violations of architectural boundaries.
</details>
<details>
    <summary>
        Dependency Management:
    </summary>
    It can be challenging to manage dependencies between packages, especially in large and complex applications. Ensuring that dependencies flow in the correct direction can require careful discipline.
</details>
<details>
    <summary>
        Tooling:
    </summary>
    Some languages and development ecosystems may not provide strong tooling for enforcing architectural constraints when using packages alone.
</details>

Using Modules (e.g., Gradle Modules):

Pros:
<details>
    <summary>
        Strong Encapsulation:
    </summary>
    Modules often provide stronger encapsulation, allowing you to explicitly specify which classes and packages are accessible from outside the module. This can help enforce architectural boundaries more rigorously.
</details>
<details>
    <summary>
        Dependency Management:
    </summary> 
    Modules typically have more advanced dependency management capabilities, allowing you to explicitly declare module dependencies. This can make it easier to ensure that dependencies follow architectural rules.
</details>
<details>
    <summary>
        Isolation:
    </summary> 
    Modules can be built and tested independently, promoting isolation and better separation of concerns. This can lead to more modular and maintainable code.
</details>
<details>
    <summary>
        Tooling:
    </summary> 
    Some build tools, like Gradle, offer powerful module management and build capabilities, which can be useful for large-scale applications.
</details>

Cons:
<details>
    <summary>
        Complexity:
    </summary>
    Setting up and managing modules, especially in larger projects, can be more complex than using packages. It may require additional tooling and configuration.
</details>
<details>
    <summary>
        Learning Curve:
    </summary>
    Developers who are not familiar with module systems may need time to learn how to use them effectively.
</details>
<details>
    <summary>
        Compatibility:
    </summary>
    Some older or less widely used programming languages and environments may not support modules, making it less suitable for certain projects.
</details>

##### Gradle Modules

##### Arch Unit

#### Testing

### Resources

* [The Principles of Clean Architecture by Uncle Bob Martin](https://www.youtube.com/watch?v=o_TH-Y78tt4)
* [Hexagonal Architecture (Ports and Adapters) with Alistair Cockburn](https://www.youtube.com/watch?v=AOIWUPjal60)
* [Boundary Control Entity Architecture Pattern](https://vaclavkosar.com/software/Boundary-Control-Entity-Architecture-The-Pattern-to-Structure-Your-Classes)
* [Entity-control-boundary](https://en.wikipedia.org/wiki/Entity-control-boundary)
* [Clean Architecture with Spring by Tom Hombergs @ Spring I/O 2019](https://www.youtube.com/watch?v=cPH5AiqLQTo)
