package presentation.ui;

import domain.Record;

import java.util.Arrays;
import java.util.Scanner;

import static java.util.stream.Collectors.joining;

public class ConsoleView {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static int[] ask() {
        System.out.println("예상 숫자를 입력하세요. (,로 구분)");
        return Arrays.stream(SCANNER.nextLine().split(","))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    public static void render(Record record) {

        String stat = Arrays.stream(record.getStat())
                .mapToObj(String::valueOf)
                .collect(joining(" "));
        if (record.isOut()) {
            System.out.printf("%s : OUT%n", stat);
            return;
        }
        System.out.printf("%s :  %sS  %sB%n", stat, record.getStrike(), record.getBall());

    }
}
