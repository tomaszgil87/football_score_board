package footballscoreboard;

public class MatchNotFoundException extends RuntimeException {

    private final String msg;

    public MatchNotFoundException(String msg) {
        super(msg);
        this.msg = msg;
    }
}
