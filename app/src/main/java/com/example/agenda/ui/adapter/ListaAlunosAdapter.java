package com.example.agenda.ui.adapter;

import java.util.List;
import java.util.ArrayList;

import android.view.View;
import android.view.ViewGroup;
import android.content.Context;
import android.widget.TextView;
import android.widget.BaseAdapter;
import android.view.LayoutInflater;

import com.example.agenda.R;
import com.example.agenda.model.Aluno;

public class ListaAlunosAdapter extends BaseAdapter {

    private final List<Aluno> alunos = new ArrayList<>();
    private final Context context;

    public ListaAlunosAdapter(Context context) { this.context = context; }

    @Override
    public int getCount() {
        return alunos.size();
    }

    @Override
    public Aluno getItem(int position) { return alunos.get(position); }

    @Override
    public long getItemId(int position) {
        return alunos.get(position).getId();
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        View createView = createView(viewGroup);

        Aluno alunoDevolvido = alunos.get(position);
        vinculaDados(createView, alunoDevolvido);

        return createView;
    }

    private void vinculaDados(View view, Aluno aluno) {
        TextView name = view.findViewById(R.id.item_aluno_nome);
        TextView phone = view.findViewById(R.id.item_aluno_telefone);

        name.setText(aluno.getNome());
        phone.setText(aluno.getTelefone());
    }

    private View createView(ViewGroup viewGroup) {
        return LayoutInflater
                .from(context)
                .inflate(R.layout.item_aluno, viewGroup, false);
    }

    public void update(List<Aluno> alunos){
        this.alunos.clear();
        this.alunos.addAll(alunos);
        notifyDataSetChanged();
    }

    public void remove(Aluno aluno) {
        alunos.remove(aluno);
        notifyDataSetChanged();
    }

}
