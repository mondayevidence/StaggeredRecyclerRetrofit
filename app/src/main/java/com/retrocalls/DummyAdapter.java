package com.retrocalls;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

public class DummyAdapter extends RecyclerView.Adapter<DummyAdapter.ImageViewHolder> {
    Context context;
    List<row> rows;

    public DummyAdapter(Context context, List<row> rows) {
        this.context = context;
        this.rows = rows;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public List<row> getRows() {
        return rows;
    }

    public void setRows(List<row> rows) {
        this.rows = rows;
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_item, viewGroup, false);

        return new ImageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder imageViewHolder, int i) {
        imageViewHolder.img.setImageResource(rows.get(i).getImg());

    }

    @Override
    public int getItemCount() {
        return rows.size();
    }

    public class ImageViewHolder extends RecyclerView.ViewHolder {
        ImageView img;

        public ImageViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.row_img);
        }
    }
}
