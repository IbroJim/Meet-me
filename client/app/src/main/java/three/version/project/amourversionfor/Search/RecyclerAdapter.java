package three.version.project.amourversionfor.Search;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

import three.version.project.amourversionfor.R;
import three.version.project.amourversionfor.UsersPhotoGallery;

/**
 * Created by Ibraim on 25.02.2018.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.UsersRecyclerViewHolder> {

    private ArrayList<UsersPhotoModel> arrayList=new ArrayList<>();

    public RecyclerAdapter(ArrayList<UsersPhotoModel> arrayList){
        this.arrayList=arrayList;
    }

    @Override
    public UsersRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.image_recycler_view,parent,false);
        UsersRecyclerViewHolder usersRecyclerViewHolder=new UsersRecyclerViewHolder(view);

        return usersRecyclerViewHolder;
    }

    @Override
    public void onBindViewHolder(UsersRecyclerViewHolder holder, int position) {
        UsersPhotoModel usersPhotoModel= arrayList.get(position);
        holder.usersImage.setImageResource(usersPhotoModel.getImg_users());

    }

    @Override
    public int getItemCount()
    {

        return arrayList.size() ;
    }

    public static class UsersRecyclerViewHolder extends RecyclerView.ViewHolder {

        private ImageView usersImage;

        public UsersRecyclerViewHolder(View itemView) {
            super(itemView);

           usersImage=(ImageView)itemView.findViewById(R.id.imageUsersPhoto);

        }



    }




}
