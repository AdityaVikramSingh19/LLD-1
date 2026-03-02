public class DiscountRules {
    public static DiscountCalculator getDiscountCalculator(String customerType) {
        if ("student".equalsIgnoreCase(customerType)) {
            return new StudentDiscountCalculator();
        }
        if ("staff".equalsIgnoreCase(customerType)) {
            return new StaffDiscountCalculator();
        }
        return new NoDiscountCalculator();
    }
}
