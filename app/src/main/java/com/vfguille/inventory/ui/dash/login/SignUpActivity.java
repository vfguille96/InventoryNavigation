package com.vfguille.inventory.ui.dash.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.vfguille.inventory.R;
import com.vfguille.inventory.utils.CommonUtils;

public class SignUpActivity extends AppCompatActivity {
    private Button btSignUp;
    TextInputEditText tietUser;
    TextInputEditText tietPassword1;
    TextInputEditText tietPassword2;
    TextInputEditText tietEmail;
    TextInputLayout tilUser;
    TextInputLayout tilPassword1;
    TextInputLayout tilPassword2;
    TextInputLayout tilEmail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        initializeComponents();
        btSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate();
            }
        });
    }

    private void initializeComponents() {
        btSignUp = findViewById(R.id.btRegister);

        tietUser = findViewById(R.id.tiedUser);
        tietEmail = findViewById(R.id.tiedEmail);
        tietPassword1 = findViewById(R.id.tiedPass1);
        tietPassword2 = findViewById(R.id.tiedPass2);

        tilUser = findViewById(R.id.tilUser);
        tilEmail = findViewById(R.id.tilEmail);
        tilPassword1 = findViewById(R.id.tilPass1);
        tilPassword2 = findViewById(R.id.tilPass2);


        tietUser.addTextChangedListener(new SignUpWatcher(tietUser));
        tietUser.addTextChangedListener(new SignUpWatcher(tietUser));
        tietUser.addTextChangedListener(new SignUpWatcher(tietUser));
    }

    /**
     * Método que comprueba la validez de los campos del TIL
     */
    private void validate() {
        //1. Se guarda el usuario en la BD
        //2. Envío correo al usuario (Firebase)
        //3. Se pasa a la ventana Login
        if (validateUser(tietUser.getText().toString()) && validatePassword(tietPassword1.getText().toString(),
                tietPassword2.getText().toString()) && validateEmail(tietEmail.getText().toString())) {
            startActivity(new Intent(SignUpActivity.this, LoginActivity.class).setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP));
            finish();
            Toast.makeText(this, "SignUp successfull", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Valida email
     *
     * @return
     */
    private boolean validateEmail(String email) {
        return !email.isEmpty();
    }

    /**
     * Valida Pass
     *
     * @return
     */
    private boolean validatePassword(String password1, String password2) {
        return CommonUtils.checkPasswordLength(password1) && CommonUtils.checkEqualsPasswords(password1, password2)
                && CommonUtils.regexpPasswordsValidation(password1);
    }

    /**
     * Valida usuario.
     *
     * @return
     */
    private boolean validateUser(String user) {
        if (user.length() < 4){
            tilUser.setError(getString(R.string.errUserEmpty));
            return false;
        }else
            return true;
    }

    private class SignUpWatcher implements TextWatcher{

        private View view;
        public SignUpWatcher (View view){
            this.view = view;
        }

        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void afterTextChanged(Editable editable) {
            switch (view.getId()){
                case R.id.edUser:
                    validateUser(((TextInputEditText)view).getText().toString());
                    break;

            }
        }
    }
}