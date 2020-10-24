package com.example.kopapirollo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity
{
    private ImageButton Ko,Papir,Ollo;
    private ImageView gep1,gep2,gep3,jatekos1,jatekos2,jatekos3,gepValasztas,JatekosValasztas;
    private TextView dontetlen;
    private int Dontetlen,jatekosHP,gepHP;
    private Random r;
    private AlertDialog alertDialog;
    private AlertDialog.Builder builder;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        Ko.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                JatekosValasztas.setBackgroundResource(R.drawable.rock);
                int rand= r.nextInt(3);
                switch (rand)
                {
                    case 0: gepValasztas.setBackgroundResource(R.drawable.rock);
                    Dontetlen++;
                    dontetlen.setText("Döntetlenek száma: "+Dontetlen);
                    Toast.makeText(MainActivity.this,"Döntetlen",Toast.LENGTH_SHORT).show();
                    case 1: gepValasztas.setBackgroundResource(R.drawable.paper);
                    jatekosHP--;
                    Toast.makeText(MainActivity.this,"A gép nyert",Toast.LENGTH_SHORT).show();
                    jatekosHPCsokken();break;
                    case 2: gepValasztas.setBackgroundResource(R.drawable.scissors);
                    gepHP--;
                    gepHPCsokken();
                    Toast.makeText(MainActivity.this,"Ön nyert",Toast.LENGTH_SHORT).show();
                    break;
                }
            }
        });
        Papir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                JatekosValasztas.setBackgroundResource(R.drawable.paper);
                int rand= r.nextInt(3);
                switch (rand)
                {
                    case 0: gepValasztas.setBackgroundResource(R.drawable.rock);
                        gepHP--;
                        Toast.makeText(MainActivity.this,"Ön nyert",Toast.LENGTH_SHORT).show();
                        gepHPCsokken();
                        break;
                    case 1: gepValasztas.setBackgroundResource(R.drawable.paper);

                        Dontetlen++;
                        dontetlen.setText("Döntetlenek száma: "+Dontetlen);
                        Toast.makeText(MainActivity.this,"Döntetlen",Toast.LENGTH_SHORT).show();
                        break;
                    case 2: gepValasztas.setBackgroundResource(R.drawable.scissors);

                        jatekosHP--;
                        Toast.makeText(MainActivity.this,"A gép nyert",Toast.LENGTH_SHORT).show();
                        jatekosHPCsokken();break;
                }

            }
        });
        Ollo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                JatekosValasztas.setBackgroundResource(R.drawable.scissors);
                int rand= r.nextInt(3);
                switch (rand)
                {
                    case 0: gepValasztas.setBackgroundResource(R.drawable.rock);
                        jatekosHP--;
                        Toast.makeText(MainActivity.this,"A gép nyert",Toast.LENGTH_SHORT).show();
                        jatekosHPCsokken();break;
                    case 1: gepValasztas.setBackgroundResource(R.drawable.paper);
                        gepHP--;
                        Toast.makeText(MainActivity.this,"Ön nyert",Toast.LENGTH_SHORT).show();
                        gepHPCsokken();
                        break;
                    case 2: gepValasztas.setBackgroundResource(R.drawable.scissors);
                        Dontetlen++;
                        dontetlen.setText("Döntetlenek száma: "+Dontetlen);
                        Toast.makeText(MainActivity.this,"Döntetlen",Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
    }
    private void init()
    {
        Ko=findViewById(R.id.Ko);
        Papir=findViewById(R.id.Papir);
        Ollo=findViewById(R.id.Ollo);
        gep1=findViewById(R.id.gepHp1);
        gep2=findViewById(R.id.gepHp2);
        gep3=findViewById(R.id.gepHp3);
        jatekos1=findViewById(R.id.jatekosHp1);
        jatekos2=findViewById(R.id.jatekosHp2);
        jatekos3=findViewById(R.id.jatekosHp3);
        gepValasztas=findViewById(R.id.GepTipp);
        JatekosValasztas=findViewById(R.id.JatekosTipp);
        dontetlen=findViewById(R.id.Dontetlen);
        r=new Random();
        jatekosHP=3;
        gepHP=3;
        Dontetlen=0;
        builder=new AlertDialog.Builder(MainActivity.this);
        builder.setMessage("Szeretne e új játékot kezdeni?")
            .setPositiveButton("Igen", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            })
            .setNegativeButton("Nem", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            })
            .setTitle("Game over!!")
            .setCancelable(false);
        alertDialog=builder.create();
    }
    private void jatekosHPCsokken()
    {
        if (jatekosHP==2)
        {
            jatekos1.setBackgroundResource(R.drawable.heart1);
        }
        else if(jatekosHP==1)
        {
            jatekos2.setBackgroundResource(R.drawable.heart1);
        }
        else
        {
            jatekos3.setBackgroundResource(R.drawable.heart1);
            alertDialog.show();
        }

    }
    private void gepHPCsokken()
    {
        if (gepHP==2)
        {
            gep3.setBackgroundResource(R.drawable.heart1);
        }
        else if(gepHP==1)
        {
            gep2.setBackgroundResource(R.drawable.heart1);
        }
        else
        {
            gep1.setBackgroundResource(R.drawable.heart1);
            builder.setTitle("Ön nyert");
            alertDialog=builder.create();
            alertDialog.show();
        }
    }
}