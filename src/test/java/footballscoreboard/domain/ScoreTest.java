package footballscoreboard.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScoreTest {

    @Test
    void shouldNotCreateWhenScoreIsLessThanZero() {
        //given
        int score = -1;
        //expected
        assertThrows(IllegalArgumentException.class,
                     () ->new Score(new Team("home team"), score));
    }
}