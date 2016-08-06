package com.smartexam.germanium.smartexam.fragement;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.smartexam.germanium.smartexam.InstructionActivity;
import com.smartexam.germanium.smartexam.Qustionary;
import com.smartexam.germanium.smartexam.R;
import com.smartexam.germanium.smartexam.adapter.CustomListAdapter;


/**
 * Created by AndroidDevloper on 2/8/2016.
 */
public class FragmentQuiz extends BaseFragment {


    ListView mListview;
    CustomListAdapter adapter;
    String subject[] = {"English", "Maths", "Science", "History", "Account", "Hindi", "Gujarati"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        View view = inflater.inflate(R.layout.activity_examhistory, null, false);

        //Intilize
        mListview = (ListView) view.findViewById(R.id.list_item);

        //setting to adapter;
        adapter = new CustomListAdapter(getActivity(), subject);

        mListview.setAdapter(adapter);

        //Click on the listview

        mListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent in = new Intent(getActivity(), InstructionActivity.class);
                startActivity(in);
            }
        });

        return view;
    }


}

