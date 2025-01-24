/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package suche2024;

/**
 * @param name Attributes
 * @author mag
 */
public record Country(String name, int area, int population, int highestPoint) {

    static final String[] prefixes = {
            "Real ", "North ", "East ", "South ", "West ", "New ",
            "Old ", "Newest ", "Oldest", "Northernmost ",
            "European ", "United "
    };
    static final String[] start = {
            "Germ", "Cook", "Russ", "Eng", "Sigm", "Hat",
            "Ball", "Nut", "Roll", "Trip", "Weed", "High",
            "Vlad", "Andr", "Leo", "Greas",
    };
    static final String[] middleFirst = {"a", "i", "o", "y", "u"};
    static final String[] middleSecond = {"n", "b", "ck", "s", "p", "z", "wr"};
    static final String[] middleThird = {"a", "i", "o", "y", "u"};


    static final String[] end = {
            "ny", "nia", "ria", "burg", "stadt", "holm",
            "ton", "shire", "port", "land", "wick", "grad",
            "stan", "polis", "dell", "vale", "wood", "haven",
            "field", "bridge", "ford", "mere", "hall", "bank",
            "mir", "as"
    };

    static final String[] type = {
            " Kingdom", " Empire", " Federation", " Confederation", " Dominion",
            " Alliance", " Republic", " Coalition", " Confederacy", " State",
            " Territory", " Principality", " Commonwealth", " Province",
            " Confederation", " Realm", " Enclave", " Dominion", " Syndicate"
    };


    /*
    public static void main(String[] args){
        long totalCombinations = prefixes.length* start.length*middleFirst.length* middleSecond.length* middleThird.length*end.length* type.length;
        System.out.println(totalCombinations);
    }
     */

    public static String genName(int id) {
        if (id == 69) return "Foobar";

        // Calculate indexes based on the ID
        int prefixId = id % prefixes.length;
        int startId = (id / prefixes.length) % start.length;
        int middleFirstId = (id / (prefixes.length * start.length)) % middleFirst.length;
        int middleSecondId = (id / (prefixes.length * start.length * middleFirst.length)) % middleSecond.length;
        int middleThirdId = (id / (prefixes.length * start.length * middleFirst.length * middleSecond.length)) % middleThird.length;
        int endId = (id / (prefixes.length * start.length * middleFirst.length * middleSecond.length * middleThird.length)) % end.length;
        int typeId = (id / (prefixes.length * start.length * middleFirst.length * middleSecond.length * middleThird.length * end.length)) % type.length;

        // Construct the name based on the calculated indexes
        return prefixes[prefixId] + start[startId] + middleFirst[middleFirstId] + middleSecond[middleSecondId] + middleThird[middleThirdId] + end[endId] + type[typeId];
    }

    public String toString() {
        return name + ", " + population;
        //return name + ", " + area + ", " + population + ", " + highestPoint;
    }

}
