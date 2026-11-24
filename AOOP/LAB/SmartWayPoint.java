import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.regex.Pattern;
enum SpotType {
    COMPACT, REGULAR, LARGE, EV
}
enum VehicleType {
    BIKE, CAR, SUV, EV_CAR;
    boolean fits(SpotType s) {
        return switch (this) {
            case BIKE -> true;
            case CAR -> s == SpotType.REGULAR || s == SpotType.LARGE;
            case SUV -> s == SpotType.LARGE;
            case EV_CAR -> s == SpotType.EV || s == SpotType.REGULAR || s == SpotType.LARGE;
        };
    }
}
enum BookingStatus {
    RESERVED, ACTIVE, COMPLETED, CANCELLED
}
final class Spot {
    private static final Pattern ID = Pattern.compile("^L([0-9])-[A-Z][0-9]{2}$");
    private final String id;
    private final int level;
    private final SpotType type;
    Spot(String id, SpotType type) {
        Objects.requireNonNull(id, "spot id");
        var m = ID.matcher(id);
        if (!m.matches())
            throw new IllegalArgumentException("S1 violated: Bad Spot id " + id);
        this.id = id;
        this.level = Integer.parseInt(m.group(1));
        this.type = Objects.requireNonNull(type, "Spot Type");
    }
    String id() {
        return id;
    }
    int level() {
        return level;
    }
    SpotType type() {
        return type;
    }
    @Override
    public boolean equals(Object o) {
        return o instanceof Spot s && s.id.equals(id);
    }
    @Override
    public int hashCode() {
        return id.hashCode();
    }
    @Override
    public String toString() {
        return id + "(" + type + ")";
    }
}
final class Vehicle {
    private static final Pattern PLATE = Pattern.compile("^[A-Z]{2}[0-9]{2}[A-Z]{1,2}[0-9]{4}$");
    private final String plate;
    private final VehicleType type;
    Vehicle(String rawPlate, VehicleType type) {
        Objects.requireNonNull(rawPlate, "plate");
        String p = rawPlate.replaceAll("[\\s-]", "").toUpperCase();
        if (!PLATE.matcher(p).matches())
            throw new IllegalArgumentException("S3 violated: Bad plate " + rawPlate);
        this.plate = p;
        this.type = Objects.requireNonNull(type, "vehicle type");
    }
    String plate() {
        return plate;
    }
    VehicleType type() {
        return type;
    }
    @Override
    public String toString() {
        return plate + "(" + type + ")";
    }
}
record TimeSlot(LocalDateTime start, LocalDateTime end) {
    TimeSlot {
        Objects.requireNonNull(start, "start");
        Objects.requireNonNull(end, "end");
        if (!start.isBefore(end))
            throw new IllegalArgumentException("S4 violated: Start must be before end");
        Duration d = Duration.between(start, end);
        if (d.toMinutes() < 15 || d.compareTo(Duration.ofHours(24)) > 0)
            throw new IllegalArgumentException("S4 violated: Duration " + d);
        if (start.getMinute() % 15 != 0 || end.getMinute() % 15 != 0 || start.getSecond() != 0 || end.getSecond() != 0)
            throw new IllegalArgumentException("S4 violated: Slot must align to 15 minutes");
    }
    long minutes() {
        return Duration.between(start, end).toMinutes();
    }
    boolean overlaps(TimeSlot o) {
        return start.isBefore(o.end) && o.start.isBefore(end);
    }
}
final class Booking {
    private static int seq = 0;
    private final String id;
    private final Spot spot;
    private final Vehicle vehicle;
    private final TimeSlot slot;
    private BookingStatus status;
    private LocalDateTime checkedInAt;
    Booking(Spot spot, Vehicle vehicle, TimeSlot slot) {
        this.id = "BK-" + (++seq);
        this.spot = Objects.requireNonNull(spot);
        this.vehicle = Objects.requireNonNull(vehicle);
        this.slot = Objects.requireNonNull(slot);
        this.status = BookingStatus.RESERVED;
        checkInvariants();
    }
    void checkIn(LocalDateTime at) {
        requireStatus(BookingStatus.RESERVED, "check in");
        status = BookingStatus.ACTIVE;
        checkedInAt = at;
        checkInvariants();
    }
    void complete() {
        requireStatus(BookingStatus.ACTIVE, "complete");
        status = BookingStatus.COMPLETED;
        checkInvariants();
    }
    void cancel() {
        requireStatus(BookingStatus.RESERVED, "cancel");
        status = BookingStatus.CANCELLED;
        checkInvariants();
    }
    private void requireStatus(BookingStatus expected, String action) {
        if (status != expected)
            throw new IllegalStateException("S6/S7 violated: cannot " + action + " when booking is " + status);
    }
    private void checkInvariants() {
        if (!vehicle.type().fits(spot.type()))
            throw new IllegalStateException("S5 violated: " + vehicle + " does not fit " + spot);
        boolean shouldHaveCheckIn = status == BookingStatus.ACTIVE || status == BookingStatus.COMPLETED;
        if (shouldHaveCheckIn != (checkedInAt != null))
            throw new IllegalStateException("S8 violated: Check-in time does not match status " + status);
    }
    BookingStatus status() {
        return status;
    }
    @Override
    public String toString() {
        return id + "[" + vehicle + "@" + spot + "," + slot.minutes() + "min," + status + "]";
    }
}
public class SmartWayPoint {
    public static void main(String[] args) {
        System.out.println("Name: Kandhula Poojasri Reddy");
        System.out.println("Registered Number: 2510030093");
        LocalDateTime t = LocalDateTime.of(2026, 11, 17, 10, 0);
        Spot a07 = new Spot("L1-A07", SpotType.REGULAR);
        Vehicle car = new Vehicle("ts 09 ab 1234", VehicleType.CAR);
        Booking b = new Booking(a07, car, new TimeSlot(t, t.plusHours(2)));
        System.out.println("Created: " + b);
        b.checkIn(t.plusMinutes(5));
        System.out.println("Checked in: " + b);
        b.complete();
        System.out.println("Completed: " + b);
        System.out.println("\n--- Invariant violations (each must be rejected) ---");
    }
}