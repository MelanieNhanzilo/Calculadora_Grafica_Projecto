package mz.ac.isutc.i32.mt2.calculadora;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.List;

public class MyPagerAdapterCalculos extends FragmentPagerAdapter {

    private final List<Fragment> fragments;

    public MyPagerAdapterCalculos (FragmentManager fm, List fragments) {
        super(fm);
        this.fragments=fragments;
    }
    @NonNull
    @Override
    public Fragment getItem(int position) {
        return this.fragments.get(position);
    }
    @Override
    public int getCount() {
        return fragments.size();
    }
}
