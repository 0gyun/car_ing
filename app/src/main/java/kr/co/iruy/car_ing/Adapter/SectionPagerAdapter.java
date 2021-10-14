package kr.co.iruy.car_ing.Adapter;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import kr.co.iruy.car_ing.PlazaFragment;
import kr.co.iruy.car_ing.RecommendFragment;
import kr.co.iruy.car_ing.StudyFragment;

public class SectionPagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> fragmentList = new ArrayList<>();
    private List<String> titleList = new ArrayList<>();

    public SectionPagerAdapter(FragmentManager fm){
        super(fm);
    }
    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0:
                return new RecommendFragment();
            case 1:
                return new PlazaFragment();
            case 2:
                return new StudyFragment();
            default:
                return new RecommendFragment();
        }
    }

    @Override
    public int getCount() {
        return  fragmentList.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titleList.get(position);
    }

    public void addFragment(Fragment fragment, String title){
        fragmentList.add(fragment);
        titleList.add(title);
    }
}
