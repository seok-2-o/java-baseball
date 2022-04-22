package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StatTest {

    private static final Stat FIXTURE = new Stat(0, 7, 6);

    @DisplayName("485 - 들어맞는 숫자가 아예 없으므로 Out을 리턴한다.")
    @Test
    void match01() {
        int[] input = new int[]{4, 8, 5};
        Record record = FIXTURE.match(new Stat(input));
        assertThat(record).isEqualTo(new Record(input, 0, 0));
    }

    @DisplayName("310 - 0이 있지만 위치가 다르므로 1볼을 리턴한다.")
    @Test
    void match02() {
        int[] input = new int[]{3, 1, 0};
        Record record = FIXTURE.match(new Stat(input));
        assertThat(record).isEqualTo(new Record(input, 0, 1));
    }

    @DisplayName("206 - 6이 있고 위치가 맞으며, 0이 있지만 위치가 다르므로 1스트라이크 1볼.")
    @Test
    void match03() {
        int[] input = new int[]{2, 0, 6};
        Record record = FIXTURE.match(new Stat(input));
        assertThat(record).isEqualTo(new Record(input, 1, 1));
    }

    @DisplayName(" 067 - 숫자는 전부 맞지만 위치는 0만 맞고 나머지 둘은 다르므로 1스트라이크 2볼")
    @Test
    void match04() {
        int[] input = new int[]{0, 6, 7};
        Record record = FIXTURE.match(new Stat(input));
        assertThat(record).isEqualTo(new Record(input, 1, 2));
    }

    @DisplayName(" 076 - 전부 맞으므로 3스트라이크.")
    @Test
    void match05() {
        int[] input = new int[]{0, 7, 6};
        Record record = FIXTURE.match(new Stat(input));
        assertThat(record).isEqualTo(new Record(input, 3, 0));
    }
}
