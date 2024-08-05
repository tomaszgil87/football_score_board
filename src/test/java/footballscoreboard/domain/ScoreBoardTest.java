package footballscoreboard.domain;

import footballscoreboard.infrastructure.ScoreBoardRepository;
import footballscoreboard.infrastructure.ScoreBoardRepositoryImpl;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ScoreBoardTest {

    private final ScoreBoardRepository scoreBoardRepository = new ScoreBoardRepositoryImpl();
    private final ScoreBoard scoreBoard = new ScoreBoardImpl(scoreBoardRepository);

    @Test
    void shouldStartGame() {
        //given
        var homeTeam = new Team("home team");
        var awayTeam = new Team("away team");
        //when
        var matchId = scoreBoard.startGame(homeTeam, awayTeam);
        //then
        var summary = scoreBoard.summary();
        Match match = getMatch(matchId, summary).get();
        assertEquals(0, match.homeTeamScore().score());
        assertEquals(0, match.awayTeamScore().score());
    }

    @Test
    void shouldFinishGame() {
        //given
        var homeTeam1 = new Team("home team1");
        var awayTeam1 = new Team("away team1");
        var matchId1 = scoreBoard.startGame(homeTeam1, awayTeam1);
        var homeTeam2 = new Team("home team1");
        var awayTeam2 = new Team("away team1");
        var matchId2 = scoreBoard.startGame(homeTeam2, awayTeam2);
        //when
        scoreBoard.finishGame(matchId1);
        //then
        var summary = scoreBoard.summary();
        assertFalse(getMatch(matchId1, summary).isPresent());
        assertTrue(getMatch(matchId2, summary).isPresent());
    }

    @Test
    void shouldUpdateScore() {
        //given
        var homeTeam = new Team("home team");
        var awayTeam = new Team("away team");
        var matchId = scoreBoard.startGame(homeTeam, awayTeam);
        //when
        scoreBoard.updateScore(matchId, new Score(homeTeam, 1), new Score(awayTeam, 2));
        //then
        var summary = scoreBoard.summary();
        Match match = getMatch(matchId, summary).get();
        assertEquals(1, match.homeTeamScore().score());
        assertEquals(2, match.awayTeamScore().score());
    }

    @Test
    void shouldGetSummary() {
        //given
        var homeTeam1 = new Team("home team1");
        var awayTeam1 = new Team("away team1");
        var homeTeam2 = new Team("home team2");
        var awayTeam2 = new Team("away team2");
        var homeTeam3 = new Team("home team3");
        var awayTeam3 = new Team("away team3");
        var matchId1 = scoreBoard.startGame(homeTeam1, awayTeam1);
        var matchId2 = scoreBoard.startGame(homeTeam2, awayTeam2);
        scoreBoard.updateScore(matchId1, new Score(homeTeam1, 1), new Score(awayTeam1, 0));
        var matchId3 = scoreBoard.startGame(homeTeam3, awayTeam3);
        scoreBoard.updateScore(matchId2, new Score(homeTeam1, 0), new Score(awayTeam1, 1));
        //when
        var summary = scoreBoard.summary();
        //then
        assertEquals(matchId2, summary.get(0).id());
        assertEquals(matchId3, summary.get(1).id());
        assertEquals(matchId1, summary.get(2).id());
    }

    private static Optional<Match> getMatch(MatchId id, List<Match> summary) {
        return summary.stream()
                      .filter(match -> match.id().equals(id))
                      .findFirst();
    }
}