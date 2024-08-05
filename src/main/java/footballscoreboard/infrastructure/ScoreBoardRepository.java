package footballscoreboard.infrastructure;

import footballscoreboard.domain.Match;
import footballscoreboard.domain.MatchId;
import footballscoreboard.domain.Score;
import footballscoreboard.domain.Team;

import java.util.List;
import java.util.Optional;

public interface ScoreBoardRepository {

    MatchId addMatch(Score homeTeamScore, Score awayTeamScore);
    void updateMatch(MatchId id, Score homeTeamScore, Score awayTeamScore);
    void deleteMatch(MatchId id);
    Optional<Match> get(MatchId id);
    List<Match> getAll();
}
