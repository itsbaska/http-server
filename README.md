# HTTP server


## Getting Started

#### Requirements

* JDK SE 10 ([Download](http://www.oracle.com/technetwork/java/javase/downloads/jdk10-downloads-4416644.html))
* Gradle ([Installation instructions](https://gradle.org/install/))

#### Cloning Project

```
$ git clone git@github.com:itsbaska/http-server.git
```

## Running server

Running server on default PORT 5000:
```
$ cd http-server
$ gradle run
```

Running server on custom PORT:
```
$ cd http-server/src/main/java
$ javac StartServer.java
$ java StartServer -p [PORT]
```
## Running Tests
All Tests
```
$ gradle test
```

Cucumber Tests
```
$ gradle cucumber
```

## Built With

* [Java 10](http://www.oracle.com/technetwork/java/javase/downloads/jdk10-downloads-4416644.html)
* [Gradle](https://gradle.org//)
* [JUnit 4](https://junit.org/junit4/)
* [Cucumber](https://cucumber.io)
