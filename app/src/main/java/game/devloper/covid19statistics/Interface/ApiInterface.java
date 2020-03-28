package game.devloper.covid19statistics.Interface;

import java.util.List;

import game.devloper.covid19statistics.Helper.Model;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("api")
    Call<List<Model>> getModel();

}
