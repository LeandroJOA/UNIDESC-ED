package exercicio.oat.arvore;

public class Arvore {

    public No raiz_principal;

    public Arvore() {

        this.raiz_principal = null;
    }

    //Metodo de inserção sem recursividade
    public void insertarNo(int valor) {

        if (raiz_principal == null) {
            raiz_principal = new No(valor);
            return;
        } else {
            No raiz_temp = raiz_principal;

            while (raiz_temp != null) {
                //Valor a esquerda
                if (valor < raiz_temp.valor) {
                    if (raiz_temp.esq == null) {
                        raiz_temp.esq = new No(valor);
                        return;
                    } else {
                        raiz_temp = raiz_temp.esq;
                        continue;
                    }
                    //Valor a direita
                } else {
                    if (raiz_temp.dir == null) {
                        raiz_temp.dir = new No(valor);
                        return;
                    } else {
                        raiz_temp = raiz_temp.dir;
                        continue;
                    }
                }
            }
        }
    }

    public void insertar(int valor) {
        raiz_principal = insertarRecursivo(raiz_principal, valor);
    }

    //Metodo de inserção com recursividade
    private No insertarRecursivo(No raiz_temp, int valor) {

        if (raiz_temp == null) {
            return new No(valor);
        } else {
            //Nó a esquerda
            if (valor < raiz_temp.valor) {
                raiz_temp.esq = insertarRecursivo(raiz_temp.esq, valor);
                //Nó a esquerda
            } else {
                raiz_temp.dir = insertarRecursivo(raiz_temp.dir, valor);
            }
            return raiz_temp;
        }
    }

    //Metodo para imprimir arvore com recursividade
    public void imprimir() {
        imprimirRecursivo(raiz_principal, 0);
    }

    //Metodo de inserção com recursividade
    private void imprimirRecursivo(No raiz_temp, int cont) {

        if (raiz_temp == null) {
            return;
        } else {
            imprimirRecursivo(raiz_temp.dir, cont + 1);

            for (int i = 0; i < cont; i++)
                System.out.print("    ");

            System.out.println(raiz_temp.valor);
            imprimirRecursivo(raiz_temp.esq, cont + 1);
        }
    }

    //Metodo para remoção
    public void deletar(int valor) {
        raiz_principal = deletarRecursivo(raiz_principal, valor);
    }

    //Metodo para remoção com recursividade
    private No deletarRecursivo(No raiz_temp, int valor) {

        if(raiz_temp == null) {
            return null;
        } else {
            if (valor == raiz_temp.valor) {
                if(raiz_temp.esq == null && raiz_temp.dir == null) {
                    return null;
                } else if(raiz_temp.esq == null) {
                    return raiz_temp.dir;
                } else if(raiz_temp.dir == null) {
                    return raiz_temp.esq;
                } else {
                    int minValue = menorValor(raiz_temp.dir);
                    raiz_temp.valor = minValue;
                    raiz_temp.dir = deletarRecursivo(raiz_temp.dir, minValue);
                }
            } else if(valor < raiz_temp.valor) {
                raiz_temp.esq = deletarRecursivo(raiz_temp.esq, valor);
            }else {
                raiz_temp.dir = deletarRecursivo(raiz_temp.dir, valor);
            }
        }

        return raiz_temp;
    }

    //Metodo para encontrar o menor valor
    private int menorValor(No raiz) {

        if(raiz.esq != null) {
            return menorValor(raiz.esq);
        }
        return raiz.valor;
    }
}
