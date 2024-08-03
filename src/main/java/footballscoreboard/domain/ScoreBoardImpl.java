package footballscoreboard.domain;

import java.util.List;

public class ScoreBoardImpl implements ScoreBoard {

    @Override
    public MatchId startGame(Team homeTeam, Team awayTeam) {
        return null;
    }

    @Override
    public void finishGame(MatchId id) {

    }

    @Override
    public void updateScore(MatchId id, Score homeTeamScore, Score awayTeamScore) {

    }

    @Override
    public List<Match> summary() {
        return List.of();
    }
}
