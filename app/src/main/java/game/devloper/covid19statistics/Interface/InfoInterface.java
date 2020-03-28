package game.devloper.covid19statistics.Interface;

import java.util.List;

import game.devloper.covid19statistics.Helper.KabinetInfo;
import retrofit2.Call;
import retrofit2.http.GET;

public interface InfoInterface {

    @GET("api/news")
    Call<List<KabinetInfo>> info();

}
