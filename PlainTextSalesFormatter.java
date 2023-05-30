package Experiment1;


import java.util.Iterator;

public class PlainTextSalesFormatter implements SalesFormatter {
    private static PlainTextSalesFormatter singletonInstance = new PlainTextSalesFormatter();

    private PlainTextSalesFormatter() {
    }

    public static PlainTextSalesFormatter getSingletonInstance() {return singletonInstance;
    }

    @Override
    public String formatSales(Sales sales) {
        Iterator<Order> iterator = sales.iterator();
        int i = 1;
        String str = "------------------------\n";
        while (iterator.hasNext()) {
            str = str + "--------Order " + i + "--------\n";
            Order order = iterator.next();
            Iterator<OrderItem> iterator1 = order.iterator();
            while (iterator1.hasNext()) {
                OrderItem orderItem = iterator1.next();
                Product product = orderItem.getProduct();
                str = str + orderItem.getQuantity() + " " + product.getCode() + " " + product.getPrice() + "\n";
            }
            i++;
            str = str + "Totole=" + order.getTotalCost() + "\n";
        }
        return str;
    }
}
