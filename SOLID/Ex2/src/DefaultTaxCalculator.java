public class DefaultTaxCalculator implements TaxCalculator {
    @Override
    public double calculateTax(double subtotal) {
        return subtotal * (getTaxRate() / 100.0);
    }

    @Override
    public double getTaxRate() {
        return 8.0;
    }
}
