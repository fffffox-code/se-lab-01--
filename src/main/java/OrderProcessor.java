public class OrderProcessor {

    // 坏味道1：重复代码块
    public double calcRectangleArea(double length, double width) {
        double area = length * width;
        System.out.println("矩形面积为: " + area);
        return area;
    }

    public double calcSquareArea(double side) {
        double area = side * side;
        System.out.println("正方形面积为: " + area);
        return area;
    }

    // 坏味道2：过长函数（超过20行）+ 未使用变量
    public double processOrders(Order[] orders) {
        double total = 0.0;
        int unused = 42;    // 未使用变量
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
                System.out.println("处理订单 " + order.id +
                        ": 原价 " + order.amount +
                        ", 折扣 " + discount +
                        ", 实付 " + finalAmount);
                order.status = "processed";
            } else if (order.status.equals("completed")) {
                System.out.println("订单 " + order.id + " 已完成，跳过");
            } else {
                System.out.println("订单 " + order.id + " 状态未知，跳过");
            }
        }
        System.out.println("总金额: " + total);
        return total;
    }
}

class Order {
    String id;
    double amount;
    String status;
}
