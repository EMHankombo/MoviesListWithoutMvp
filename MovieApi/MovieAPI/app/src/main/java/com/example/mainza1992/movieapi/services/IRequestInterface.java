package com.example.mainza1992.movieapi.services;

import com.example.mainza1992.movieapi.model.MovieListModel;
import com.example.mainza1992.movieapi.model.movieDetailsModel.MovieDetailsModel;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by mainza1992 on 28/09/2017.
 */

public interface IRequestInterface {


    /**
     * list of all the request i'll be making to the server
     */

    String apikey = "65cec66457a6bad59c45f52c0dbdb984";


    //list of movies
    @GET("movie/top_rated")
    Observable<MovieListModel> getMovieList(@Query("api_key") String apikey);


    //individual movie details
    @GET("movie/{id}")
    Observable<MovieDetailsModel> getMovieDetail(@Path("id") int id,@Query("api_key") String apikey);

}
