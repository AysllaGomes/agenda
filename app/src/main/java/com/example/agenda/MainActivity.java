package com.example.agenda;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

import android.os.Bundle;

import android.app.Activity;
import android.widget.ListView;
import android.widget.ArrayAdapter;

import androidx.annotation.Nullable;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        // Apenas os brabos entendem
        List<String> alunos = new ArrayList<>(
                Arrays.asList(
                        "Diego Alves", "Rodrigo Caio", "Rafinha", "Filipe Luís", "Willian Arão", "Everson Ribeiro",
                        "Diego", "De Arrascaeta", "Gabriel B.", "Pedro", "Gerson", "Michael"
                )
        );

        ListView listaDeAlunos = findViewById(R.id.activity_main_list_de_alunos);

        listaDeAlunos.setAdapter(
                new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, alunos)
        );
    }

}
