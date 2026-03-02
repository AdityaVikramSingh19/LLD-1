import java.util.*;

public class PricingComponentFactory {
    private static final Map<Integer, PricingComponent> ROOM_PRICING = new HashMap<>();
    private static final Map<AddOn, PricingComponent> ADDON_PRICING = new HashMap<>();

    static {
        ROOM_PRICING.put(LegacyRoomTypes.SINGLE, new SingleRoomPricing());
        ROOM_PRICING.put(LegacyRoomTypes.DOUBLE, new DoubleRoomPricing());
        ROOM_PRICING.put(LegacyRoomTypes.TRIPLE, new TripleRoomPricing());
        ROOM_PRICING.put(LegacyRoomTypes.DELUXE, new DeluxeRoomPricing());

        ADDON_PRICING.put(AddOn.MESS, new MessAddOnPricing());
        ADDON_PRICING.put(AddOn.LAUNDRY, new LaundryAddOnPricing());
        ADDON_PRICING.put(AddOn.GYM, new GymAddOnPricing());
    }

    public static PricingComponent getRoomPricing(int roomType) {
        return ROOM_PRICING.getOrDefault(roomType, new DeluxeRoomPricing());
    }

    public static PricingComponent getAddOnPricing(AddOn addOn) {
        return ADDON_PRICING.get(addOn);
    }
}
