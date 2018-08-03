package com.example.ysbeh.tarcianapps;


import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.ysbeh.tarcianapps.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.jar.JarException;

import static com.google.android.gms.internal.zzs.TAG;

/**
 * A simple {@link Fragment} subclass.
 */
public class TimetableFragment extends Fragment {
    FloatingActionButton x;
    ListView timetablelist;
    Spinner timetableSpinner;
    List<Timetable> arrayOfTimetable;
    TimetableAdapter adapter;
    private ProgressDialog pDialog;
    String timetableid;
    public TimetableFragment() {
        // Required empty public constructor
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        x=(FloatingActionButton)getActivity().findViewById(R.id.fab);
        x.setVisibility(View.INVISIBLE);
        timetablelist= (ListView) getActivity().findViewById(R.id.timetableList);
        timetableSpinner=(Spinner)getActivity().findViewById(R.id.timetableSpinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),R.array.day_list, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        timetableSpinner.setAdapter(adapter);



        registerForContextMenu(timetablelist);
        pDialog = new ProgressDialog(getActivity());
        arrayOfTimetable=new ArrayList<>();


        timetableSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                if(position==0){
                    sendRequest(timetableid,"Monday");
                }else if(position==1){
                    sendRequest(timetableid,"Tuesday");
                }else if(position==2){
                    sendRequest(timetableid,"Wednesday");
                }else if(position==3){
                    sendRequest(timetableid,"Thursday");
                }else if(position==4){
                    sendRequest(timetableid,"Friday");
                }else if(position==5){
                    sendRequest(timetableid,"Saturday");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                sendRequest(timetableid,new SimpleDateFormat("EEEE", Locale.ENGLISH).format(System.currentTimeMillis()));
            }
        } );
        Date d = new Date();
        sendRequest(timetableid,(String)(android.text.format.DateFormat.format("EEEE", d)));

        Intent x=getActivity().getIntent();
       // x.getStringExtra("");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_timetable, container, false);
        timetableid="rsf2"; //<<----------timetableid here

        // Inflate the layout for this fragment
        return view;
    }

    public void sendRequest(String timetableid,String day){
        try {
            String url =getActivity().getApplicationContext().getString(R.string.select_timetable_url);
            makeServiceCall(getActivity(), url , timetableid,day);
           // finish();
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(getActivity().getApplicationContext(), "Error: " + e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    public void makeServiceCall(Context context, String url, final String timetableid,final String day){
        //mPostCommentResponse.requestStarted();
        RequestQueue queue = Volley.newRequestQueue(context);

        //Send data
        try {
            StringRequest postRequest = new StringRequest(
                    Request.Method.POST,
                    url,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            Toast.makeText(getActivity().getApplicationContext(), "Done retreive ", Toast.LENGTH_LONG).show();
                            try{
                                JSONArray x=new JSONArray(response);
                                arrayOfTimetable.clear();
                                for(int i=0; i < x.length();i++){
                                    JSONObject courseResponse = (JSONObject) x.get(i);

                                    String subject_code = courseResponse.getString("subject_code");
                                    String timetable_id=courseResponse.getString("timetable_id");
                                    String time = courseResponse.getString("time");
                                    String venue = courseResponse.getString("venue");
                                    String tutor = courseResponse.getString("tutor");
                                    String day = courseResponse.getString("day");

                                    Timetable timetable = new Timetable(subject_code,time,venue,tutor,day);
                                    //Add a new course to list

                                    arrayOfTimetable.add(timetable);


                                }

                                loadtimetable();
                                if (pDialog.isShowing())
                                    pDialog.dismiss();
                            }catch (Exception e){
                                Toast.makeText(getActivity().getApplicationContext(), "Error:" + e.getMessage(), Toast.LENGTH_LONG).show();
                            }
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(getActivity().getApplicationContext(), "Error. " + error.toString(), Toast.LENGTH_LONG).show();
                        }
                    }){
                //type here bobo
                @Override
                protected Map<String, String> getParams() {
                    Map<String, String> params = new HashMap<>();
                    params.put("timetableid", timetableid);
                    params.put("day",day);
                    return params;
                }

                @Override
                public Map<String, String> getHeaders() throws AuthFailureError {
                    Map<String, String> params = new HashMap<>();
                    params.put("Content-Type", "application/x-www-form-urlencoded");
                    return params;
                }


            };


            queue.add(postRequest);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void loadtimetable(){
        adapter=new TimetableAdapter(getActivity(),R.layout.timetable_layout,arrayOfTimetable);
        timetablelist.setAdapter(adapter);
        Toast.makeText(getActivity().getApplicationContext(), "Done Load timetable", Toast.LENGTH_SHORT).show();
    }
}
