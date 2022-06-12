public class Queue {

    private IntNode _head, _tail;

    public Queue() {
        _head = null;
        _tail = null;
    }

    public boolean isEmpty() {
        return _head == null;
    }

    public void enqueue(int num) {
        IntNode temp = new IntNode(num, null);

        if (_tail != null) _tail.setNext(temp);
        _tail = temp;
        if (isEmpty()) _head = temp;
    }

    // must NOT be empty
    public int dequeue() {
        int temp = _head.getValue();
        _head = _head.getNext();
        return temp;
    }

    // must NOT be empty
    public int first() {
        return _head.getValue();
    }

    public String toString() {
        String s = "";
        Queue q1 = new Queue();

        while (!this.isEmpty()) {
            int temp = dequeue();
            q1.enqueue(temp);
            s = s.concat(temp + "\t");
        }

        while (!q1.isEmpty()) {
            int temp = q1.dequeue();
            this.enqueue(temp);
        }
        return s;
    }

    public static int size(Queue q) {
        int count=0;
        Queue temp = new Queue();
        while (!q.isEmpty()) {
            temp.enqueue(q.dequeue());
            count++;
        }
        while (!temp.isEmpty())
            q.enqueue(temp.dequeue());
        return count;
    }

    // USE AS BLUEPRINT
    public static boolean equals(Queue q1, Queue q2) {
        if (size(q1) != size(q2))
            return false;

        Queue temp1 = new Queue();
        Queue temp2 = new Queue();
        boolean flag = true;

        while(!q1.isEmpty()) {
            int x = q1.dequeue();
            int y = q2.dequeue();

            if (x != y)
                flag = false;

            temp1.enqueue(x);
            temp2.enqueue(y);
        }

        while (!temp1.isEmpty() && !temp2.isEmpty()) {
            q1.enqueue(temp1.dequeue());
            q2.enqueue(temp2.dequeue());
        }

        return flag;
    }
}
