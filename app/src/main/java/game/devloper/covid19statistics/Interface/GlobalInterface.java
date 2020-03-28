package game.devloper.covid19statistics.Interface;

import game.devloper.covid19statistics.Helper.GlobalModel;
import retrofit2.Call;
import retrofit2.http.GET;

public interface GlobalInterface {

    @GET("api/stats")
    Call<GlobalModel> g_model();

}
