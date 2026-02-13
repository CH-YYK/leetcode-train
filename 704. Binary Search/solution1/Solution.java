class Solution {
  public int search(int[] nums, int target) {
    // find the nums[k] where nums[k] == target, else -1.
    // We can decompose the step, 1. find nums[k] >= targe, 2. check if nums[k]
    // == target.
    int l = 0, r = nums.length;
    while (l < r) {
      int m = (l + r) / 2;
      if (nums[m] == target)
        return m;
      else if (nums[m] < target)
        l = m + 1;
      else
        r = m;
    }
    return -1;
  }
}