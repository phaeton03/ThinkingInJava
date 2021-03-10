package Generics.P311;

import java.util.*;
public class Ex14 {
    public static void addToTheMiddle(List list, int [] nums){
        for (int i = 0; i < nums.length; i++){
            ListIterator<Integer> lit = list.listIterator(i/2);
            lit.add(nums[i]);
        }
        System.out.println(list);
    }
    public static void main(String[] args) {
        int [] nums = {8,7,3,2,20};
        LinkedList<Integer> list = new LinkedList<>();
        addToTheMiddle(list,nums);
    }
}
