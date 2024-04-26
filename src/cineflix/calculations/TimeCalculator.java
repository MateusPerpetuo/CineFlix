package cineflix.calculations;

import cineflix.models.Title;

public class TimeCalculator {
    private int totalTime;

    public String getTotalTime() {
        return "para maratonar tudo vc vai precisar de um totam de " + (totalTime/60) + " horas";
    }

    public void addTime(Title title){
        System.out.println("Added time duration in minutes from " + title.getName());
        this.totalTime += title.getDurationInMinutes();
    }

}

