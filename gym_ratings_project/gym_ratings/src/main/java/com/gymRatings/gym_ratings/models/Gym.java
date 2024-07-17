package com.gymRatings.gym_ratings.models;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Gym
{
    private int id;
    private  String gymName;

    public Gym() {}


    public Gym(ResultSet rs) throws SQLException {
        this.id = rs.getInt("id");
        this.gymName = rs.getString("gymname");
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGymName() {
        return gymName;
    }

    public void setGymName(String gymName) {
        this.gymName = gymName;
    }
}
