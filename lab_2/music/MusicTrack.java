package music;

public abstract class MusicTrack {
    private String title;
    private String artist;
    private double length;

    public MusicTrack(String title, String artist, double length) {
        this.title = title;
        this.artist = artist;
        this.length = length;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public double getLength() {
        return length;
    }

    public abstract String getStyle();

    @Override
    public String toString() {
        return String.format("Title: %s, Artist: %s, Length: %.2f minutes, Style: %s",
                title, artist, length, getStyle());
    }
}
