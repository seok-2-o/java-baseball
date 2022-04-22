package domain;

import java.util.Objects;

public final class Record {

    public static final Record TREE_STRIKE = new Record(3, 0);

    private final int strike;
    private final int ball;

    public Record(int strike, int ball) {
        validate(strike, ball);
        this.strike = strike;
        this.ball = ball;
    }

    private void validate(int strike, int ball) {
        if (strike + ball > 3) {
            throw new IllegalArgumentException("유효하지 않은 기록입니다.");
        }
    }

    public boolean isTreeStrike() {
        return strike == 3;
    }

    public boolean isOut() {
        return strike == 0 && ball == 0;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        Record record = (Record) other;
        return strike == record.strike &&
                ball == record.ball;
    }

    @Override
    public int hashCode() {
        return Objects.hash(strike, ball);
    }
}
