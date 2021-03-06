package uz.nursoft.nurbek.makhmudov.kurs.bestblogtest.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import uz.nursoft.nurbek.makhmudov.kurs.bestblogtest.R;
import uz.nursoft.nurbek.makhmudov.kurs.bestblogtest.adapters.MyRecyclerAdapter;
import uz.nursoft.nurbek.makhmudov.kurs.bestblogtest.models.ModelRecycler;

public class FrRecent extends Fragment {

    private RecyclerView frRecentRecVW;
    private List<ModelRecycler> modelRecyclers;
    private MyRecyclerAdapter myRecyclerAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fr_recent, container, false);

        findListener(view);
        addData();

        return view;
    }

    private void findListener(View view){
        frRecentRecVW = (RecyclerView) view.findViewById(R.id.frRecentRecVW);
        frRecentRecVW.setHasFixedSize(false);
        frRecentRecVW.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    private void addData(){
        modelRecyclers = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            modelRecyclers.add(new ModelRecycler(
                    "Title", "Desv", "10", "5", "20", "10 May 2019"
            ));
        }

        myRecyclerAdapter = new MyRecyclerAdapter(getActivity(), modelRecyclers);
        frRecentRecVW.setAdapter(myRecyclerAdapter);
    }






}
