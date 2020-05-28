package com.example.agenda.ui.activity;

import android.os.Bundle;
import android.content.Intent;

import android.view.View;

import android.widget.Button;
import android.widget.EditText;

import com.example.agenda.R;
import com.example.agenda.model.Aluno;
import com.example.agenda.ui.DAO.AlunoDAO;

import androidx.appcompat.app.AppCompatActivity;

import static com.example.agenda.ui.activity.ConstantesActivities.KEY_ALUNO;

public class FormularioAlunoActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR_NOVO_ALUNO = "Novo aluno";
    public static final String TITULO_APPBAR_EDITA_ALUNO = "Alteração do aluno";

    private EditText campoNome;
    private EditText campoTelefone;
    private EditText campoEmail;

    private Aluno aluno;
    private final AlunoDAO alunoDAO = new AlunoDAO();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_aluno);

        inicializacaoDosCampos();
        configuraBotaoSalvar();

        loadAluno();
    }

    private void loadAluno() {
        Intent dados = getIntent();

        if (dados.hasExtra(KEY_ALUNO)) {
            setTitle(TITULO_APPBAR_EDITA_ALUNO);
            aluno = (Aluno) dados.getSerializableExtra(KEY_ALUNO);
            preencheCampos();
        } else {
            setTitle(TITULO_APPBAR_NOVO_ALUNO);
            aluno = new Aluno();
        }
    }

    private void preencheCampos() {
        campoNome.setText(aluno.getNome());
        campoTelefone.setText(aluno.getTelefone());
        campoEmail.setText(aluno.getEmail());
    }

    private void configuraBotaoSalvar() {
        Button botaoSalvar = findViewById(R.id.activity_formulario_aluno_botao_salvar);

        botaoSalvar.setOnClickListener(
                new View.OnClickListener() {

                    @Override
                    public void onClick(View view) {
                        finalizaFormulario();
                    }

                }
        );
    }

    private void finalizaFormulario() {
        preencheAluno();

        if (aluno.idValido()) { alunoDAO.edit(aluno); }
            else { alunoDAO.salva(aluno); }

        finish();
    }

    private void inicializacaoDosCampos() {
        campoNome = findViewById(R.id.activity_formulario_aluno_nome);
        campoTelefone = findViewById(R.id.activity_formulario_aluno_telefone);
        campoEmail = findViewById(R.id.activity_formulario_aluno_email);
    }

    private void preencheAluno() {
        String nome = campoNome.getText().toString();
        String telefone = campoTelefone.getText().toString();
        String email = campoEmail.getText().toString();

        aluno.setNome(nome);
        aluno.setTelefone(telefone);
        aluno.setEmail(email);
    }

}
