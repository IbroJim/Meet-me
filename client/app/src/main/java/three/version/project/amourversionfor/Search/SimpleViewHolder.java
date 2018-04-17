package three.version.project.amourversionfor.Search;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import three.version.project.amourversionfor.R;

/**
 * Created by Ibraim on 13.04.2018.
 */

public class SimpleViewHolder extends RecyclerView.ViewHolder {
    private ImageView usersImage;
    private int img;

    public ImageView getUsersImage() {
        return usersImage;
    }

    public SimpleViewHolder(View itemView) {
        super(itemView);

        usersImage=(ImageView) itemView.findViewById(R.id.imageUsersPhoto);
    }


}
