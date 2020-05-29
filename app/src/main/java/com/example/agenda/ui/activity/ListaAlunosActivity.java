package com.example.agenda.ui.activity;

import android.os.Bundle;
import android.content.Intent;

import android.view.View;
import android.view.MenuItem;
import android.widget.ListView;
import android.view.ContextMenu;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.agenda.R;
import com.example.agenda.model.Aluno;
import com.example.agenda.ui.DAO.AlunoDAO;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import static com.example.agenda.ui.activity.ConstantesActivities.KEY_ALUNO;

public class ListaAlunosActivity extends AppCompatActivity {

    public static final String TITULO_APP_BAR = "Lista de Alunos";

    private final AlunoDAO alunoDAO = new AlunoDAO();
    private ArrayAdapter<Aluno> adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_alunos);

        setTitle(TITULO_APP_BAR);
        configuraFabNovoAluno();
        configuraLista(alunoDAO);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View view, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, view, menuInfo);
        getMenuInflater().inflate(R.menu.activity_lista_alunos_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        int itemId = item.getItemId();
        isRemoveId(item, itemId);

        return super.onContextItemSelected(item);
    }

    private void isRemoveId(MenuItem item, int itemId) {
        if (itemId == R.id.activity_lista_alunos_menu_remover) {
            AdapterView.AdapterContextMenuInfo menuInfo =
                    (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();

            Aluno alunoEscolhido = adapter.getItem(menuInfo.position);
            remove(alunoEscolhido);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        atualizacaoAlunos();
    }

    private void atualizacaoAlunos() {
        adapter.clear();
        adapter.addAll(alunoDAO.todos());
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

    private void configuraLista(final AlunoDAO alunoDAO) {
        ListView listaDeAlunos = findViewById(R.id.activity_lista_alunos_listview);

        configuraAdapter(listaDeAlunos);
        configuraListnerPorItem(listaDeAlunos);

        registerForContextMenu(listaDeAlunos);
    }

    private void remove(Aluno aluno) {
        alunoDAO.delete(aluno);
        adapter.remove(aluno);
    }

    private void configuraAdapter(ListView listaDeAlunos) {
        adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1
        );

        listaDeAlunos.setAdapter(adapter);
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
