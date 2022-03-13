package com.example.learning.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.learning.R;
import com.example.learning.data.remotly.FeelingsResponse;
import com.squareup.picasso.Picasso;

import java.util.List;

public class FeelingAdapter extends RecyclerView.Adapter<FeelingAdapter.FeelingViewHolder> {

    private List<FeelingsResponse.FeelingsDataEntry> data;
    private Context ctx;

    public FeelingAdapter(List<FeelingsResponse.FeelingsDataEntry> data, Context ctx) {
        this.data = data;
        this.ctx = ctx;
    }

    @Override
    public int getItemCount() {
        if (data != null) {
            return data.size();
        }
        return 0;
    }

    @NonNull
    @Override
    public FeelingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(ctx).inflate(R.layout.item_feeling, parent, false);

        return new FeelingViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FeelingViewHolder holder, int position) {
        holder.title.setText(data.get(position).title);

        /*Picasso.get()
                .load()*/
    }

    protected final class FeelingViewHolder extends RecyclerView.ViewHolder{
        private final ImageView icon;
        private final TextView title;

        public FeelingViewHolder(@NonNull View itemView) {
            super(itemView);

            icon = itemView.findViewById(R.id.icon);
            title = itemView.findViewById(R.id.title);
        }
    }
}
