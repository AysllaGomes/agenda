package com.example.agenda.ui.activity;

import android.os.Bundle;
import android.content.Intent;

import android.view.View;
import android.widget.ListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.agenda.R;
import com.example.agenda.model.Aluno;
import com.example.agenda.ui.DAO.AlunoDAO;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import static com.example.agenda.ui.activity.ConstantesActivities.KEY_ALUNO;

import java.util.List;

public class ListaAlunosActivity extends AppCompatActivity {

    public static final String TITULO_APP_BAR = "Lista de Alunos";

    private final AlunoDAO alunoDAO = new AlunoDAO();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_alunos);

        setTitle(TITULO_APP_BAR);
        configuraFabNovoAluno();
    }

    private void configuraFabNovoAluno() {
        FloatingActionButton botaoNovoAluno = findViewById(R.id.activity_lista_alunos_fab_novo_aluno);
        botaoNovoAluno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abreFormularioAlunoModoCreate();
            }
        });
    }

    private void abreFormularioAlunoModoCreate() {
        startActivity(new Intent(
                this,
                FormularioAlunoActivity.class)
        );
    }

    @Override
    protected void onResume() {
        super.onResume();
        configuraLista(alunoDAO);
    }

    private void configuraLista(AlunoDAO alunoDAO) {
        ListView listaDeAlunos = findViewById(R.id.activity_lista_alunos_listview);

        final List<Aluno> alunos = alunoDAO.todos();

        configuraAdapter(listaDeAlunos, alunos);
        configuraListnerPorItem(listaDeAlunos);
    }

    private void configuraAdapter(ListView listaDeAlunos, List<Aluno> alunos) {
        listaDeAlunos.setAdapter(
                new ArrayAdapter<>(
                        this,
                        android.R.layout.simple_list_item_1,
                        alunos
                )
        );
    }

    private void configuraListnerPorItem(ListView listaDeAlunos) {
        listaDeAlunos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Aluno alunoEscolhido = (Aluno) adapterView.getItemAtPosition(position);
                abreFormModoEditAluno(alunoEscolhido);
            }
        });
    }

    private void abreFormModoEditAluno(Aluno aluno) {
        Intent idFormularioActivity = new Intent(ListaAlunosActivity.this, FormularioAlunoActivity.class);
        idFormularioActivity.putExtra(KEY_ALUNO, aluno);
        startActivity(idFormularioActivity);
    }

}
