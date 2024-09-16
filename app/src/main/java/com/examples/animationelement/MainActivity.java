package com.examples.animationelement;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private AnimationDrawable perritoanimado;
    private ImageView imagen;
    //Tuve que declarar una variable//
    //animacionDetenida que cambia entre true y false para controlar si la animación debe empezar o detenerse con cada toque//
    private boolean animacionDetenida = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        imagen = (ImageView) findViewById(R.id.imageperro);
        imagen.setBackgroundResource(R.drawable.animation_dog);
        perritoanimado = (AnimationDrawable) imagen.getBackground();
        perritoanimado.start();

               //Se detiene por segundos// //TEMPORIZADOR//
      /*  Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                perritoanimado.stop();

            }
        },5000);*/
    }



    @Override
    //Tuve que agregar una variable para que pudiera rastrear el estado de mi animaicion
    //y cambie el estado de la animacion//


    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            //Si la animación está detenida (animacionDetenida == true), entonces llamas al método start//
            if (animacionDetenida) {
                perritoanimado.start();
                //Aqui lo que hice fue que esta "buscando" el estado de la animacion //
                animacionDetenida = false;
            } else {
                //Si la animación no está detenida (esta avanzando mi animacion), llame al método stop//
                perritoanimado.stop();
                //Aqui lo que hice fue que esta "buscando" el estado de la animacion //
                //Si la detengo se llama al metodo start//
                animacionDetenida = true;
            }
        }
        return super.onTouchEvent(event);
    }




}