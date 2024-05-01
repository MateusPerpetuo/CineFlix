package cineflix.calculations;

public class FilterRecommendation {

    public void filter (Classifiable classifiable ) {

        if (classifiable.getClassification() >= 4) {
            System.out.println("It's the top picks of the moment!");
        } else if (classifiable.getClassification() >= 2) {
            System.out.println("Well-rated at the moment");
        } else {
            System.out.println("Add it to the watch latter list");
        }
    }
}
