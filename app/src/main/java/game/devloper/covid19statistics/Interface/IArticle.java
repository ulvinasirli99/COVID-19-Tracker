package game.devloper.covid19statistics.Interface;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface IArticle {

    @GET("api/articles")
    Call<List<List<String>>> getArtic();
}
