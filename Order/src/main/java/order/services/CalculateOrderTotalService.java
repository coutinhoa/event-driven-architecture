package order.services;

public class CalculateOrderTotalService {
    static double calculate(double price, int quantity){
        return price * quantity;
    }
}
