package com.jaydot2.rest.cloud.contract.restcloudconsumercontract;

import com.jaydot2.rest.cloud.contract.restcloudconsumercontract.client.WorkoutClient;
import com.jaydot2.rest.cloud.contract.restcloudconsumercontract.model.Workout;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertNotNull;

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
