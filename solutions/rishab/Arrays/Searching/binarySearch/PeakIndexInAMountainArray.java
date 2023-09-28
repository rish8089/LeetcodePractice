package solutions.rishab.Arrays.Searching.binarySearch;

public class PeakIndexInAMountainArray {
    public int peakIndexInMountainArray(int[] arr) {
        int u=0;
        int v=arr.length-1;
        while(u<=v){
            int mid=u+(v-u)/2;
            int left=mid-1>=0?arr[mid-1]:Integer.MIN_VALUE;
            int right=mid+1<arr.length?arr[mid+1]:Integer.MIN_VALUE;
            if(arr[mid]>left && arr[mid]>right){
                return mid;
            }else if(arr[mid]>left && arr[mid]<right)
                u=mid+1;
            else
                v=mid-1;
        }
        return -1;
    }
}
