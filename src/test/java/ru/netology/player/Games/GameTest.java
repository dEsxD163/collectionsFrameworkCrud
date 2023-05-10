package ru.netology.player.Games;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {
    @Test
    public void winnerDenis() {
        Player denis = new Player(1, "Денис", 10);
        Player lena = new Player(2, "Лена", 5);

        Game game = new Game();
        game.register(denis);
        game.register(lena);

        int expected = 1;
        int actual = game.round("Денис", "Лена");

        Assertions.assertEquals(expected, actual);


    }

    @Test
    public void winnerLena() {
        Player denis = new Player(1, "Денис", 10);
        Player lena = new Player(2, "Лена", 20);

        Game game = new Game();
        game.register(denis);
        game.register(lena);

        int expected = 2;
        int actual = game.round("Денис", "Лена");

        Assertions.assertEquals(expected, actual);


    }

    @Test
    public void playedInADraw() {
        Player denis = new Player(1, "Денис", 20);
        Player lena = new Player(2, "Лена", 20);

        Game game = new Game();
        game.register(denis);
        game.register(lena);

        int expected = 0;
        int actual = game.round("Денис", "Лена");

        Assertions.assertEquals(expected, actual);


    }

    @Test
    public void passingTheTestNotRegisteredExceptionPlayer2() {
        Player denis = new Player(1, "Денис", 20);
        Player lena = new Player(2, "Лена", 20);

        Game game = new Game();
        game.register(denis);
        game.register(lena);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Денис", "Оля");
        });
    }

    @Test
    public void passingTheTestNotRegisteredExceptionPlayer1() {
        Player denis = new Player(1, "Денис", 20);
        Player lena = new Player(2, "Лена", 20);

        Game game = new Game();
        game.register(denis);
        game.register(lena);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Оля", "Денис");
        });
    }
}
