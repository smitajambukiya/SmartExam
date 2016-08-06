package com.smartexam.germanium.smartexam.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.smartexam.germanium.smartexam.R;


public class FooterPagerAdapter extends PagerAdapter {

    private Activity _activity;
    private LayoutInflater inflater;
    int a[] = {R.drawable.home_mentoring_card, R.drawable.home_specials_card, R.drawable.home_quizzo_card, R.drawable.home_mentoring_card, R.drawable.home_specials_card};


    // constructor
    public FooterPagerAdapter(Activity activity) {
        this._activity = activity;


    }

    @Override
    public int getCount() {
        return 5;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((LinearLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        inflater = (LayoutInflater) _activity
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View viewLayout = inflater.inflate(R.layout.pager_footer, container,
                false);
        ImageView ivFooter = (ImageView) viewLayout.findViewById(R.id.ivFooter);
        LinearLayout lnAdd = (LinearLayout) viewLayout.findViewById(R.id.lnAdd);


        ((ViewPager) container).addView(viewLayout);

        ivFooter.setBackgroundResource(a[position]);

        return viewLayout;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ((ViewPager) container).removeView((LinearLayout) object);

    }

}
