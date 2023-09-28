//https://leetcode.com/problems/find-positive-integer-solution-for-a-given-equation/
package solutions.rishab.Arrays.Searching.binarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindPositiveIntegerSolutionForAGivenEquation {
    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        List<List<Integer>> ans=new ArrayList<>();
        for(int i=1;i<=1000;i++){
            int j=binarySearch(customfunction,z,i);
            if(j!=-1)
                ans.add(Arrays.asList(i,j));
        }
        return ans;
    }

    private int binarySearch(CustomFunction customfunction, int z, int x){
        int u=1;
        int v=1000;
        while(u<=v){
            int mid=u+(v-u)/2;
            int val=customfunction.f(x,mid);
            if(val==z){
                return mid;
            }else if(val>z)
                v=mid-1;
            else
                u=mid+1;
        }
        return -1;
    }
    interface CustomFunction {
        public int f(int x, int y);
    };
}
