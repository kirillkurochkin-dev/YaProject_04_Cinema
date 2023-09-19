package ru.kirikura.yaproject_05_cinema.storage.film;

import ru.kirikura.yaproject_05_cinema.model.Film;

import java.util.Map;

public interface FilmStorage {
    Map<Integer, Film> findAllFilms();
    Film addFilm(Film film);
    Film updateFilm(Film film);
    Film getFilmById(int id);
    void deleteFilmById(int id);
    void deleteAllFilms();
}