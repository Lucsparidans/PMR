package com.example.hcipartbprototype.Fragments.CustomWidgets;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.example.hcipartbprototype.Fragments.Screens.LogsFragment;
import com.example.hcipartbprototype.LogEntry;
import com.example.hcipartbprototype.R;

import java.util.Date;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;

public class LogEntryCardFragment extends Fragment {
    private EditText inputBox;
    private TextView dateLabel;
    private LogEntry data;
    private static int logID = 0;
    private int id;
    private NavController navController;
    public LogEntryCardFragment() {
    }
    public static LogEntryCardFragment newInstance() {

        Bundle args = new Bundle();

        LogEntryCardFragment fragment = new LogEntryCardFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        id = ++logID;
        data = new LogEntry(new Date(), "log" + id, "");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.log_entry_card,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        inputBox = view.findViewById(R.id.edit_query);
        dateLabel = view.findViewById(R.id.log_date);
        inputBox.setInputType(InputType.TYPE_NULL);
        dateLabel.setText(data.getDate());

        navController = Navigation.findNavController(getActivity(),R.id.logs_navHost);
        dateLabel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_logsContainerFragment_to_calendarCardFragment);
            }
        });

    }

    public EditText getInputBox() {
        return inputBox;
    }

    public TextView getDateLabel() {
        return dateLabel;
    }

    public LogEntry getData() {
        return data;
    }

    public static int getLogID() {
        return logID;
    }


    public int getEntryId() {
        return id;
    }
}
