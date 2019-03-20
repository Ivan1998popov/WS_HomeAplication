package ru.myproject.ws_homeapplication.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import ru.myproject.ws_homeapplication.R;

public class AuthorizationActivity extends AppCompatActivity {

    private EditText text_login,text_password;
    private Button btn_log_in;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authorization);

        text_login=findViewById(R.id.text_login);
        text_password=findViewById(R.id.text_password);
        btn_log_in=findViewById(R.id.btn_log_in);

        btn_log_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getBaseContext(),InfoActivity.class);
                startActivity(intent);
              //  checkAuthorization();
            }
        });



    }

    private void checkAuthorization(){
        if(text_login.getText().toString().equals(getResources().getString(R.string.login))
                &&text_password.getText().toString().equals(getResources()
                .getString(R.string.password))){
            Intent intent =new Intent(getBaseContext(),InfoActivity.class);
            startActivity(intent);
        }else{
            Toast.makeText(getApplicationContext(),"Не правильный логин или пароль!"
                    ,Toast.LENGTH_SHORT).show();
        }
    }

}
