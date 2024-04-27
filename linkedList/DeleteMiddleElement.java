package linkedList;


public class DeleteMiddleElement {
    public static void main(String[] args) {
        LinkedList ll= new LinkedList(6);
        ll = new LinkedList(2, ll);
        // ll = new LinkedList(1, ll);
        // ll = new LinkedList(7, ll);
        // ll = new LinkedList(4, ll);
        // ll = new LinkedList(3, ll);
        // ll = new LinkedList(1, ll);
        
        LinkedList.print(ll);
        
        LinkedList s = ll.next;
        LinkedList f = ll.next.next;
        LinkedList t = s;

        while(f != null && f.next != null){
            t=s;
            s = s.next;
            f = f.next.next;
        }

        System.out.println(t.val);
            if(t.next == null){
                ll.next=null;
            }else{
                t.next=t.next.next;
            }

         LinkedList.print(ll);
    }
}
