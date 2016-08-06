package com.smartexam.germanium.smartexam.fragement;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.smartexam.germanium.smartexam.NavActivity;
import com.smartexam.germanium.smartexam.R;
import com.smartexam.germanium.smartexam.adapter.FooterPagerAdapter;
import com.smartexam.germanium.smartexam.custom.AutoScrollViewPager;


/**
 * Created by AndroidDevloper on 2/8/2016.
 */
public class FragmentDashBoard extends BaseFragment {


    AutoScrollViewPager autoScrollPager;
    View view;
    LinearLayout ln1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        view = inflater.inflate(R.layout.activity_dashboard, null, false);
        init();
        return view;
    }

    private void init() {
        autoScrollPager = (AutoScrollViewPager) view.findViewById(R.id.pager_adv);
        ln1 = (LinearLayout) view.findViewById(R.id.ln1);
        final FooterPagerAdapter adapter = new FooterPagerAdapter(getActivity());
        autoScrollPager.setAdapter(adapter);
        autoScrollPager.startAutoScroll();

        ln1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mActivity.replaceFragment(NavActivity.FRAG_NAME.QUIZ);
            }
        });

    }


}

