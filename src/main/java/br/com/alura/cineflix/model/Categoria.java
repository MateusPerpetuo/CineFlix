package br.com.alura.cineflix.model;

public enum Categoria {

    ACAO("Action" , "Ação"),
    ROMANCE("Romance" , "Romance"),
    COMEDIA("Comedy" , "Comédia"),
    DRAMA("Drama" , "Drama"),
    CRIME("Crime", "Crime");

    private String generoOmdb;
    private String generoPortugues;

    Categoria(String generoOmdb, String generoPortugues){
        this.generoOmdb = generoOmdb;
        this.generoPortugues = generoPortugues;
    }

    public static Categoria fromString(String text) {
        for (Categoria categoria : Categoria.values()) {
            if (categoria.generoOmdb.equalsIgnoreCase(text)) {
                return categoria;
            }
        }
        throw new IllegalArgumentException("Nenhuma categoria encontrada para a string fornecida: " + text);
    }
    public static Categoria fromPortugues(String text) {

        for (Categoria categoria : Categoria.values()) {
            if (categoria.generoPortugues.equalsIgnoreCase(text)) {
                return categoria;
            }
        }
        throw new IllegalArgumentException("Nenhuma categoria encontrada para a string fornecida: " + text);
    }
}
