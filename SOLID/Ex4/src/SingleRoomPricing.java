public class SingleRoomPricing implements PricingComponent {
    @Override
    public Money getMonthlyFee() {
        return new Money(14000.0);
    }

    @Override
    public Money getDeposit() {
        return new Money(5000.0);
    }
}
