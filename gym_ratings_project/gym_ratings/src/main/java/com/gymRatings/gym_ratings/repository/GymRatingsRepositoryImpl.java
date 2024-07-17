package com.gymRatings.gym_ratings.repository;

import com.gymRatings.gym_ratings.models.Gym;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class GymRatingsRepositoryImpl implements GymRatingsRepository {

    @Autowired
    @Qualifier("gymRatingsDataSourceTemplate")
    private JdbcTemplate gymRatingsDataSourceTemplate;

    @Override
    public List<Gym> getAllGyms() {
        String query ="select * from gym";

        RowMapper<Gym> mapper = new RowMapper<Gym>(){

            public Gym mapRow(ResultSet rs, int rowNum) throws SQLException {

                Gym gym = new Gym(rs);

                return gym;
            }

        };

        List<Gym> gyms = this.gymRatingsDataSourceTemplate.query(query,mapper);

        return gyms;
    }

    @Override
    public Gym saveGym(Gym gym) throws Exception {
        return null;
    }

    @Override
    public Gym updateGym(Gym gym) throws Exception {
        return null;
    }

    @Override
    public Gym deleteGym(Gym gym) throws Exception {
        return null;
    }
}
