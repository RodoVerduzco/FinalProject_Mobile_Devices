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

import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

import mx.itesm.csf.proyectofinal.Adapters.HistorialAdapter;
import mx.itesm.csf.proyectofinal.Model.HistorialModel;
import mx.itesm.csf.proyectofinal.R;

public class Historial extends Fragment {

    RecyclerView recView;
    RecyclerView.Adapter recAdapter;
    RecyclerView.LayoutManager recLayoutManager;
    List<HistorialModel> historialElements;

    ProgressDialog progressBar;
    public static Historial newInstance() {
        return new Historial();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.activity_historial, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // Get the elements from the CardView and the list
        recView =  getView().findViewById(R.id.recyclerview);
        progressBar = new ProgressDialog(getContext());
        historialElements = new ArrayList<>();



                             /* TODO Get the data */



        /* CardView components */
        recLayoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        recView.setLayoutManager(recLayoutManager);
        recAdapter = new HistorialAdapter(getContext(), historialElements);
        recView.setAdapter(recAdapter);
    }
}
