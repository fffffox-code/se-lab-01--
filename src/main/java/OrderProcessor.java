import java.util.logging.Logger;

public class OrderProcessor {

    private static final Logger LOGGER = Logger.getLogger(OrderProcessor.class.getName());

    // 只保留一个日志方法，消除重复
    public void logMessage() {
        LOGGER.info("Start");
        int x = 10;
        LOGGER.info("Value: " + x);
    }

    // 处理订单的主方法，移除 System.out，改用 Logger
    public double processOrders(Order[] orders) {
        double total = 0.0;
        for (Order order : orders) {
            if (order.status.equals("pending")) {
                double discount = 0.0;
                if (order.amount > 100) {
                    discount = 0.10;
                } else if (order.amount > 50) {
                    discount = 0.05;
                } else {
                    discount = 0.0;
                }
                double finalAmount = order.amount * (1 - discount);
                total += finalAmount;
                LOGGER.info("处理订单 " + order.id + ": 原价 " + order.amount
                            + ", 折扣 " + discount + ", 实付 " + finalAmount);
                order.status = "processed";
            } else if (order.status.equals("completed")) {
                LOGGER.info("订单 " + order.id + " 已完成，跳过");
            } else {
                LOGGER.warning("订单 " + order.id + " 状态未知，跳过");
            }
        }
        LOGGER.info("总金额: " + total);
        return total;
    }
}

class Order {
    String id;
    double amount;
    String status;
}
