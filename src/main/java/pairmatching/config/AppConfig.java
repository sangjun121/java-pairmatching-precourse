package pairmatching.config;

import pairmatching.controller.PairController;
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

    public PairController pairController() {
        return new PairController(inputView(), outputView());
    }
}
