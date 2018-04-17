package three.version.project.amourversionfor;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.github.chrisbanes.photoview.PhotoView;

import java.util.ArrayList;

import three.version.project.amourversionfor.Search.RecyclerAdapter;
import three.version.project.amourversionfor.Search.SearchActivity;
import three.version.project.amourversionfor.Search.UsersPhotoModel;
import three.version.project.amourversionfor.Util.CustomSwipeAdapter;


/**
 * Created by Ibraim on 22.03.2018.
 */


public class UsersPhotoGallery extends AppCompatActivity {


    //Recycler widjets private ArrayList<UsersPhotoModel> arrayList=new ArrayList<>();
 private RecyclerAdapter recyclerAdapter;
 private Context mContext=UsersPhotoGallery.this;
 private PhotoView bigImageGallery;




    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_gallery);
        bigImageGallery=(PhotoView) findViewById(R.id.bigImageGallery);


        ViewPager viewPager=(ViewPager)findViewById(R.id.viewPager);
        CustomSwipeAdapter customSwipeAdapter=new CustomSwipeAdapter(mContext);
        viewPager.setAdapter(customSwipeAdapter);

    }



}
