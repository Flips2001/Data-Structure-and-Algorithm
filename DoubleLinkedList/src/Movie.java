import java.util.Objects;

public class Movie {
    private final String title;
    private final String director_name;
    private final int release_year;

    /* default constructor */
    public Movie() {
        this.title = "";
        this.director_name = "";
        this.release_year = 0;
    }

    /* default constructor */
    public Movie(String title, String director_name, int release_year) {
        this.title = title;
        this.director_name = director_name;
        this.release_year = release_year;
    }

    /* copy constructor */
    public Movie(Movie movie) {
        this.title = movie.title;
        this.director_name = movie.director_name;
        this.release_year = movie.release_year;
    }

    @Override
    public String toString() {
        return "Title: " + this.title + ", Director: " + this.director_name + ", Release Year: " + this.release_year;
    }

    @ Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Movie movie)) {
            return false;
        }
        return this.title.equals(movie.title) && this.director_name.equals(movie.director_name) && this.release_year == movie.release_year;
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, director_name, release_year);
    }




}
