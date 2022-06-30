package com.example.freetrip.ui.mine.view.travel;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.freetrip.R;

public class DemoObjectFragment extends Fragment {
    public static final String ARG_OBJECT = "object";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_collection_object, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Bundle args = getArguments();
        assert args != null;
        String flag = Integer.toString(args.getInt(ARG_OBJECT));

        if (args.getInt(ARG_OBJECT) == 1) {
            ((TextView)view.findViewById(R.id.date1)).setText("出发日期：2021-09-04");
            ((TextView)view.findViewById(R.id.date2)).setText("出发日期：2022-07-01");
            ((TextView)view.findViewById(R.id.info1)).setText("敦煌->西安  2021-09-04  15:30-17:45\n" +
                    "                        MU2216\n" +
                    "            西安->武汉  2021-09-05  19:55-21:30\n" +
                    "MU2462");
            ((TextView)view.findViewById(R.id.info2)).setText("武汉->厦门 2022-07-01  19:30-21:15\n" +
                    "国航CA8227 空客320");
        } else {
            ((TextView)view.findViewById(R.id.date1)).setText("出发日期：2022-07-05");
            ((TextView)view.findViewById(R.id.date2)).setText("出发日期：2022-07-06");
            ((TextView)view.findViewById(R.id.info1)).setText("武汉->永康南 2022-07-05 09:20-14:49\n" +
                    "                          G2040");
            ((TextView)view.findViewById(R.id.info2)).setText("武汉站->长沙站 2022-07-06 07:37-09:09\n" +
                    "                          G1105");
        }
    }
}