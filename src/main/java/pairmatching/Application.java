package pairmatching;

import pairmatching.config.AppConfig;
import pairmatching.controller.PairController;

public class Application {
    public static void main(String[] args) {
        AppConfig appConfig = AppConfig.getInstance();
        PairController pairController = appConfig.pairController();
        pairController.run();
    }
}
