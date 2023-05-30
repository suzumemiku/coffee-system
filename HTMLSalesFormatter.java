package Experiment1;

import java.util.Iterator;

public class HTMLSalesFormatter implements SalesFormatter {
    private static HTMLSalesFormatter singletonInstance = new HTMLSalesFormatter();

    private HTMLSalesFormatter() {
    }

    public static HTMLSalesFormatter getSingletonInstance() {

        return singletonInstance;
    }
    @Override
    public String formatSales(Sales sales) {
        String str = "<html>\n"
                     + "<body>\n"
                     + "<center><h2>Orders</h2></center>\n";
        Iterator<Order> iterator = sales.iterator();
        while (iterator.hasNext()) {
            Order order = iterator.next();
            str =str+"<hr>\n"
                    + "<h4>"
                    + "Totle="
                    + order.getTotalCost()
                    + "</h4>\n";
            Iterator<OrderItem> iterator1 = order.iterator();
            while (iterator1.hasNext()) {
                OrderItem orderItem = iterator1.next();
                Product product = orderItem.getProduct();
                str = str + "<p>\n"
                        + "<b>code:</b>"
                        + product.getCode()
                        + "<br>\n"
                        +"<b>quantity:</b>"
                        + orderItem.getQuantity()
                        + "<br>\n"
                        +"<b>price:</b>"
                        + product.getPrice()
                        + "\n"
                        +"</p>\n";
            }
        }
        str =str+"</body>\n"
                + "</html>";
        return str;
    }
}
