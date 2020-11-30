package exercicio.oat.arvore;

public class No {

    public int valor;
    public No esq;
    public No dir;

    public No(int valor) {
        this.valor = valor;
        this.dir = null;
        this.esq = null;
    }
}
