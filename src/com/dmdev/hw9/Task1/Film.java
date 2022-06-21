package com.dmdev.hw9.Task1;

import java.util.Objects;

public class Film {
    private final int id;
    private final int year;
    private final int month;
    private final Genre genre;
    private final double rating;


    public Film(int id, int year, int month, Genre genre, double rating) {
        this.id = id;
        this.year = year;
        this.month = month;
        this.genre = genre;
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public Genre getGenre() {
        return genre;
    }

    public double getRating() {
        return rating;
    }

    @Override
    public String toString() {
        return "Film{" +
                "id=" + id +
                ", year=" + year +
                ", month=" + month +
                ", genre=" + genre +
                ", rating=" + rating +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Film film = (Film) o;
        return id == film.id && year == film.year && month == film.month && Double.compare(film.rating, rating) == 0 && genre == film.genre;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, year, month, genre, rating);
    }
}
