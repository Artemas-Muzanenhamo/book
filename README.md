# Book Service

A simple book service demonstrating **Hexagonal Architecture** principles using **Gradle multi-module** structure. This approach enforces strict separation between layers, ensuring:
- No adapter layer dependencies leak into the application layer.
- No application layer dependencies leak into the domain layer.

---

## Why Hexagonal Architecture?

Hexagonal Architecture (also known as **Ports and Adapters**) aims to **decouple business logic from external frameworks and technologies**. By introducing **ports** (interfaces) and **adapters** (implementations), we create a flexible, testable, and maintainable system where:
- Business rules remain independent of UI, databases, or third-party services.
- External systems interact through well-defined boundaries.

---

### Visual Overview
<img width="375" height="342" alt="Image" src="https://github.com/user-attachments/assets/c548469c-ab50-45bb-9698-989f270349f8"/>

---

## Pros and Cons of Implementation Approaches

### **Using Packages**
**Pros**
- ✅ **Simple & Familiar**: Easy to implement without extra tooling.
- ✅ **Flexible Structure**: Organize code as needed.
- ✅ **Compatible**: Works with most IDEs and build tools.

**Cons**
- ❌ **Weak Encapsulation**: Classes in the same package can access internals.
- ❌ **Dependency Discipline Required**: Harder to enforce boundaries.
- ❌ **Limited Tooling**: Few options for automated architectural checks.

---

### **Using Modules (e.g., Gradle Modules)**
**Pros**
- ✅ **Strong Encapsulation**: Explicit control over visibility.
- ✅ **Better Dependency Management**: Declare and enforce module boundaries.
- ✅ **Isolation & Testability**: Modules can be built and tested independently.
- ✅ **Powerful Tooling**: Gradle provides robust module support.

**Cons**
- ❌ **Setup Complexity**: Requires configuration and tooling.
- ❌ **Learning Curve**: Developers need to understand module systems.
- ❌ **Compatibility Issues**: Not all environments support modules.

---

## How We Enforce Architecture
We use **Gradle multi-module** setup combined with **ArchUnit** tests to ensure:
- No forbidden dependencies between layers.
- Clear separation of concerns.

---

## Application Commands
- `./gradlew bootR` - Starts up the Spring Boot application.
- `./gradlew clean build` - Builds the application including running integration + unit tests.
- `http://localhost:8080/swagger-ui/index.html` - Swagger UI which shows the application API endpoints.

---

## Resources
- [The Principles of Clean Architecture – Uncle Bob Martin](https://www.youtube.com/watch?v=o_TH-Y78tt4)
- [Hexagonal Architecture (Ports and Adapters) – Alistair Cockburn](https://www.youtube.com/watch?v=AOIWUPjal60)
- [Clean Architecture with Spring – Tom Hombergs](https://www.youtube.com/watch?v=cPH5AiqLQTo)
