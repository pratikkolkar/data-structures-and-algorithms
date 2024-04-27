package linkedList;

public class OddEvenLinkedList {
    public static void main(String[] args) {
        LinkedList ll= new LinkedList(6);
        ll = new LinkedList(2, ll);
        ll = new LinkedList(1, ll);
        ll = new LinkedList(7, ll);
        ll = new LinkedList(4, ll);
        ll = new LinkedList(3, ll);
        ll = new LinkedList(1, ll);
        
        LinkedList.print(ll);


        LinkedList odd = ll;
        LinkedList even = ll.next;
        LinkedList evenHead = ll.next;

        while(even !=null && even.next != null){
            odd.next=odd.next.next;
            odd = odd.next;
            even.next = even.next.next;
            even= even.next;
        }

        odd.next=evenHead;

        LinkedList.print(ll);

    }
}
