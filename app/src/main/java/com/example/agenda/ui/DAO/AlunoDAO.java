package com.example.agenda.ui.DAO;

import com.example.agenda.model.Aluno;

import java.util.ArrayList;
import java.util.List;

public class AlunoDAO {

    private final static List<Aluno> alunos = new ArrayList<>();

    private static int contIds = 1;

    public void salva(Aluno aluno) {
        aluno.setId(contIds);
        alunos.add(aluno);

        atualizaId();
    }

    private void atualizaId() {
        contIds++;
    }

    public void edit(Aluno aluno) {
        Aluno alunoEncontrado = buscaAlunoPeloId(aluno);

        if (alunoEncontrado != null) {
            int posicaoDoAluno = alunos.indexOf(alunoEncontrado);
            alunos.set(posicaoDoAluno, aluno);
        }
    }

    private Aluno buscaAlunoPeloId(Aluno aluno) {
        for (Aluno student:
                alunos) {
            if (student.getId() == aluno.getId()) {
                return student;
            }

        }

        return null;
    }

    public List<Aluno> todos() { return  new ArrayList<>(alunos); }

    public void delete(Aluno aluno) {
        Aluno alunoDevolvido = buscaAlunoPeloId(aluno);

        if (alunoDevolvido != null) {
            alunos.remove(alunoDevolvido);
        }
    }

}
