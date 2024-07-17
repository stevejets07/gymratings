package com.gymRatings.gym_ratings;

import com.gymRatings.gym_ratings.models.Gym;
import com.gymRatings.gym_ratings.repository.GymRatingsRepositoryImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;

import static org.assertj.core.api.FactoryBasedNavigableListAssert.assertThat;

@SpringBootTest//this class is intended to test methods for this project
class GymRatingsApplicationTests {

	@Autowired
	private GymRatingsRepositoryImpl gymRatingsRepository;

	@Test//means method is meant to be tested
    public void getAllGymsTest() throws Exception {
		ArrayList<Gym> gyms = (ArrayList<Gym>) this.gymRatingsRepository.getAllGyms();
		assertThat(gyms.size()).isGreaterThan(3);
    }

}
