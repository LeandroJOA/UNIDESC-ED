package exercicio.oat.vetores.ex01;

import java.util.Scanner;

public class Vetor02 {

    public static void main(String[] args) {

        //Chamada do metodo inicializador
        System.out.println("Informe o tamnho do 1º vetor: (Maior que zero)");
        int[] v1 = initVector();
        System.out.println("Informe o tamnho do 2º vetor: (Maior que zero)");
        int[] v2 = initVector();

        //Chamada do metodo de impressão
        System.out.println("Vetores criados: \n");
        printVetor(v1);
        printVetor(v2);

        //Chamada do metodo de concatenação
        System.out.println("\nVetores concatenados: \n");
        int[] v3 = appendVector(v1, v2);
        printVetor(v3);

        //Chamada do metodo para valores perfeitos
        System.out.println("\nVetor com valores perfeitos: \n");
        int[] v4 = perfectVector(v3);
        printVetor(v4);
    }

    public static int[] initVector() {

        int n;

        Scanner scanner = new Scanner(System.in);

        //Captura do tamanho do vetor
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

    public static int[] appendVector(int[] vetor1, int[] vetor2) {

        //Instanciação de um vetor com tamanho igual a soma do tamanho dos vetores recebidos
        int[] vetor3 = new int[vetor1.length + vetor2.length];


        //Preenchimento das primeiras posições do vetor 3 com os valores do primeiro vetor recebido
        for (int i = 0; i < vetor1.length; i++) {
            vetor3[i] = vetor1[i];
        }

        //Preenchimento das ultimas posições do vetor 3 com os valores do segundo vetor recebido
        int i2 = 0;
        for (int i = vetor1.length; i < vetor3.length; i++) {
            vetor3[i] = vetor2[i2];
            i2++;
        }

        //Retorno do terceito vetor preenchido
        return vetor3;
    }

    public static int[] perfectVector(int[] vetor) {

        int somaDivisiveis = 0, quantDivisiveis = 0;

        //Percorrendo o vetor recebido para identificar quantos valores perfeitos existem
        for (int i = 0; i < vetor.length; i++) {
            //Identificando os valores que são divisiveis pelo valor do vetor na posição atual
            for (int j = 1; j < vetor[i]; j++) {
                //Somando todos os valores que são divisiveis
                if (vetor[i] % j == 0) {
                    somaDivisiveis += j;
                }
            }

            //Verificando o valor na posição do vetor é perfeito
            if (somaDivisiveis == vetor[i]){
                //Identificando quantos valores são perfeitos
                quantDivisiveis++;
            }
            //Resetando a soma dos divisiveis
            somaDivisiveis = 0;
        }

        //Verificando se foi encontrado pelo menos algum valor perfeito
        if (quantDivisiveis > 0) {
            //Instanciação do vetor com valor perfeitos com tamanho adequado
            int[] vetor4 = new int[quantDivisiveis];

            int i2 = 0;
            //Percorrendo o vetor recebido para preencher o novo vetor criado
            for (int i = 0; i < vetor.length; i++) {
                //Identificando os valores que são divisiveis pelo valor do vetor na posição atual
                for (int j = 1; j < vetor[i]; j++) {
                    //Somando todos os valores que são divisiveis
                    if (vetor[i] % j == 0) {
                        somaDivisiveis += j;
                    }
                }

                //Verificando o valor na posição do vetor é perfeito
                if (somaDivisiveis == vetor[i]){
                    //Atribuindo o valor perfeito ao novo vetor criado
                    vetor4[i2] = vetor[i];
                    //Incremento do contador do vetor 4
                    i2++;
                }
                //Resetando a soma dos divisiveis
                somaDivisiveis = 0;
            }

            //Retornando o vetor preenchido
            return vetor4;
        } else
            //Mensagem de erro
            System.out.println("Não existem valores perfeitos neste vetor");

        return null;
    }

    public static void printVetor(int[] vetor) {
        //Verificando se o vetor recebido não é nulo
        if (vetor != null) {
            //Percorrendo o vetor recebido e imprimindo-o
            for (int i = 0; i < vetor.length; i++) {
                System.out.print(vetor[i] + " ");
            }
            System.out.println();
        }
    }
}
