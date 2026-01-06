package pairmatching.application.dto;

import pairmatching.domain.Course;
import pairmatching.domain.Level;
import pairmatching.domain.Mission;

public class DetailRequest {
    private final Course course;
    private final Level level;
    private final Mission mission;

    public DetailRequest(Course course, Level level, Mission mission) {
        this.course = course;
        this.level = level;
        this.mission = mission;
    }

    public Course getCourse() {
        return course;
    }

    public Level getLevel() {
        return level;
    }

    public Mission getMission() {
        return mission;
    }
}
