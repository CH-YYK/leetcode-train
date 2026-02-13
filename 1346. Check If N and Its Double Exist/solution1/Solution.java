import java.util.Arrays;

class Solution {
  public boolean checkIfExist(int[] arr) {
    // sort and binary search
    Arrays.sort(arr);
    for (int i = 0; i < arr.length; ++i) {
      if (binarySearch(arr, 2 * arr[i], i))
        return true;
    }
    return false;
  }
  private boolean binarySearch(int[] arr, int target, int curr) {
    int l = 0, r = arr.length;
    while (l < r) {
      int m = (l + r) / 2;

      // skipping the current
      if (m == curr)
        m--;
      if (arr[m] == target)
        return true;
      else if (arr[m] < target) {
        l = m + 1;
      } else
        r = m;
      // skipping the current
      if (l == curr)
        l++;
      if (r == curr)
        r--;
    }
    return false;
  }
}