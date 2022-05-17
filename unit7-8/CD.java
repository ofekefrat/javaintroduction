public class CD extends Item {
    //fields
    private String _artist;
    private int _numOfTracks;

    //const
    public CD(String title, int year, String artist, int tracks) {
        super(title, year);
        this._artist = artist;
        this._numOfTracks = tracks;
    }

    //copy const
    public CD(CD other) {
        this(other._title, other._publishYear, other._artist, other._numOfTracks);
    }

    public String getArtist() {
        return _artist;
    }

    public int getNumOfTracks() {
        return _numOfTracks;
    }

    public void setArtist(String artist) {
        this._artist = artist;
    }

    public void setNumOfTracks(int tracks) {
        this._numOfTracks = tracks;
    }

    @Override
    public String toString() {
        return super.toString() + "\t by: " + _artist + "\t Number Of Tracks: " + _numOfTracks;
    }

    @Override
    public void play() {
        System.out.println("Now playing " + _title + " by " + _artist + ", enjoy listening...");
    }
}
