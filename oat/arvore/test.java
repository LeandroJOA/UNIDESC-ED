package exercicio.oat.arvore;

public class test {

    public static void main(String[] args) {

        Arvore arvore = new Arvore();

        arvore.insertarNo(10);
        arvore.insertarNo(20);
        arvore.insertarNo(25);
        arvore.insertarNo(6);
        arvore.insertarNo(1);

        arvore.imprimir();

        arvore.deletar(20);

        System.out.println("\nNodulo deletado com sucesso!\n");

        arvore.imprimir();
    }
}
