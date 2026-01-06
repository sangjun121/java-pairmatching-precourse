package pairmatching.controller;

import java.util.Arrays;
import java.util.List;
import pairmatching.application.PairService;
import pairmatching.domain.Course;
import pairmatching.domain.Pair;
import pairmatching.util.FileReader;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class PairController {
    private static final String BACKEND_CREW_FILE_PATH = "src/main/resources/backend-crew.md";
    private static final String FRONTEND_CREW_FILE_PATH = "src/main/resources/frontend-crew.md";

    private final InputView inputView;
    private final OutputView outputView;
    private final PairService pairService;

    public PairController(InputView inputView, OutputView outputView, PairService pairService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.pairService = pairService;
    }

    public void run() {
        bootStrap();

        String optionNumber = readOptionNumber();
        while (!optionNumber.equals("Q")) {
            doOneSequence(optionNumber);
            optionNumber = readOptionNumber();
        }
    }

    private void bootStrap() {
        registerCrews();
    }

    private void doOneSequence(String optionNumber){
        try{
            if (optionNumber.equals("1")) {
                matchPair();
            }
            if (optionNumber.equals("2")) {
                readPairMatchingResult();
            }
            if (optionNumber == "3") {

            }
        } catch (Exception e){
            outputView.printErrorMessage(e.getMessage());
        }
    }

    private void registerCrews() {
        List<String> backendCrewNames = Arrays.asList(FileReader.read(BACKEND_CREW_FILE_PATH).split(" "));
        pairService.registerCrews(Course.BACKEND, backendCrewNames);

        List<String> frontendCrewNames = Arrays.asList(FileReader.read(FRONTEND_CREW_FILE_PATH).split(" "));
        pairService.registerCrews(Course.FRONTEND, frontendCrewNames);
    }

    private String readOptionNumber() {
        outputView.printMainPage();
        return inputView.readOptionNumber();
    }

    private void matchPair(){
        String missionDetail = readMissionDetail();
        List<Pair> pairs = pairService.runPairMatching(missionDetail);
        printPairResult(pairs);
    }

    private String readMissionDetail(){
        outputView.printCourseInformation();
        return inputView.readMissionDetail();
    }

    private void readPairMatchingResult(){
        String missionDetail = readMissionDetail();
        List<Pair> pairs = pairService.readPairMatchingResult(missionDetail);
        printPairResult(pairs);
    }

    private void printPairResult(List<Pair> pairs){
        outputView.printPairMatchingResult(pairs);
    }
}
