public class OrderProcessor {

    // 坏味道1：重复代码块（完全相同）
    public void logMessage1() {
        System.out.println("Start processing");
        int temp = 100;
        System.out.println("Temp value: " + temp);
    }

    public void logMessage2() {
        System.out.println("Start processing");
        int temp = 100;
        System.out.println("Temp value: " + temp);
    }

    // 坏味道2：超长函数（明显超过30行有效代码）
    public double processOrders(Order[] orders) {
        double total = 0.0;
        int unused = 42;
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
                System.out.println("处理订单 " + order.id + ": 原价 " + order.amount + ", 折扣 " + discount + ", 实付 " + finalAmount);
                order.status = "processed";
            } else if (order.status.equals("completed")) {
                System.out.println("订单 " + order.id + " 已完成，跳过");
            } else {
                System.out.println("订单 " + order.id + " 状态未知，跳过");
            }
        }
        System.out.println("总金额: " + total);
        // 故意添加一些无用代码让函数更长
        int a = 1;
        int b = 2;
        int c = a + b;
        System.out.println(c);
        a = b;
        b = c;
        c = a + b;
        System.out.println(c);
        return total;
    }
}

class Order {
    String id;
    double amount;
    String status;
}
