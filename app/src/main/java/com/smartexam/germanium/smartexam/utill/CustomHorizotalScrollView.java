package com.smartexam.germanium.smartexam.utill;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsoluteLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.smartexam.germanium.smartexam.R;

/**
 * Created by AndroidDevloper on 7/31/2016.
 */
public class CustomHorizotalScrollView extends HorizontalScrollView {
    LinearLayout linearLayoutParent;
    int max_len = 15;
    int color_selected, color_unselected;
    OnNumberClickListener onNumberClickListener;

    public CustomHorizotalScrollView(Context context) {
        super(context);
        init(context);
    }

    public CustomHorizotalScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    @Override
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    public void init(Context context) {
        setHorizontalScrollBarEnabled(false);
        color_selected = context.getResources().getColor(android.R.color.white);
        color_unselected = context.getResources().getColor(android.R.color.black);
        linearLayoutParent = new LinearLayout(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        linearLayoutParent.setLayoutParams(layoutParams);
        linearLayoutParent.setOrientation(LinearLayout.HORIZONTAL);

        addTextView(context);
        addView(linearLayoutParent);
    }

    public void setMaxLength(int len) {
        this.max_len = len;
    }

    public int getMaxLength() {
        return max_len;
    }

    public void addTextView(Context context) {
        for (int i = 0; i < getMaxLength(); i++) {
            final TextView textView = new TextView(context);
            textView.setText("" + (i + 1));
            textView.setPadding(20, 10, 20, 10);
            textView.setTag(i);
            textView.setTextSize(15f);
            textView.setTextColor(color_unselected);
            textView.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    unSelectedText();
                    onNumberClickListener.onClicked((int) textView.getTag());
                }
            });
            linearLayoutParent.addView(textView);
        }
    }

    public void unSelectedText() {
        for (int i = 0; i < linearLayoutParent.getChildCount(); i++) {
            TextView textView = (TextView) linearLayoutParent.findViewWithTag(i);
            textView.setTextColor(color_unselected);
            textView.setBackgroundResource(android.R.color.transparent);
        }
    }

    public void setSelectedNumber(int position) {
        unSelectedText();

        TextView textView = (TextView) linearLayoutParent.findViewWithTag(position);
        textView.setTextColor(color_selected);
        textView.setBackgroundResource(R.drawable.round_circle);
        ViewGroup.LayoutParams params = textView.getLayoutParams();
        params.height = 50;
        textView.setLayoutParams(params);

        scrollTo(textView.getLeft(), textView.getTop());
    }

    public void setOnNumberClikListner(OnNumberClickListener onNumberClikListner) {
        this.onNumberClickListener = onNumberClikListner;
    }

    public interface OnNumberClickListener {
        void onClicked(int position);
    }

}
