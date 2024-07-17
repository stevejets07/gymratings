package com.gymRatings.gym_ratings.repository;

import com.gymRatings.gym_ratings.models.Gym;

import java.util.List;

public interface GymRatingsRepository {

    public List<Gym> getAllGyms()throws Exception;

    public Gym saveGym(Gym gym)throws Exception;

    public Gym updateGym(Gym gym)throws Exception;

    public Gym deleteGym(Gym gym)throws  Exception;

}
