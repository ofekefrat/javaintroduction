public class IntNode {
    private int _value;
    private IntNode _next;

    public IntNode(int val) {
        this._value = val;
        this._next = null;
    }

    public IntNode(int value, IntNode next) {
        this._value = value;
        this._next = next;
    }

    public int getValue() {
        return _value;
    }

    public IntNode getNext() {
        return _next;
    }

    public void setValue(int value) {
        this._value = value;
    }

    public void setNext(IntNode node) {
        this._next = node;
    }
}
