package com.example.ysbeh.tarcianapps;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ysbeh.tarcianapps.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class CourseInfoFragment extends Fragment {


    public CourseInfoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_course_info, container, false);
        // Inflate the layout for this fragment
        return view;
    }

}
