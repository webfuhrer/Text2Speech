package com.example.aplicaciontexttospeech_2;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.speech.tts.Voice;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.Locale;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    TextToSpeech hablar;
    Button btn_hablar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        hablar=new TextToSpeech(this, new  TextToSpeech.OnInitListener(){
             @Override
            public void onInit(int status) {
                if (status!=TextToSpeech.ERROR) {
                    Locale idioma_castellano = new Locale("es");
                    hablar.setLanguage(idioma_castellano);
                    Set<Voice> voces=hablar.getVoices();
                    for (Voice v: voces)
                    {
                        Log.d("VOZ", v.getName());
                    }
                    Log.d("Respuesta", "Inicializacion conrrecta");
                }
                else
                {
                    //Log.d("Respuesta", hablar.getDefaultEngine());
                }
            }
        });

        //hablar.setEngineByPackageName(TextToSpeech.ACTION_TTS_QUEUE_PROCESSING_COMPLETED);
        btn_hablar=findViewById(R.id.btn_hablar);
        btn_hablar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                int respuesta = hablar.speak("Buenos días", TextToSpeech.QUEUE_FLUSH, null, null);
                Log.d("Respuesta", String.valueOf(respuesta));
            }
        });


    }



}