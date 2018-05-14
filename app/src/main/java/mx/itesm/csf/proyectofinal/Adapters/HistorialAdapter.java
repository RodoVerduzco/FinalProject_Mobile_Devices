package mx.itesm.csf.proyectofinal.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.gc.materialdesign.views.ButtonFlat;

import java.util.List;

import mx.itesm.csf.proyectofinal.Fragments.Historial;
import mx.itesm.csf.proyectofinal.Model.HistorialModel;
import mx.itesm.csf.proyectofinal.R;

public class HistorialAdapter extends RecyclerView.Adapter<HistorialAdapter.HistorialContainer>{

    // List to add every JSON element
    private List<HistorialModel> historialElements;
    // Context
    private Context context;

    /* Adapter to send Context and Element list */
    public HistorialAdapter (Context context, List<HistorialModel> elements)
    {
        this.historialElements= elements;
        this.context = context;
    }

    /* Creating the ViewHolder with an element (not personalized yet) */
    @NonNull
    @Override
    public HistorialContainer onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        /* Get the Layout */
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View layout = layoutInflater.inflate(R.layout.historial_list_view, parent,false);
        /* Create a DataContainer Instance with the layout*/
        return new HistorialContainer(layout);
    }


    /* Personalizing the ViewHolder */
    @Override
    public void onBindViewHolder(@NonNull final HistorialContainer holder, int position)
    {
        /* Vendedor Model instance based on position */
        HistorialModel historialModel= historialElements.get(position);

        /* Get the name from the model and set the name in the holder*/
        holder._id.setText(historialModel.getType());
        //holder.product_name.setText(ventasModel.getProduct_name());
        //holder.client_name.setText(ventasModel.getClient_name());
        //holder.product_specs.setText(ventasModel.getProduct_specs());
        //holder.product_price.setText(ventasModel.getProduct_price());

        holder.historialModel = historialModel;

        /*holder.btn_entregado.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "Éste elemento será eliminado " + holder.product_name.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });*/
    }

    /* Get the size of the List */
    @Override
    public int getItemCount() {
        return historialElements.size();
    }

    /* Data Container class */
    class HistorialContainer extends RecyclerView.ViewHolder
    {
        TextView _id;
        /*TextView venta_id;
        TextView product_name;
        TextView client_name;
        TextView product_specs;
        TextView product_price;*/

        ButtonFlat btn;

        HistorialModel historialModel;

        // Define the View
        public  HistorialContainer (View itemView)
        {
            super(itemView);

            // Find the view Components

            _id = itemView.findViewById(R.id._id);
            /*venta_id       =  itemView.findViewById(R.id.v_id);
            product_name   =  itemView.findViewById(R.id.v_sales);
            client_name    =  itemView.findViewById(R.id.v_name);
            product_specs  =  itemView.findViewById(R.id.v_store);
            product_price  =  itemView.findViewById(R.id.product_price);
            btn_entregado  =  itemView.findViewById(R.id.btn_entregado);*/

        }

    }
}