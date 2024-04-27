package arrays;


public class Arrays02ReverseSentence {
    public static void main(String[] args) {
        String s = "a good   example";
        String[] arr=s.split(" ");
        StringBuilder sb=new StringBuilder();
        for(int i = arr.length-1; i>=0; i--){
            if(arr[i] != "")
                System.out.println(arr[i]);
            sb.append(arr[i].strip()).append(" ");
        }
        sb.toString().trim();

    }
}
