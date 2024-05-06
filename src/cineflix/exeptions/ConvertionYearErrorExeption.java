package cineflix.exeptions;

public class ConvertionYearErrorExeption extends RuntimeException {
    private String message;

    public ConvertionYearErrorExeption(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
