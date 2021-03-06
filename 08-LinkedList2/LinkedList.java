public class LinkedList {

    private Node head;
    private Node tail;
    private int length;

    public LinkedList() {
        head = null;
        tail = null;
        length = 0;
    }

    public LinkedList(Node n) {
        head = n;
        tail = n;
        length = 1;
    }

    public void append(Node n) {
        if (head != null && tail != null) {
            Node tmp = tail.copy();
            n.setParent(tmp);
            tmp.setDaughter(n);
            tail = n;
            length++;
        } else {
            head = n;
            tail = n;
            length = 1;
        }
    }

    public void prepend(Node n) {
        if (head != null && tail != null) {
            Node tmp = head.copy();
            n.setDaughter(tmp);
            tmp.setParent(n);
            head = n;
            length++;
        } else {
            head = n;
            tail = n;
            length = 1;
        }
    }

    private void detach(Node n) {
        n.getParent().setDaughter(n.getDaughter());
        n.getDaughter().setParent(n.getParent());
        n.setParent(null);
        n.setDaughter(null);
        length--;
    }

    public void removeAt(int index) {
        Node tmp = head;
        for (int i = 0; head != null && tail != null && i <= index && tmp.getDaughter() != null; i++) {
            tmp = tmp.getDaughter();
        }
        detach(tmp);
    }

    public void insert(Node n , int index) {
        if (head != null && tail != null) {
            Node tmp = n.copy();
            Node movingHead = head;
            for (int i = 0; i <= index - 1 && movingHead.getDaughter() != null; i++) {
                tmp.setParent(movingHead);
                movingHead = movingHead.getDaughter();
            }
            tmp.setDaughter(tmp.getParent().getDaughter());
            tmp.getParent().setDaughter(tmp);
        } else {
            head = n;
            tail = n;
            length++;
        }
    }
}
