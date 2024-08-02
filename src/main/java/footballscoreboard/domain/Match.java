package footballscoreboard.domain;

import footballscoreboard.shared.ValueObject;

@ValueObject
public record Match(Score homeTeamScore, Score awayTeamScore) {
}
