package presentation;

import domain.BaseBallGame;
import domain.Record;
import domain.Stat;
import presentation.ui.ConsoleView;

public class GameApplication {


    public static void main(String[] args) {
        BaseBallGame game = new BaseBallGame(Stat.random());
        while (!game.isEnd()) {
            Record record = game.pitch(new Stat(ConsoleView.ask()));
            ConsoleView.render(record);
        }

    }
}
