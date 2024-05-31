class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    private Node head;

    public LinkedList() {
        this.head = null;
    }

    // Getter method for head
    public Node getHead() {
        return head;
    }

    // Setter method for head
    public void setHead(Node head) {
        this.head = head;
    }

    // Method to insert a node at a specified position
    public void insertAtPos(int data, int position) {
        Node newNode = new Node(data);
        if (position == 1) {
            newNode.next = head;
            head = newNode;
        } else {
            Node current = head;
            int count = 1;
            while (count < position - 1 && current != null) {
                current = current.next;
                count++;
            }
            if (current != null) {
                newNode.next = current.next;
                current.next = newNode;
            }
        }
    }

    // Method to delete a node at a specified position
    public void deleteAtPosition(int position) {
        if (head == null)
            return;

        Node temp = head;
        if (position == 1) {
            head = temp.next;
            return;
        }

        for (int i = 1; temp != null && i < position - 1; i++) {
            temp = temp.next;
        }

        if (temp == null || temp.next == null)
            return;

        temp.next = temp.next.next;
    }

    // Method to delete the node after a given node
    public void deleteAfterNode(Node prevNode) {
        if (prevNode == null || prevNode.next == null)
            return;

        prevNode.next = prevNode.next.next;
    }

    // Method to search for a node with a specific value
    public boolean searchNode(int value) {
        Node current = head;
        while (current != null) {
            if (current.data == value)
                return true;
            current = current.next;
        }
        return false;
    }
}

class Stack {
    private LinkedList list;

    public Stack() {
        this.list = new LinkedList();
    }

    // Method to push an element onto the stack
    public void push(int data) {
        list.insertAtPos(data, 1);
    }

    // Method to pop an element from the stack
    public void pop() {
        list.deleteAtPosition(1);
    }

    // Method to peek the top element of the stack
    public int peek() {
        Node topNode = list.getHead();
        if (topNode != null)
            return topNode.data;
        return -1; // Assuming -1 represents an empty stack
    }
}

public class assignment2 {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insertAtPos(5, 1);
        list.insertAtPos(10, 2);
        list.insertAtPos(15, 3);
        list.deleteAtPosition(2);
        System.out.println("Search for 10: " + list.searchNode(10));
        System.out.println("Search for 15: " + list.searchNode(15));

        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("Peek: " + stack.peek());
        stack.pop();
        System.out.println("Peek after pop: " + stack.peek());
    }
}
