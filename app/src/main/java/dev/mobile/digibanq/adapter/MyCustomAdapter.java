package dev.mobile.digibanq.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import dev.mobile.digibanq.data.Information;
import info.androidhive.digibanq.R;

import java.util.ArrayList;

/**
 * Created by banktech on 9/25/2016.
 */
public class MyCustomAdapter extends RecyclerView.Adapter<MyCustomAdapter.MyViewHolder> {

    Context context;
    ArrayList<Information> data;
    LayoutInflater inflater;


    public MyCustomAdapter(Context context, ArrayList<Information> data) {

        this.context = context;
        this.data = data;
        inflater = LayoutInflater.from(context);



    }

    @Override
    public MyCustomAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int position) {

        View view = inflater.inflate(R.layout.recent_list_item, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder myViewHolder, int position) {

        myViewHolder.textview.setText(data.get(position).title);
        myViewHolder.imageview.setImageResource(data.get(position).imageid);

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView textview;
        ImageView imageview;


    public MyViewHolder(View itemView) {
        super(itemView);

        textview = (TextView) itemView.findViewById(R.id.txv_row);
        imageview = (ImageView) itemView.findViewById(R.id.img_row);
    }
}




}
