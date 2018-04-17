package three.version.project.amourversionfor.Search;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import java.util.ArrayList;

import three.version.project.amourversionfor.R;
import three.version.project.amourversionfor.UsersPhotoGallery;
import three.version.project.amourversionfor.Util.UniversalImageLoader;
import three.version.project.amourversionfor.Util.BottomNavigationViewExHelper;

/**
 * Created by Ibraim on 20.02.2018.
 */

public class SearchActivity  extends AppCompatActivity implements ClickRecyclerAdapter.OnItemClickListenner{
    private Context thisContext=SearchActivity.this;
    private static final int ACTIVITY_NUM=1;
    private static final String TAG="SearchActivity";

    //Список
    private RecyclerView recyclerView;
//    private RecyclerAdapter recyclerAdapter;
//    private RecyclerView.LayoutManager layoutManager;
//      private ArrayList<UsersPhotoModel> arrayList=new ArrayList<>();
    private ImageView imageUsers;
    private TextView userInformation;
    private SimpleViewHolder simpleViewHolder;




    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_search);
        Log.d(TAG,"Oncreate: started");


        setupBottomNavigationViewEx();
      //  setupRecyclerView();
        setupBigImage();
        setupAlertUrslef();
        recyclerView=(RecyclerView) findViewById(R.id.recyclerSearchImage);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(SearchActivity.this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(new ClickRecyclerAdapter(getLayoutInflater(),this));


        ImageView imageSettings=(ImageView) findViewById(R.id.searchSettings);
        imageSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(thisContext,SettingsSerch.class);
                startActivity(intent);
            }
        });



    }

    private void setupImage(){
        String imgUrl="ruinformer.com/uploads/_pages/32043/6476a493403a0e3f7f6319efd14da151.jpg";
        UniversalImageLoader.setImage(imgUrl,imageUsers,null,"http://");

    }
    private void setupBottomNavigationViewEx(){

        Log.d(TAG,"SetupBottomaNavigationView:setuo up");
        BottomNavigationViewEx bottomNavigationViewEx=(BottomNavigationViewEx) findViewById(R.id.bottom_nav_view);
        BottomNavigationViewExHelper.setupNavigationViewHelp(bottomNavigationViewEx);
        BottomNavigationViewExHelper.enableNavigation(thisContext,bottomNavigationViewEx,ACTIVITY_NUM);
        Menu menu=bottomNavigationViewEx.getMenu();
        MenuItem menuItem=menu.getItem(ACTIVITY_NUM);
        menuItem.setChecked(true);
    }
    private void setupRecyclerView() {


////        for(int i=0;i<img_res.length;i++){
////            UsersPhotoModel usersPhotoModel=new UsersPhotoModel(img_res[i]);
////            arrayList.add(usersPhotoModel);
////        }
//        recyclerAdapter = new RecyclerAdapter(arrayList);
//        recyclerView.setHasFixedSize(true);
//        layoutManager = new LinearLayoutManager(SearchActivity.this, LinearLayoutManager.HORIZONTAL, false);
//        recyclerView.setLayoutManager(layoutManager);
//        recyclerView.setAdapter(recyclerAdapter);
    }

    private void setupBigImage(){
        imageUsers=(ImageView) findViewById(R.id.imageSearchUsers);
        imageUsers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(thisContext, UsersPhotoGallery.class);
                startActivity(intent);
            }
        });
    }
    private void setupAlertUrslef(){
        userInformation=(TextView) findViewById(R.id.urselfInforamtionSerch);
        userInformation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder mBuilder=new AlertDialog.Builder(thisContext);
                View view=getLayoutInflater().inflate(R.layout.dialog_layout,null);
                TextView textUrselfDialog=(TextView) view.findViewById(R.id.urselfInforamtionDilog);
                textUrselfDialog.setText(userInformation.getText());
                mBuilder.setView(view);
                AlertDialog dialog=mBuilder.create();
                dialog.show();
            }
        });

    }

    @Override
    public void onItemClick(View view, int position) {

     imageUsers.setImageResource(SimpleRecyclerAdapter.img_res[position]);
    }
}


