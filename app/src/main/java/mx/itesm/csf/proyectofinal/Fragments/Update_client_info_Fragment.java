package mx.itesm.csf.proyectofinal.Fragments;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.gc.materialdesign.views.ButtonRectangle;

import org.json.JSONException;
import org.json.JSONObject;

import mx.itesm.csf.proyectofinal.R;
import mx.itesm.csf.proyectofinal.RegisterActivity;

public class Update_client_info_Fragment extends Fragment {


    EditText password, address, phone;
    ButtonRectangle btn_guardar;

    String pass, addr, ph;

    /* Instance to be shown on the Botom Navigation Activity*/
    public static Update_client_info_Fragment newInstance() {
        return new Update_client_info_Fragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.activity_update_client_info__fragment, container, false);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        password = getView().findViewById(R.id.et_name);
        address = getView().findViewById(R.id.et_address);
        phone = getView().findViewById(R.id.et_tel);

        btn_guardar = getView().findViewById(R.id.btn_guardar);

        get_data();

        btn_guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    update_data();
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        });
    }

    public void update_data() throws JSONException {

        // Get the information from the EditText
        pass = password.getText().toString();
        addr = address.getText().toString();
        ph   = phone.getText().toString();


        if(pass.matches("") || addr.matches("") || ph.matches("") )
        {
            JSONObject json = new JSONObject();

            json.put("address", addr);
            json.put("phone", ph);
            json.put("password", pass);

            Log.d("JSON", json.toString());
        }
        else{
            Toast.makeText(getContext(), "INGRESA DATOS VALIDOS", Toast.LENGTH_LONG).show();
        }
    }

     public void get_data(){

     }

}
