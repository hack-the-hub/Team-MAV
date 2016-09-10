package industries.mav.localbuddy;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;


import io.fabric.sdk.android.Fabric;

public class MainActivity extends AppCompatActivity
{
    private static final String TAG = "MainActivity";

    //Views
//    private Toolbar mToolbar;
    private TabLayout mTabLayout;
    private ViewPager mPager;

    private int[] imageResIds = new int[]{R.drawable.newsicon,
            R.drawable.councilloricon,
            R.drawable.mapicon};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Fabric.with(this, LocalBuddyApplication.getTweetMan().getKits());

        mTabLayout = (TabLayout) findViewById(R.id.tabLayout);
        mTabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        mPager = (ViewPager) findViewById(R.id.pager);

        MainAdapter mainAdapter = new MainAdapter(getSupportFragmentManager(), this);
        mainAdapter = new MainAdapter(getSupportFragmentManager(), getApplicationContext());
        mPager.setAdapter(mainAdapter);

        mTabLayout.setupWithViewPager(mPager);

        for (int i = 0; i < mTabLayout.getTabCount(); i++) {
            TabLayout.Tab tab = mTabLayout.getTabAt(i);
            tab.setIcon(imageResIds[i]);
        }
    }

    protected static class MainAdapter extends FragmentPagerAdapter
    {
        private Fragment[] fragments = {new TwitterFeedFragment(), new CounsellorFragment(), new CounsellorFragment()};
        protected Context context;

        public MainAdapter(FragmentManager fm, Context context) {
            super(fm);
            this.context = context;
        }

        @Override
        public int getCount() {
            return fragments.length;
        }

        @Override
        public Fragment getItem(int position) {
            return fragments[position];
        }

    }
}
