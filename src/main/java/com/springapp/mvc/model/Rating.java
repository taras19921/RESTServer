package com.springapp.mvc.model;

import com.springapp.mvc.data.response.RatingResponseDATA;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "rating")
//@NamedQueries({@NamedQuery(name = Rating.FIND_USER_ID_IN_RATING_WITHOUT_DATE, query = "SELECT r FROM Rating r WHERE r.ratingDate is null") })
@NamedNativeQueries({@NamedNativeQuery(name = Rating.FIND_ALL_RATING, query = "SELECT r.id, u.name, m.title, r.rating, r.rating_date FROM Rating AS r LEFT JOIN User AS u ON r.user_id = u.id LEFT JOIN Movie AS m ON r.movie_id = m.id", resultSetMapping = "AllRatingInfoResult"),
        @NamedNativeQuery(name = Rating.FIND_USER_ID_IN_RATING_WITHOUT_DATE, query = "SELECT * FROM Rating AS r WHERE r.rating_date IS NULL", resultClass = Rating.class),
        @NamedNativeQuery(name = Rating.FIND_MOVIES_ID_BY_RATING, query = "SELECT * FROM rating AS r WHERE r.rating = 4 OR r.rating = 5 ORDER BY r.rating_date ASC", resultClass = Rating.class),
        @NamedNativeQuery(name = Rating.FIND_MOVIES_WITHOUT_RATING, query = "SELECT m.title FROM rating AS r JOIN movie AS m ON r.movie_id = m.id WHERE r.rating IS NULL OR r.rating = 0", resultSetMapping = "MoviesWithoutRatingInfoResult")})
@SqlResultSetMappings({
        @SqlResultSetMapping(name = "AllRatingInfoResult", classes = {
                @ConstructorResult(targetClass = RatingResponseDATA.class, columns = {
                        @ColumnResult(name = "id", type = Integer.class),
                        @ColumnResult(name = "name"),
                        @ColumnResult(name = "title"),
                        @ColumnResult(name = "rating", type = Integer.class),
                        @ColumnResult(name = "rating_date", type = Date.class) }) }),
        @SqlResultSetMapping(name = "MoviesWithoutRatingInfoResult", classes = {
                @ConstructorResult(targetClass = RatingResponseDATA.class, columns = {
                        @ColumnResult(name = "title") }) })
})

public class Rating {

    public static final String FIND_ALL_RATING = "Rating.findAllRating";
    public static final String FIND_USER_ID_IN_RATING_WITHOUT_DATE = "Rating.findUserIdWithoutDate";
    public static final String FIND_MOVIES_ID_BY_RATING = "Rating.findMoviesIdByRating";
    public static final String FIND_MOVIES_WITHOUT_RATING = "Rating.findMoviesWithoutRating";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private Integer id;
    @Column(nullable = false, unique = true, name = "user_id", insertable = false, updatable = false)
    private Integer userId;
    @Column(nullable = false, unique = true, name = "movie_id", insertable = false, updatable = false)
    private Integer movieId;
    @Column
    private Integer rating;
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
    @ManyToOne(fetch = FetchType.LAZY)
    private Movie movie;
    @Column(name = "rating_date")
    private Date ratingDate;

    public Rating() {
    }

    public Rating(Integer userId, Integer movieId, Integer rating, Date ratingDate) {
        this.userId = userId;
        this.movieId = movieId;
        this.rating = rating;
        this.ratingDate = ratingDate;
    }

    public Rating(Integer userId, Integer movieId, Integer rating, User user, Movie movie, Date ratingDate) {
        this.userId = userId;
        this.movieId = movieId;
        this.rating = rating;
        this.user = user;
        this.movie = movie;
        this.ratingDate = ratingDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Date getRatingDate() {
        return ratingDate;
    }

    public void setRatingDate(Date ratingDate) {
        this.ratingDate = ratingDate;
    }
}
