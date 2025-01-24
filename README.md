```java
BinarySearch binarySearch = new BinarySearch();
binarySearch.sortPopulation(); // Ensure countries are sorted
Country result = binarySearch.search(2000);

if (result != null) {
    System.out.println("Found country: " + result);
} else {
    System.err.println("Country not found!");
}
