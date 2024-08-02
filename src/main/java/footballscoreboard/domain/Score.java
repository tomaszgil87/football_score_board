package footballscoreboard.domain;

import footballscoreboard.shared.ValueObject;

@ValueObject
public record Score(Team team, int score) {
}
