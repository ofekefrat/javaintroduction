public class IntNodeTwo {
    private int _num;
    private IntNodeTwo _next, _prev;

    public IntNodeTwo(int n) {
        this._num = n;
        _next = null;
        _prev = null;
    }

    public IntNodeTwo(int num, IntNodeTwo n, IntNodeTwo p) {
        this._num = num;
        this._next = n;
        this._prev = p;
    }

    public int getNum() {
        return _num;
    }

    public IntNodeTwo getNext() {
        return _next;
    }

    public IntNodeTwo getPrev() {
        return _prev;
    }

    public void setNum(int num) {
        this._num = num;
    }

    public void setNext(IntNodeTwo next) {
        this._next = next;
    }

    public void setPrev(IntNodeTwo prev) {
        this._prev = prev;
    }

}
