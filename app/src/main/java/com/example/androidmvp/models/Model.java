package com.example.androidmvp.models;

import android.os.Handler;

import com.example.androidmvp.Contract;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Model implements Contract.Model {

    private List<String> courseList = Arrays.asList(
            "Information Technology",
            "Engineering",
            "Management",
            "Quantity Surveying"
    );

    @Override
    public void getNextCourse(final OnFinishedListener listener) {
        new Handler().postDelayed(() -> listener.onFinished(getRandomString()), 1200);
    }

    private String getRandomString() {
        Random random = new Random();
        int index = random.nextInt(courseList.size());
        return courseList.get(index);
    }
}
