package three.version.project.amourversionfor.Home;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;
import com.nostra13.universalimageloader.core.ImageLoader;


import java.util.ArrayList;

import cn.pedant.SweetAlert.SweetAlertDialog;
import me.gujun.android.taggroup.TagGroup;
import three.version.project.amourversionfor.GalleryActivity;
import three.version.project.amourversionfor.MessageActivity;
import three.version.project.amourversionfor.R;
import three.version.project.amourversionfor.Rating.RatingActivity;
import three.version.project.amourversionfor.SettingsProfile;
import three.version.project.amourversionfor.UsersPhotoGallery;
import three.version.project.amourversionfor.Util.UniversalImageLoader;
import three.version.project.amourversionfor.Util.BottomNavigationViewExHelper;

public class HomeActivity extends AppCompatActivity {
    private static final int ACTIVITY_NUM=0;
    private static final String TAG="HomeActivity";
    private TextView urslefInformation;





    private Context mContext=HomeActivity.this;
    private  ArrayList<String> strings;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        urslefInformation=(TextView) findViewById(R.id.urselfInforamtion);
        Log.d(TAG,"Oncreate: started");
        initImage();
        setuoBottomNavigationViewEx();
        setupAlertDialogUrslef();
        setupAletDialogTagGroup();
        setupHelpLayout();
        TagGroup tagGroup=(TagGroup) findViewById(R.id.tagLayout);
        strings=new ArrayList<>();
        addListTags(strings);
        tagGroup.setTags(strings);
    }

    private void initImage(){
        UniversalImageLoader universalImageLoader=new UniversalImageLoader(mContext);
        ImageLoader.getInstance().init(universalImageLoader.getConfig());
    }



    private  void addListTags(ArrayList<String> sad){
        sad.add("Кальян");
        sad.add("Бегаю по утрам");
        sad.add("Книги");
        sad.add("69 поза");
        sad.add("BMW");
        sad.add("Игра престолов");
        sad.add("Rap");
    }

    private void setuoBottomNavigationViewEx(){
        Log.d(TAG,"SetupBottomaNavigationView:setuo up");

        BottomNavigationViewEx bottomNavigationViewEx=(BottomNavigationViewEx) findViewById(R.id.bottom_nav_view);
        BottomNavigationViewExHelper.setupNavigationViewHelp(bottomNavigationViewEx);
        BottomNavigationViewExHelper.enableNavigation(mContext,bottomNavigationViewEx,ACTIVITY_NUM);
        Menu menu=bottomNavigationViewEx.getMenu();
        MenuItem menuItem=menu.getItem(ACTIVITY_NUM);
        menuItem.setChecked(true);

    }



    private void setupAlertDialogUrslef(){

        urslefInformation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder mBuilder=new AlertDialog.Builder(mContext);
                View view=getLayoutInflater().inflate(R.layout.dialog_layout,null);
                TextView textUrselfDialog=(TextView) view.findViewById(R.id.urselfInforamtionDilog);
                textUrselfDialog.setText(urslefInformation.getText());
              mBuilder.setView(view);
              AlertDialog dialog=mBuilder.create();
              dialog.show();
            }
        });

    }
    private void setupAletDialogTagGroup(){
        LinearLayout tagLayoutHome=(LinearLayout) findViewById(R.id.tag_layoutid);
        tagLayoutHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder mBuilder=new AlertDialog.Builder(mContext);
                View view=getLayoutInflater().inflate(R.layout.dialog_layout_taggroup,null);
                TagGroup tagGroupDialog=(TagGroup) view.findViewById(R.id.tagLayoutDialog);
                tagGroupDialog.setTags(strings);
                mBuilder.setView(view);
                AlertDialog dialog=mBuilder.create();
                dialog.show();
            }
        });

    }
    private void setupHelpLayout(){
        RelativeLayout relativePhoto=(RelativeLayout) findViewById(R.id.relativeOne);
        RelativeLayout relativeSettings =(RelativeLayout) findViewById(R.id.relativeTwo);
        RelativeLayout relativeRating=(RelativeLayout) findViewById(R.id.relativeTrio);
        RelativeLayout relativeMessage=(RelativeLayout) findViewById(R.id.relativeFour);
        relativePhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(mContext, UsersPhotoGallery.class);
                startActivity(intent);
            }
        });
        relativeSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(mContext, SettingsProfile.class);
                startActivity(intent1);
            }
        });
        relativeRating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2=new Intent(mContext, RatingActivity.class);
                startActivity(intent2);
            }
        });
        relativeMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3=new Intent(mContext,MessageActivity.class);
                startActivity(intent3);
            }
        });
    }



}
