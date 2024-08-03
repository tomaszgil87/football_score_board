package footballscoreboard.domain;

import footballscoreboard.shared.ValueObject;

@ValueObject
public record Match(MatchId id, Score homeTeamScore, Score awayTeamScore) {
}
