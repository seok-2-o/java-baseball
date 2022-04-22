package domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class Stat {

    private static final List<Integer> POOL = IntStream.rangeClosed(0, 9)
            .boxed()
            .collect(toList());

    private final int[] elements;

    public Stat(int[] elements) {
        validate(elements);
        this.elements = elements;
    }

    public Stat(int first, int second, int third) {
        this(new int[]{first, second, third});
    }

    public static Stat random() {
        Collections.shuffle(POOL);
        int[] elements = POOL.stream()
                .limit(3)
                .mapToInt(i -> i)
                .toArray();
        return new Stat(elements);
    }

    private void validate(int[] elements) {
        long distinct = Arrays.stream(elements)
                .filter(it -> 0 <= it && it <= 9)
                .distinct()
                .count();
        if (distinct != 3) {
            throw new IllegalArgumentException("투구 기록은 중복 되지 않는 0~9로 숫자 조합이여야 합니다.");
        }
    }

    public Record match(Stat other) {
        Set<Integer> temp = Arrays.stream(elements)
                .boxed()
                .collect(Collectors.toSet());
        int strike = 0;
        for (int idx = 0; idx < elements.length; idx++) {
            int current = this.elements[idx];
            if (current == other.elements[idx]) {
                strike++;
                temp.remove(current);
            }
        }
        int ball = 0;
        for (int idx = 0; idx < elements.length; idx++) {
            if (temp.remove(other.elements[idx])) {
                ball++;
            }
        }
        return new Record(other.elements, strike, ball);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stat stat = (Stat) o;
        return Arrays.equals(elements, stat.elements);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(elements);
    }
}
