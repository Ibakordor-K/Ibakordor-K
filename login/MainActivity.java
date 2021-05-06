package com.ik.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ImageView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText username,password;
    Button btnlogin;
    String user,pass;
    ImageView IV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.ETUser);
        password = findViewById(R.id.etPassword);
        btnlogin = findViewById(R.id.buttonlogin);
        IV = findViewById(R.id.IVinternet);
        Picasso.with(this)
                .load("https://thumbs.dreamstime.com/b/leaf-skeleton-blue-wet-background-158136268.jpg")
            .resize(400,400)
            .into(IV);

       // Picasso.with(this).load("https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.publicdomainpictures.net%2Fen%2Fview-image.php%3Fimage%3D316756%26picture%3Dbackground-image&psig=AOvVaw2vm00zHBv_jMaKcT9d2asA&ust=1603125193098000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCJDzpp_JvuwCFQAAAAAdAAAAABAD").into(IV);
        btnlogin.setOnClickListener(this);

    }



    @Override
    public void onClick(View v) {

        if(v.equals(btnlogin)) {

            user = username.getText().toString();
            pass = password.getText().toString();

            FirebaseDatabase db = FirebaseDatabase.getInstance();
            DatabaseReference root = db.getReference();

            root.setValue(user);
           // username.setText(" ");

            // DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference().child("pass");

            DatabaseReference child = db.getReference();
            child.setValue(pass);
            password.setText(" ");

            Toast.makeText(getApplicationContext(), "Inserted", Toast.LENGTH_LONG).show();

            Intent objtostart2ndActivity = new Intent(this, SecondActivity.class);

            objtostart2ndActivity.putExtra("U", user);
            objtostart2ndActivity.putExtra("P", pass);


            startActivity(objtostart2ndActivity);

        }


    }
}