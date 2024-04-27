package arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Arrays04RateLimitter {


    public static void main(String[] args) {

        //[ok,ok,ok, blocked,ok,ok,ok, blocked,ok, ok, ok, blocked]
        String[] arr = {"http://google.com","http://google.com","http://yahoo.com","http://google.com","http://google.com","http://google.com","http://facebook.com","http://facebook.com","http://insta.com","http://insta.com","http://facebook.com","http://insta.com"};

        Map<String,Integer> map = new HashMap<>();
        int left = 0;
        String[] result = new String[arr.length];
        for(int right=0; right<arr.length; right++){
            String site = arr[right];
            if(!map.containsKey(site)){
                map.put(site,1);
                result[right]="ok";
            }
            else if(map.containsKey(site) && map.get(site)<2){
                map.put(site,map.get(site)+1);
                result[right]="ok";
            }else{
                map.put(site,map.get(site)+1);
                result[right] ="blocked";
            }
            if(right-left+1==4){
                map.put(arr[left],map.get(arr[left])-1);
                left++;
            }

        }

        Arrays.stream(result)
            .forEach(i-> System.out.println(i));

    }
}
