public class InvoiceFormatter {
    public String format(InvoiceData invoice) {
        StringBuilder out = new StringBuilder();
        out.append("Invoice# ").append(invoice.invoiceId).append("\n");

        for (InvoiceData.LineItemData item : invoice.lineItems) {
            out.append(String.format("- %s x%d = %.2f\n", 
                item.itemName, item.quantity, item.lineTotal));
        }

        out.append(String.format("Subtotal: %.2f\n", invoice.subtotal));
        out.append(String.format("Tax(%.0f%%): %.2f\n", invoice.taxRate, invoice.tax));
        out.append(String.format("Discount: -%.2f\n", invoice.discount));
        out.append(String.format("TOTAL: %.2f\n", invoice.total));

        return out.toString();
    }
}
