package com.example.lab9;

import android.util.Log;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class UDPconection extends Thread {


    private DatagramSocket socket;

    public void run() {

        //ESCUCHAR

        try {

            socket = new DatagramSocket(6000);

            //ESPERAR MENSAJE

            while(true) {

                byte[] buffer = new byte [100];
                DatagramPacket packet = new DatagramPacket(buffer,buffer.length);
                Log.e("udp","Esperando Datagrama....");
                socket.receive(packet);
                String mensaje = new String(packet.getData()).trim();
                Log.e("udp","Mensaje recibido...."+mensaje);

            }

        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }



    }


    public void sendMessage(String message) {

        new Thread(

                ()->{

                    try {
                        InetAddress ip;
                        ip = InetAddress.getByName("192.168.0.42");
                        DatagramPacket packet = new DatagramPacket(message.getBytes(), message.getBytes().length, ip, 5000);
                        socket.send(packet);


                    } catch (UnknownHostException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }


                }

        ).start();

}

    }
