package jiedian3;

import java.util.ArrayList;
import java.util.List;

public class FANGAN_Calculator {
    public static void main(String[] args) {

    }
    public int[] createTargetArray(int[] nums, int[] index) {
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            list.add(index[i],nums[i]);
        }
        return list.stream().mapToInt(Integer::valueOf).toArray();
    }
}
