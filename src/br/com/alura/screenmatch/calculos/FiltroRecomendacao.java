package br.com.alura.screenmatch.calculos;

import br.com.alura.screenmatch.modelos.Titulo;

public class FiltroRecomendacao {
    public void filtraTitulo(Classificavel classificavel) {
        if (classificavel.getClassificacao() >= 4) {
            System.out.println("Está entre os preferidos do momento.");
        } else if (classificavel.getClassificacao() >= 2) {
            System.out.println("muito bem avaliado no momento!");
        } else {
            System.out.println("coloque na sua lista para ver dps.");
        }
    }
}
