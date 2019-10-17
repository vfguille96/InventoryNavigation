package com.vfguille.inventory;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SignUpActivity extends AppCompatActivity {
    private Button btSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        btSignUp = findViewById(R.id.btRegister);
        btSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate();
            }
        });
    }

    /**
     * Método que comprueba la validez de los campos del TIL
     */
    private void validate() {

        if (validateUser() && validatePassword() && validateEmail()){
            //  1. Se guarda el usuario en la BD.
            //  2. Envío de correo al usuario (Firebase)
            //  3. LoginActivity
            startActivity(new Intent(SignUpActivity.this, LoginActivity.class).setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP));
            finish();
        }
    }

    /**
     * Valida email
     * @return
     */
    private boolean validateEmail() {
        return true;
    }

    /**
     * Valida Pass
     * @return
     */
    private boolean validatePassword() {
        return  true;
    }

    /**
     * Valida usuario.
     * @return
     */
    private boolean validateUser() {
        return true;

    }
}