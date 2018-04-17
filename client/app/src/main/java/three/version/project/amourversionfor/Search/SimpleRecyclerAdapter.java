package three.version.project.amourversionfor.Search;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.lang.ref.WeakReference;

import three.version.project.amourversionfor.R;

/**
 * Created by Ibraim on 13.04.2018.
 */

public class SimpleRecyclerAdapter extends RecyclerView.Adapter<SimpleViewHolder> {

    private final WeakReference<LayoutInflater> layoutInflaterWeakReference;
    public static int img_res[]= {R.drawable.boy1,R.drawable.boy2,R.drawable.boy3,R.drawable.boy4,R.drawable.boy5,R.drawable.boy6,R.drawable.boy7,R.drawable.boy8};


    public SimpleRecyclerAdapter(LayoutInflater inflater) {
        layoutInflaterWeakReference = new WeakReference<LayoutInflater>(inflater);
    }

    @Override
    public SimpleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater=layoutInflaterWeakReference.get();
        if(inflater!=null){
            return new SimpleViewHolder(inflater.inflate(R.layout.image_recycler_view,parent,false));
        }
        else {
            throw new RuntimeException("Ресайклер понтуется ");
        }
    }


    @Override
    public void onBindViewHolder(SimpleViewHolder holder, int position) {
        holder.getUsersImage().setImageResource(img_res[position]);
    }

    @Override
    public int getItemCount() {
        return img_res.length;
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }
}
