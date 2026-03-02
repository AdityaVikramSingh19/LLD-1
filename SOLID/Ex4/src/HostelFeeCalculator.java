import java.util.*;

public class HostelFeeCalculator {
    private final FakeBookingRepo repo;

    public HostelFeeCalculator(FakeBookingRepo repo) { this.repo = repo; }

    // Refactored: Uses pricing components instead of switch-case
    public void process(BookingRequest req) {
        List<PricingComponent> components = getPricingComponents(req);
        Money monthly = calculateTotal(components, PricingComponent::getMonthlyFee);
        Money deposit = calculateTotal(components, PricingComponent::getDeposit);

        ReceiptPrinter.print(req, monthly, deposit);

        String bookingId = "H-" + (7000 + new Random(1).nextInt(1000)); // deterministic-ish
        repo.save(bookingId, req, monthly, deposit);
    }

    private List<PricingComponent> getPricingComponents(BookingRequest req) {
        List<PricingComponent> components = new ArrayList<>();
        
        // Add room pricing
        components.add(PricingComponentFactory.getRoomPricing(req.roomType));
        
        // Add add-on pricing
        for (AddOn addOn : req.addOns) {
            PricingComponent addOnPricing = PricingComponentFactory.getAddOnPricing(addOn);
            if (addOnPricing != null) {
                components.add(addOnPricing);
            }
        }
        
        return components;
    }

    private Money calculateTotal(List<PricingComponent> components, java.util.function.Function<PricingComponent, Money> extractor) {
        Money total = new Money(0.0);
        for (PricingComponent component : components) {
            total = total.plus(extractor.apply(component));
        }
        return total;
    }
}
