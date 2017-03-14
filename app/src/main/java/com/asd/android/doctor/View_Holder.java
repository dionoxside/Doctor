package com.asd.android.doctor;

import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Mantan on 8/20/2016.
 */
public class View_Holder extends RecyclerView.ViewHolder
        implements View.OnClickListener {


    private Recycler_View_Adapter.ItemClickListener clickListener;

    CardView cv;
    TextView title;
    TextView description;
    ImageView imageView;

    View_Holder(View itemView) {
        super(itemView);
        cv = (CardView) itemView.findViewById(R.id.cardView);
        title = (TextView) itemView.findViewById(R.id.title);
        description = (TextView) itemView.findViewById(R.id.description);
        imageView = (ImageView) itemView.findViewById(R.id.imageView);
        itemView.setOnClickListener(this);
    }


    public void setClickListener(Recycler_View_Adapter.ItemClickListener itemClickListener) {
        this.clickListener = itemClickListener;
    }
    @Override
    public void onClick(View view) {
        Log.e("title",title.getText().toString());
        Intent i = new Intent(view.getContext(),SakitKepala.class);
        view.getContext().startActivity(i);
    }
}