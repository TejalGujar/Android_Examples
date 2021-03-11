package com.example.tabactivity;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.tabactivity.TabFragment.CallFragment;
import com.example.tabactivity.TabFragment.ChatFragment;
import com.example.tabactivity.TabFragment.StatusFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class TabActivity extends AppCompatActivity
{
    ViewPager mViewPager;
    TabLayout mTabLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.tab_activity_layout);

        mTabLayout = findViewById(R.id.tablelayout);
        mViewPager = findViewById(R.id.viewpager_id);

        MyViewPagerAdapter myViewPagerAdapter = new MyViewPagerAdapter(getSupportFragmentManager());
        myViewPagerAdapter.addFragment(new ChatFragment(), "CHAT");
        myViewPagerAdapter.addFragment(new StatusFragment(), "STATUS");
        myViewPagerAdapter.addFragment(new CallFragment(), "CALL");

        mViewPager.setAdapter(myViewPagerAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
    }
    class MyViewPagerAdapter extends FragmentPagerAdapter
    {
        final List<Fragment> listFragment = new ArrayList<>();
        final  List<String> listTitles = new ArrayList<>();

        public MyViewPagerAdapter(@NonNull FragmentManager fm)
        {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return listFragment.get(position);
        }

        @Override
        public int getCount() {
            return listFragment.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return listTitles.get(position);
        }

        public void addFragment(Fragment fragment, String title)
        {
            listFragment.add(fragment);
            listTitles.add(title);
        }
    }
}
