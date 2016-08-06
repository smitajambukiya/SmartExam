package com.smartexam.germanium.smartexam.fragement;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.smartexam.germanium.smartexam.ChangePasswordActivity;
import com.smartexam.germanium.smartexam.EditProfileActivity;
import com.smartexam.germanium.smartexam.R;


/**
 * Created by AndroidDevloper on 2/8/2016.
 */
public class FragmentProfile extends BaseFragment {

    View view;
    LinearLayout lneditProfile;
    LinearLayout lnchangepassword;
    LinearLayout lnInviteFreind;
    LinearLayout lnLogout;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        view = inflater.inflate(R.layout.activity_setting, null, false);

        init();


        lneditProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(getActivity(), EditProfileActivity.class);
                startActivity(in);
            }
        });

        lnchangepassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(getActivity(), ChangePasswordActivity.class);
                startActivity(in);
            }
        });

        lnInviteFreind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Invited", Toast.LENGTH_SHORT).show();
            }
        });
        lnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Logou", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }

    private void init() {
        lneditProfile = (LinearLayout) view.findViewById(R.id.lneditProfile);
        lnchangepassword = (LinearLayout) view.findViewById(R.id.lnchangepassword);
        lnInviteFreind = (LinearLayout) view.findViewById(R.id.lnInviteFreind);
        lnLogout = (LinearLayout) view.findViewById(R.id.lnLogout);
    }


}

