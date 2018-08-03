package com.example.ysbeh.tarcianapps;

import android.content.Context;

import android.support.v7.app.AppCompatActivity;

import android.widget.Button;

import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.ysbeh.tarcianapps.R;

import java.util.HashMap;
import java.util.Map;
/**
 * A simple {@link Fragment} subclass.
 */
public class ReportFragment extends Fragment {
    Spinner reportSpinner;
    EditText reportMessageEditText;
    Button submitReport;
    public ReportFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_report, container, false);
        reportSpinner=(Spinner)view.findViewById(R.id.reportSpinner);
        reportMessageEditText=(EditText)view.findViewById(R.id.reportMessageEditText);
        submitReport=(Button)view.findViewById(R.id.buttonSubmitError);
        // Inflate the layout for this fragment


        //Bundle bundle = getIntent().getExtras();

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),R.array.report_list, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        reportSpinner.setAdapter(adapter);
        submitReport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveRecord(view);

            }
        });
        return view;
    }


    public void saveRecord(View v) {
        if(reportMessageEditText.getText().length()==0){
            reportMessageEditText.setError("Please leave some comment~ tq.");
            return;
        }
        if(reportSpinner.getSelectedItemPosition()==0){
            Toast.makeText(getActivity(),"Please choose an error category",Toast.LENGTH_LONG).show();
            return;
        }



        try {
            String url = this.getString(R.string.insert_course_url);
            makeServiceCall(this.getContext(), url , reportSpinner.getAdapter().getItem(reportSpinner.getSelectedItemPosition()).toString(),reportMessageEditText.getText().toString());
            //getActivity().finish();
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(getActivity(), "Error: " + e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    public void makeServiceCall(Context context, String url, final String errorType,final String errorMessage){
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
                            Toast.makeText(getActivity(), "Your report has sent to the server", Toast.LENGTH_LONG).show();
                            ((MainActivity)getActivity()).killFragment();
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(getActivity(), "Error. " + error.toString(), Toast.LENGTH_LONG).show();
                        }
                    }){
                @Override
                protected Map<String, String> getParams() {
                    Map<String, String> params = new HashMap<>();
                    params.put("error_type", errorType);
                    params.put("error_message", errorMessage);

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
}
