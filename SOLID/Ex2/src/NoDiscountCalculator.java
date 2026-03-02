public class NoDiscountCalculator implements DiscountCalculator {
    @Override
    public double calculateDiscount(double subtotal, int distinctLines) {
        return 0.0;
    }
}
