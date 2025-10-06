class Solution {
    public boolean[] subsequenceSumAfterCapping(int[] nums, int k) {
        int n =nums.length;

        Arrays.sort(nums);
        boolean[] res = new boolean[n];
        boolean[] sum = new boolean[k+1];
        sum[0] = true;

        int j=0, i=0;
        for (; i<n; i++){
            int x=i+1;
            
            while (j<n && nums[j] < x){

                for (int s=k; s>=nums[j]; s--){
                    if (sum[s-nums[j]]) sum[s] = true;
                }
                j++;
            }

            int leftEls = n-j;
            int bound = Math.min(leftEls, k/x);

            for (int l=0; l<=bound; l++){
                int req = k-l*x;
                if (req >= 0 && sum[req]){
                    res[i] = true;
                    break;
                }
            }

        }

        return res;
    }
}