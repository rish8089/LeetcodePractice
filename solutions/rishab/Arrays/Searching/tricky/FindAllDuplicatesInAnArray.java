//https://leetcode.com/problems/find-all-duplicates-in-an-array/

package solutions.rishab.Arrays.Searching.tricky;

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicatesInAnArray {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> list=new ArrayList<>();
        int n=nums.length;
        for(int i=0;i<n;i++){
            int val=nums[i];
            int old=val%(n+1);
            nums[old-1] += n+1;
        }
        for(int i=0;i<n;i++){
            if(nums[i]/(n+1) == 2)
                list.add(i+1);
        }
        return list;
    }
}
