# HTTP Server  ![build--badge](https://travis-ci.com/itsbaska/http-server.svg?branch=master)



## Getting Started

#### Requirements

* JDK SE 10 ([Download](http://www.oracle.com/technetwork/java/javase/downloads/jdk10-downloads-4416644.html))
* Gradle ([Installation instructions](https://gradle.org/install/))

#### Cloning Project

```
git clone git@github.com:itsbaska/http-server.git
```

## Running server

Running server on default PORT 3000:
```
cd http-server
gradle run
```

Running server on custom PORT:
```
gradle build
java -jar build/libs/http-server-all.jar -p <PORT>
```
## Running Tests
All Tests
```
gradle test
```

Cucumber Tests
```
gradle cucumber
```

## Built With

* [Java 10](http://www.oracle.com/technetwork/java/javase/downloads/jdk10-downloads-4416644.html)
* [Gradle](https://gradle.org//)
* [JUnit 4](https://junit.org/junit4/)
* [Cucumber](https://cucumber.io)
