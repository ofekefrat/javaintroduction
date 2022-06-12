public class IntListTwo {
    private IntNodeTwo _head, _tail;

    public IntListTwo() {
        _head = null;
        _tail = null;
    }

    public boolean isEmpty() {return _head == null;}
    /**
     * Insert int value after given node
     * @param num value to insert
     * @param node the PREVIOUS node
     */
    public void insertAfter(int num, IntNodeTwo node) {
        IntNodeTwo temp = new IntNodeTwo(num);
        if (_head == null) {
            _head = temp;
            _tail = _head;
        }

        else {
            IntNodeTwo current = _head;
            boolean exists = false;

            while (current.getNext() != null && !exists) {// make sure the given node exists in the list
                if (current == node) exists = true;
                else current = current.getNext();
            }
            if (exists) {
                temp.setNext(current.getNext());
                temp.setPrev(current);
                current.setNext(temp);
                if (temp.getNext() == null) _tail = temp; // if last, set as tail
                else temp.getNext().setPrev(temp); // otherwise, let the next one know we're the prev
            }
            else { // node doesn't exist
                temp.setPrev(_tail);
                _tail = temp;
            }
        }
    }

    // use as blueprint for other arrangement methods
    public void rearrange() {
        IntNodeTwo left = _head;
        IntNodeTwo right = _tail;

        while (left != right) {
            if (left.getNum() < 0) left = left.getNext(); // ok, just iterate left
            else if (right.getNum() > 0) right = right.getPrev(); // ok, just iterate right
            else { // both left and right are incorrect, switch them
                int temp = left.getNum();
                left.setNum(right.getNum());
                right.setNum(temp);
            }
        }
    }


    public boolean diff(int num) {
        if (isEmpty() || _head.getNext() == null) return false;

        IntNodeTwo ptr = _head;
        int max = ptr.getNum();
        int min = ptr.getNum();

        while (ptr != null) {
            if (ptr.getNum() > max) max = ptr.getNum();
            if (ptr.getNum() < min) min = ptr.getNum();
            ptr = ptr.getNext();
        }
        return max - min > num;
    }
}
