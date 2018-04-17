package three.version.project.amourversionfor.Search;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Ibraim on 13.04.2018.
 */

public class ClickRecyclerAdapter  extends SimpleRecyclerAdapter implements View.OnClickListener {


    public interface OnItemClickListenner{
        void onItemClick(View view, int position);

    }
    private final OnItemClickListenner itemClickListenner;

    public ClickRecyclerAdapter( LayoutInflater inflater, OnItemClickListenner onItemClickListenner) {
        super(inflater);
        itemClickListenner = onItemClickListenner;
    }

    @Override
    public SimpleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        SimpleViewHolder simpleViewHolder=super.onCreateViewHolder(parent,viewType);
        simpleViewHolder.itemView.setOnClickListener(this);
        return simpleViewHolder;
    }

    @Override
    public void onBindViewHolder(SimpleViewHolder holder, int position) {
        super.onBindViewHolder(holder, position);
        holder.itemView.setTag(position);
    }


    @Override
    public void onClick(View v) {
       Integer position= (Integer) v.getTag();
       itemClickListenner.onItemClick(v,position);
    }
}
