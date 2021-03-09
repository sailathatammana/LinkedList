package se.sdaproject;

// a "box" in our previous picture
class Node {
    // field 1: the data
    // in our case just an integer
    int elem;
    // field 2: the reference to the next node
    Node next;
    Node(int num) {
        this.elem = num;
        this.next = null;
    }
}


public class LinkedList {

    private Node first = null;

    public void add(int num) {
        // int num is available!

        // step 1: is the linked list still empty?
        if (first == null) {
            // in this case, the linked list is empty
            Node node = new Node(num); // node.next == null
            first = node;
        } else {
            // in this case, the linked list is *not* empty
            // this means, first != null

            // step 2: find the last node

            // Key: introduce a temporary variable!
            // we can then update this temporary variable,
            // without changing "first"!
            // important, since "first" should not be changed!
            Node current = first;
            while (current.next != null) { // current is not the last node!
                current = current.next;
            }
            // what do we know about "current"?
            // current.next == null
            // AWESOME!
            // it means, "current" is the last node!

            // step 3: create a new node with the given int "num"
            Node node = new Node(num);

            // step 4: change the reference of the last node to
            // point to the new node
            current.next = node;
        }

    }
    // Searching a element in data structure
    public int search(int num){
        if (first== null){
            return -1;
        }
        else{
            Node current= first;
            int index=0;
            if (current.elem==num){
                return index;
            }
            else {
                while(current.next!=null){
                    index+=1;
                    if (current.next.elem== num) {
                        return index;
                    }
                    current=current.next;
                }
            }
            return -1;
        }
    }

    public Node get(int index) {
        if (first == null) {
            return null;
        }
        try {
            Node current = first;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            return current;
        } catch (NullPointerException e) {
            return null;
        }
    }

    public int size(){
        try {
            Node current = first;
            int size = 1;
            while (current.next != null) {
                current = current.next;
                size++;
            }
            return size;
        } catch (NullPointerException ignored) {
            return 0;
        }

    }

    public boolean remove (int num) {
        try {
            if (search(num) < 0) {
                return false;
            } else if (search(num)== 0 && size() >1) {
                first = get(search(num)+1);
                return true;
            } else if (search(num) == 0 && size() == 1){
                first = null;
                return true;
            }
            else {
                Node previousNode = get(search(num)-1);
                if (get(search(num)+1) == null ) {
                    previousNode.next = null;
                } else {
                    previousNode.next = get(search(num)+1);}

                return true;

            }
        } catch (NullPointerException e) {
            return false;
        }
    }

    // useful for testing!
    public String toString() {
        // goal is to return a string like this:
        // "LinkedList(5,2,10)"

        StringBuilder builder = new StringBuilder();

        // call methods on "builder" to add strings

        builder.append("LinkedList(");
        // append strings for each integer in the list

        if (first == null) {
            // what to do here?
            // string to be returned: "LinkedList()"
            // nothing left to do!
        } else {
            // here, we know that first != null
            // go through the chain of nodes, starting with
            // "first"

            Node current = first;
            // treat first element specially:
            builder.append("" + current.elem);

            while (current.next != null) {
                current = current.next;
                builder.append("," + current.elem);
            }
            // current.next == null
            // we have already appended the last num!
        }

        // append ")"
        builder.append(")");
        return builder.toString();
    }
}