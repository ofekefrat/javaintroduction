public class IntList {

    private IntNode _head;

    public IntList() {
        _head = null;
    }

    public IntList(IntNode node) {
        _head = node;
    }

    public boolean empty() {
        return _head == null;
    }

    public IntNode nextElement(IntNode node) {
        return node.getNext();
    }

    public int getValueOfNode(IntNode node) {
        return node.getValue();
    }

    public void addToEnd(IntNode node) { // O(n)
        if (this.empty()) _head = node;
        else {
            IntNode ptr = _head; //initialize pointer
            while (ptr.getNext() != null) // take pointer to last element
                ptr = ptr.getNext();

            ptr.setNext(node);
        }
    }

    public void addToHead(IntNode node) { // O(1)
        IntNode temp = _head;
        _head = node;
        node.setNext(temp);
    }

    public void remove(int num) { // O(n)
        if (this.empty()) return;

        if (_head.getValue() == num) {
            _head = _head.getNext();
            return;
        }

        IntNode behind = _head;
        while (behind.getNext() != null) {
            if (behind.getNext().getValue() == num) {
                behind.setNext(behind.getNext().getNext());
                return;
            }
            behind = behind.getNext(); // take pointer to element behind num
        } // of while
    }

    public void printList() { // O(n)
        IntNode temp = _head;
        while (temp != null) {
            System.out.println(temp.getValue() + " --> ");
            temp = temp.getNext();
        }
        System.out.println(" null");
    }

    public int length() { // O(n)
        IntNode temp = _head;
        int count=0;
        while (temp != null) {
            count++;
            temp = temp.getNext();
        }
        return count;
    }

    public IntNode predecessor(IntNode node) { // O(n)
        if (this.empty() || _head == node) return null;

        IntNode behind = _head;
        while (behind.getNext() != null) {
            if (behind.getNext() == node) return behind;
            behind = behind.getNext();
        }
        return null;
    }


    // recursive methods

    public int lengthRec() {return lengthRec(_head);}

    private int lengthRec(IntNode node) {
        if (node == null) return 0;
        return 1 + lengthRec(node.getNext());
    }

    public void printListRec() {printListRec(_head);}

    private void printListRec(IntNode node) {
        if (node == null) {
            System.out.println(" null ");
            return;
        }
        System.out.println(node.getValue() + " --> ");
        printListRec(node.getNext());
    }

    public void addToEndRec(int num) {_head = addToEndRec(_head, num);}

    private IntNode addToEndRec(IntNode node, int num) {
        if (node == null) return new IntNode(num, null);
        node.setNext(addToEndRec(node.getNext(), num));
        return node;
    }

    public void addInOrder (int num) {
        _head = addInOrder(_head, num);
    }

    private IntNode addInOrder(IntNode node, int num) {
        if (node == null) return new IntNode(num);
        if (node.getValue() > num) return new IntNode(num, node);

        node.setNext(addInOrder(node.getNext(), num));
        return node;
    }

    // for sorted lists!
    public IntNode merge(IntNode node1, IntNode node2) {
        if (node1 == null) return node2;
        if (node2 == null) return node1;

        if (node1.getValue() < node2.getValue()) {
            node1.setNext(merge(node1.getNext(), node2));
            return node1;
        }
        node2.setNext(merge(node1, node2.getNext()));
        return node2;
    }

    public IntNode split(IntNode node) {
        if (node == null || node.getNext() == null) return null;
        IntNode list2 = node.getNext();
        node.setNext(list2.getNext());
        list2.setNext(split(list2.getNext()));
        return list2;
    }

    public IntNode mergeSort(IntNode node) { // O(n logn)
        if (node == null || node.getNext() == null) return node;
        IntNode list2 = split(node);
        node = mergeSort(node);
        list2 = mergeSort(list2);

        return merge(node, list2);
    }
}
