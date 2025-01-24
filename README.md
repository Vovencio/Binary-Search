<img src="https://c.tenor.com/EYUlar2QIe4AAAAd/tenor.gif" 
     alt="Search Speed GIF" 
     style="width: 30%; float: left; margin-right: 20px;">

<h1>Suche2024: Country Search Algorithms in Java</h1>
<p>
  Suche2024 is a simple Java project demonstrating binary and linear search algorithms on a dataset of randomly generated "countries." Each country has attributes like name, area, population, and highest point.
</p>



## Features

- **Binary Search**:
  - Efficiently finds countries by population in a sorted dataset.
  - Includes a custom, inefficient sort function for demonstration.
  
- **Linear Search**:
  - Finds countries by name or minimum area.
  - Direct and intuitive approach.

- **Country Generator**:
  - Dynamically generates unique country names using predefined components.

## Project Structure

- **`BinarySearch`**: Implements binary search for fast population-based lookup. Includes a `test` method to validate accuracy and measure performance.
- **`LinearSearch`**: Implements linear search to find countries by name or area. Also includes a `test` method for validation.
- **`Country`**: A record class representing a country with attributes like name, area, population, and highest point.
- **`Main`**: Example main class.

## Usage

Run the `main` method to test and benchmark both search implementations.

### Example Code

```java
public static void main(String[] args) {
    // Initialize both searches with 20k countries
    BinarySearch b = new BinarySearch(20_000);
    LinearSearch l = new LinearSearch(20_000);

    // Test both
    b.test();
    l.test();
}
```
