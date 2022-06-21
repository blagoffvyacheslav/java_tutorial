package com.dmdev.hw9.Task1;

import java.util.*;

public class CinemaRunner {
    public static void main(String[] args) {
        Set<Film> first = new HashSet<>(Arrays.asList(new Film(1, 2008, 1, Genre.COMEDY, 3.5), new Film(5, 2008, 3, Genre.THRILLER, 2.3), new Film(6, 2008, 4, Genre.MELODRAMA, 4.6)));
        Set<Film> second = new HashSet<>(Arrays.asList(new Film(2, 2009, 2, Genre.THRILLER, 4.8), new Film(4, 2009, 2, Genre.MELODRAMA, 5.0)));
        Set<Film> third = new HashSet<>(Arrays.asList(new Film(3, 2010, 3, Genre.MELODRAMA, 4.2), new Film(13, 2010, 2, Genre.MELODRAMA, 5.0)));
        Set<Film> fourth = new HashSet<>(List.of(new Film(7, 2012, 5, Genre.THRILLER, 4.9)));
        Set<Film> fifth = new HashSet<>(List.of(new Film(8, 2013, 6, Genre.MELODRAMA, 4.9)));
        Set<Film> sixth = new HashSet<>(Arrays.asList(new Film(9, 2015, 7, Genre.COMEDY, 4.9), new Film(10, 2015, 7, Genre.MELODRAMA, 4.9)));
        Set<Film> seventh = new HashSet<>(List.of(new Film(11, 2020, 8, Genre.COMEDY, 4.9)));
        Set<Film> eighth = new HashSet<>(List.of(new Film(12, 2022, 12, Genre.THRILLER, 4.9)));

        HashMap<Integer, Set<Film>> films = new LinkedHashMap<>();
        films.put(2008, first);
        films.put(2009, second);
        films.put(2010, third);
        films.put(2012, fourth);
        films.put(2013, fifth);
        films.put(2015, sixth);
        films.put(2020, seventh);
        films.put(2022, eighth);
        Cinema cinema = new Cinema(films);
        System.out.println(cinema.getFilms());
        System.out.println(cinema.addFilm(new Film(12, 2022, 12, Genre.THRILLER, 4.9)));
        System.out.println(cinema.getFilms());
        System.out.println(cinema.getFilmByYear(2008));
        System.out.println(cinema.getFilmByYearAndMonth(2008, 3));
        System.out.println(cinema.getFilmByGenre(Genre.MELODRAMA));
        System.out.println(cinema.getTopTenDesk());

    }
}
