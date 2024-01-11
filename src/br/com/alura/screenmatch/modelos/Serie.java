package br.com.alura.screenmatch.modelos;

public class Serie extends Titulo {
    private int temporadas;
    private boolean ativa;
    private int episodiosPoTemporada;
    private int minutosPorTemporada;

    public Serie(String nome, int anoLancamento, int temporadas, int epPorTemporada, int duracao) {
        super(nome, anoLancamento);
        setTemporadas(temporadas);
        setEpisodiosPoTemporada(epPorTemporada);
        setDuracao(duracao);
    }

    public int getTemporadas() {
        return temporadas;
    }

    public void setTemporadas(int temporadas) {
        this.temporadas = temporadas;
    }

    public boolean isAtiva() {
        return ativa;
    }

    public void setAtiva(boolean ativa) {
        this.ativa = ativa;
    }

    public int getEpisodiosPoTemporada() {
        return episodiosPoTemporada;
    }

    public void setEpisodiosPoTemporada(int episodiosPoTemporada) {
        this.episodiosPoTemporada = episodiosPoTemporada;
    }

    public int getMinutosPorTemporada() {
        return minutosPorTemporada;
    }

    public void setMinutosPorTemporada(int minutosPorTemporada) {
        this.minutosPorTemporada = minutosPorTemporada;
    }

    @Override
    public int getDuracao() {
        return temporadas * episodiosPoTemporada * minutosPorTemporada;
    }

    @Override
    public String toString() {
        return "Série: " + getNome() + " (" + getAnoLancamento() + ")";
    }
}
