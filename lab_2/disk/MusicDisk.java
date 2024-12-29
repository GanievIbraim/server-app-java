package disk;

import music.MusicTrack;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MusicDisk {
    private List<MusicTrack> tracks;

    public MusicDisk() {
        this.tracks = new ArrayList<>();
    }

    public void addTrack(MusicTrack track) {
        tracks.add(track);
    }

    public double getTotalLength() {
        return tracks.stream().mapToDouble(MusicTrack::getLength).sum();
    }

    public void sortTracksByStyle() {
        tracks.sort(Comparator.comparing(MusicTrack::getStyle));
    }

    public List<MusicTrack> findTracksByLengthRange(double minLength, double maxLength) {
        List<MusicTrack> result = new ArrayList<>();
        for (MusicTrack track : tracks) {
            if (track.getLength() >= minLength && track.getLength() <= maxLength) {
                result.add(track);
            }
        }
        return result;
    }

    public void printTracks() {
        tracks.forEach(System.out::println);
    }
}
