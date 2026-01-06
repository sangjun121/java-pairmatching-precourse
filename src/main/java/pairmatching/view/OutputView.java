package pairmatching.view;

import java.util.List;
import pairmatching.domain.Pair;

public class OutputView {
    private static final String MAIN_PAGE_GUIDE = "기능을 선택하세요.\n"
            + "1. 페어 매칭\n"
            + "2. 페어 조회\n"
            + "3. 페어 초기화\n"
            + "Q. 종료";

    private static final String COURSE_INFORMATION = "#############################################\n"
            + "과정: 백엔드 | 프론트엔드\n"
            + "미션:\n"
            + "  - 레벨1: 자동차경주 | 로또 | 숫자야구게임\n"
            + "  - 레벨2: 장바구니 | 결제 | 지하철노선도\n"
            + "  - 레벨3: \n"
            + "  - 레벨4: 성능개선 | 배포\n"
            + "  - 레벨5: \n"
            + "############################################";
    private static final String PAIR_MATCHING_RESULT_GUIDE = "페어 매칭 결과입니다.";
    private static final String SEPERATOR = " : ";

    public void printMainPage() {
        System.out.println(MAIN_PAGE_GUIDE);
    }

    public void printCourseInformation() {
        System.out.println(COURSE_INFORMATION);
    }

    public void printPairMatchingResult(List<Pair> pairs) {
        System.out.println(PAIR_MATCHING_RESULT_GUIDE);
        for (Pair pair : pairs) {
            printEachPair(pair.getCrews());
        }
    }

    public void printErrorMessage(String message) {
        System.out.println(message);
    }

    private void printEachPair(List<String> crews) {
        StringBuilder sb = new StringBuilder();

        for (String crew : crews) {
            sb.append(crew);
            sb.append(SEPERATOR);
        }
        sb.delete(sb.length() - 3, sb.length());
        System.out.println(sb);
    }
}
