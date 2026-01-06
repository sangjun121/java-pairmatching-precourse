package pairmatching.application;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import pairmatching.application.dto.DetailRequest;
import pairmatching.domain.Course;
import pairmatching.domain.Crew;
import pairmatching.domain.Pair;
import pairmatching.registry.PairMatchingRegistry;
import pairmatching.util.InputParser;

public class PairService {
    private final PairMatchingRegistry pairMatchingRegistry;
    private final InputParser inputParser;

    public PairService(PairMatchingRegistry pairMatchingRegistry, InputParser inputParser) {
        this.pairMatchingRegistry = pairMatchingRegistry;
        this.inputParser = inputParser;
    }

    public void registerCrews(Course course, List<String> crewNames) {
        List<Crew> crews = new ArrayList<>();
        for (String name : crewNames) {
            crews.add(new Crew(course, name));
        }

        pairMatchingRegistry.registerCrews(course, crews);
    }

    public List<Pair> runPairMatching(String missionDetail) {
        DetailRequest detailRequest = inputParser.parseDetail(missionDetail);
        List<Crew> crews = pairMatchingRegistry.findCrews(detailRequest.getCourse());
        return matchPair(detailRequest, crews);
    }

    public List<Pair> readPairMatchingResult(String missionDetail) {
        DetailRequest detailRequest = inputParser.parseDetail(missionDetail);
        List<Pair> pairs = pairMatchingRegistry.findPairsByCourseAndMission(detailRequest.getCourse(),
                detailRequest.getMission());

        if (pairs.size() == 0) {
            throw new IllegalArgumentException("[ERROR] 매칭 이력이 없습니다.");
        }

        return pairs;
    }

    public void deleteAllPair(){
        pairMatchingRegistry.deleteAllPair();
    }

    private List<Pair> matchPair(DetailRequest detailRequest, List<Crew> crews) {
        List<String> shuffledCrew = Randoms.shuffle(getCrewsName(crews));
        List<Pair> pairs = new ArrayList<>();

        if (shuffledCrew.size() % 2 == 0) {
            for (int i = 0; i < shuffledCrew.size(); i += 2) {
                List<String> crewNames = new ArrayList<>();
                crewNames.add(shuffledCrew.get(i));
                crewNames.add(shuffledCrew.get(i + 1));
                pairs.add(new Pair(detailRequest.getCourse(), detailRequest.getLevel(), detailRequest.getMission(),
                        crewNames));
            }
        } else {
            for (int i = 0; i < shuffledCrew.size() - 3; i += 2) {
                List<String> crewNames = new ArrayList<>();
                crewNames.add(shuffledCrew.get(i));
                crewNames.add(shuffledCrew.get(i + 1));
                pairs.add(new Pair(detailRequest.getCourse(), detailRequest.getLevel(), detailRequest.getMission(),
                        crewNames));
            }

            List<String> crewNames = new ArrayList<>();
            crewNames.add(shuffledCrew.get(shuffledCrew.size() - 3));
            crewNames.add(shuffledCrew.get(shuffledCrew.size() - 2));
            crewNames.add(shuffledCrew.get(shuffledCrew.size() - 1));
            pairs.add(new Pair(detailRequest.getCourse(), detailRequest.getLevel(), detailRequest.getMission(),
                    crewNames));
        }

        savePairMatching(pairs);
        return pairs;
    }

    private void savePairMatching(List<Pair> pairs) {
        pairMatchingRegistry.registerPair(pairs);
    }

    private List<String> getCrewsName(List<Crew> crews) {
        List<String> crewNames = new ArrayList<>();

        for (Crew crew : crews) {
            crewNames.add(crew.getName());
        }

        return crewNames;
    }
}
