public class LinkedList {
    public Node head;

    //This was created in order to save time. Didn't take it from anywhere.


    static class Node {
        int data;
        Node next;

        Node(int d) {
            this.data = d;
            this.next = null;
        }
    }
    // This is the basic values of a Node class,
    // I've read about it on here :
    // https://www.geeksforgeeks.org/linked-list-set-1-introduction/?ref=lbp
    // Implemented as required.

    //The main class calls on listSelect(); in order to start the actions.
    //You can select : List 1 or List 2 doing lets you modify either of them afterwards.
    //listSelect(); calls on Visual.choices() to let you select what you want to do.
    // public LinkedList listOne = new LinkedList();

    static LinkedList listOne = new LinkedList();
    static LinkedList listTwo = new LinkedList();

    public static void main(String[] args) {
        listOne.add(1);
        listOne.add(15);
        listOne.add(2);
        listOne.add(3);
        listOne.add(23);
        listOne.add(4);
        listOne.add(2);
        listTwo.add(1);
        listTwo.add(15);
        listTwo.add(2);
        listTwo.add(3);
        listTwo.add(23);
        listTwo.add(4);
        listTwo.add(2);
        System.out.println("This is list one : " + listOne);
        System.out.println("This is list two : " + listTwo);
        System.out.println("The size is for list one is: " + listOne.size());
        System.out.println("The size is for list two is: " + listTwo.size());
        System.out.println("Does list one contain: " + listOne.contain(15));
        System.out.println("Compare: " + listOne.compare());
        System.out.println("Magic Compare: " + listOne.magicCompare());
        Visual.listSelect();

    }

    // 1 Option Add Node, followed this site to understand and create the add (append) - https://www.geeksforgeeks.org/linked-list-set-2-inserting-a-node/
    // I learn via applying what I see and understanding it, as such, most of the code in this A1 is following the information provided on GeeksForGeeks.
    public void add(int newInt) {
        Node newNode = new Node(newInt);
        if (head == null) { // Add a new node at the head
            head = newNode;
            return;
        }
        newNode.next = null;
        Node last = head;
        while (last.next != null)
            last = last.next;
        last.next = newNode;
    }


    // As above, followed the tutorial from GeeksForGeeks:
    // https://www.geeksforgeeks.org/linked-list-set-3-deleting-node/)
    // This helped me understand the flow of Nodes and how to manipulate them.
    // I expended for the control of two Linked List
    public void remove(int removeInt) {
        {
            Node temp = head, prev = null;
            if (temp != null && temp.data == removeInt) {
                head = temp.next;
                return;
            }
            while (temp != null && temp.data != removeInt) {
                prev = temp;
                temp = temp.next;
            }
            if (temp == null) {
                System.out.println("The list doesn't contains the number: " + removeInt);
                System.out.println("-- " + Visual.listSelected + " --");
                return;
            }
            prev.next = temp.next;
        }
    }
    // Used this idea here for the toString:
    // https://www.geeksforgeeks.org/convert-linkedlist-to-string-in-java/
    // I used this at first with an Iterator and modified it in order to have something not using
    // Iterators

    public String toString() {
        Node now = head;
        String list = "";
        while (now != null) {
            list = list + (now).data + " ";
            now = now.next;
        }
        if (list.equals("")) return "0";
        else {
            return list;
        }
    }

    // I've had a hard time working on this part.
    // I went for the easy way in the end as I was unable to work through it.
    // ABOVE IS DEPRECATED
    // I was unable to tackle this at first and used the .size from LinkedList (java). In the end,
    // After understanding the logic I made this from scratch. It might be present on the same website
    // Mentioned before, but I have not been looking for it.

    public int size() {
        int listSize = 0;
        Node temps = head;
        while (temps != null) {
            listSize++;
            temps = temps.next;
        }
        return listSize;
    }

    // Yet again this went quite easily after the previous ones.
    // I have been able to look into this after writing it.
    // It is very similar to the following code :
    // https://www.geeksforgeeks.org/search-an-element-in-a-linked-list-iterative-and-recursive/
    public boolean contain(int searchInt) {
        Node now;
        now = head;
        while (now != null) {
            if (now.data == searchInt) return true;
            now = now.next;
        }
        return false;
    }

    // No inspiration here, from scratch.
    public static boolean compare() {
        Node temp = listOne.head;
        Node temp2 = listTwo.head;
        if (listOne.size() != listTwo.size()) {
            System.out.println(listOne.size() + " & " + listTwo.size());
            return false;
        }
        while (temp.data == temp2.data) {
            if (temp.next != null) {
                temp = temp.next;
                temp2 = temp2.next;
            } else return true;
        }
        return false;
    }

    // Same as Compare.
    public boolean magicCompare() {
        LinkedList tempL1 = new LinkedList();
        Node n1 = listOne.head;

        while (n1 != null) {
            tempL1.add(n1.data);
            n1 = n1.next;
        }
        Node t2 = listTwo.head;
        if (listOne.size() != listTwo.size() || listTwo.size() != listOne.size()) {
            return false;
        }
        while (t2 != null)
            if (tempL1.contain(t2.data)) {
                tempL1.remove(t2.data);
                t2 = t2.next;
                System.out.println("Temp List 1: " + tempL1);
                System.out.println("List 2: " + listTwo );
            }
        return tempL1.size() == 0;
    }
}