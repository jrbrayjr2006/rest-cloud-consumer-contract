package com.jaydot2.rest.cloud.contract.restcloudconsumercontract.client;

import com.jaydot2.rest.cloud.contract.restcloudconsumercontract.model.Workout;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("workouts")
public interface WorkoutClient {

    @RequestMapping( method = RequestMethod.GET, value = "/workout/{workoutId}", consumes = MediaType.APPLICATION_JSON_VALUE )
    Workout getWorkoutById(Long workoutId);
}
