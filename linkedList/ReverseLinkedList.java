package linkedList;

public class ReverseLinkedList {
    public static void main(String[] args) {
        LinkedList head= new LinkedList(6);
        head = new LinkedList(2, head);
        head = new LinkedList(1, head);
        head = new LinkedList(7, head);
        head = new LinkedList(4, head);
        head = new LinkedList(3, head);
        head = new LinkedList(1, head);

        LinkedList.print(head);

        LinkedList nextNode=null;
        LinkedList tmp=head;
        while(head.next!=null){
            nextNode=head.next;
            head.next=nextNode.next;
            nextNode.next=tmp;
            tmp=nextNode;
        }

        head = nextNode;
        LinkedList.print(head);
    }
}
