package pairmatching.domain;

import java.util.List;

public class Pair {
    private final Course course;
    private final Level level;
    private final Mission mission;
    private final List<String> crews;

    public Pair(Course course, Level level, Mission mission, List<String> crews) {
        this.course = course;
        this.level = level;
        this.mission = mission;
        this.crews = crews;
    }

    public List<String> getCrews(){
        return crews;
    }

    public Course getCourse(){
        return course;
    }

    public Mission getMission(){
        return mission;
    }
}
