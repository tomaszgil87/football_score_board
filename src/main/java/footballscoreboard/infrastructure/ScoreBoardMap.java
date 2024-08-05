package footballscoreboard.infrastructure;

import footballscoreboard.domain.MatchId;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Optional;

import static java.util.Optional.ofNullable;

final class ScoreBoardMap {

    private static ScoreBoardMap INSTANCE;
    private volatile LinkedHashMap<MatchId, MatchEntity> scoreBoardMap;
    private ScoreBoardMap() {
        this.scoreBoardMap = new LinkedHashMap<>(0);
    }

    static ScoreBoardMap getInstance() {
        if(INSTANCE == null) {
            return new ScoreBoardMap();
        }
        return INSTANCE;
    }

    void add(final MatchEntity entity) {
        scoreBoardMap.put(entity.getId(), entity);
    }

    void update(final MatchEntity entity) {
        scoreBoardMap.remove(entity.getId());
        scoreBoardMap.put(entity.getId(), entity);
    }

    void delete(final MatchId id) {
        scoreBoardMap.remove(id);
    }

    Optional<MatchEntity> get(MatchId id) {
        return ofNullable(scoreBoardMap.get(id));
    }

    List<MatchEntity> getAll() {
        return scoreBoardMap.values()
                            .stream()
                            .toList();
    }
}
