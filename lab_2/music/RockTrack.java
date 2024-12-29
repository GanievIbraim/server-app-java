package music;

public class RockTrack extends MusicTrack {
    public RockTrack(String title, String artist, double length) {
        super(title, artist, length);
    }

    @Override
    public String getStyle() {
        return "Rock";
    }
}
