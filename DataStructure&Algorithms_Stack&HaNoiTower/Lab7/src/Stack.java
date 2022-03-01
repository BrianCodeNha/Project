public class Stack {
    Node head;

    public void push (int data) {
        Node newNode = new Node(data);
        newNode.setNextNode(this.head);
        this.head = newNode;
    }

    public String toString () {
        String result = "[" + "\n";
        Node current = this.head;

        while (current != null) {
            result += current.toString() + "\n";
            current = current.getNextNode();
        }
        result += "]";
        return result;
    }

    public int pop() {
        int top = this.head.getData();
        this.head = this.head.getNextNode();
        return top;

    }

    public int length() {
        int length = 0;
        Node current = this.head;

        while (current != null) {
            length++;
            current = current.getNextNode();
        }
        return length;
    }

}
