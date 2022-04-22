package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BaseBallGameTest {

    private static final Stat FIXTURE = new Stat(0, 7, 6);

    @DisplayName("3스트라이크를 맞추면 게임이 종료 된다.")
    @Test
    void isEnd() {
        BaseBallGame game = new BaseBallGame(FIXTURE);
        game.pitch(FIXTURE);
        assertThat(game.isEnd()).isTrue();
    }
}
