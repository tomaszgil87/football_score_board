package footballscoreboard.domain;

import java.util.List;

public interface ScoreBoard {

    MatchId startGame(Team homeTeam, Team awayTeam);
    void finishGame(MatchId id);
    void updateScore(MatchId id, Score homeTeamScore, Score awayTeamScore);
    List<Match> summary();
}
