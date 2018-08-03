package com.example.ysbeh.tarcianapps;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lee on 19/12/2016.
 */

public class TimetableAdapter extends ArrayAdapter<Timetable> {
    TextView timetableCourseText,timetableTimeText,tutorText,venueText,dayText;

    public TimetableAdapter(Context context, int resources,List<Timetable> timetable){
        super (context,resources,timetable);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Timetable timetable = getItem(position);


        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.custome_timetable_layout, parent, false);
        }
        // Lookup view for data population
        timetableCourseText = (TextView) convertView.findViewById(R.id.timetableCourseText);
        timetableTimeText = (TextView) convertView.findViewById(R.id.timetableTimeText);
        tutorText=(TextView)convertView.findViewById(R.id.tutorText);
        venueText=(TextView)convertView.findViewById(R.id.venueText);
        dayText=(TextView)convertView.findViewById(R.id.dayText);

        // Populate the data into the template view using the data object
        timetableCourseText.setText(timetable.getCourse());
        timetableTimeText.setText(timetable.getTime());
        tutorText.setText(timetable.getTutor());
        venueText.setText(timetable.getVenue());
        dayText.setText(timetable.getDay());
        // Return the completed view to render on screen
        return convertView;
    }

}
