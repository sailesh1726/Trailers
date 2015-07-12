package com.example.android.trailers;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by sailesh on 6/19/15.
 */
public class TrailerAdapter extends RecyclerView.Adapter<TrailerAdapter.ViewHolder> {
    private ArrayList<String> trailerArrayList = null;

    public TrailerAdapter(ArrayList<String> trailerArrayList) {
        this.trailerArrayList=trailerArrayList;
    }



    @Override
    public TrailerAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View parentView= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycle_item,viewGroup,false);

        ViewHolder viewHolder = new ViewHolder(parentView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(TrailerAdapter.ViewHolder viewHolder, int i) {

        viewHolder.textView.setText(trailerArrayList.get(i));
    }


    @Override
    public int getItemCount() {
        return trailerArrayList.size();
    }

    protected class ViewHolder extends RecyclerView.ViewHolder {

        TextView textView;
        public ViewHolder(View itemView) {
            super(itemView);
            textView= (TextView) itemView.findViewById(R.id.trailerTextview);
        }
    }
}
