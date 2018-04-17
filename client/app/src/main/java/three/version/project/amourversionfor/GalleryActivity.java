package three.version.project.amourversionfor;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.nfc.Tag;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Spinner;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

import java.lang.reflect.GenericArrayType;
import java.util.ArrayList;

import me.gujun.android.taggroup.TagGroup;
import three.version.project.amourversionfor.Util.FilePath;
import three.version.project.amourversionfor.Util.FileSearch;
import three.version.project.amourversionfor.Util.GridImageAdapter;
import three.version.project.amourversionfor.Util.Permissions;

/**
 * Created by Ibraim on 19.03.2018.
 */

public class GalleryActivity extends AppCompatActivity {
    private static final  String TAG="GalleryActivity ";
    private static final int NUM_GRID_COLUMS = 3;
    Context mContext=GalleryActivity.this;

    private GridView gridView;
    private Spinner spinnerDirectory;
    private ProgressBar progressBar;
    private ImageView imageGallery;


    private ArrayList<String> derictories;
    private String mAppend="file:/";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_galery);

        closeActiviti();
        imageGallery=(ImageView) findViewById(R.id.usersPhotoGallery);
        gridView=(GridView) findViewById(R.id.gridViewGallery);
        progressBar=(ProgressBar) findViewById(R.id.progressDerictory);
        progressBar.setVisibility(View.GONE);
        derictories=new ArrayList<>();
        spinnerDirectory=(Spinner) findViewById(R.id.spinnerFielPictures);
        ImageView imageClose=(ImageView) findViewById(R.id.close);
        imageClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"Onclick:closing gallery");
                   finish();
            }
        });
        init();


    }


    private void init(){
        FilePath filePath=new FilePath();
        if(FileSearch.getDirectoryPath(filePath.PICTURES)!=null){
            derictories=FileSearch.getDirectoryPath(filePath.PICTURES);

        }
        derictories.add(filePath.CAMERA);

        ArrayAdapter<String> adapter=new ArrayAdapter<String>(mContext,android.R.layout.simple_spinner_item,derictories);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerDirectory.setAdapter(adapter);

        spinnerDirectory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
              Log.d(TAG,"seleceted "+derictories.get(position));

              setupGridView(derictories.get(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



    }
    private void setupGridView(final String selectedDirectory){
        final ArrayList<String> imgURLs=FileSearch.getFilesPath(selectedDirectory);
        //Натсройка отабражение foto
        int gridWidth=getResources().getDisplayMetrics().widthPixels;
        int imageWidth=gridWidth/NUM_GRID_COLUMS;
        gridView.setColumnWidth(imageWidth);

        GridImageAdapter gridImageAdapter=new GridImageAdapter(mContext,R.layout.image_grid_layout,mAppend,imgURLs);
        gridView.setAdapter(gridImageAdapter);



        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d(TAG,"seleceted "+imgURLs.get(position));
                setImageGallery(imgURLs.get(position),imageGallery,mAppend);
           }
       });
    }
    private void setImageGallery(String imgURL,ImageView image,String append){

        ImageLoader imageLoader=ImageLoader.getInstance();

        imageLoader.displayImage(append + imgURL, image, new ImageLoadingListener() {
            @Override
            public void onLoadingStarted(String imageUri, View view) {
                progressBar.setVisibility(View.VISIBLE);
            }

            @Override
            public void onLoadingFailed(String imageUri, View view, FailReason failReason) {
                progressBar.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
                progressBar.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onLoadingCancelled(String imageUri, View view) {
                progressBar.setVisibility(View.INVISIBLE);
            }
        });
    }
    private void closeActiviti(){
        ImageView imageClose=(ImageView) findViewById(R.id.close);
        imageClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

}
