package linkedList;

public class MaxTwinSum {
    public static void main(String[] args) {
        LinkedList head= new LinkedList(6);
        head = new LinkedList(2, head);
        head = new LinkedList(1, head);
        head = new LinkedList(7, head);
        head = new LinkedList(4, head);
        head = new LinkedList(3, head);
        
        LinkedList.print(head);

        LinkedList slow=head.next;
        LinkedList fast= head.next.next;

        while(fast !=null && fast.next !=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        System.out.println(slow.val);

        LinkedList nextNode=null;
        slow=slow.next;
        LinkedList tmp=slow;
        
        while(slow.next!=null){
            nextNode=slow.next;
            slow.next=nextNode.next;
            nextNode.next=tmp;
            tmp=nextNode;
        }
        LinkedList.print(tmp);
        int max = Integer.MIN_VALUE;
        while(tmp.next !=null){
            max=Math.max(head.val + tmp.val,max);
            head=head.next;
            tmp = tmp.next;
        }

        System.out.println(max);
    }
}
