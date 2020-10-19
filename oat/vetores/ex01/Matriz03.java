package exercicio.oat.vetores.ex01;

public class Matriz03 {

    public static void main(String[] args) {

        //Instanciação da matriz
        int[][] mat_int = new int[3][4];

        //Preenchimento da matriz com valores crescentes
        int cresc = 10;
        for (int i = 0; i < mat_int.length; i++) {
            for (int j = 0; j < mat_int[0].length; j++) {
                mat_int[i][j] = cresc;
                cresc++;
            }
        }

        //Chamada do metodo de impressão
        System.out.println("Matriz criada:\n");
        printMat(mat_int);

        //Instanciação da matriz transposta com linhas e colunas invertidas
        int[][] mat_transposta = new int[mat_int[0].length][mat_int.length];

        //Preenchimento da matriz transposta com valores invertidos
        for (int i = 0; i < mat_transposta.length; i++) {
            for (int j = 0; j < mat_transposta[0].length; j++) {
                mat_transposta[i][j] = mat_int[j][i];
            }
        }

        //Chamada do metodo de impressão
        System.out.println("Matriz transposta:\n");
        printMat(mat_transposta);
    }

    public static void printMat(int[][] matriz) {
        //Percorrendo a matriz recebido e imprimindo-a
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
