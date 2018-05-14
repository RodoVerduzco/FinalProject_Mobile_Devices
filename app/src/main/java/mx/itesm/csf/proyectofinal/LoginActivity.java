package mx.itesm.csf.proyectofinal;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.gc.materialdesign.views.ButtonFlat;
import com.gc.materialdesign.views.ButtonRectangle;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;


public class LoginActivity extends AppCompatActivity {

     public static final String USUARIO = "usuario";
     public static final String PASSWORD = "password";
     public static final String LOGIN = "\"http://ubiquitous.csf.itesm.mx/~raulms/content/TC2024/REST/Minisistema2/servicio.login.php?";

    private final String TAG = "LOGIN";
    private EditText editTextUsuario;
    private EditText editTextPassword;

    private String usuario;
    private String password;

    ButtonRectangle btn_login;
    ButtonFlat btn_register;

    private Usuario userData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Check if user is logged
        check_login();

        editTextUsuario  = (EditText) findViewById(R.id.lg_usuario);
        editTextPassword = (EditText) findViewById(R.id.lg_pass);

        // Login
        btn_login = findViewById(R.id.lg_btn);
        btn_login.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                try {
                    usuarioLogin();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
        // Register
        btn_register = findViewById(R.id.btn_registrar);
        btn_register.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v)
            {
                usuarioRegister();
            }
        });

    }

    //Register Data
    private void usuarioRegister()
    {
        startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
    }

    // Handle Login Data
    private void usuarioLogin() throws JSONException {
        /* Think */
        final ProgressDialog progressBar = new ProgressDialog(LoginActivity.this);
        progressBar.setMessage("Iniciando sesion...");
        progressBar.show();

        /* Get User and Password*/
        usuario = editTextUsuario.getText().toString().trim();
        password = editTextPassword.getText().toString().trim();

        /* Get the correct login url for the service*/
        String LOGIN_URL = LOGIN + USUARIO + "=" + usuario + "&" + PASSWORD + "=" + password;
        Log.d(TAG, LOGIN_URL);

        /* Put the data to a JSON object */
        if(!usuario.matches("")|| !password.matches("")) {
            JSONObject json = new JSONObject();

            json.put("email", usuario);
            json.put("password", password);

            /* TODO Delete */
                Toast.makeText(LoginActivity.this, "LOGIN " + json.toString(), Toast.LENGTH_LONG).show();
                startActivity(new Intent(LoginActivity.this, MainActivity.class));
        }
        else
        {
            Toast.makeText(LoginActivity.this, "INGRESA DATOS PARA INICIAR SESIÓN", Toast.LENGTH_LONG).show();
        }

        progressBar.hide();
    }
    
    private void check_login()
    {

    }


}
