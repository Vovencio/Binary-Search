package suche2024;

public class Main {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Initialize both searches with 20k countries
        BinarySearch b = new BinarySearch(20_000);
        LinearSearch l = new LinearSearch(20_000);

        // Test both
        b.test();
        l.test();
    }
}
