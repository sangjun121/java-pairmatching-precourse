package pairmatching.util;

import java.util.Arrays;
import java.util.List;
import pairmatching.application.dto.DetailRequest;
import pairmatching.domain.Course;
import pairmatching.domain.Level;
import pairmatching.domain.Mission;

public class InputParser {
    public DetailRequest parseDetail(String detailInput) {
        List<String> details = Arrays.asList(detailInput.split(","));

        Course course = Course.getCourseByName(details.get(0).trim());
        Level level = Level.getLevelByName(details.get(1).trim());
        Mission mission = Mission.getMissionByName(details.get(2).trim());

        return new DetailRequest(course, level, mission);
    }
}
