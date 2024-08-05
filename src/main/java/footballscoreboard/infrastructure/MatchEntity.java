package footballscoreboard.infrastructure;

import footballscoreboard.domain.Match;
import footballscoreboard.domain.MatchId;
import footballscoreboard.domain.Score;
import footballscoreboard.domain.Team;
import footballscoreboard.shared.EntityObject;

@EntityObject
class MatchEntity {

    private MatchId id;

    private String homeTeam;
    private int homeTeamScore;
    private String awayTeam;
    private int awayTeamScore;

    MatchEntity(final MatchId id, final Score homeTeamScore, final Score awayTeamScore) {
        this.id = id;
        this.homeTeam = homeTeamScore.getTeamName();
        this.homeTeamScore = homeTeamScore.score();
        this.awayTeam = awayTeamScore.getTeamName();
        this.awayTeamScore = awayTeamScore.score();
    }

    Team getHomeTeam() {
        return new Team(homeTeam);
    }

    Team getAwayTeam() {
        return new Team(awayTeam);
    }

    MatchId getId() {
        return id;
    }

    Match toMatch() {
        return new Match(id, new Score(getHomeTeam(), homeTeamScore), new Score(getAwayTeam(), awayTeamScore));
    }
}
