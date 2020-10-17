package com.example.lab9;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.example.lab9.model.Coffe;
import com.example.lab9.model.Muffin;
import com.example.lab9.model.Sandwitch;
import com.example.lab9.model.Smoothie;
import com.google.gson.Gson;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{


    private ImageView muffin,smoothie,coffe,sandwich;
    String ip;
    UDPconection udp;
    Muffin product1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        muffin = findViewById(R.id.muffin);
        smoothie = findViewById(R.id.smoothie);
        coffe = findViewById(R.id.coffe);
        sandwich = findViewById(R.id.sandwich);

        muffin.setOnClickListener(this);
        smoothie.setOnClickListener(this);
        coffe.setOnClickListener(this);
        sandwich.setOnClickListener(this);


        udp = new UDPconection();
        udp.start();

        new Thread(

                ()->{

                    try {
                        InetAddress direccion = InetAddress.getLocalHost();
                        ip = direccion.getHostAddress();

                        Log.e("ip","es:"+""+ip);
                    } catch (UnknownHostException e) {
                        e.printStackTrace();
                    }


                }


        ).start();



    }

    @Override
    public void onClick(View view) {

        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        String fecha = sdf.format(date);

        String idOne = UUID.randomUUID().toString();

        switch (view.getId()){

            case R.id.muffin:

                Muffin orden = new Muffin("Muffin",fecha,idOne,ip);
                Gson gson = new Gson();
                String json = gson.toJson(orden);
                udp.sendMessage(json);

                break;

            case R.id.sandwich:

                Sandwitch product2 = new Sandwitch("Sandwitch",fecha,idOne,ip);
                Gson gson2 = new Gson();
                String json2 = gson2.toJson(product2);
                udp.sendMessage(json2);

                break;

            case R.id.coffe:

                Coffe product3 = new Coffe("Coffe",fecha,idOne,ip);
                Gson gson3 = new Gson();
                String json3 = gson3.toJson(product3);
                udp.sendMessage(json3);
                break;

            case R.id.smoothie:

                Smoothie product4 = new Smoothie("Smoothie",fecha,idOne,ip);
                Gson gson4 = new Gson();
                String json4 = gson4.toJson(product4);
                udp.sendMessage(json4);

                break;
        }








    }
}