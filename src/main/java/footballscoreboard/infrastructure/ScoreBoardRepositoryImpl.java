package footballscoreboard.infrastructure;

import footballscoreboard.domain.Match;
import footballscoreboard.domain.MatchId;
import footballscoreboard.domain.Score;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class ScoreBoardRepositoryImpl implements ScoreBoardRepository {

    private final ScoreBoardMap scoreBoardMap;

    public ScoreBoardRepositoryImpl() {
        this.scoreBoardMap = ScoreBoardMap.getInstance();
    }

    @Override
    public MatchId addMatch(final Score homeTeamScore, final Score awayTeamScore) {
        MatchId id = generateId();
        scoreBoardMap.add(new MatchEntity(id, homeTeamScore, awayTeamScore));
        return id;
    }

    @Override
    public void updateMatch(final MatchId id, final Score homeTeamScore, final Score awayTeamScore) {
        scoreBoardMap.update(new MatchEntity(id, homeTeamScore, awayTeamScore));
    }

    @Override
    public void deleteMatch(final MatchId id) {
        scoreBoardMap.delete(id);
    }

    @Override
    public Optional<Match> get(final MatchId id) {
        return scoreBoardMap.get(id)
                            .map(MatchEntity::toMatch);
    }

    @Override
    public List<Match> getAll() {
        return scoreBoardMap.getAll()
                            .stream()
                            .map(MatchEntity::toMatch)
                            .toList()
                            .reversed();
    }

    private static MatchId generateId() {
        return new MatchId(UUID.randomUUID());
    }
}
