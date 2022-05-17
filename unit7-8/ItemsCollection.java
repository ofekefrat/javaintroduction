public class ItemsCollection {
    //fields
    private Item[] _collection;
    private int _numOfItems;

    private final int MAX_ITEMS = 20;

    //const
    public ItemsCollection() {
        this._collection = new Item[MAX_ITEMS];
        this._numOfItems = 0;
    }

    public boolean addItem(Item newItem) {
        if (newItem == null) return false;
        if (_numOfItems == MAX_ITEMS) return false;

        this._collection[_numOfItems++] = newItem;
        return true;
    }

    public void playItem(int itemNumber) {
        if (itemNumber<0 || itemNumber>=_numOfItems) {
            System.out.println("Item no." + itemNumber + " doesn't exit in the collection.");
            return;
        }
        _collection[itemNumber].play();
    }

    public int getNumberOfCDs() {
        int count=0;
        for (int i = 0; i < _numOfItems; i++) {
            if (_collection[i] instanceof CD) count++;
        }
        return count;
    }

    public void oldiesButGoldies(int year) {
        if (_numOfItems == 0) return;
        for (int i = 0; i < _numOfItems; i++) {
            if (_collection[i] instanceof Video)
                if (((Video) _collection[i]).isOlder(year))
                    System.out.println(_collection[i].getTitle());
        }
    }
}
