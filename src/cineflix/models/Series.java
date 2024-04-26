package cineflix.models;
/*** Class model for the tv series
 * @author Mateus Perpétuo
 * @version 1.0
 */
public class Series extends Title{
    private int seasons;
    private boolean active;
    private int episodesPerSeason;
    private int episodeDuration;
    private int totalEpisodes;

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

    @Override
    public int getDurationInMinutes() {

        return (getEpisodeDuration() * getEpisodesPerSeason()) * getSeasons();
    }

}
