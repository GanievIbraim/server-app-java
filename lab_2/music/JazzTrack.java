package music;

public class JazzTrack extends MusicTrack {
    public JazzTrack(String title, String artist, double length) {
        super(title, artist, length);
    }

    @Override
    public String getStyle() {
        return "Jazz";
    }
}
