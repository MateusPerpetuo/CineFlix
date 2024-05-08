package cineflix.models;

import cineflix.calculations.Classifiable;

/*** Class model for the tv series
 * @author Mateus Perpétuo
 * @version 1.0
 */
public class Serie extends Title implements Classifiable {
    private int seasons;
    private boolean finished;
    private int episodesPerSeason;
    private int episodeDuration;
    private int totalEpisodes;
    private int totalViews;

    // Constructor

    public Serie(String name, String year, int seasons) {
        super(name, year);
        this.seasons = seasons;
    }


    public Serie(SerieOmdb serieOmdb) {
        super(serieOmdb.title(), serieOmdb.year());
        this.episodeDuration = Integer.valueOf(serieOmdb.runtime().substring(0,2));
        this.seasons = Integer.valueOf(serieOmdb.totalSeasons());
        this.finished = serieOmdb.response();
        this.episodeDuration = Integer.valueOf(serieOmdb.runtime().substring(0,2));

    }


    // Getters and setters

    public int getSeasons() {
        return seasons;
    }

    public void setSeasons(int seasons) {
        this.seasons = seasons;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    public int getEpisodesPerSeason() {
        return episodesPerSeason;
    }

    public void setEpisodesPerSeason(int episodesPerSeason) {
        this.episodesPerSeason = episodesPerSeason;
    }

    public int getEpisodeDuration() {
        return episodeDuration;
    }

    public void setEpisodeDuration(int episodeDuration) {
        this.episodeDuration = episodeDuration;
    }

    public int getTotalEpisodes() {
        totalEpisodes = getEpisodesPerSeason() * getSeasons() ;
        return totalEpisodes;
    }

    public void setTotalEpisodes(int totalEpisodes) {
        this.totalEpisodes = totalEpisodes;
    }

    public int getTotalViews() {
        return totalViews;
    }

    public void setTotalViews(int totalViews) {
        this.totalViews = totalViews;
    }

    //  Methods
    @Override
    public int getDurationInMinutes() {

        return (getEpisodeDuration() * getEpisodesPerSeason()) * getSeasons();
    }

    @Override
    public int getClassification() {
        if (totalViews > 100){
            return 4;
        } else  {
            return 2;
        }
    }

    @Override
    public String toString() {
        return "Serie: " + this.getName() + " (" + this.getYear() + ")"
                + "\nSeasons: " + this.seasons
                + "\nFinished: " + this.finished
                + "\nRuntime: " + this.episodeDuration
                ;
    }
}
