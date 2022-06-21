package com.dmdev.hw9.Task1;

import java.util.*;

public class Cinema {
    private final HashMap<Integer, Set<Film>> filmsByYear;


    public Cinema(HashMap<Integer, Set<Film>> filmsByYear) {
        this.filmsByYear = filmsByYear;
    }

    public HashMap<Integer, Set<Film>> getFilms() {
        return filmsByYear;
    }

    public boolean addFilm(Film film) {
        return filmsByYear.get(film.getYear()).add(film);
    }

    public Set<Film> getFilmByYear(int year) {
        return filmsByYear.get(year);
    }

    public ArrayList<Film> getFilmByYearAndMonth(int year, int month) {
        ArrayList<Film> filmsWithYearAndMonth = new ArrayList<>();
        Set<Film> films = filmsByYear.get(year);
        for (Film film : films) {
            if (film.getMonth() == month) {
                filmsWithYearAndMonth.add(film);
            }
        }
        return filmsWithYearAndMonth;
    }

    public ArrayList<Film> getFilmByGenre(Genre genre) {
        ArrayList<Film> filmsWithGenre = new ArrayList<>();
        for (Set<Film> films : filmsByYear.values()) {
            for (Film film : films) {
                if (film.getGenre() == genre) {
                    filmsWithGenre.add(film);
                }
            }
        }
        return filmsWithGenre;
    }

    public ArrayList<Film> getTopTenDesk() {
        TreeSet<Film> sortedFilms = new TreeSet<>(Comparator.comparing(Film::getRating, Comparator.reverseOrder()));
        ArrayList<Film> sortedFilmsTopTen = new ArrayList<>();
        Collection<Set<Film>> filmsByYearParts = filmsByYear.values();
        for (Set<Film> filmPart : filmsByYearParts) {
            for (Film film : filmPart) {
                System.out.println(film);
                sortedFilms.add(film);
            }
        }
        int i = 0;
        Iterator<Film> iter = sortedFilms.iterator();
        while (i < 10 && iter.hasNext()) {
            Film film = iter.next();
            sortedFilmsTopTen.add(film);
            i++;
        }
        return sortedFilmsTopTen;
    }


}
