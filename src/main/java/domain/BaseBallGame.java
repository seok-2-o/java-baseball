package domain;

import java.util.ArrayList;
import java.util.List;

public class BaseBallGame {

    private final Stat expected;
    private final List<Record> records = new ArrayList<>();

    public BaseBallGame(Stat expected) {
        this.expected = expected;
    }

    public Record pitch(Stat attempt) {
        Record match = expected.match(attempt);
        records.add(match);
        return match;
    }

    public boolean isEnd() {
        return !records.isEmpty() && records.get(records.size() - 1).isTreeStrike();
    }
}
