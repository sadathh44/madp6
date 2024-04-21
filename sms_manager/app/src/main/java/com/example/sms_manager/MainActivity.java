package com.example.sms_manager;

import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    EditText number,message;
    Button send;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
       setContentView(R.layout.activity_main);
       ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
           Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
           v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        number=findViewById(R.id.edittext1);
        message=findViewById(R.id.edittext2);
        send=findViewById(R.id.button);
        send.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone=number.getText().toString();
                String text=message.getText().toString();
                try {
                    SmsManager sm = SmsManager.getDefault();
                    sm.sendTextMessage(phone,null,text,null,null);
                    Snackbar.make(v,"SMS sent Successfully",Snackbar.LENGTH_LONG).show();

                }
                catch (Exception e) {
                    Snackbar.make(v,"SMS Not sent Successfully",Snackbar.LENGTH_LONG).show();

                }
            }
        }));
    }



}