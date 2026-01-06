package pairmatching.config;

import pairmatching.application.PairService;
import pairmatching.controller.PairController;
import pairmatching.registry.PairMatchingRegistry;
import pairmatching.util.InputParser;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class AppConfig {
    private static final AppConfig INSTANCE = new AppConfig();

    private AppConfig() {
    }

    public static AppConfig getInstance() {
        return INSTANCE;
    }

    public InputView inputView() {
        return new InputView();
    }

    public OutputView outputView() {
        return new OutputView();
    }

    public PairMatchingRegistry pairMatchingRegistry() {
        return PairMatchingRegistry.getInstance();
    }

    public InputParser inputParser(){
        return new InputParser();
    }

    public PairService pairService() {
        return new PairService(pairMatchingRegistry(), inputParser());
    }

    public PairController pairController() {
        return new PairController(inputView(), outputView(), pairService());
    }
}
