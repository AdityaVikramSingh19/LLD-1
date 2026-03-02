import java.util.*;

public class CafeteriaSystem {
    private final Map<String, MenuItem> menu = new LinkedHashMap<>();
    private final InvoiceStorage storage;
    private final InvoiceFormatter formatter;
    private int invoiceSeq = 1000;

    public CafeteriaSystem(InvoiceStorage storage, InvoiceFormatter formatter) {
        this.storage = storage;
        this.formatter = formatter;
    }

    public void addToMenu(MenuItem i) { menu.put(i.id, i); }

    public void checkout(String customerType, List<OrderLine> lines) {
        String invId = "INV-" + (++invoiceSeq);
        
        // Get calculators based on customer type
        TaxCalculator taxCalc = TaxRules.getTaxCalculator(customerType);
        DiscountCalculator discountCalc = DiscountRules.getDiscountCalculator(customerType);
        PricingCalculator pricingCalc = new PricingCalculator(menu);

        // Calculate pricing
        double subtotal = pricingCalc.calculateSubtotal(lines);
        double tax = taxCalc.calculateTax(subtotal);
        double discount = discountCalc.calculateDiscount(subtotal, lines.size());
        double total = subtotal + tax - discount;

        // Build line items for invoice
        List<InvoiceData.LineItemData> lineItems = new ArrayList<>();
        for (OrderLine l : lines) {
            MenuItem item = pricingCalc.getMenuItem(l.itemId);
            double lineTotal = item.price * l.qty;
            lineItems.add(new InvoiceData.LineItemData(item.name, l.qty, lineTotal));
        }

        // Create invoice data
        InvoiceData invoiceData = new InvoiceData(
            invId, lineItems, subtotal, taxCalc.getTaxRate(), tax, discount, total
        );

        // Format and print
        String printable = formatter.format(invoiceData);
        System.out.print(printable);

        // Persist
        storage.save(invId, printable);
        System.out.println("Saved invoice: " + invId + " (lines=" + storage.countLines(invId) + ")");
    }
}
