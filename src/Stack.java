public class Stack {
    private IntNode _top;

    public Stack() {
        this._top = null;
    }

    public boolean isEmpty() {
        return _top == null;
    }

    public void push(int num) {
        this._top = new IntNode(num, _top);
    }

    // THIS METHOD ASSUMES THE STACK IS NOT EMPTY
    public int pop() {
        int temp = _top.getValue();
        this._top = _top.getNext();
        return temp;
    }

    public int top() {
        int temp = pop();
        push(temp);
        return temp;
    }

    public String toString() {
        String s = "";
        Stack s1 = new Stack();

        while (!this.isEmpty()) {
            int temp = pop();
            s1.push(temp);
            s = s.concat(temp + "\t");
        }

        while (!s1.isEmpty()) {
            int temp = s1.pop();
            this.push(temp);
        }
        return s;
    }

    // returns the place of a certain element in a stack.
    public static int place(Stack s, int num) {
        if (s.isEmpty()) return Integer.MIN_VALUE;

        int x = s.pop();
        if (x == num) {
            s.push(x);
            return 0;
        }
        int p = place(s, num);
        s.push(x);
        if (p == Integer.MIN_VALUE) return p;
        return p+1;
    }

    public static int size(Stack s) {
        if (s.isEmpty()) return 0;

        int x = s.pop();
        int temp = 1 + size(s);
        s.push(x);
        return temp;
    }

    public static boolean equals(Stack s1, Stack s2) {
        if (s1.isEmpty() && s2.isEmpty()) return true;
        if (s1.isEmpty() || s2.isEmpty()) return false;

        int x = s1.pop();
        int y = s2.pop();
        boolean res = (x == y) && equals(s1, s2);
        s1.push(x);
        s2.push(y);
        return res;
    }
}
