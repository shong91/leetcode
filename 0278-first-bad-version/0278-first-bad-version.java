/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int left = 0; 
        
        while(left <= n) {
            // TO avoid overflow, use below calculation instead of (n+left)/2
            int newN = left + (n - left) /2;   
            if(isBadVersion(newN)) {
                n = newN-1;
            } else {
                left = newN+1;
            }
        }
        return left;
    }
}
