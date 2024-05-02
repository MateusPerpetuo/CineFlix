package cineflix.models;

import cineflix.calculations.Classifiable;

/*** Class model for the tv series
 * @author Mateus Perpétuo
 * @version 1.0
 */
public class Serie extends Title implements Classifiable {
    private int seasons;
    private boolean active;
    private int episodesPerSeason;
    private int episodeDuration;
    private int totalEpisodes;
    private int totalViews;


    // Getters and setters

    public int getSeasons() {
        return seasons;
    }

    public void setSeasons(int seasons) {
        this.seasons = seasons;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
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
}
