package footballscoreboard.domain;

import footballscoreboard.MatchNotFoundException;
import footballscoreboard.infrastructure.ScoreBoardRepository;

import java.util.List;

import static java.lang.String.format;

public class ScoreBoardImpl implements ScoreBoard {

    private final ScoreBoardRepository scoreBoardRepository;

    public ScoreBoardImpl(ScoreBoardRepository scoreBoardRepository) {
        this.scoreBoardRepository = scoreBoardRepository;
    }

    @Override
    public MatchId startGame(final Team homeTeam, final Team awayTeam) {
        return scoreBoardRepository.addMatch(new Score(homeTeam), new Score(awayTeam));
    }

    @Override
    public void finishGame(final MatchId id) {
        scoreBoardRepository.get(id)
                            .ifPresentOrElse(match -> scoreBoardRepository.deleteMatch(id),
                                             () -> throwException(id));
    }

    @Override
    public void updateScore(final MatchId id, final Score homeTeamScore, final Score awayTeamScore) {
        scoreBoardRepository.get(id)
                            .ifPresentOrElse(match -> scoreBoardRepository.updateMatch(id, homeTeamScore, awayTeamScore),
                                             () -> throwException(id));
    }

    @Override
    public List<Match> summary() {
        return scoreBoardRepository.getAll();
    }

    private void throwException(MatchId id) {
        throw new MatchNotFoundException(format("Match with id %s does not exist", id));
    }
}
