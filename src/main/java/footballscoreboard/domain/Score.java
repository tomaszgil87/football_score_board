package footballscoreboard.domain;

import footballscoreboard.shared.ValueObject;

@ValueObject
public record Score(Team team, int score) {

    public Score(Team team, int score) {
        validate(score);
        this.team = team;
        this.score = score;
    }

    public Score(Team team) {
        this(team, 0);
    }

    private void validate(int score) {
        if(score < 0) throw new IllegalArgumentException("Score cannot be less than zero");
    }
}
