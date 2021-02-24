package com.example.componetofinterface;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.icu.text.UnicodeSetSpanner;
import android.media.MediaPlayer;
import android.net.wifi.p2p.WifiP2pManager;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.sql.Time;
import java.util.Random;


public class MainActivity extends AppCompatActivity {

    Button btn;
    Button btn1;
    ImageView imageView;
    ImageView imageView1;
    private static int number1;
    private static int number2;
    public static boolean kontro1 = false;
    private boolean kontro2 = false;
    private  static  int firstScore;
    private  static int secondScore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButtonTanimla();
        islevVer(btn);
        islevVer(btn1);


    }

    private void ButtonTanimla() {
        btn = findViewById(R.id.Button1);
        btn1 = findViewById(R.id.Button2);
        imageView = findViewById(R.id.BirinciZar);
        imageView1 = findViewById(R.id.IkinciZar);

    }

    private void islevVer(Button btn) {


        btn.setOnClickListener(new View.OnClickListener() {


                                   @SuppressLint("WrongConstant")
                                   @Override
                                   public void onClick(View v) {


                                       if (v.getId() == R.id.Button1 && kontro1 != true) {
                                           Random random = new Random();
                                           number1 = random.nextInt(7 - 1) + 1;
                                           cal();

                                           //Toast.makeText(getApplicationContext(), "Birinci oyuncu " + number1 + "  " + "Sayısını attı", 1).show();
                                            Toast.makeText(getApplicationContext(), "Birinci oyuncu"+" "+String.valueOf(number1)+" "+"Sayısını attı!", Toast.LENGTH_SHORT).show();




                                           degistir(number1);

                                           kontro1 = true;
                                       } else if (v.getId() == R.id.Button2 && kontro2 != true) {

                                           Random random = new Random();
                                           cal();
                                           number2 = random.nextInt(7 - 1) + 1;
                                           degistir1(number2);
                                           kontro2 = true;
                                           Toast.makeText(getApplicationContext(), "İkinci oyuncu" + " " + number2 + " " + "Sayısını attı", 1).show();
                                       }

                                       if (kontro1 && kontro2) {
                                           if (number1 == number2) {
                                               //System.out.println("Bir numaralı sayı"+number1);



                                               Toast.makeText(getApplicationContext(), "Kazanan Yok!"+"\n" +"Birinci oyuncu skoru"+" "+ String.valueOf(firstScore)+"\n "+"ikinci oyuncu skoru"+" "+String.valueOf(secondScore),Toast.LENGTH_SHORT).show();
                                               //System.out.println("İKİ numaralı sayı"+number2);
                                               Log.i("Eşittir", String.valueOf(number2));

                                               //System.out.println("Bir numara iki numaradan daha büyük");
                                           }
                                           if (number1 > number2) {
                                               //System.out.println("Bir numaralı sayı"+number1);

                                               firstScore++;

                                               Toast.makeText(getApplicationContext(), "Birinci Oyuncu Kazandı Tebrikler!" +"\n"+"Birinci oyuncu skoru"+" "+ String.valueOf(firstScore)+"\n"+"ikinci oyuncu skoru"+" "+String.valueOf(secondScore),Toast.LENGTH_SHORT).show();


                                               //System.out.println("İKİ numaralı sayı"+number2);
                                               Log.i("Bir numaralı sayı büyük", String.valueOf(number2));

                                               //System.out.println("Bir numara iki numaradan daha büyük");
                                           }
                                           if (number1 < number2) {
                                               //System.out.println("Bir numaralı sayı"+number1);
                                               secondScore++;

                                               Toast.makeText(getApplicationContext(), "İkinci  Oyuncu Kazandı Tebrikler!" +"\n"+"Birinci oyuncu skoru"+" "+ String.valueOf(firstScore)+"\n "+"ikinci oyuncu skoru"+" "+String.valueOf(secondScore),Toast.LENGTH_SHORT).show();


                                               //System.out.println("İKİ numaralı sayı"+number2);
                                               Log.i("İki numaralı sayı büyük", String.valueOf(number2));

                                               //System.out.println("Bir numara iki numaradan daha büyük");
                                           }
                                           kontro2 = false;
                                           kontro1 = false;

                                       }


                                   }


                               }

        );

    }

    public void degistir(int number) {
        if (number == 1) {
            imageView.setImageResource(R.drawable.dice1);


        } else if (number == 2) {
            imageView.setImageResource(R.drawable.dice2);

        } else if (number == 3) {
            imageView.setImageResource(R.drawable.dice3);
        } else if (number == 4) {
            imageView.setImageResource(R.drawable.dice4);
        } else if (number == 5) {
            imageView.setImageResource(R.drawable.dice5);
        } else if (number == 6) {
            imageView.setImageResource(R.drawable.dice6);
        }
    }

    public void degistir1(int number) {
        if (number == 1) {
            imageView1.setImageResource(R.drawable.dice1);
        } else if (number == 2) {
            imageView1.setImageResource(R.drawable.dice2);
        } else if (number == 3) {
            imageView1.setImageResource(R.drawable.dice3);
        } else if (number == 4) {
            imageView1.setImageResource(R.drawable.dice4);
        } else if (number == 5) {
            imageView1.setImageResource(R.drawable.dice5);
        } else if (number == 6) {
            imageView1.setImageResource(R.drawable.dice6);
        }
    }
    /*public void cal(){
        //final MediaPlayer mp=MediaPlayer.create(getApplicationContext(),R.raw.);
        mp.start();
    }*/
    public void cal(){
        final MediaPlayer mp=MediaPlayer.create(MainActivity.this,R.raw.zarr);
        mp.start();
    }
}