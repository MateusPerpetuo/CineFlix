import cineflix.calculations.FilterRecommendation;
import cineflix.calculations.TimeCalculator;
import cineflix.models.Movie;
import cineflix.models.Serie;

public class Main {
    public static void main(String[] args) {

        Movie avangers = new Movie();
        avangers.setName("Avenger");
        avangers.setYear(2023);
        avangers.setDurationInMinutes(120);

        avangers.showCredits();

        Serie lost = new Serie();
        lost.setName("Lost");
        lost.setYear(2000);
        lost.setSeasons(10);
        lost.setEpisodeDuration(50);
        lost.setEpisodesPerSeason(10);
        System.out.println("Para maratonar Lost: " + lost.getDurationInMinutes());

        TimeCalculator calculator = new TimeCalculator();
        calculator.addTime(avangers);
        calculator.addTime(lost);

        System.out.println(calculator.getTotalTime());

        FilterRecommendation filter = new FilterRecommendation();
        filter.filter(avangers);

        Episode episode = new Episode


    }
}
