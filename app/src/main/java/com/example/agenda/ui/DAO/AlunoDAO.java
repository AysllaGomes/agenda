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

        contIds++;
    }

    public void edit(Aluno aluno) {
        Aluno alunoEncontrado = null;

        for (Aluno student:
                alunos) {
            if (student.getId() == aluno.getId()) {
                alunoEncontrado = student;
            }

        }

        if (alunoEncontrado != null) {
            int posicaoDoAluno = alunos.indexOf(alunoEncontrado);
            alunos.set(posicaoDoAluno, aluno);
        }
    }

    public List<Aluno> todos() { return  new ArrayList<>(alunos); }

}
