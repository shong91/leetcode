class Solution {
    public int maxProfit(int[] prices) {
       
        int left = 0; 
        int right = prices.length -1; 
         int maxProfit =  0;
        int minPrice = 10000; 
        
        for(int price : prices) {
            minPrice = Math.min(minPrice, price); 
            maxProfit = Math.max(maxProfit, price - minPrice);
            
        }
        
        return maxProfit; 
        
    }
}