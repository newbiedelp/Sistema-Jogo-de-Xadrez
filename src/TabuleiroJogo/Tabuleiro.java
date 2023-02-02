package TabuleiroJogo;

public class Tabuleiro {
    private int linhas;
    private int colunas;
    private Peca[][] pecas;

    public Tabuleiro(int linhas, int colunas) {
        if (linhas<1 || colunas<1){
            throw new TabuleiroException("Erro ao gerar tabuleiro, pois é necessario ao menos uma linha e uma coluna");
        }
        this.linhas = linhas;
        this.colunas = colunas;
        pecas = new Peca[linhas][colunas];
    }

    public int getLinhas() {
        return linhas;
    }

    public int getColunas() {
        return colunas;
    }

    public Peca peca(int linha,int coluna){
        if (!posicaoExiste(linha,coluna)){
            throw new TabuleiroException("Posição não presente no tabuleiro");
        }
        return pecas[linha][coluna];
    }

    public Peca peca(Posicao posicao){
        if (!posicaoExiste(posicao)){
            throw new TabuleiroException("Posição não presente no tabuleiro");
        }
        return pecas[posicao.getLinha()][posicao.getColuna()];
    }

    public void colocapeca(Peca peca,Posicao posicao){
        if (possuiPeca(posicao)){
            throw new TabuleiroException("Já existe uma peça nessa posição " + posicao);
        }
        pecas[posicao.getLinha()][posicao.getColuna()] = peca;
        peca.posicao = posicao;
    }

    public Peca removerPeca(Posicao posicao){
        if (!posicaoExiste(posicao)){
            throw new TabuleiroException("Pòsição não esta no tabuleiro");
        }
        if (peca(posicao)==null){
            return null;
        }
        Peca aux =peca(posicao);
        aux.posicao = null;
        pecas[posicao.getLinha()][posicao.getColuna()]=null;
        return aux;
    }

    private boolean posicaoExiste(int linha,int coluna){
        return linha >= 0 && linha<linhas && coluna >=0 && coluna<colunas;
    }
    public boolean posicaoExiste(Posicao posicao){
        return posicaoExiste(posicao.getLinha(), posicao.getColuna());
    }

    public boolean possuiPeca(Posicao posicao){
        if (!posicaoExiste(posicao)){
            throw new TabuleiroException("Posição não presente no tabuleiro");
        }
        return peca(posicao) != null;
    }


}
