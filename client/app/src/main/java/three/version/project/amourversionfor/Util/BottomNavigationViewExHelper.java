package three.version.project.amourversionfor.Util;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.view.MenuItem;

import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import three.version.project.amourversionfor.Home.HomeActivity;
import three.version.project.amourversionfor.NotificationActivity;
import three.version.project.amourversionfor.R;
import three.version.project.amourversionfor.Rating.RatingActivity;
import three.version.project.amourversionfor.Search.SearchActivity;

/**
 * Created by Ibraim on 19.02.2018.
 */

public class BottomNavigationViewExHelper  {
    public static void setupNavigationViewHelp(BottomNavigationViewEx bottomNavigationViewEx){
      // bottomNavigationViewEx.enableAnimation(false);
       bottomNavigationViewEx.enableItemShiftingMode(false);
       bottomNavigationViewEx.enableShiftingMode(false);
       bottomNavigationViewEx.setTextVisibility(false);
    }
    public static void enableNavigation(final Context context, BottomNavigationViewEx viewEx, final int positionActivity){
        viewEx.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home_id:
                        if(positionActivity!=0) {
                            Intent intent = new Intent(context, HomeActivity.class);//0
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            context.startActivity(intent);
                            break;
                        }
                        break;
                    case  R.id.searh_id:
                        if(positionActivity!=1) {
                            Intent intent1 = new Intent(context, SearchActivity.class);
                            intent1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            context.startActivity(intent1);
                            break;
                        }
                        break;
                   case R.id.rating_id:
                       if(positionActivity!=2) {
                           Intent intent2 = new Intent(context, RatingActivity.class);
                           intent2.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                           context.startActivity(intent2);
                           break;
                       }break;
                    case R.id.notification_id:
                        if(positionActivity!=3) {
                            Intent intent3 = new Intent(context, NotificationActivity.class);
                            intent3.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            context.startActivity(intent3);
                            break;
                        }break;
                }

                return false;
            }
        });
    }


}
