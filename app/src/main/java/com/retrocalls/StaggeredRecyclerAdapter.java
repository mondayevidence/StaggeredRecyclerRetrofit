package com.retrocalls;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.List;

import static android.R.drawable.sym_def_app_icon;

public class StaggeredRecyclerAdapter extends RecyclerView.Adapter<StaggeredRecyclerAdapter.ImageViewHolder> {
    Context mContext;
    List<Images> mData;
    public static final String IMAGE_URL_BASE_PATH="http://image.tmdb.org/t/p/w185//";


    public StaggeredRecyclerAdapter(Context mContext, List<Images> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.row_item, viewGroup, false);

        return new ImageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder imageViewHolder, int i) {
        //imageViewHolder.img.setImageResource(mData.get(i).getPoster_path());

        String image_url = IMAGE_URL_BASE_PATH + mData.get(i).getPoster_path();
        Picasso.get().load(image_url).placeholder(sym_def_app_icon)
                .error(R.drawable.error)
                .into(imageViewHolder.img);

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public  class ImageViewHolder extends RecyclerView.ViewHolder{

        ImageView img;

        public ImageViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.row_img);
        }
    }
}
