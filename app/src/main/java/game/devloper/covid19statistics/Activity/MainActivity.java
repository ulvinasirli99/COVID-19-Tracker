package game.devloper.covid19statistics.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.SearchView;
import android.widget.Toast;

import com.github.ybq.android.spinkit.SpinKitView;
import com.github.ybq.android.spinkit.sprite.Sprite;
import com.github.ybq.android.spinkit.style.CubeGrid;
import com.github.ybq.android.spinkit.style.Pulse;
import com.github.ybq.android.spinkit.style.WanderingCubes;
import com.github.ybq.android.spinkit.style.Wave;

import java.util.ArrayList;
import java.util.List;

import game.devloper.covid19statistics.Interface.ApiInterface;
import game.devloper.covid19statistics.R;
import game.devloper.covid19statistics.Adapter.Adapter;
import game.devloper.covid19statistics.Service.ApiClient;
import game.devloper.covid19statistics.Helper.Model;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ProgressBar progressBar;

    private List<Model> models = new ArrayList<>();

    androidx.appcompat.widget.Toolbar toolbar;

    private ProgressDialog progressDialog;

    private RecyclerView.LayoutManager layoutManager;

    private Context context;

    private RecyclerView recyclerView;

    private Adapter adapter = new Adapter(models, context);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);

        context = this;

        progressBar = findViewById(R.id.mainSpin);

        Sprite pulse = new Wave();

        progressBar.setIndeterminateDrawable(pulse);

        toolbar = findViewById(R.id.appBar);
        setSupportActionBar(toolbar);


        progressDialog = new ProgressDialog(context);
        progressDialog.setMessage("Please wait, the news is loaded...");
        progressDialog.setCancelable(false);
        progressDialog.show();


        layoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        loadApi();

    }

    public void loadApi() {

        ApiInterface api = ApiClient.getRetrofit().create(ApiInterface.class);

        Call<List<Model>> call = api.getModel();

        call.enqueue(new Callback<List<Model>>() {
            @Override
            public void onResponse(Call<List<Model>> call, Response<List<Model>> response) {

                progressBar.setVisibility(View.GONE);

                progressDialog.dismiss();

                if (response.isSuccessful() && response.body().get(0) != null) {

                    if (!models.isEmpty()) {
                        models.clear();
                    }

                    models = response.body();
                    adapter = new Adapter(models, context);
                    recyclerView.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<List<Model>> call, Throwable t) {

                progressDialog.dismiss();

                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }
}