package game.devloper.covid19statistics.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import game.devloper.covid19statistics.Service.ApiClient;
import game.devloper.covid19statistics.Helper.GlobalModel;
import game.devloper.covid19statistics.Interface.GlobalInterface;
import game.devloper.covid19statistics.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GlobalNews extends AppCompatActivity {

    ProgressDialog dialog;

    Context context;

    TextView aktiv_xesteler, gergin_xesteler, yeni_yoluxanlar, yeni_olenler,
            yayilma_faizi, umumi_yoluxanlar, umumi_olenler, umumi_sagalanlar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_global_news);

        context = this;

        dialog = new ProgressDialog(context);
        dialog.setTitle("Yüklənir...");
        dialog.setCancelable(false);
        dialog.show();

        aktiv_xesteler = findViewById(R.id.aktiv_xesteler);
        gergin_xesteler = findViewById(R.id.gergin_xesteler);
        yeni_yoluxanlar = findViewById(R.id.yeni_yoluxanlar);
        yeni_olenler = findViewById(R.id.yeni_olenler);
        yayilma_faizi = findViewById(R.id.yayilma_faizi);
        umumi_yoluxanlar = findViewById(R.id.umumi_yoluxanlar);
        umumi_olenler = findViewById(R.id.umumi_olenler);
        umumi_sagalanlar = findViewById(R.id.umumi_sagalanlar);

        globalNews();

    }

    public void globalNews() {

        GlobalInterface global = ApiClient.getRetrofit().create(GlobalInterface.class);

        Call<GlobalModel> call = global.g_model();

        call.enqueue(new Callback<GlobalModel>() {
            @Override
            public void onResponse(Call<GlobalModel> call, Response<GlobalModel> response) {
                dialog.dismiss();
                if (response.isSuccessful()) {

                    GlobalModel model = response.body();

                    aktiv_xesteler.setText(model.getActive_cases());
                    gergin_xesteler.setText(model.getCritical_cases());
                    yeni_yoluxanlar.setText(model.getNew_cases());
                    yayilma_faizi.setText(model.getPer_mln()+" %");
                    umumi_yoluxanlar.setText(model.getTotal_cases());
                    umumi_olenler.setText(model.getTotal_deaths());
                    umumi_sagalanlar.setText(model.getTotal_recovered());

                }
            }

            @Override
            public void onFailure(Call<GlobalModel> call, Throwable t) {
                dialog.dismiss();
                Toast.makeText(GlobalNews.this, t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });

    }

}
