package suche2024;

import javax.sound.sampled.Line;
import java.util.Objects;

/**
 *
 * @author mag
 */
public class LinearSearch {

    // Attributes
    private final Country[] countries;

    // Constructor
    public LinearSearch(int amount) {
        countries = new Country[amount];

        for (int i = 0; i < countries.length; i++){
            countries[i] = new Country(Country.genName(i), i*2, i, (int) (Math.sin(i)*i));
        }

        /*
        countries = new Country[6];
        countries[0] = new Country("Germany", 357112, 81859000, 2962); // Zugspitze
        countries[1] = new Country("Russia", 17098242, 144500000, 5642); // Mount Elbrus
        countries[2] = new Country("China", 9596961, 1411778724, 8849); // Mount Everest
        countries[3] = new Country("Ukraine", 603628, 41460000, 2061); // Hoverla
        countries[4] = new Country("Italy", 301340, 60317116, 4810); // Mont Blanc (shared w/ France)
        countries[5] = new Country("Spain", 505990, 47350000, 3715); // Teide (Canary Islands)
         */
    }

    public Country search(String name) {
        for (Country country : countries){
            if (Objects.equals(country.name(), name)) return country;
        }
        System.err.printf("Country %s not found!", name);
        return null;
    }

    public int searchIndex(String name) {
        for (int i = 0; i < countries.length; i++){
            if (Objects.equals(countries[i].name(), name)) return i;
        }
        System.err.printf("Country %s not found!", name);
        return 0;
    }

    public Country searchMinArea() {
        int min = Integer.MAX_VALUE;
        Country minCountry = countries[0];

        for (Country country : countries){
            if (country.area() < min) {
                min = country.area();
                minCountry = country;
            }
        }
        return minCountry;
    }

    public int searchMinAreaIndex() {
        int min = Integer.MAX_VALUE;
        int minId = 0;

        for (int i = 0; i < countries.length; i++){
            if (countries[i].area() < min) {
                min = countries[i].area();
                minId = i;
            }
        }
        return minId;
    }

    void test() {
        long startTime = System.nanoTime();
        for (Country country : countries){
            Country found = search(country.name());

            if (!Objects.equals(found, country)){
                System.err.printf("Failed test: Expected %s, but gotten %s %n", country.toString(), found.toString());
                return;
            }
        }

        long endTime = System.nanoTime();
        long ellapsedTime = endTime - startTime;
        long averageTime = ellapsedTime / countries.length;

        System.out.printf("All tests passed!%n  Processing Time: %s nanoseconds." +
                "%n  Average Time Per Search: %s nanoseconds.%n", formatTime(ellapsedTime), formatTime(averageTime));
    }

    private static String formatTime(long number) {
        StringBuilder result = new StringBuilder();
        String numberString = Long.toString(number);
        int length = numberString.length();

        // Insert commas every 3 digits starting from the end
        for (int i = 0; i < length; i++) {
            if (i > 0 && (length - i) % 3 == 0) {
                result.append(',');
            }
            result.append(numberString.charAt(i));
        }

        return result.toString();
    }
}
