import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class GameTest {

    @Test
    public void testAllStrikes() {
        Game game = new Game();
        // 12 tiri --> 10 frames + 2 tiri bonus
        for (int i = 0; i < 12; i++) {
            game.roll(10); // Tutti strike
        }
        assertEquals(300F, game.score());
    }

    @Test
    public void testAllSpares() {
        Game game = new Game();
        // 21 tiri --> 2 tiri per 10 frame + 1 tiro bonus
        for (int i = 0; i < 21; i++) {
            game.roll(5);
        }
        assertEquals(150F, game.score());
    }

    @Test
    public void testNoStrikesNoSpares() {
        Game game = new Game();
        // 20 tiri --> 2 tiri per 10 frame (no bonus)
        for (int i = 0; i < 20; i++) {
            game.roll(4);
        }
        assertEquals(80F, game.score());
    }

    @Test
    public void testMixedRolls() {
        Game game = new Game();
        game.roll(10);// Strike
        game.roll(7);
        game.roll(3);// Spare
        game.roll(9);
        game.roll(0);
        game.roll(10);// Strike
        game.roll(10);// Strike
        game.roll(10);// Strike
        game.roll(2);
        game.roll(3);
        game.roll(6);
        game.roll(4);// Spare
        game.roll(10);// Strike
        game.roll(0);
        game.roll(0);
        assertEquals(150F, game.score());
    }
}
