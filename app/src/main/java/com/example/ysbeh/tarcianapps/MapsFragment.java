package com.example.ysbeh.tarcianapps;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import com.example.ysbeh.tarcianapps.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MapsFragment extends Fragment implements OnMapReadyCallback{
    FloatingActionButton x;
    private GoogleMap mMap;
    private Spinner mapSpinner;
    private LatLng taruc;
    private LatLng dk5 ;
    private LatLng dkaba;
    private LatLng blockc ;
    private LatLng blockk ;
    private LatLng citc;
    private LatLng tansiewsin;
    private LatLng khawkaiboh;
    private LatLng blockh;
    private LatLng blockb;
    private LatLng canteen1;
    private LatLng dk1;
    private LatLng dk2;
    private LatLng dk3;
    private LatLng dk4;
    private LatLng dk6;
    private LatLng dk7;
    private LatLng dk8;
    private LatLng blockd;
    private LatLng dkb;
    private LatLng blockpa;
    private LatLng blockp;
    private LatLng blockq;
    private  LatLng blockn;
    private LatLng dka;
    private LatLng blockr;
    private LatLng library;
    private LatLng blockm;
    private  LatLng canteen2;
    private LatLng blockl;
    private LatLng dkc;
    private LatLng dkd;
    private LatLng dkw;
    private LatLng dkx;
    private LatLng dky;
    private LatLng dkz;
    private LatLng sportcomplex;
    private LatLng swimmingpool;
    private LatLng clubhouse;
    private LatLng fernhouse;
    private LatLng collegehall;
    private LatLng dks;
    private LatLng blocky;
    private LatLng blockx;
    private LatLng blockw;
    private LatLng dke;
    private LatLng blockv;
    private LatLng dkabb;
    private LatLng dkabc;
    private  LatLng dkabd;
    private LatLng dkabe;
    private LatLng dkabf;


    private Marker currentMarker;
    private  Marker mTaruc ;
    private  Marker mDk5 ;
    private  Marker mDkaba ;
    private  Marker mBlockC ;
    private  Marker mBlockK ;
    //private  Button button2;
    public MapsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mapSpinner=(Spinner)getActivity().findViewById(R.id.mapSpinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),R.array.map_list, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mapSpinner.setAdapter(adapter);

        mapSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int choice, long l) {

                if (choice == 1) {
                    currentMarker.remove();
                    currentMarker =mMap.addMarker(new MarkerOptions().position(blockb).title("Block B"));
                    changeMap(blockb, currentMarker);
                } else if (choice == 2) {
                    currentMarker.remove();
                    currentMarker =mMap.addMarker(new MarkerOptions().position(blockc).title("Block C"));
                    changeMap(blockc, currentMarker);
                } else if (choice == 3) {
                    currentMarker.remove();
                    currentMarker =mMap.addMarker(new MarkerOptions().position(blockd).title("Block D"));
                    changeMap(blockd, currentMarker);
                }else if (choice == 4) {
                    currentMarker.remove();
                    currentMarker =mMap.addMarker(new MarkerOptions().position(blockh).title("Block H"));
                    changeMap(blockh, currentMarker);
                }else if (choice == 5) {
                    currentMarker.remove();
                    currentMarker =mMap.addMarker(new MarkerOptions().position(blockk).title("Block K"));
                    changeMap(blockk, currentMarker);
                }else if (choice == 6) {
                    currentMarker.remove();
                    currentMarker =mMap.addMarker(new MarkerOptions().position(blockl).title("Block L"));
                    changeMap(blockl, currentMarker);
                }else if (choice == 7) {
                    currentMarker.remove();
                    currentMarker =mMap.addMarker(new MarkerOptions().position(blockm).title("Block M"));
                    changeMap(blockm, currentMarker);
                }else if (choice ==8) {
                    currentMarker.remove();
                    currentMarker =mMap.addMarker(new MarkerOptions().position(blockn).title("Block N"));
                    changeMap(blockn, currentMarker);
                }else if (choice == 9) {
                    currentMarker.remove();
                    currentMarker =mMap.addMarker(new MarkerOptions().position(blockp).title("Block P"));
                    changeMap(blockp, currentMarker);
                }else if (choice == 10) {
                    currentMarker.remove();
                    currentMarker =mMap.addMarker(new MarkerOptions().position(blockpa).title("Block PA"));
                    changeMap(blockpa, currentMarker);
                }else if (choice == 11) {
                    currentMarker.remove();
                    currentMarker =mMap.addMarker(new MarkerOptions().position(blockq).title("Block Q"));
                    changeMap(blockq, currentMarker);
                }else if (choice == 12) {
                    currentMarker.remove();
                    currentMarker =mMap.addMarker(new MarkerOptions().position(blockr).title("Block R"));
                    changeMap(blockr, currentMarker);
                }else if (choice == 13) {
                    currentMarker.remove();
                    currentMarker =mMap.addMarker(new MarkerOptions().position(blockv).title("Block V"));
                    changeMap(blockv, currentMarker);
                }else if (choice == 14) {
                    currentMarker.remove();
                    currentMarker =mMap.addMarker(new MarkerOptions().position(blockw).title("Block W"));
                    changeMap(blockw, currentMarker);
                }else if (choice == 15) {
                    currentMarker.remove();
                    currentMarker =mMap.addMarker(new MarkerOptions().position(blockx).title("Block X"));
                    changeMap(blockx, currentMarker);
                }else if (choice == 16) {
                    currentMarker.remove();
                    currentMarker =mMap.addMarker(new MarkerOptions().position(blocky).title("Block Y"));
                    changeMap(blocky, currentMarker);
                }else if (choice == 17) {
                    currentMarker.remove();
                    currentMarker =mMap.addMarker(new MarkerOptions().position(canteen1).title("Canteen 1"));
                    changeMap(canteen1, currentMarker);
                }else if (choice == 18) {
                    currentMarker.remove();
                    currentMarker =mMap.addMarker(new MarkerOptions().position(canteen2).title("Canteen 2"));
                    changeMap(canteen2, currentMarker);
                }else if (choice == 19) {
                    currentMarker.remove();
                    currentMarker =mMap.addMarker(new MarkerOptions().position(citc).title("Citc"));
                    changeMap(citc, currentMarker);
                }else if (choice == 20) {
                    currentMarker.remove();
                    currentMarker =mMap.addMarker(new MarkerOptions().position(clubhouse).title("Club House"));
                    changeMap(clubhouse, currentMarker);
                }else if (choice == 21) {
                    currentMarker.remove();
                    currentMarker =mMap.addMarker(new MarkerOptions().position(collegehall).title("College Hall"));
                    changeMap(collegehall, currentMarker);
                }else if (choice == 22) {
                    currentMarker.remove();
                    currentMarker =mMap.addMarker(new MarkerOptions().position(dk1).title("DK 1"));
                    changeMap(dk1, currentMarker);
                }else if (choice == 23) {
                    currentMarker.remove();
                    currentMarker =mMap.addMarker(new MarkerOptions().position(dk2).title("DK 2"));
                    changeMap(dk2, currentMarker);
                }else if (choice == 24) {
                    currentMarker.remove();
                    currentMarker =mMap.addMarker(new MarkerOptions().position(dk3).title("DK 3"));
                    changeMap(dk3, currentMarker);
                }else if (choice == 25) {
                    currentMarker.remove();
                    currentMarker =mMap.addMarker(new MarkerOptions().position(dk4).title("DK 4"));
                    changeMap(dk4, currentMarker);
                }else if (choice == 26) {
                    currentMarker.remove();
                    currentMarker =mMap.addMarker(new MarkerOptions().position(dk5).title("DK 5"));
                    changeMap(dk5, currentMarker);
                }else if (choice == 27) {
                    currentMarker.remove();
                    currentMarker =mMap.addMarker(new MarkerOptions().position(dk6).title("DK 6"));
                    changeMap(dk6, currentMarker);
                }else if (choice == 28) {
                    currentMarker.remove();
                    currentMarker =mMap.addMarker(new MarkerOptions().position(dk7).title("DK 7"));
                    changeMap(dk7, currentMarker);
                }else if (choice == 29) {
                    currentMarker.remove();
                    currentMarker =mMap.addMarker(new MarkerOptions().position(dk8).title("DK 8"));
                    changeMap(dk8, currentMarker);
                }else if (choice == 30) {
                    currentMarker.remove();
                    currentMarker =mMap.addMarker(new MarkerOptions().position(dka).title("DK A"));
                    changeMap(dka, currentMarker);
                }else if (choice == 31) {
                    currentMarker.remove();
                    currentMarker =mMap.addMarker(new MarkerOptions().position(dkaba).title("DK ABA"));
                    changeMap(dkaba, currentMarker);
                }else if (choice == 32) {
                    currentMarker.remove();
                    currentMarker =mMap.addMarker(new MarkerOptions().position(dkabb).title("DK ABB"));
                    changeMap(dkabb, currentMarker);
                }else if (choice == 33) {
                    currentMarker.remove();
                    currentMarker =mMap.addMarker(new MarkerOptions().position(dkabc).title("DK ABC"));
                    changeMap(dkabc, currentMarker);
                }else if (choice == 34) {
                    currentMarker.remove();
                    currentMarker =mMap.addMarker(new MarkerOptions().position(dkabd).title("DK ABD"));
                    changeMap(dkabd, currentMarker);
                }else if (choice == 35) {
                    currentMarker.remove();
                    currentMarker =mMap.addMarker(new MarkerOptions().position(dkabe).title("DK ABE"));
                    changeMap(dkabe, currentMarker);
                }else if (choice == 36) {
                    currentMarker.remove();
                    currentMarker =mMap.addMarker(new MarkerOptions().position(dkabf).title("DK ABF"));
                    changeMap(dkabf, currentMarker);
                }else if (choice == 37) {
                    currentMarker.remove();
                    currentMarker =mMap.addMarker(new MarkerOptions().position(dkb).title("DK B"));
                    changeMap(dkb, currentMarker);
                }else if (choice == 38) {
                    currentMarker.remove();
                    currentMarker =mMap.addMarker(new MarkerOptions().position(dkc).title("DK C"));
                    changeMap(dkc, currentMarker);
                }else if (choice == 39) {
                    currentMarker.remove();
                    currentMarker =mMap.addMarker(new MarkerOptions().position(dkd).title("DK D"));
                    changeMap(dkd, currentMarker);
                }else if (choice == 40) {
                    currentMarker.remove();
                    currentMarker =mMap.addMarker(new MarkerOptions().position(dke).title("DK E"));
                    changeMap(dke, currentMarker);
                }else if (choice == 41) {
                    currentMarker.remove();
                    currentMarker =mMap.addMarker(new MarkerOptions().position(dks).title("DK S"));
                    changeMap(dks, currentMarker);
                }else if (choice == 42) {
                    currentMarker.remove();
                    currentMarker =mMap.addMarker(new MarkerOptions().position(dkw).title("DK W"));
                    changeMap(dkw, currentMarker);
                }else if (choice == 43) {
                    currentMarker.remove();
                    currentMarker =mMap.addMarker(new MarkerOptions().position(dkx).title("DK X"));
                    changeMap(dkx, currentMarker);
                }else if (choice == 44) {
                    currentMarker.remove();
                    currentMarker =mMap.addMarker(new MarkerOptions().position(dky).title("DK Y"));
                    changeMap(dky, currentMarker);
                }else if (choice == 45) {
                    currentMarker.remove();
                    currentMarker =mMap.addMarker(new MarkerOptions().position(dkz).title("DK Z"));
                    changeMap(dkz, currentMarker);
                }else if (choice == 46) {
                    currentMarker.remove();
                    currentMarker =mMap.addMarker(new MarkerOptions().position(fernhouse).title("Fern house"));
                    changeMap(fernhouse, currentMarker);
                }else if (choice == 47) {
                    currentMarker.remove();
                    currentMarker =mMap.addMarker(new MarkerOptions().position(khawkaiboh).title("Bangunan Tan Sri Khaw Kai Boh"));
                    changeMap(khawkaiboh, currentMarker);
                }else if (choice == 48) {
                    currentMarker.remove();
                    currentMarker =mMap.addMarker(new MarkerOptions().position(library).title("Library"));
                    changeMap(library, currentMarker);
                }else if (choice == 49) {
                    currentMarker.remove();
                    currentMarker =mMap.addMarker(new MarkerOptions().position(sportcomplex).title("Sport Complex"));
                    changeMap(sportcomplex, currentMarker);
                }else if (choice == 50) {
                    currentMarker.remove();
                    currentMarker =mMap.addMarker(new MarkerOptions().position(swimmingpool).title("Swimming Pool"));
                    changeMap(swimmingpool, currentMarker);
                }else if (choice == 51) {
                    currentMarker.remove();
                    currentMarker =mMap.addMarker(new MarkerOptions().position(tansiewsin).title("Bangunan Tun Tan Siew Sin"));
                    changeMap(tansiewsin, currentMarker);
                }else if (choice == 52) {
                    currentMarker.remove();
                    currentMarker =mMap.addMarker(new MarkerOptions().position(taruc).title("TARCollege Main Gate"));
                    changeMap(taruc, currentMarker);
                }
                Toast.makeText(getActivity().getApplicationContext(), getString(R.string.mapHint), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

                currentMarker.remove();
                currentMarker =mMap.addMarker(new MarkerOptions().position(taruc).title("TARCollege Main Gate"));
                changeMap(taruc, currentMarker);
            }
        });
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        //super.onCreate(savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_maps, container, false);
        Toast.makeText(getActivity().getApplicationContext(), getString(R.string.mapHint2), Toast.LENGTH_LONG).show();
       // button2 = (Button) view.findViewById(R.id.button2);
        x=(FloatingActionButton)getActivity().findViewById(R.id.fab);
        x.setVisibility(View.INVISIBLE);
        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);



       /* button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moveMe();
            }
        });*/


        // Inflate the layout for this fragment
        return view;
    }





   /* public void moveMe (){
        int choice = mapSpinner.getSelectedItemPosition();


    }*/

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        taruc = new LatLng(3.214971, 101.728446);
        dk5 = new LatLng(3.216849, 101.725882);
        dkaba = new LatLng(3.215253, 101.731086);
        blockc = new LatLng(3.215987, 101.727036);
        blockk = new LatLng(3.216748, 101.725099);
        citc=new LatLng(3.214096, 101.726554);
        tansiewsin=new LatLng(3.214642, 101.726334);
        khawkaiboh=new LatLng(3.215150, 101.726474);
        blockh=new LatLng(3.215413, 101.726119);
        blockb=new LatLng(3.215451, 101.726523);
        canteen1=new LatLng(3.216093, 101.725597);
        dk1=new LatLng(3.216222, 101.725831);
        dk2=new LatLng(3.216380, 101.725836);
        dk3=new LatLng(3.216388, 101.726034);
        dk4=new LatLng(3.216272, 101.726048);
        dk6=new LatLng(3.216953, 101.725860);
        dk7=new LatLng(3.216942, 101.726056);
        dk8=new LatLng(3.216867, 101.726056);
        blockd=new LatLng(3.216656, 101.726614);
        dkb=new LatLng(3.216626, 101.725608);
        blockpa=new LatLng(3.217472, 101.726126);
        blockp=new LatLng(3.217577, 101.726365);
        blockq=new LatLng(3.217984, 101.727145);
        blockn=new LatLng(3.217266, 101.727264);
        dka=new LatLng(3.217266, 101.727264);
        blockr=new LatLng(3.217266, 101.727264);
        library=new LatLng(3.217184, 101.728017);
        blockm=new LatLng(3.216775, 101.727779);
        canteen2=new LatLng(3.216236, 101.727851);
        blockl=new LatLng(3.215824, 101.727823);
        dkc=new LatLng(3.218086, 101.728217);
        dkd=new LatLng(3.218061, 101.728559);
        dkw=new LatLng(3.217695, 101.728303);
        dkx=new LatLng(3.217704, 101.728456);
        dky=new LatLng(3.217548, 101.728460);
        dkz=new LatLng(3.217542, 101.728287);
        sportcomplex=new LatLng(3.218067, 101.729731);
        clubhouse=new LatLng(3.217385, 101.730088);
        dks=new LatLng(3.217300, 101.729389);
        swimmingpool=new LatLng(3.217550, 101.729933);
        fernhouse=new LatLng(3.217787, 101.730604);
        blocky=new LatLng(3.217515, 101.730483);
        blockx=new LatLng(3.217240, 101.730435);
        blockw=new LatLng(3.216945, 101.730146);
        dke=new LatLng(3.216934, 101.730404);
        blockv=new LatLng(3.216735, 101.730252);
        collegehall=new LatLng(3.216437, 101.729420);
        dkabb=new LatLng(3.215353, 101.731261);
        dkabc=new LatLng(3.215530, 101.731444);
        dkabd=new LatLng(3.215755, 101.731701);
        dkabe=new LatLng(3.215873, 101.731873);
        dkabf=new LatLng(3.216215, 101.731991);

        /*mTaruc =mMap.addMarker(new MarkerOptions().position(taruc).title("TARCollege Main Gate"));
        mDk5 =mMap.addMarker(new MarkerOptions().position(dk5).title("DK5"));
        mDkaba =mMap.addMarker(new MarkerOptions().position(dkaba).title("DK ABA"));
        mBlockC =mMap.addMarker(new MarkerOptions().position(blockc).title("Block C"));
        mBlockK =mMap.addMarker(new MarkerOptions().position(blockk).title("Block K"));*/

        //currentMarker=mTaruc;
        currentMarker =mMap.addMarker(new MarkerOptions().position(taruc).title("TARCollege Main Gate"));
        changeMap(taruc,currentMarker);
        //currentMarker=mTaruc;

    }
    public void changeMap(LatLng x,Marker y){
        final LatLng position =x;
        final Marker newMark=y;
        CameraPosition mapsetting = CameraPosition.builder()
                .target(position)
                .zoom(17)
                .bearing(0)
                .tilt(0)
                .build();
        mMap.animateCamera(
                CameraUpdateFactory.newCameraPosition(mapsetting),
                500,
                new GoogleMap.CancelableCallback() {

                    @Override
                    public void onFinish() {


                        CameraPosition cameraPosition =
                                new CameraPosition.Builder()
                                        .target(position)
                                        .tilt(0)
                                        //.bearing((float)heading)
                                        .zoom(mMap.getCameraPosition().zoom)
                                        .build();
                        mMap.animateCamera(
                                CameraUpdateFactory.newCameraPosition(cameraPosition),
                                500,
                                null);

                    }

                    @Override
                    public void onCancel() {
                    }
                }
        );
        newMark.showInfoWindow();
    }

}
