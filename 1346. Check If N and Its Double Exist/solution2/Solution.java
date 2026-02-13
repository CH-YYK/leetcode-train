import java.util.Arrays;
import java.util.Set;

class Solution {
  public boolean checkIfExist(int[] arr) {
    // HashSet
    Set<Integer> set = new HashSet<>();
    for (int a : arr) {
      if (set.contains(a * 2))
        return true;
      if (a % 2 == 0 && set.contains(a / 2))
        return true;
      set.add(a);
    }
    return false;
  }
}