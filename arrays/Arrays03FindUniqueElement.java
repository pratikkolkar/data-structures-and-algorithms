package arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.swing.RowFilter.Entry;

/*
 * i/P ={12, 1, 12, 3, 12, 1, 1, 2, 3, 3}
    O/P=2
 */
public class Arrays03FindUniqueElement {
    public static void main(String[] args) {
        int[] arr = {12, 1, 12, 3, 1, 2, 3};
        // findUniqueElementSream(arr);
        findUniqueElementXor(arr);
        

            //Arraysort
            //

            
    }

    private static void findUniqueElementXor(int[] arr) {
        Integer unqiueValueOption= Arrays.stream(arr)
        .boxed()
        .reduce(0,(acc,val)->acc^val);
        int result=0;
        // // int[] arr1={ 3, 5, 4, 5, 2,3, 4};
        for (int i = 0; i < arr.length; i++) {
            result = result ^ arr[i]; 
            // System.out.println(result);
        }
        // if (unqiueValueOption.isPresent()) {
            System.out.println(unqiueValueOption);
        // }else{
        //     System.out.println(-1);
        // }
    }

    private static void findUniqueElementSream(int[] arr) {
        Optional<java.util.Map.Entry<Integer, Long>> unqiueValueOption=Arrays.stream(arr)
            .boxed()
            .map(i -> i)
            .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
            .entrySet()
            .stream()
            .filter(item -> item.getValue() == 1)
            .findFirst();
            if (unqiueValueOption.isPresent()) {
                System.out.println(unqiueValueOption.get().getKey());
            }else{
                System.out.println(-1);
            }
           
    }
}
