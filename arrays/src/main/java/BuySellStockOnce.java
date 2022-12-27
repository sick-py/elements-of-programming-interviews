import java.util.List;

public class BuySellStockOnce {

    /**
       6.6
     Specifically, on Page 2 we showed how to compute the maximum profit by computing the difference of the current entry with the minimum value seen so far as we iterate through the array.
    */

    public static int buySellStockOnce(List<Integer> A) {
        int minPrice = Integer.MAX_VALUE, maxProfit = -1;
        for (int price : A) {
            maxProfit = Math.max(maxProfit, price - minPrice);
            minPrice = Math.min(minPrice, price);
        }

        return maxProfit;
    }
}
