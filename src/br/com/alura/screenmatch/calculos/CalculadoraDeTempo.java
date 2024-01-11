package br.com.alura.screenmatch.calculos;

import br.com.alura.screenmatch.modelos.Filme;
import br.com.alura.screenmatch.modelos.Serie;
import br.com.alura.screenmatch.modelos.Titulo;

public class CalculadoraDeTempo {
    private int tempoTotal;
    private Titulo titulo;

    public int getTempoTotal() {
        return tempoTotal;
    }

    public void incluiTitulo(Titulo titulo) {
        tempoTotal += titulo.getDuracao();
    }
}
