public class CinemaShow {

    private String title;
    private int seatsAvailable;
    private final int capacity;
    private static int totalBooked = 0;

    public CinemaShow(String title, int capacity) {
        this.title = title;
        this.capacity = capacity;
        this.seatsAvailable = capacity;
    }

    public CinemaShow(String title) {
        this(title, 100);
    }

    public boolean book(int n) {
        if (n <= seatsAvailable) {
            seatsAvailable -= n;
            totalBooked += n;
            return true;
        }

        return false;
    }

    public void cancel(int n) {
        seatsAvailable += n;

        if (seatsAvailable > capacity)
            seatsAvailable = capacity;
    }

    public int getSeatsAvailable() {
        return seatsAvailable;
    }

    public static int getTotalBooked() {
        return totalBooked;
    }

    public static void main(String[] args) {

        CinemaShow show = new CinemaShow("Avengers", 50);

        System.out.println("Initial seats: " + show.getSeatsAvailable());

        System.out.println("Booking 20 seats: " + show.book(20));
        System.out.println("Seats available: " + show.getSeatsAvailable());

        System.out.println("Booking 40 seats: " + show.book(40));
        System.out.println("Seats available: " + show.getSeatsAvailable());

        System.out.println("Booking 10 seats: " + show.book(10));
        System.out.println("Seats available: " + show.getSeatsAvailable());

        show.cancel(5);
        System.out.println("After cancelling 5 seats:");
        System.out.println("Seats available: " + show.getSeatsAvailable());

        show.cancel(100);
        System.out.println("After cancelling 100 seats:");
        System.out.println("Seats available: " + show.getSeatsAvailable());

        System.out.println("Total booked: " + CinemaShow.getTotalBooked());
    }
}