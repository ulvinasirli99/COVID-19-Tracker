package game.devloper.covid19statistics.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import game.devloper.covid19statistics.Helper.KabinetInfo;
import game.devloper.covid19statistics.R;

public class KAdapter extends RecyclerView.Adapter<KAdapter.ViewHolder> {

    private List<KabinetInfo> info;

    private Context context;

    public KAdapter(List<KabinetInfo> info, Context context) {
        this.info = info;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.kabinet_item,parent,false);

        ViewHolder holder = new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        KabinetInfo kabinet = info.get(position);

        ViewHolder count = holder;

        count.basliqlar.setText(kabinet.getTitle());
        count.news.setText(kabinet.getBody());


    }

    @Override
    public int getItemCount() {
        return info.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView basliqlar,news;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            basliqlar = itemView.findViewById(R.id.basliqlar);

            news = itemView.findViewById(R.id.news);

        }
    }

}
