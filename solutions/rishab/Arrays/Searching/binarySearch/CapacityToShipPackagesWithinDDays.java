//https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/
package solutions.rishab.Arrays.Searching.binarySearch;
public class CapacityToShipPackagesWithinDDays {
    public int shipWithinDays(int[] weights, int days) {
        int maxWeight=0;
        int sumOfWeights=0;
        for(int i=0;i<weights.length;i++)
            maxWeight=Math.max(maxWeight,weights[i]);
        for(int i=0;i<weights.length;i++)
            sumOfWeights += weights[i];
        int u=maxWeight;
        int v=sumOfWeights;
        int ans=sumOfWeights;
        while(u<=v){
            int mid=u+(v-u)/2;
            if(check(weights,days,mid)){
                ans=mid;
                v=mid-1;
            }else{
                u=mid+1;
            }
        }
        return ans;
    }
    private boolean check(int[] weights, int days, int capacity){
        int i=0;
        int n=weights.length;
        while(i<n && days>0){
            int sum=weights[i];
            while(i+1<n && sum+weights[i+1]<=capacity){
                sum += weights[i+1];
                i++;
            }
            i++;
            days--;
        }
        return i>=n;
    }
}
