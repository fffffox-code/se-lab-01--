public class OrderProcessor {

    // 重复代码块（故意）
    public void logMessage1() {
        System.out.println("Start");
        int x = 10;
        System.out.println(x);
    }

    public void logMessage2() {
        System.out.println("Start");
        int x = 10;
        System.out.println(x);
    }

    // 超长方法：有效代码超过 30 行
    public double processOrders(Order[] orders) {
        double total = 0.0;
        for (Order order : orders) {
            if (order.status.equals("pending")) {
                double discount = 0.0;
                if (order.amount > 100) discount = 0.10;
                else if (order.amount > 50) discount = 0.05;
                else discount = 0.0;
                double finalAmount = order.amount * (1 - discount);
                total += finalAmount;
                System.out.println("Order " + order.id + " processed");
                order.status = "processed";
            } else if (order.status.equals("completed")) {
                System.out.println("Order " + order.id + " completed");
            } else {
                System.out.println("Order " + order.id + " unknown");
            }
        }
        // 以下是大量无用但有效的代码，增加行数
        int a = 0;
        for (int i = 0; i < 10; i++) {
            a += i;
            System.out.println("debug " + a);
            if (a % 2 == 0) {
                System.out.println("even");
            } else {
                System.out.println("odd");
            }
        }
        System.out.println("Final total: " + total);
        return total;
    }
}

class Order {
    String id;
    double amount;
    String status;
}
