package three.version.project.amourversionfor.Util;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

import java.util.ArrayList;

import three.version.project.amourversionfor.R;

/**
 * Created by Ibraim on 19.03.2018.
 */

public class GridImageAdapter extends ArrayAdapter<String> {

    private Context mContext;
    private LayoutInflater mInflayter;
    private int layoutResource;
    private String mAppend;
    private ArrayList<String> imgUrl;

    public GridImageAdapter(Context context, int layoutResource, String append, ArrayList<String> imgUrl) {
        super(context,layoutResource,imgUrl);
        mContext = context;
        mInflayter = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.layoutResource = layoutResource;
        mAppend = append;
        this.imgUrl = imgUrl;
    }

    private static class ViewHolder{
        SqaureImageView profileImage;
        ProgressBar progressBar;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        final  ViewHolder viewHolder;
        if(convertView==null) {
            convertView=mInflayter.inflate(layoutResource,parent,false);
            viewHolder = new ViewHolder();
            viewHolder.profileImage=(SqaureImageView) convertView.findViewById(R.id.gridImageView);
            viewHolder.progressBar=(ProgressBar) convertView.findViewById(R.id.gridProgressBar);

            convertView.setTag(viewHolder);
        }else {
            viewHolder=(ViewHolder)convertView.getTag();
        }

        String imgUrl=getItem(position);
        ImageLoader imageLoader=ImageLoader.getInstance();
        imageLoader.displayImage(mAppend + imgUrl, viewHolder.profileImage, new ImageLoadingListener() {
            @Override
            public void onLoadingStarted(String imageUri, View view) {
                if(viewHolder.progressBar!=null){
                    viewHolder.progressBar.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onLoadingFailed(String imageUri, View view, FailReason failReason) {
                if(viewHolder.progressBar!=null){
                    viewHolder.progressBar.setVisibility(View.GONE);
                }
            }

            @Override
            public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
                if(viewHolder.progressBar!=null){
                    viewHolder.progressBar.setVisibility(View.GONE);
                }

            }

            @Override
            public void onLoadingCancelled(String imageUri, View view) {

                if (viewHolder.progressBar != null) {
                    viewHolder.progressBar.setVisibility(View.GONE);

                }
            }
        });
        return convertView;
    }
}
