package footballscoreboard.infrastructure;

import footballscoreboard.domain.Match;
import footballscoreboard.domain.MatchId;
import footballscoreboard.domain.Score;

import java.util.List;
import java.util.Optional;

public class ScoreBoardRepositoryImpl implements ScoreBoardRepository {
    @Override
    public MatchId addMatch(final Score homeTeamScore, final Score awayTeamScore) {
        return null;
    }

    @Override
    public void updateMatch(final MatchId id, final Score homeTeamScore, final Score awayTeamScore) {

    }

    @Override
    public void deleteMatch(final MatchId id) {

    }

    @Override
    public Optional<Match> get(final MatchId id) {
        return Optional.empty();
    }

    @Override
    public List<Match> getAll() {
        return null;
    }
}
