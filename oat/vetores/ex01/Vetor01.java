package exercicio.oat.vetores.ex01;

import java.util.Scanner;

public class Vetor01 {

    public static void main(String[] args) {

        //Chamada do metodo inicializador
        int[] vet_num = initVector();

        //Chamada do metodo de impressão
        System.out.println("Vetor criados: \n");
        printVector(vet_num);

        //Chamada do metodo de inversão
        System.out.println("\nVetor invertido: \n");
        invVector(vet_num);
        printVector(vet_num);

        //Chamada do metodo de verificação de pares
        System.out.println("\nVetor com valores pares: \n");
        int[] vet_par = evenVector(vet_num);
        printVector(vet_par);

    }

    public static int[] initVector() {

        int n;

        Scanner scanner = new Scanner(System.in);

        //Captura do tamanho do vetor
        System.out.println("Informe o tamanho desejado para o vetor: (Maior que zero)");
        do {
            n = scanner.nextInt();
            //Verificando se é um valor valido
            if (n <= 0)
                System.out.println("Informe um valor valido");
        } while (n <= 0);

        //Instanciação do vetor com o tamanho escolhido pelo usuario
        int [] vetor = new int[n];

        //Preenchimento do vetor
        for (int i = 0; i < vetor.length; i++) {
            System.out.println("Informe o " + (i+1) + "º valor:");
            vetor[i] = scanner.nextInt();
        }

        //Retorno do vetor preenchido
        return vetor;
    }

    public static void printVector(int[] vetor) {
        //Percorrendo o vetor recebido e imprimindo-o
        for (int i = 0; i < vetor.length; i++) {
            System.out.print(vetor[i] + " ");
        }
        System.out.println();
    }

    public static void invVector(int[] vetor) {

        int aux, ate;

        //Verificando se o tamanho do vetor é par
        if (vetor.length % 2 == 0)
            //Variavel para controle de loop recebe metade do tamanho do vetor
            ate = vetor.length / 2;
        else
            //Variavel para controle de loop recebe metade do tamanho do vetor + 1
            ate = (vetor.length / 2) + 1;


        //Percorrendo o vetor
        //Contador responsavel pela ultima posição
        int i2 = vetor.length-1;
        for (int i = 0; i < ate; i++) {
            //Variavel de auxilio recebe a primeira posição do vetor
            aux = vetor[i];
            //Vetor na primeira posição recebe a ultima posição
            vetor[i] = vetor[i2];
            //Vetor na ultima posição recebe o valor de auxilio
            vetor[i2] = aux;
            //Decremento da variavel contadora inversa
            i2--;
        }
    }

    public static int[] evenVector(int[] vetor) {

        int tamanhoVetor = 0;

        //Determinando quantos valores pares existem no vetor
        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] % 2 == 0) {
                tamanhoVetor++;
            }
        }

        //Instanciação de um vetor para valores pares com tamanho adequado
        int[] vetorPar = new int[tamanhoVetor];

        //Atribuindo os valores pares para o vetor criado
        //Contador secundario
        int j = 0;
        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] % 2 == 0) {
                vetorPar[j] = vetor[i];
                j++;
            }
        }

        //Retorno do vetor preenchido
        return vetorPar;
    }
}
