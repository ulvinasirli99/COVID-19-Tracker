package game.devloper.covid19statistics.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import game.devloper.covid19statistics.Interface.IArticle;
import game.devloper.covid19statistics.R;
import game.devloper.covid19statistics.Service.ApiClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ArticleActivity extends AppCompatActivity {

    private Context context;

    private TextView meqale;

    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article);

        context = this;

        meqale = findViewById(R.id.meqaleler);

        progressDialog = new ProgressDialog(context);
        progressDialog.setTitle("Yüklənilir...");
        progressDialog.setCancelable(false);
        progressDialog.show();

        loadArticle();


    }

    public void loadArticle() {

        IArticle article = ApiClient.getRetrofit().create(IArticle.class);

        Call<List<List<String>>> call = article.getArtic();

        call.enqueue(new Callback<List<List<String>>>() {
            @Override
            public void onResponse(Call<List<List<String>>> call, Response<List<List<String>>> response) {

                progressDialog.dismiss();

                if (response.isSuccessful()){

                    List<List<String>> fresh = response.body();

                    for (List<String> list : fresh){

                        String contents = "";
//
                        contents = list.get(1) + "\n";

                        meqale.append(contents);

                    }

                }
            }

            @Override
            public void onFailure(Call<List<List<String>>> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(context, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
