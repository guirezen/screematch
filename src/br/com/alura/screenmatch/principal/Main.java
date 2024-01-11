package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.calculos.CalculadoraDeTempo;
import br.com.alura.screenmatch.calculos.FiltroRecomendacao;
import br.com.alura.screenmatch.modelos.Episodio;
import br.com.alura.screenmatch.modelos.Filme;
import br.com.alura.screenmatch.modelos.Serie;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Filme meuFilme = new Filme("viveiro", 180, 2020);

        meuFilme.retornaDadosDoFilme();
        meuFilme.avalia(8);
        meuFilme.avalia(10);
        meuFilme.avalia(5.5);
        System.out.println(meuFilme.pegaMediaDasAvaliacoes());
        System.out.println(meuFilme.getTotalAvaliacoes());

        Serie serieLost = new Serie("Lost", 2006, 6, 8, 42);

        CalculadoraDeTempo calculadora = new CalculadoraDeTempo();
        calculadora.incluiTitulo(meuFilme);
        calculadora.incluiTitulo(serieLost);
        System.out.println(calculadora.getTempoTotal());

        FiltroRecomendacao filtro = new FiltroRecomendacao();
        filtro.filtraTitulo(meuFilme);

        Episodio episodio = new Episodio("Em busca de algo", 1, serieLost, 120);
        filtro.filtraTitulo(episodio);

        var filmeAvatar = new Filme("Avatar", 280, 2012);
        filmeAvatar.avalia(8);

        ArrayList<Filme> listaFilmes = new ArrayList<>();
        listaFilmes.add(filmeAvatar);
        listaFilmes.add(meuFilme);
        System.out.println("Tamanho da lista: " + listaFilmes.size());
        System.out.println("Primeiro filme da lista: " + listaFilmes.get(0).getNome());
        listaFilmes.forEach(filme -> System.out.println(filme.toString()));
    }
}