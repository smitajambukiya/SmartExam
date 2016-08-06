package com.smartexam.germanium.smartexam;

import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.smartexam.germanium.smartexam.fragement.FragmentDashBoard;
import com.smartexam.germanium.smartexam.fragement.FragmentProfile;
import com.smartexam.germanium.smartexam.fragement.FragmentQuiz;
import com.smartexam.germanium.smartexam.fragement.FragmentQuizHistory;

;

public class NavActivity extends AppCompatActivity {

    private DrawerLayout mDrawer;
    private Toolbar toolbar;
    NavigationView nvDrawer;
    ActionBarDrawerToggle drawerToggle;

    boolean doubleBackToExitPressedOnce = false;

    public TextView tvLeftUser;

    ImageView imageView;

    public enum FRAG_NAME{
        DASHBOARD,QUIZ,QUIZ_HISTORY,SETTING,ABOUT_US
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav);

        // Set a Toolbar to replace the ActionBar.
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Find our drawer view
        mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerToggle = setupDrawerToggle();

        // Tie DrawerLayout events to the ActionBarToggle
        mDrawer.setDrawerListener(drawerToggle);

        // Find our drawer view
        mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        nvDrawer = (NavigationView) findViewById(R.id.nvView);
        // Setup drawer view
        setupDrawerContent(nvDrawer);

//        View nav_header = nvDrawer.inflateHeaderView(R.layout.nav_header);

        View nav_header = nvDrawer.getHeaderView(0);

        imageView = (ImageView) nav_header.findViewById(R.id.ivLeftProfile);
        tvLeftUser = (TextView) nav_header.findViewById(R.id.tvLeftUser);


        // set news feed
        // Insert the fragment by replacing any existing fragment
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.flContent, new FragmentDashBoard()).commit();
        setTitle(R.string.nav1);
        //  ((MenuItem)findViewById(R.id.nav_news_fragment)).setChecked(true);


    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);


        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // The action bar home/up action should open or close the drawer.
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawer.openDrawer(GravityCompat.START);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    // Make sure this is the method with just `Bundle` as the signature
    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        drawerToggle.syncState();

    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Pass any configuration change to the drawer toggles
        drawerToggle.onConfigurationChanged(newConfig);
    }

    private void setupDrawerContent(NavigationView navigationView) {

        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        selectDrawerItem(menuItem);
                        return true;
                    }
                });
    }

    public void selectDrawerItem(MenuItem menuItem) {
        // Create a newlbanner fragment and specify the planet to show based on
        // position
        switch (menuItem.getItemId()) {
            case R.id.nav_home_fragment:
                replaceFragment(new FragmentDashBoard());
                break;
            case R.id.nav_quiz_fragment:
                replaceFragment(new FragmentQuiz());
                break;
            case R.id.nav_quizHistory_fragment:
                replaceFragment(new FragmentQuizHistory());
                break;
            case R.id.nav_setting_fragment:
                replaceFragment(new FragmentProfile());
                break;
            case R.id.nav_about_fragment:
                replaceFragment(new FragmentDashBoard());
                break;
            default:
                replaceFragment(new FragmentDashBoard());
        }
        // Highlight the selected item, update the title, and close the drawer
        menuItem.setChecked(true);
        setTitle(menuItem.getTitle());
        mDrawer.closeDrawers();
    }


    private void replaceFragment(Fragment myFragment) {

        // Insert the fragment by replacing any existing fragment
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.flContent, myFragment).commit();

    }


    public void replaceFragment(FRAG_NAME frag_name) {

            Fragment myFragment;
            switch (frag_name){
                case DASHBOARD:
                    myFragment = new FragmentDashBoard();
                    break;
                case QUIZ:
                    myFragment = new FragmentQuiz();
                    break;
                case  QUIZ_HISTORY:
                    myFragment = new FragmentQuizHistory();
                    break;
                case SETTING:
                    myFragment = new FragmentProfile();
                    break;
                case  ABOUT_US:
                    myFragment = new FragmentDashBoard();
                    break;
                default:
                    myFragment = new FragmentDashBoard();
                    break;
            }

        // Insert the fragment by replacing any existing fragment
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.flContent, myFragment).commit();
        setTitle(getTitle());

    }

    private ActionBarDrawerToggle setupDrawerToggle() {
        return new ActionBarDrawerToggle(this, mDrawer, toolbar, R.string.app_name, R.string.app_name);
    }


    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }
        this.doubleBackToExitPressedOnce = true;

        Toast.makeText(NavActivity.this, "Press BACK again to exit", Toast.LENGTH_SHORT).show();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                doubleBackToExitPressedOnce = false;
            }
        }, 2000);

    }

}

