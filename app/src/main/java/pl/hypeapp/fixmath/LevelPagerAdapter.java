package pl.hypeapp.fixmath;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by PrzemekEnterprise on 04.01.2016.
 */
public class LevelPagerAdapter extends FragmentPagerAdapter {
    public LevelPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new FragmentLevelPage1();
            case 1:
                return new FragmentLevelPage2();
            case 2:
                return new FragmentLevelPage3();
            case 3:
                return new FragmentLevelPage4();
            default:
                break;
        }
        return null;
    }

    @Override
    public int getCount() {
        return 4;
    }
}
