public class Video extends Item {
    //fields
    private String _director;

    //const
    public Video(String title, int year, String director) {
        super(title, year);
        this._director = director;
    }

    //copy const
    public Video(Video other) {
        this(other._title, other._publishYear, other._director);
    }

    public String getDirector() {
        return _director;
    }

    public void setDirector(String director) {
        this._director = director;
    }

    @Override
    public String toString() {
        return super.toString() + "\t Directed by :" + _director;
    }

    @Override
    public void play() {
        System.out.println("Now Playing " + _title + " directed by " + _director + ", enjoy watching...");
    }

    public boolean isOlder(int year) {
        if (year<0) return false;
        return (this._publishYear < year);
    }
}
