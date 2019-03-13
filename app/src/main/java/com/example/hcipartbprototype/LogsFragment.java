package com.example.hcipartbprototype;


import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LogsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LogsFragment extends Fragment {
    public static final String TAG = "LogsFragment";
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private ArrayList<LogEntry> logs;

    public LogsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment LogsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static LogsFragment newInstance(String param1, String param2) {
        LogsFragment fragment = new LogsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_logs, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        logs = new ArrayList<>();
        Resources res = getResources();
        logs.add(new LogEntry(res.getString(R.string.logs_1_date),res.getString(R.string.log_1_title),res.getString(R.string.log_1_content)));
        ((EditText)view.findViewById(R.id.log1_content)).setInputType(InputType.TYPE_NULL);
    }
}
