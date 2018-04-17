package three.version.project.amourversionfor.Rating;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import three.version.project.amourversionfor.R;
import three.version.project.amourversionfor.Util.BottomNavigationViewExHelper;

/**
 * Created by Ibraim on 19.02.2018.
 */

public class RatingActivity extends AppCompatActivity {

    private static final int ACTIVITY_NUM=2;
    private Context mContext=RatingActivity.this;
    private SectionPageAdapter sectionPageAdapter;
    private ViewPager mViewpager;
    private static final String TAG="RatingActivity";



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating);
        Log.d(TAG,"Oncreate: started");

        setupBottomNavigationViewEx();

        sectionPageAdapter=new SectionPageAdapter(getSupportFragmentManager());
        mViewpager=(ViewPager) findViewById(R.id.view_pagerid);
        setupViewPager(mViewpager);

        TabLayout tabLayout=(TabLayout) findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(mViewpager);
    }

    private void setupBottomNavigationViewEx(){

        Log.d(TAG,"SetupBottomaNavigationView:setuo up");
        BottomNavigationViewEx bottomNavigationViewEx=(BottomNavigationViewEx) findViewById(R.id.bottom_nav_view);
        BottomNavigationViewExHelper.setupNavigationViewHelp(bottomNavigationViewEx);
        BottomNavigationViewExHelper.enableNavigation(mContext,bottomNavigationViewEx,ACTIVITY_NUM);
        Menu menu=bottomNavigationViewEx.getMenu();
        MenuItem menuItem=menu.getItem(ACTIVITY_NUM);
        menuItem.setChecked(true);
    }

    private void setupViewPager(ViewPager viewPager){
        SectionPageAdapter adapter=new SectionPageAdapter(getSupportFragmentManager());
        adapter.addFragment(new BoyRatingFragment(),"Парни");
        adapter.addFragment(new GirlsRatingFragment(),"Девушки");
        viewPager.setAdapter(adapter);
    }

}
