package mx.itesm.csf.proyectofinal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.gc.materialdesign.views.ButtonRectangle;

import org.json.JSONException;
import org.json.JSONObject;

public class RegisterActivity extends AppCompatActivity {

    EditText name, ap, am, dir, tel, mail, pass;
    String name_str, ap_str, am_str, dir_str, tel_str, mail_str, pass_str;
    ButtonRectangle btn_register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        name = findViewById(R.id.et_name);
        ap = findViewById(R.id.et_ap);
        am = findViewById(R.id.et_am);
        dir = findViewById(R.id.et_direccion);
        tel = findViewById(R.id.et_tel);
        mail = findViewById(R.id.et_correo);
        pass = findViewById(R.id.et_pass);

        btn_register = findViewById(R.id.btn_register);
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    register();
                } catch (JSONException e) {
                        e.printStackTrace();
                    }
            }
        });
    }

    public void register() throws JSONException {

        // Get the information from the EditText
        name_str = name.getText().toString();
        ap_str = ap.getText().toString();
        am_str = am.getText().toString();
        dir_str =dir.getText().toString();
        tel_str = tel.getText().toString();
        mail_str = mail.getText().toString();
        pass_str = pass.getText().toString();

        // Check nothing is missing
        if(name_str.matches("") || ap_str.matches("") || am_str.matches("") || dir_str.matches("") ||
            tel_str.matches("") || mail_str.matches("") || pass_str.matches(""))
        {
            JSONObject json = new JSONObject();

            json.put("name", name_str);
            json.put("paternalName", ap_str);
            json.put("maternalName", am_str);
            json.put("address", dir_str);
            json.put("phone", tel_str);
            json.put("email", mail_str);
            json.put("password", pass_str);

            Toast.makeText(RegisterActivity.this, "Info " + json.toString(), Toast.LENGTH_LONG ).show();
        }
        else{
            Toast.makeText(RegisterActivity.this, "Favor de llenar toda la información requerida", Toast.LENGTH_LONG).show();
        }

    }

}
