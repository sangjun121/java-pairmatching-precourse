package pairmatching.util;

import java.io.File;
import java.util.Scanner;

public class FileReader {
    public static String read(String filePath) {
        StringBuilder sb = new StringBuilder();

        try {
            Scanner scanner = new Scanner(new File(filePath));

            while (scanner.hasNext()) {
                sb.append(scanner.next());
                sb.append(" ");
            }
            return sb.toString().trim();
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 파일 탐색 문제");
        }
    }
}
