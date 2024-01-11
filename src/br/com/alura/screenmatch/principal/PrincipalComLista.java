package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.modelos.Episodio;
import br.com.alura.screenmatch.modelos.Filme;
import br.com.alura.screenmatch.modelos.Serie;
import br.com.alura.screenmatch.modelos.Titulo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class PrincipalComLista {
    public static void main(String[] args) {
        Filme meuFilme = new Filme("Viveiro", 180, 2020);
        Serie serieLost = new Serie("Lost", 2006, 6, 8, 42);
        Episodio episodio = new Episodio("Em busca de algo", 1, serieLost, 120);
        var filmeAvatar = new Filme("Avatar", 280, 2012);
        var serieSupernatural = new Serie("Supernatural", 2004, 16, 10, 1200);

        ArrayList<Titulo> lista = new ArrayList<>();
        lista.add(filmeAvatar);
        lista.add(meuFilme);
        lista.add(serieLost);

        for (Titulo item: lista) {
            System.out.println(item);
            if (item instanceof Filme filme) {
                System.out.println("Classificação do filme: " + filme.getClassificacao());
            }
        }

        var buscaPorArtista = new ArrayList<String>();
        buscaPorArtista.add("Adam Sandler");
        buscaPorArtista.add("paulo");
        buscaPorArtista.add("Jaqueline");

        Collections.sort(buscaPorArtista);
        System.out.println(buscaPorArtista);

        Collections.sort(lista);
        System.out.println(lista);

        lista.sort(Comparator.comparing(Titulo::getAnoLancamento));
        System.out.println("Lista ordenada por ano: " + lista);
    }
}
