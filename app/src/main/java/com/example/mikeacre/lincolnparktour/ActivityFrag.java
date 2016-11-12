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

public class ActivityFrag extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.location_list, container, false);

        Resources res = (Resources) getActivity().getResources();
        String[] clocktower = res.getStringArray(R.array.clocktower);
        String[] train = res.getStringArray(R.array.train);
        String[] museum = res.getStringArray(R.array.museum);

        final ArrayList<Location> locations = new ArrayList<Location>();
        locations.add(new Location(clocktower[0],clocktower[1],clocktower[2]));
        locations.add(new Location(train[0],train[1],train[2]));
        locations.add(new Location(museum[0],museum[1],museum[2]));

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
