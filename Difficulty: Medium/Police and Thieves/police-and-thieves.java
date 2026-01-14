class Solution {
    public int catchThieves(char[] arr, int k) {
        // code here
        List<Integer>pIndices=new ArrayList<>();
        List<Integer>tIndices=new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            if(arr[i]=='P')
                pIndices.add(i+1);
            else
                tIndices.add(i+1);
        }
        int i=0,j=0;
        int count=0;
        while(i < pIndices.size() && j < tIndices.size()){
            if(Math.abs(pIndices.get(i)-tIndices.get(j))<=k){
                count++;
                i++;
                j++;
            }
            else if(tIndices.get(j)<pIndices.get(i))
                j++;
            else
                i++;
        }
        return count;
    }
}