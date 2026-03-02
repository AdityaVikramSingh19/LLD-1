import java.util.*;

public class InvoiceData {
    public final String invoiceId;
    public final List<LineItemData> lineItems;
    public final double subtotal;
    public final double taxRate;
    public final double tax;
    public final double discount;
    public final double total;

    public InvoiceData(String invoiceId, List<LineItemData> lineItems, 
                       double subtotal, double taxRate, double tax, 
                       double discount, double total) {
        this.invoiceId = invoiceId;
        this.lineItems = lineItems;
        this.subtotal = subtotal;
        this.taxRate = taxRate;
        this.tax = tax;
        this.discount = discount;
        this.total = total;
    }

    public static class LineItemData {
        public final String itemName;
        public final int quantity;
        public final double lineTotal;

        public LineItemData(String itemName, int quantity, double lineTotal) {
            this.itemName = itemName;
            this.quantity = quantity;
            this.lineTotal = lineTotal;
        }
    }
}
