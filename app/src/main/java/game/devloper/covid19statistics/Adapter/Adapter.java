package game.devloper.covid19statistics.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import game.devloper.covid19statistics.Helper.Model;
import game.devloper.covid19statistics.R;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private List<Model> model;

    private Context context;

    public Adapter(List<Model> model, Context context) {
        this.model = model;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Model test = model.get(position);

        ViewHolder async = holder;

        async.olkeler.setText(test.getCountry());
        async.u_olenler.setText(test.getTotal_deaths());
        async.u_sagalanlar.setText(test.getTotal_recovered());
        async.u_yoluxanlar.setText(test.getTotal_cases());

        if (test.getNew_cases().toString().isEmpty() || test.getNew_deaths().toString().isEmpty()){
            async.y_yoluxanlar.setText("Yoxdur");
            async.y_olenler.setText("Yoxdur");
        }

        if (test.getNew_cases().toString().isEmpty()){
            async.y_yoluxanlar.setText("Yoxdur");
        }else {
            async.y_yoluxanlar.setText(test.getNew_cases());
        }

        if (test.getNew_deaths().toString().isEmpty()){
            async.y_olenler.setText(test.getNew_deaths());
        }else {
            async.y_olenler.setText("Yoxdur");
        }

    }

    @Override
    public int getItemCount() {
        return model.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView olkeler,y_yoluxanlar,y_olenler,u_yoluxanlar,u_olenler,u_sagalanlar;

        public ViewHolder(@NonNull View itemView) {

            super(itemView);

            olkeler = itemView.findViewById(R.id.olkeler);
            y_yoluxanlar = itemView.findViewById(R.id.y_yoluxanlar);
            y_olenler = itemView.findViewById(R.id.y_olenler);
            u_yoluxanlar = itemView.findViewById(R.id.u_yoluxanlar);
            u_olenler = itemView.findViewById(R.id.u_olenler);
            u_sagalanlar = itemView.findViewById(R.id.u_sagalanlar);

        }
    }
}
