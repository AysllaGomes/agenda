package com.example.agenda.ui.activity;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

import com.example.agenda.R;

import android.os.Bundle;

import android.widget.ListView;
import android.widget.ArrayAdapter;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ListaAlunosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_lista_alunos);
        setTitle("Lista de Alunos");

        // Apenas os brabos entendem
        List<String> alunos = new ArrayList<>(
                Arrays.asList(
                        "Diego Alves", "Rodrigo Caio", "Rafinha", "Filipe Luís", "Willian Arão", "Everson Ribeiro",
                        "Diego", "De Arrascaeta", "Gabriel B.", "Pedro", "Gerson", "Michael"
                )
        );

        ListView listaDeAlunos = findViewById(R.id.activity_lista_alunos_listview);

        listaDeAlunos.setAdapter(
                new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, alunos)
        );
    }

}
