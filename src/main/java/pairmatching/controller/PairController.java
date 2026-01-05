package pairmatching.controller;

import java.util.Arrays;
import java.util.List;
import pairmatching.util.FileReader;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class PairController {
    private static final String BACKEND_CREW_FILE_PATH = "src/main/resources/backend-crew.md";
    private static final String FRONTEND_CREW_FILE_PATH = "src/main/resources/frontend-crew.md";

    private final InputView inputView;
    private final OutputView outputView;

    public PairController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {

        readOptionNumber();
    }

    private void readCrewNames() {
        List<String> backendCrewNames = Arrays.asList(FileReader.read(BACKEND_CREW_FILE_PATH).split(" "));
        List<String> frontendCrewNames = Arrays.asList(FileReader.read(FRONTEND_CREW_FILE_PATH).split(" "));
    }

    private void readOptionNumber() {
        outputView.printMainPage();
        String optionNumber = inputView.readOptionNumber();
    }
}
