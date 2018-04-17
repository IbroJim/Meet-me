package three.version.project.amourversionfor.Util;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import three.version.project.amourversionfor.R;

/**
 * Created by Ibraim on 02.04.2018.
 */

public class CustomSwipeAdapter extends PagerAdapter {
    private int img_res[]= {R.drawable.boy1,R.drawable.boy2,R.drawable.boy3,R.drawable.boy4,R.drawable.boy5,R.drawable.boy6,R.drawable.boy7,R.drawable.boy8};
private Context mContext;
private LayoutInflater layoutInflaterl;

    public CustomSwipeAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @Override

    public int getCount() {
        return img_res.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view==(RelativeLayout)object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflaterl=(LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=layoutInflaterl.inflate(R.layout.activity_photo_gallery,container,false);
        ImageView imageView=(ImageView) view.findViewById(R.id.bigImageGallery);
        imageView.setImageResource(img_res[position]);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
   container.removeView((RelativeLayout)object);
    }
}
