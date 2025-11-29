class Solution {
    public int[] productExceptSelf(int[] nums) 
{
        int n = nums.length, mul = 1, z = 0;
        int[] ans = new int[n];
        
        for(int i = 0; i < n; i++) {
            if(nums[i] == 0) {
                z++;
                continue;
            }
            mul *= nums[i];
        }
        
        if(z > 1) return ans;
        
        for(int i = 0; i < n; i++) {
            if(z > 0) {
                ans[i] = (nums[i] == 0 ? mul : 0);
            } else {
                ans[i] = mul / nums[i];
            }
        }
        
        return ans;
    }
}