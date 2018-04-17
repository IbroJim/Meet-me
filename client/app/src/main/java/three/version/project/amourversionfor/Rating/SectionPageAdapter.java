package three.version.project.amourversionfor.Rating;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ibraim on 20.02.2018.
 */

public class SectionPageAdapter extends FragmentPagerAdapter {

    private List<Fragment> mFragment=new ArrayList<>();
    private List<String> mTitleFragment=new ArrayList<>();

    public void addFragment(Fragment fragment,String title){
        mFragment.add(fragment);
        mTitleFragment.add(title);
    }

    public SectionPageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitleFragment.get(position);
    }

    @Override
    public Fragment getItem(int position) {
        return mFragment.get(position);
    }

    @Override
    public int getCount() {
        return mFragment.size();
    }
}
