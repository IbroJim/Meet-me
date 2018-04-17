package three.version.project.amourversionfor;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import org.w3c.dom.Text;

import io.ghyeok.stickyswitch.widget.StickySwitch;
import three.version.project.amourversionfor.Util.BottomNavigationViewExHelper;
import three.version.project.amourversionfor.Util.Permissions;

/**
 * Created by Ibraim on 20.02.2018.
 */

public class NotificationActivity extends AppCompatActivity{
    private Context thisContext=NotificationActivity.this;
    private static final int ACTIVITY_NUM=3;
    private static final String TAG="NotificationActivity";



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        Log.d(TAG,"Oncreate: started");
        //setupBottomNavigationViewEx();



    }

    private void setupBottomNavigationViewEx(){

        Log.d(TAG,"SetupBottomaNavigationView:setup up");
        BottomNavigationViewEx bottomNavigationViewEx=(BottomNavigationViewEx) findViewById(R.id.bottom_nav_view);
        BottomNavigationViewExHelper.setupNavigationViewHelp(bottomNavigationViewEx);
        BottomNavigationViewExHelper.enableNavigation(thisContext,bottomNavigationViewEx,ACTIVITY_NUM);
        Menu menu=bottomNavigationViewEx.getMenu();
        MenuItem menuItem=menu.getItem(ACTIVITY_NUM);
        menuItem.setChecked(true);
    }

}
