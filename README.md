# rest-cloud-consumer-contract

## Overview

This project provides a sample reference application for implementing Spring Cloud Contract using REST from the consumer perspective.

## Details

### The Consumer

This project uses Spring Feign to consume RESTful endpoints.  See the repo for [Producer Contract Testing](https://github.com/jrbrayjr2006/rest-cloud-producer-contract).

## Testing

This section describes important aspects of testing Spring Feign Client and Spring Cloud Contract consumer testing.

- Contract Test
- Configuration in the `POM.xml`

### Test Class

```java
@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes = RestCloudConsumerContractApplication.class )
@AutoConfigureStubRunner( ids = {"com.jaydot2.rest.cloud.contract:rest-cloud-producer-contract:+:stubs:8080"}, stubsMode = StubRunnerProperties.StubsMode.LOCAL)
public class WorkoutConsumerTest {

    @Autowired
    WorkoutClient workoutClient;


    @Test
    @DisplayName("Given a workout ID, when a request is made, should return one workout")
    void givenWorkoutId_shouldFindOneWorkout() throws Exception {
        // Given
        Long workoutId = new Random().nextLong();
        // When
        Workout workout = workoutClient.getWorkoutById(workoutId);

        // Then
        assertNotNull(workout);
    }
}
```

### Maven POM Configuration

**Spring Consumer Contract Testing Dependencies**

```xml
	<dependencies>
		...
		...

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
			<exclusions>
				<exclusion>
					<groupId>org.junit.vintage</groupId>
					<artifactId>junit-vintage-engine</artifactId>
				</exclusion>
			</exclusions>
		</dependency>
		<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-contract-stub-runner</artifactId>
			<scope>test</scope>
		</dependency>
	</dependencies>
```

**Spring Feign Dependencies**

```xml
	<dependencies>
		...
		...
		<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-openfeign-core</artifactId>
			<version>2.2.1.RELEASE</version>
		</dependency>

		...
		...
	</dependencies>
```

### Noteworthy

- Using the `@EnableFeignClients` annotation of the root application class that also has the `@SpringBootApplication` annotation will result in the tests that use the `@SpringBootTest` annotation not being able to load tbe Spring context.  To get around this, do the following:


## References

- [How to use JUnit5 and Spring Cloud Contract](http://antkorwin.com/cloud/spring_cloud_contract_junit5.html)
- [Spring Cloud OpenFeign](https://spring.io/projects/spring-cloud-openfeign)
- [Intro to Feign](https://www.baeldung.com/intro-to-feign)
- [Producer Contract Testing code sample repo](https://github.com/jrbrayjr2006/rest-cloud-producer-contract)
