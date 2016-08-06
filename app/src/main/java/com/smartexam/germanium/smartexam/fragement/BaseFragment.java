package com.smartexam.germanium.smartexam.fragement;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.smartexam.germanium.smartexam.NavActivity;


/**
 * Created by Android on 12/30/2015.
 */
public class BaseFragment extends Fragment {
    protected NavActivity mActivity;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = (NavActivity) this.getActivity();
    }


}
