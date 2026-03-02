public class TaxRules {
    public static TaxCalculator getTaxCalculator(String customerType) {
        if ("student".equalsIgnoreCase(customerType)) {
            return new StudentTaxCalculator();
        }
        if ("staff".equalsIgnoreCase(customerType)) {
            return new StaffTaxCalculator();
        }
        return new DefaultTaxCalculator();
    }
}
