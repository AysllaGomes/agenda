package com.example.agenda.ui.activity;

import com.example.agenda.R;
import com.example.agenda.ui.DAO.AlunoDAO;

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

        AlunoDAO alunoDAO = new AlunoDAO();

        ListView listaDeAlunos = findViewById(R.id.activity_lista_alunos_listview);

        listaDeAlunos.setAdapter(
                new ArrayAdapter<>(
                        this,
                        android.R.layout.simple_list_item_1,
                        alunoDAO.todos()
                )
        );
    }

}
