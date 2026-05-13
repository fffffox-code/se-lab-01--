public class OrderProcessor {

    /**
     * 处理订单金额，返回折扣后的价格
     * @param amount 原价（正数）
     * @param isVIP 是否VIP会员
     * @return 折扣后的价格
     */
    public double process(double amount, boolean isVIP) {
        if (amount < 0) {
            throw new IllegalArgumentException("金额不能为负数");
        }
        double discount = isVIP ? 0.8 : 1.0;
        return amount * discount;
    }

    /**
     * 验证订单状态
     * @param status 状态字符串
     * @return 是否有效
     */
    public boolean isValidStatus(String status) {
        return "PAID".equals(status) || "SHIPPED".equals(status) || "DELIVERED".equals(status);
    }

    /**
     * 计算订单总价（带税费）
     * @param items 商品价格数组
     * @param taxRate 税率（如0.1表示10%）
     * @return 总价
     */
    public double calculateTotal(double[] items, double taxRate) {
        if (items == null || items.length == 0) {
            return 0;
        }
        double subtotal = 0;
        for (double price : items) {
            if (price < 0) throw new IllegalArgumentException("商品价格不能为负数");
            subtotal += price;
        }
        return subtotal * (1 + taxRate);
    }
}
