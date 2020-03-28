package game.devloper.covid19statistics.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import game.devloper.covid19statistics.R;

public class Transition extends AppCompatActivity {

    TextView glo_news,general_info,kecN,nedir;

    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transition);

        context = this;

        nedir = findViewById(R.id.nedir);

        glo_news = findViewById(R.id.g_news);

        general_info = findViewById(R.id.u_melumat);

        kecN = findViewById(R.id.nazirKecid);

        kecN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,InfoActivity.class);
                startActivity(intent);
            }
        });

        glo_news.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,GlobalNews.class);
                startActivity(intent);
            }
        });

        general_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,MainActivity.class);
                startActivity(intent);
            }
        });

        nedir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,ArticleActivity.class);
                startActivity(intent);
            }
        });

    }
}
