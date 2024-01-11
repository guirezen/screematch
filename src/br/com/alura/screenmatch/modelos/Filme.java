package br.com.alura.screenmatch.modelos;

import br.com.alura.screenmatch.calculos.Classificavel;

import java.util.ArrayList;

public class Filme extends Titulo implements Classificavel {
    private String diretor;

    public Filme(String nome, int duracao, int anoLancamento) {
        super(nome, anoLancamento);
        setDuracao(duracao);
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    @Override
    public int getClassificacao() {
        return (int) pegaMediaDasAvaliacoes()/2;
    }
}
