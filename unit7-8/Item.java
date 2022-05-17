public abstract class Item {
    //protected vars
    protected String _title;
    protected int _publishYear;

    //constructor
    public Item(String title, int year) {
        this._title = title;
        this._publishYear = year;
    }

    //copy constructor
    public Item(Item other) {
        this(other._title, other._publishYear);
    }

    public String getTitle() {
        return _title;
    }

    public int getPublishYear() {
        return _publishYear;
    }

    public void setTitle(String newTitle) {
        this._title = newTitle;
    }

    public void setPublishYear(int newYear) {
        this._publishYear = newYear;
    }

    public abstract void play();

    @Override
    public String toString() {
        return (_title + "\t Published at: " + _publishYear);
    }
}
