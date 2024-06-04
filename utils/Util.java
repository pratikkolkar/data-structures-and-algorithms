package utils;
import java.util.*;
import java.util.stream.Collectors;

public class Util {
    
    public static void printIntArray(List<?> res){
        System.out.println("[" + (res.stream().map(el -> "" + el).collect(Collectors.joining(","))) + "]");
    }

    public static void print(int result) {
        System.out.println("Result: "+result);
    }
}
