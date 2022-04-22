package domain;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class Stat {

    private final int[] elements;

    public Stat(int first, int second, int third) {
        this.elements = new int[]{
                first,
                second,
                third
        };
    }

    public Record match(Stat other) {
        if (this.equals(other)) {
            return Record.TREE_STRIKE;
        }
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
        return new Record(strike, ball);
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
