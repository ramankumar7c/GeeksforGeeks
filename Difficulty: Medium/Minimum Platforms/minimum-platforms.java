class Solution {
    public int minPlatform(int arr[], int dep[]) {
        //  code here
        Arrays.sort(arr);
        Arrays.sort(dep);
        int arrival=0,departure=0,count=0,max=0;
        while(arrival<arr.length && departure<dep.length){
            if(arr[arrival]<=dep[departure]){
                count++;
                max=Math.max(count,max);
                arrival++;
            }
            else{
                count--;
                departure++;
            }
        }
        return max;
    }
}
