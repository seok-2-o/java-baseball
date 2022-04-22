package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RecordTest {

    @DisplayName("기록지의 Strike 와 Ball 의 개수의 합은 3을 넘을 수 없다.")
    @Test
    void create() {
        Assertions.assertThatThrownBy(()-> new Record(4, 0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("기록지가 3 Strike 인지 판별한다.")
    @Test
    void isTreeStrike() {
        Record record = new Record(3, 0);
        assertThat(record.isTreeStrike()).isTrue();
    }

    @DisplayName("기록지가 Out 인지 판별한다.")
    @Test
    void isOut() {
        Record record = new Record(0, 0);
        assertThat(record.isOut()).isTrue();
    }

}
