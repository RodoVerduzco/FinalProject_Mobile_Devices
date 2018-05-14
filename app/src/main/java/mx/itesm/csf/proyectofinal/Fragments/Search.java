package mx.itesm.csf.proyectofinal.Fragments;

import android.app.ProgressDialog;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import mx.itesm.csf.proyectofinal.Adapters.SearchAdapter;
import mx.itesm.csf.proyectofinal.Model.SearchModel;
import mx.itesm.csf.proyectofinal.R;

public class Search extends Fragment {

    RecyclerView recView;
    RecyclerView.Adapter recAdapter;
    RecyclerView.LayoutManager recLayoutManager;
    List<SearchModel> search_list_Elements;

    ProgressDialog progressBar;
    public static Search newInstance() {
        return new Search();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.activity_search, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // Get the elements from the CardView and the list
        recView =  getView().findViewById(R.id.recyclerview);
        progressBar = new ProgressDialog(getContext());
        search_list_Elements= new ArrayList<>();



                             /* TODO Get the data */



        /* CardView components */
        recLayoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false); /* Change to Grid Layout*/
        recView.setLayoutManager(recLayoutManager);
        recAdapter = new SearchAdapter(getContext(), search_list_Elements);
        recView.setAdapter(recAdapter);
    }
}
