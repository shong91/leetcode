class Solution {
    public static double myPow(double x, double n) {
       // base case
    if (n == 0 ) {
      return 1;
    }
    if (x == 0) {
      return 0;
    }

    if (n < 0) {
      return myPow(1 / x, Double.valueOf(Math.abs(n)));
    }
    return (n % 2 == 0) ? myPow(x * x, (int) n / 2) : x * myPow(x * x, (int) n / 2);
  }
}