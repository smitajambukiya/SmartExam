package com.smartexam.germanium.smartexam;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.smartexam.germanium.smartexam.adapter.CustomGridAdapter;
import com.smartexam.germanium.smartexam.utill.CustomHorizotalScrollView;
import com.smartexam.germanium.smartexam.utill.Helper;


public class Qustionary extends AppCompatActivity {

    Button mNextButton;
    Button mPrevButton, mButton_rev;
    Toolbar toolbar;
    ViewPager viewPager;
    CustomHorizotalScrollView hsvMain;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        init();

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        hsvMain.setMaxLength(10);

        hsvMain.setOnNumberClikListner(new CustomHorizotalScrollView.OnNumberClickListener() {
            @Override
            public void onClicked(int position) {
                viewPager.setCurrentItem(position);
            }
        });
        MyPagerAdapter myPagerAdapter = new MyPagerAdapter();
        viewPager.setAdapter(myPagerAdapter);

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

//                for(int i = 1; i<= llParent.getChildCount();i++){
//                    TextView textView = (TextView) llParent.findViewWithTag(i);
//                    textView.setTextColor(getResources().getColor(R.color.color_black));
//                }
//                TextView tv = (TextView) llParent.findViewWithTag(position);
//                tv.setTextColor(getResources().getColor(R.color.colorPrimary));
//                hsvMain.scrollTo(tv.getLeft(),tv.getTop());
                hsvMain.setSelectedNumber(position);

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


    }


    private void init() {

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        hsvMain = (CustomHorizotalScrollView) findViewById(R.id.hsvMain);
        //Button
        mNextButton = (Button) findViewById(R.id.next_button);
        mPrevButton = (Button) findViewById(R.id.prev_button);
        mButton_rev = (Button) findViewById(R.id.buton_rev);
    }

    private void customdialog() {

        String subject[] = {"English", "Maths", "Science", "History", "Account", "Hindi", "Gujarati", "English", "Maths", "Science", "History", "Account", "Hindi", "Gujarati"};

        CustomGridAdapter customGridAdapter1 = new CustomGridAdapter(this, 1);
        CustomGridAdapter customGridAdapter2 = new CustomGridAdapter(this, 2);
        CustomGridAdapter customGridAdapter3 = new CustomGridAdapter(this, 3);
        CustomGridAdapter customGridAdapter4 = new CustomGridAdapter(this, 4);

        Dialog materialDialog = new Dialog(this);
        materialDialog.setTitle("Review");
        materialDialog.setContentView(R.layout.activity_dialog);
        Helper gridViewAnswered = (Helper) materialDialog.findViewById(R.id.gridAnswerd);
        Helper gridViewNotAnswered = (Helper) materialDialog.findViewById(R.id.gridNotAnswerd);
        Helper gridViewMarked = (Helper) materialDialog.findViewById(R.id.gridMarked);
        Helper gridViewNotVisited = (Helper) materialDialog.findViewById(R.id.gridNot);

        gridViewAnswered.setExpanded(true);
        gridViewNotAnswered.setExpanded(true);
        gridViewMarked.setExpanded(true);
        gridViewNotVisited.setExpanded(true);
        gridViewAnswered.setAdapter(customGridAdapter1);
        gridViewNotAnswered.setAdapter(customGridAdapter2);
        gridViewMarked.setAdapter(customGridAdapter3);
        gridViewNotVisited.setAdapter(customGridAdapter4);

        materialDialog.show();


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.timer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            case R.id.action_name:
                Toast.makeText(this, "finish", Toast.LENGTH_SHORT).show();
                this.finish();
                break;
            case R.id.action_counter:
                Toast.makeText(this, "finish", Toast.LENGTH_SHORT).show();
                this.finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void clickPrev(View view) {
        Toast.makeText(this, "Prev", Toast.LENGTH_SHORT).show();
    }

    public void clickRev(View view) {
        Toast.makeText(this, "Rev", Toast.LENGTH_SHORT).show();
        customdialog();
    }

    public void clickNext(View view) {
        Toast.makeText(this, "Next", Toast.LENGTH_SHORT).show();
    }

    public class MyPagerAdapter extends PagerAdapter {
        public int getCount() {
            return 15;
        }

        public Object instantiateItem(ViewGroup collection, int position) {
            LayoutInflater inflater = (LayoutInflater) collection.getContext()
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View view = inflater.inflate(R.layout.activity_question_row, null);
            TextView textView = (TextView) view.findViewById(R.id.textView);
            textView.setText("position is :" + position);
            ((ViewPager) collection).addView(view, 0);
            return view;
        }

        @Override
        public void destroyItem(ViewGroup arg0, int arg1, Object arg2) {
            ((ViewPager) arg0).removeView((View) arg2);
        }

        @Override
        public boolean isViewFromObject(View arg0, Object arg1) {
            return arg0 == ((View) arg1);
        }

        //public boolean isViewFromObject(ViewGroup arg0, Object arg1) {
        // return arg0 == ((View) arg1);
        //}
        @Override
        public Parcelable saveState() {
            return null;
        }
    }
}