package com.asd.android.doctor;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;

import java.util.Collections;
import java.util.List;

/**
 * Created by Mantan on 8/20/2016.
 */
public class Recycler_View_Adapter extends RecyclerView.Adapter<View_Holder> implements View.OnClickListener{
    private Intent i;
    List<Data> list = Collections.emptyList();
    Context context;

    public Recycler_View_Adapter(List<Data> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public void onClick(View view) {
        Intent i = new Intent(view.getContext(),SakitKepala.class);
        view.getContext().startActivity(i);
    }

    public interface ItemClickListener {
        void onClick(View view, int position, boolean isLongClick);
    }

    @Override
    public View_Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Inflate the layout, initialize the View Holder
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout, parent, false);
        View_Holder holder = new View_Holder(v);
        return holder;

    }

    @Override
    public void onBindViewHolder(View_Holder holder, int position) {

        //Use the provided View Holder on the onCreateViewHolder method to populate the current row on the RecyclerView
        holder.title.setText(list.get(position).title);
        holder.description.setText(list.get(position).description);
        holder.imageView.setImageResource(list.get(position).imageId);
        holder.setClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int position, boolean isLongClick) {
                if (position == 0){
                    i = new Intent(view.getContext(),SakitKepala.class);
                    view.getContext().startActivity(i);
                }else if(position==1){
                    i = new Intent(view.getContext(),Mata.class);
                    view.getContext().startActivity(i);
                }else if(position==2){
                    i = new Intent(view.getContext(),activitytiga.class);
                    view.getContext().startActivity(i);
                }else if(position==3){
                    i = new Intent(view.getContext(),activityempat.class);
                    view.getContext().startActivity(i);
                }else if(position==4){
                    i = new Intent(view.getContext(),activitylima.class);
                    view.getContext().startActivity(i);
                }else if(position==5){
                    i = new Intent(view.getContext(),activityenam.class);
                    view.getContext().startActivity(i);
                }else if(position==6){
                    i = new Intent(view.getContext(),activitytujuh.class);
                    view.getContext().startActivity(i);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        //returns the number of elements the RecyclerView will display
        return list.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    // Insert a new item to the RecyclerView on a predefined position
    public void insert(int position, Data data) {
        list.add(position, data);
        notifyItemInserted(position);
    }

    // Remove a RecyclerView item containing a specified Data object
    public void remove(Data data) {
        int position = list.indexOf(data);
        list.remove(position);
        notifyItemRemoved(position);
    }

}
