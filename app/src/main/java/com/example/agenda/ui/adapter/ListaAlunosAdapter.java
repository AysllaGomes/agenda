package com.example.agenda.ui.adapter;

import java.util.List;
import java.util.ArrayList;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.content.Context;
import android.widget.BaseAdapter;
import android.view.LayoutInflater;

import com.example.agenda.R;
import com.example.agenda.model.Aluno;

public class ListaAlunosAdapter extends BaseAdapter {

    private final List<Aluno> alunos = new ArrayList<>();
    private final Context context;

    public ListaAlunosAdapter(Context context) { this.context = context; }

    public void update(List<Aluno> alunos) {
        alunos.clear();
        this.alunos.addAll(alunos);
        // atualize com o q vc teve de novo
        notifyDataSetChanged();
    }

    public void remove(Aluno aluno) {
        alunos.remove(aluno);
        // atualize com o q vc teve de novo
        notifyDataSetChanged();
    }

    @Override
    public int getCount() { return alunos.size(); }

    @Override
    public Aluno getItem(int position) { return alunos.get(position); }

    @Override
    public long getItemId(int position) { return alunos.get(position).getId(); }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        View createView = createView(viewGroup);

        Aluno alunoDevolvido = alunos.get(position);
        vinculaDados(createView, alunoDevolvido);

        return createView;
    }

    private void vinculaDados(View createView, Aluno alunoDevolvido) {
        TextView name = createView.findViewById(R.id.item_aluno_nome);
        TextView phone = createView.findViewById(R.id.item_aluno_telefone);

        name.setText(alunoDevolvido.getNome());
        phone.setText(alunoDevolvido.getTelefone());
    }

    private View createView(ViewGroup viewGroup) {
        return LayoutInflater
                .from(context)
                .inflate(R.layout.item_aluno, viewGroup, false);
    }

}
