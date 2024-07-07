package br.com.alura.cineflix.service;

public interface IConverteDados {
    <T> T  obterDados(String json, Class<T> classe);
}
