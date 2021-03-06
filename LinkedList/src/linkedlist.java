
class Node {
    int data;
    Node next;
}

public class linkedlist {
    Node first;
    Node last;
    int size = 0;

    public boolean isEmpty() {
        return (size == 0);
    }

    public void insertfirst(int value) {
        Node newnode = new Node();
        newnode.data = value;
        if (size == 0) {
            last = newnode;
        }
        newnode.next = first;
        first = newnode;
        size++;
    }

    public void insertlast(int value) {
        Node newnode = new Node();
        newnode.data = value;
        if (size == 0) {
            first = newnode;
        } else {
            last.next = newnode;
        }
        last = newnode;
        size++;
    }

    public void insertposition(int pos, int value) {
        if (pos < 0 || pos > size) {
            return;
        } else if (pos == 0) {
            insertfirst(value);
            return;
        } else if (pos == size) {
            insertlast(value);
            return;
        } else if (pos > 0 && pos < size) {
            Node current = first;
            for (int i = 0; i < pos - 1; ++i) {
                current = current.next;
            }
            Node newnode = new Node();
            newnode.data = value;
            newnode.next = current.next;
            current.next = newnode;
            size++;
        }
    }

    public void deletefirst() {
        if (size == 0) {
            return;
        } else if (size == 1) {
            first = last = null;
        } else {
            first = first.next;
        }
        size--;
    }

    public void deletelast() {
        if (size == 0) {
            return;
        } else if (size == 1) {
            first = last = null;
        } else {
            Node current = first;
            while (current.next != last) {
                current = current.next;
            }
            current.next = null;
        }
        size--;
    }

    public void deleteitem(int key) {
        if (size == 0) {
            return;
        }

        if (first.data == key) {
            deletefirst();
            return;
        } else if (last.data == key) {
            deletelast();
            return;
        }

        Node current = first;
        while (current.next != null) {
            if (current.next.data == key) {
                break;
            }
            current = current.next;
        }
        current.next = current.next.next;
        size--;
    }

    public void search(int key) {
        Node current = first;
        int i = 0;
        while (current != null) {
            if (current.data == key) {
                System.out.println(key + " Found in index " + i);
                return;
            }
            current = current.next;
            i++;
        }
        System.out.println(key + " Not Found");
    }

    public void display() {
        Node current = first;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {

    }
}
