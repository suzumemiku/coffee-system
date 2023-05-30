package Experiment1;



import java.util.Iterator;

public class XMLSalesFormatter implements SalesFormatter {
   private static XMLSalesFormatter singletonInstance=new XMLSalesFormatter();
   public static XMLSalesFormatter getSingletonInstance(){

       return singletonInstance;
   }
   private XMLSalesFormatter(){

   }

    @Override
    public String formatSales(Sales sales) {
       String str="<Sales>\n";
        Iterator<Order> iterator=sales.iterator();
        while(iterator.hasNext()){
            Order order=iterator.next();
            str=str+ "<Order totle="
                    +"\""
                    +order.getTotalCost()
                    +"\""
                    +">\n";
            Iterator<OrderItem> iterator1=order.iterator();
            while(iterator1.hasNext()){
                OrderItem orderItem=iterator1.next();
                Product product=orderItem.getProduct();
                str=str+"<OrderItem quantity="
                        +"\""
                        +orderItem.getQuantity()
                        +"\""
                        +"\n";
                str=str+"price="
                        +"\""
                        +product.getPrice()
                        +"\">"
                        +product.getCode()
                        +"</OrderItem>\n";

            }
            str=str+"</Order>\n";

        }
        str=str+"</Sales>";
        return str;
    }
}
