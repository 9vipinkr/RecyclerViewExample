package com.vipinkr.recyclerviewexample;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Vipin K R on 24-01-2017.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {
    private static final String TAG = "RecyclerViewAdapter";
    private ArrayList<Person> list;

    public RecyclerViewAdapter(ArrayList<Person> list) {
        this.list = list;
    }

    /*
    A ViewHolder describes an item view and metadata about its place within the RecyclerView.
     */

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name;
        public ImageView thumbnail;

        public MyViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.textCardView);
            thumbnail = (ImageView) itemView.findViewById(R.id.imageCardView);
        }
    }

    /*The new ViewHolder will be used to display items of the adapter using onBindViewHolder.
    Since it will be re-used to display different items in the data set, it is a good idea to cache references
    */

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.card_view, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Person p = list.get(position);
        holder.thumbnail.setImageResource(p.getThumbnail());
        holder.name.setText(p.getName());
        Log.d(TAG, "onBindViewHolder: thumbnail:"+p.getThumbnail()+"name: "+p.getName());
    }

    @Override
    public int getItemCount() {
        Log.d(TAG, "getItemCount: "+list.size());
        return list.size();
    }


}
