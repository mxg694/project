package 简单;

/**
 *  给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 *
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 * 示例 1:
 *
 * 输入: [7,1,5,3,6,4]
 * 输出: 7
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 *      随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
 *
 * 示例 2:
 *
 * 输入: [1,2,3,4,5]
 * 输出: 4
 * 解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 *      注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
 *      因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
 *
 * 示例 3:
 *
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 */
public class 买卖股票的最佳时机II {

    public static void main(String[] args) {
        int[] price = {1,3,5,2,4};

        System.out.println("买卖股票的最佳时机II：" + maxProfit(price));
    }

    /**
     * 具体思路为设置prev为prices【0】 之后从i从1到length-1，now为对应数字，
     * 如果now比prev大，就直接加上now-prev（将天与天所有的利润都得到），
     * 否则就不加，然后重置prev
     * 我们可以简单地继续在斜坡上爬升并持续增加从连续交易中获得的利润，
     * 而不是在谷之后寻找每个峰值。最后，我们将有效地使用峰值和谷值，
     * 但我们不需要跟踪峰值和谷值对应的成本以及最大利润，
     * 但我们可以直接继续增加加数组的连续数字之间的差值，
     * 如果第二个数字大于第一个数字，我们获得的总和将是最大利润。
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        int sum = 0;

        if (prices !=null && prices.length >1) {
           int prev = prices[0];
            for (int i =1; i< prices.length; i++) {
                int now = prices[i];
                if (now > prev) {
                    sum += now -prev;
                }
                prev = now;
            }
        }

        return sum;
    }

}
