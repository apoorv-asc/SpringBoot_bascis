# Basics of SpringBoot

## Requirements

For building and running the application you need:

- [JDK 17](https://oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
- [Maven 3.9.6](https://maven.apache.org)


## Running the application locally

### Run Arguments
```
-Dspring.profiles.active=qa
```

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
mvn spring-boot:run
```
