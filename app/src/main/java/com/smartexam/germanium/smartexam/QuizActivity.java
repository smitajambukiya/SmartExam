package com.smartexam.germanium.smartexam;

import android.app.Dialog;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.GridView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.badoualy.stepperindicator.StepperIndicator;
import com.smartexam.germanium.smartexam.adapter.CustomGridAdapter;
import com.smartexam.germanium.smartexam.utill.Helper;


public class QuizActivity extends AppCompatActivity {

    private Button mNextButton;
    private Button mPrevButton, mButton_rev;
    Toolbar toolbar;
    ViewPager pager;
    StepperIndicator indicator;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        init();

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        assert pager != null;
        pager.setAdapter(new EmptyPagerAdapter(getSupportFragmentManager()));

        assert indicator != null;
        // We keep last page for a "finishing" page
        indicator.setViewPager(pager, true);


        mButton_rev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                customdialog();
            }
        });


    }

    private void customdialog() {

        String subject[] = {"English", "Maths", "Science", "History", "Account", "Hindi", "Gujarati", "English", "Maths", "Science", "History", "Account", "Hindi", "Gujarati"};

        CustomGridAdapter customGridAdapter1 = new CustomGridAdapter(QuizActivity.this, 1);
        CustomGridAdapter customGridAdapter2 = new CustomGridAdapter(QuizActivity.this, 2);
        CustomGridAdapter customGridAdapter3 = new CustomGridAdapter(QuizActivity.this, 3);
        CustomGridAdapter customGridAdapter4 = new CustomGridAdapter(QuizActivity.this, 4);

        Dialog materialDialog = new Dialog(QuizActivity.this);
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

    private void init() {

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        pager = (ViewPager) findViewById(R.id.pager);
        indicator = (StepperIndicator) findViewById(R.id.stepper_indicator);


        mNextButton = (Button) findViewById(R.id.next_button);
        mPrevButton = (Button) findViewById(R.id.prev_button);
        mButton_rev = (Button) findViewById(R.id.buton_rev);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


    public static class PageFragment extends Fragment {

        private TextView lblPage;

        public static PageFragment newInstance(int page, boolean isLast) {
            Bundle args = new Bundle();
            args.putInt("page", page);
            if (isLast)
                args.putBoolean("isLast", true);
            final PageFragment fragment = new PageFragment();
            fragment.setArguments(args);
            return fragment;
        }

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            final View view = inflater.inflate(R.layout.fragment_page2, container, false);
            lblPage = (TextView) view.findViewById(R.id.lbl_page);
            return view;
        }

        @Override
        public void onActivityCreated(@Nullable Bundle savedInstanceState) {
            super.onActivityCreated(savedInstanceState);
            final int page = getArguments().getInt("page", 0);
            if (getArguments().containsKey("isLast"))
                lblPage.setText("Who is primeministor of India ?");
            else
                lblPage.setText("Who is primeministor of India ?");
        }
    }

    private static class EmptyPagerAdapter extends FragmentPagerAdapter {

        public EmptyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return 6;
        }

        @Override
        public Fragment getItem(int position) {
            return PageFragment.newInstance(position + 1, position == getCount() - 1);
        }

    }

    //Custom Grid

}