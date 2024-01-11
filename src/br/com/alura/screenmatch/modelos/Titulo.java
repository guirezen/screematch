package br.com.alura.screenmatch.modelos;

import br.com.alura.screenmatch.excecao.ErroDeConversaoDeAnoException;
import com.google.gson.annotations.SerializedName;

public class Titulo implements Comparable<Titulo> {
    private String nome;
    private int anoLancamento;
    private boolean inclusoNoPlano;
    private double somaAvaliacao;
    private int totalAvaliacoes;
    private int duracao;

    public Titulo(String nome, int anoLancamento) {
        this.nome = nome;
        this.anoLancamento = anoLancamento;
    }

    public Titulo(TituloOmdb meuTituloOmdb) {
        this.nome = meuTituloOmdb.title();
        if (meuTituloOmdb.year().length() > 4) {
            throw new ErroDeConversaoDeAnoException("Não consegui converter o ano pois tem mais de 4 caracteres.");
        }
        this.anoLancamento = Integer.valueOf(meuTituloOmdb.year());
        this.duracao = Integer.valueOf(meuTituloOmdb.runtime().substring(0, 3));
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(int anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public boolean getInclusoNoPlano() {
        return inclusoNoPlano;
    }

    public void setInclusoNoPlano(boolean inclusoNoPlano) {
        this.inclusoNoPlano = inclusoNoPlano;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public int getTotalAvaliacoes() {
        return totalAvaliacoes;
    }

    public void retornaDadosDoFilme() {
        System.out.println(nome);
        System.out.println(anoLancamento);
        System.out.println(somaAvaliacao);
        System.out.println(inclusoNoPlano);
        System.out.println(totalAvaliacoes);
        System.out.println(duracao);
    }

    public void avalia(double nota) {
        somaAvaliacao += nota;
        totalAvaliacoes++;
    }

    public double pegaMediaDasAvaliacoes() {
        return somaAvaliacao / totalAvaliacoes;
    }

    @Override
    public String toString() {
        return this.getNome() + "(" + this.getAnoLancamento() + ")" + "Duração: " + this.duracao;
    }

    @Override
    public int compareTo(Titulo outroTitulo) {
        return this.getNome().compareTo(outroTitulo.getNome());
    }
}
