/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package suche2024;

import java.util.Arrays;
import java.util.Objects;

/**
 *
 * @author mag
 */
public class BinarySearch {

    // Attributes
    private Country[] countries;

    public Country[] getCountries() {
        return countries;
    }

    public void setCountries(Country[] countries) {
        this.countries = countries;
    }

    // Constructor
    public BinarySearch() {
        countries = new Country[20000];

        for (int i = 0; i < countries.length; i++){
            countries[i] = new Country(Country.genName(i), i*2, i, (int) (Math.sin(i)*i));
        }
    }

    // Dumb sorting XD
    public void sortPopulation(){
        boolean[] used = new boolean[countries.length];
        Country[] newCountries = new Country[countries.length];

        for (int i = 0; i < countries.length; i++){
            int min = Integer.MAX_VALUE;
            int minId = 0;

            for (int j = 0; j < countries.length; j++){
                if (!used[j] && countries[j].population() < min){
                    min = countries[j].population();
                    minId = j;
                }
            }

            used[minId] = true;
            newCountries[i] = countries[minId];
        }

        countries = newCountries;
    }

    public Country search(int searchedPopulation) {
        int upperBoundary = countries.length;
        int lowerBoundary = 0;

        int maxIterations = (int) Math.ceil(Math.log10(countries.length)/Math.log10(2)+1);

        for (int i = 0; i < maxIterations; i++){
            int x = (upperBoundary + lowerBoundary) / 2;
            int val = countries[x].population();

            if (val > searchedPopulation) upperBoundary = x;
            else if (val < searchedPopulation) lowerBoundary = x;
            if (val == searchedPopulation) return countries[x];
        }

        System.err.printf("Did not find a country with the population %d \n", searchedPopulation);
        return null;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Testing:
        BinarySearch s = new BinarySearch();

        s.test();

        // System.out.println(s.search(1999));
        //s.sortPopulation();
        //System.out.println(Arrays.toString(s.countries));


    }

    void test() {
        long startTime = System.nanoTime();
        for (Country country : countries){
            Country found = search(country.population());

            if (!Objects.equals(found, country)){
                System.err.printf("Failed test: Expected %s, but gotten %s", country.toString(), found.toString());
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
