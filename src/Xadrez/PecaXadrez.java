package Xadrez;

import TabuleiroJogo.Peca;
import TabuleiroJogo.Tabuleiro;

public class PecaXadrez extends Peca{
    private Cor cor;

    public PecaXadrez(Tabuleiro tabuleiro, Cor cor) {
        super(tabuleiro);
        this.cor = cor;
    }
}
