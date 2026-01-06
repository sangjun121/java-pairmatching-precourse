package pairmatching.registry;

import java.util.ArrayList;
import java.util.List;
import pairmatching.domain.Course;
import pairmatching.domain.Crew;
import pairmatching.domain.Mission;
import pairmatching.domain.Pair;

public class PairMatchingRegistry {
    private static final PairMatchingRegistry INSTANCE = new PairMatchingRegistry();

    private List<Crew> backendCrews;
    private List<Crew> frontendCrews;

    private List<Pair> pairs;

    private PairMatchingRegistry() {
        this.backendCrews = new ArrayList<>();
        this.frontendCrews = new ArrayList<>();
        this.pairs = new ArrayList<>();
    }

    public static PairMatchingRegistry getInstance() {
        return INSTANCE;
    }

    public void registerCrews(Course course, List<Crew> crews) {
        if (course == Course.BACKEND) {
            this.backendCrews = crews;
        }

        if (course == Course.FRONTEND) {
            this.frontendCrews = crews;
        }
    }

    public List<Crew> findCrews(Course course) {
        if (Course.BACKEND == course) {
            return backendCrews;
        }

        return frontendCrews;
    }

    public void registerPair(List<Pair> appendPairs) {
        pairs.addAll(appendPairs);
    }

    public List<Pair> findPairsByCourseAndMission(Course course, Mission mission) {
        List<Pair> result = new ArrayList<>();

        for (Pair pair : pairs) {
            if (pair.getCourse() == course && pair.getMission() == mission) {
                result.add(pair);
            }
        }

        return result;
    }

    public void deleteAllPair(){
        pairs = new ArrayList<>();
    }
}
