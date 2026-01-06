package pairmatching.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    private static final String SELECT_DETAIL_GUIDE = "과정, 레벨, 미션을 선택하세요.\n"
            + "ex) 백엔드, 레벨1, 자동차경주";
    public String readOptionNumber(){
        return readLine();
    }

    public String readMissionDetail(){
        System.out.println(SELECT_DETAIL_GUIDE);
        return readLine();
    }
}
