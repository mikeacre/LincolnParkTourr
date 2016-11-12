package com.example.mikeacre.lincolnparktour;

import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by mikeacre on 11/12/2016.
 */

public class NightLifeFragment extends Fragment{

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.location_list, container, false);

        Resources res = getActivity().getResources();

        String[] wex = res.getStringArray(R.array.wexford);
        String[] mothers = res.getStringArray(R.array.mothers);
        String[] hopper = res.getStringArray(R.array.hopper);

        final ArrayList<Location> locations = new ArrayList<Location>();
        locations.add(new Location(wex[0], wex[1], wex[2],R.drawable.wex));
        locations.add(new Location(mothers[0], mothers[1], mothers[2],R.drawable.grasshopper));
        locations.add(new Location(hopper[0], hopper[1], hopper[2],R.drawable.mothers));


        LocationAdapter adapter = new LocationAdapter(getActivity(), locations);

        ListView listView = (ListView) rootView.findViewById(R.id.list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                Location location = locations.get(position);

                Uri uri = Uri.parse(location.getGeoLocation());
                Intent openMap = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(openMap);
            }
            });

        return rootView;
    }

}
