class Solution {
    public int getSum(int a, int b) {
        while(b != 0) {
            // 둘 다 1이어서 자릿수가 올라갈 경우, AND 연산 후 left shift 
            int temp = (a & b) << 1; 
            // 둘 중 하나만 1인 경우 1 (XOR)
            a = a ^ b; 
            b = temp; 
        }
        return a; 
    }
}