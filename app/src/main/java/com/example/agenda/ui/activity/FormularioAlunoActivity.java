package com.example.agenda.ui.activity;

import android.os.Bundle;

import android.view.View;

import android.content.Intent;

import android.widget.Button;
import android.widget.EditText;

import com.example.agenda.R;
import com.example.agenda.model.Aluno;
import com.example.agenda.ui.DAO.AlunoDAO;

import androidx.appcompat.app.AppCompatActivity;

public class FormularioAlunoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_formulario_aluno);

        final AlunoDAO alunoDAO = new AlunoDAO();

        final EditText campoNome = findViewById(R.id.activity_formulario_aluno_nome);
        final EditText campoTelefone = findViewById(R.id.activity_formulario_aluno_telefone);
        final EditText campoEmail = findViewById(R.id.activity_formulario_aluno_email);

        Button botaoSalvar = findViewById(R.id.activity_formulario_aluno_botao_salvar);

        botaoSalvar.setOnClickListener(
                new View.OnClickListener() {

                    @Override
                    public void onClick(View view) {
                        String nome = campoNome.getText().toString();
                        String telefone = campoTelefone.getText().toString();
                        String email = campoEmail.getText().toString();

                        Aluno alunoCriado = new Aluno(nome, telefone, email);
                        alunoDAO.salva(alunoCriado);

                        finish();
                    }

                }
        );
    }

}
