package game.devloper.covid19statistics.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import game.devloper.covid19statistics.Adapter.KAdapter;
import game.devloper.covid19statistics.Helper.KabinetInfo;
import game.devloper.covid19statistics.Interface.InfoInterface;
import game.devloper.covid19statistics.R;
import game.devloper.covid19statistics.Service.ApiClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InfoActivity extends AppCompatActivity {

    private Context context;

    private ProgressDialog progressDialog;

    private RecyclerView.LayoutManager layoutManager;

    private RecyclerView recyclerView;

    private List<KabinetInfo> kabinetInfos = new ArrayList<>();

    private KAdapter kAdapter = new KAdapter(kabinetInfos,context);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        context = this;

        recyclerView = findViewById(R.id.infoRecycler);

        progressDialog = new ProgressDialog(context);
        progressDialog.setMessage("Please wait, the news is loaded...");
        progressDialog.setCancelable(false);
        progressDialog.show();

        layoutManager=new LinearLayoutManager(context);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(kAdapter);

        loadInfo();

    }

    public void loadInfo() {

        InfoInterface infoInterface = ApiClient.getRetrofit().create(InfoInterface.class);

        Call<List<KabinetInfo>> call = infoInterface.info();

        call.enqueue(new Callback<List<KabinetInfo>>() {
            @Override
            public void onResponse(Call<List<KabinetInfo>> call, Response<List<KabinetInfo>> response) {

                progressDialog.dismiss();

                if (response.isSuccessful() && response.body().get(0) !=null) {

                    if (!kabinetInfos.isEmpty()){
                        kabinetInfos.clear();
                    }

                    kabinetInfos = response.body();

                    kAdapter = new KAdapter(kabinetInfos,context);

                    recyclerView.setAdapter(kAdapter);

                    kAdapter.notifyDataSetChanged();

                }
            }
            @Override
            public void onFailure(Call<List<KabinetInfo>> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(context, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
