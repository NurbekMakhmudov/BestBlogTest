package uz.nursoft.nurbek.makhmudov.kurs.bestblogtest.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import uz.nursoft.nurbek.makhmudov.kurs.bestblogtest.R;

public class FrRecent extends Fragment {

    private RecyclerView frRecentRecVW;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fr_recent, container, false);

        findListener(view);

        return view;
    }

    private void findListener(View view){
        frRecentRecVW = (RecyclerView) view.findViewById(R.id.frRecentRecVW);

    }


}
