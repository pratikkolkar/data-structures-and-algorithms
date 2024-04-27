package linkedList;

public class LinkedList {
    int val;
    LinkedList next;

    public LinkedList() {
    }

    public LinkedList(int val) {
        this.val=val;
    }

    public LinkedList(int val, LinkedList next) {
        this.val=val;
        this.next=next;
    }

    
    static public void print(LinkedList ll) {  
        while(ll!=null){
            System.out.print(ll.val+ "->");
            ll = ll.next;
        }
        System.out.println("END");
    }
}
