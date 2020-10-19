package exercicio.oat.vetores.ex01;

import java.util.Scanner;

public class Matriz04 {

    static Scanner scanner = new Scanner(System.in);

    static boolean matPreenchida = false, vetPreenchido = false;

    public static void main(String[] args) {

        int op;

        int[][] mat_produtoDia = new int[3][7];
        float[] vet_preco = new float[3];

        //Repete ate que o usuario escolha encerrar o programa
        do {
            //Chama o metodo que imprime o menu
            menuOpcao();
            System.out.println("Informe a opção desejada: ");
            //Captura opção escolhida
            op = scanner.nextInt();
            //Solução temporaria para inconveniência do nextLine
            scanner.nextLine();

            //Tratando a opção escolhida
            switch (op) {
                //Inserir quantidade de vendas
                case 1:
                    //Chama metodo para inserção de quantidade
                    inserirQuantidade(mat_produtoDia);
                    //Indica que a quantidade já foi informada
                    matPreenchida = true;
                    break;
                //Inserir valor de produtos
                case 2:
                    //Chama metodo para inserção de preços
                    inserirValor(vet_preco);
                    //Indica que o preço já foi informado
                    vetPreenchido = true;
                    break;
                //Total de vendas
                case 3:
                    //Verifica se tanto a quantidade quanto o preço já foram preenchidos
                    if (matPreenchida && vetPreenchido)
                        //Chama metodo para calcular os totais
                        calcularTotal(mat_produtoDia, vet_preco);
                    else
                        //Mensagem de erro
                        System.out.println("\nERROR quantidade de vendas e/ou valor ainda não foram informados!");
                    break;
                //Estatísticas
                case 4:
                    //Verifica se tanto a quantidade quanto o preço já foram preenchidos
                    if (matPreenchida && vetPreenchido)
                        //Chama metodo para calcular informações adicionais
                        estatisticas(mat_produtoDia);
                    else
                        //Mensagem de erro
                        System.out.println("\nERROR quantidade de vendas e/ou valor ainda não foram informados!");
                    break;
                //Sair
                case 5:
                    //Mensagem de finalização
                    System.out.println("\nFinalizando o programa...");
                    break;
                //N.d.a
                default:
                    //Mensagem de erro
                    System.out.println("ERROR opção invalida!");
            }
        } while (op != 5);
    }

    //Metodo para impressão do menu de opções
    public static void menuOpcao() {

        //Mecanismo para permitir melhor visualização dos retornos
        System.out.println("\nPressione ENTER para continuar...");
        scanner.nextLine();
        System.out.println("\n\n+---------MENU DE OPÇÔES---------+");
        System.out.println("|   <Nome Generico> E-Commerce   |");
        System.out.println("|                                |");
        System.out.println("| 1) Inserir quantidade de vendas|");
        System.out.println("| 2) Inserir valor de produtos   |");
        System.out.println("| 3) Total de vendas             |");
        System.out.println("| 4) Estatísticas                |");
        System.out.println("| 5) Sair                        |");
        System.out.println("+--------------------------------+\n\n");
    }


    //Metodo para indentificar o dia da semana apartir de sua posição
    public static String identificarDia(int codigoSemana) {

        switch (codigoSemana) {
            case 0:
                return "domingo";
            case 1:
                return "segunda-feira";
            case 2:
                return "terça-feira";
            case 3:
                return "quarta-feira";
            case 4:
                return "quinta-feira";
            case 5:
                return "sexta-feira";
            default:
                return "sabado";
        }
    }

    //Metodo para identificar o produto apartir de sua posição
    public static String identificarProduto(int codigoProduto) {

        if (codigoProduto == 0)
            return "HD 1TB";
        else if (codigoProduto == 1)
            return "SSD 120GB";
        else
            return "SSD 240GB";
    }

    //Metodo para inserção da quantidade de vendas de cada produto em cada dia da semana
    public static void inserirQuantidade(int[][] matriz) {

        String produto, semana;

        //Percorre a matriz
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {

                //Recebe produto referente a posição atual
                produto = identificarProduto(i);
                //Recebe dia da semana referente a posição atual
                semana = identificarDia(j);

                //Captura quantidade de vendas do produto atual no dia da semana atual
                System.out.println("Informe quantos(as) '" + produto + "' foram vendidos(as) na(o) " + semana + ":");
                matriz[i][j] = scanner.nextInt();
                //Solução temporaria para inconveniência do nextLine
                scanner.nextLine();
            }
        }
    }

    //Metodo para inserção do preço de cada produto
    public static void inserirValor(float[] vetor) {

        String produto;

        //Percorre o vetor
        for (int i = 0; i < vetor.length; i++) {
            //Recebe produto referente a posição atual
            produto = identificarProduto(i);

            //Captura o preço do produto atual
            System.out.println("Informe o valor do(a) '" + produto + "': ");
            vetor[i] = scanner.nextFloat();
            //Solução temporaria para inconveniência do nextLine
            scanner.nextLine();
        }
    }

    //Metodo para calcular total de vendas por produto e da semana
    public static void calcularTotal(int[][] quantidade, float[] preco) {

        int quantidadeTotal;
        float valorTotal = 0;
        String produto, produtoTotal;

        System.out.println("\n-------------VENDAS-------------\n");
        System.out.println("PRODUTO  |  QNT  |  TOTAL");

        //Percorre a matriz
        for (int i = 0; i < quantidade.length; i++) {
            //Redefine a variavel de quantidade de vendas de um produto na semana
            quantidadeTotal = 0;
            for (int j = 0; j < quantidade[0].length; j++) {
                //Recebe o total de vendas na semana do produto na posição atual
                quantidadeTotal += quantidade[i][j];
            }

            //Recebe total de vendas do produto atual no formato de moeda
            produtoTotal = String.format("%.2f", quantidadeTotal * preco[i]);

            //Recebe produto referente a posição atual
            produto = identificarProduto(i);

            //Imprime o produto atual, sua quantidade de vendas e o valor total
            System.out.println(produto + " - " + quantidadeTotal + " - R$" + produtoTotal);

            //Variavel responsavel pela soma do total de todos os produtos
            valorTotal += (quantidadeTotal * preco[i]);
        }

        //Imprime o total de vendas na semana
        System.out.println("\nTotal de vendas na semana: R$" + String.format("%.2f", valorTotal));
        System.out.println("\n--------------------------------\n");
    }

    //Metodo para calcular o produto mais vendido e o dia com mais vendas
    public static void estatisticas(int[][] quantidade) {

        int produtoMV = 0, diaMV = 0, somaProduto, maiorSomaProduto = 0, somaDia, maiorSomaDia = 0;

        //Percorre a matriz afim de identificar a quantidade de vendas por produto
        for (int i = 0; i < quantidade.length; i++) {
            //Redefine a variavel de quantidade de vendas por produto
            somaProduto = 0;
            for (int j = 0; j < quantidade[0].length; j++) {
                //Recebe o total de vendas na semana do produto na posição atual
                somaProduto += quantidade[i][j];
            }

            //Verifica se o produto atual possui a maior quantidade de vendas
            if (somaProduto > maiorSomaProduto) {
                //Recebe a quantidade considerada atualmente como maior
                maiorSomaProduto = somaProduto;
                //Recebe a posição do produto na posição atual
                produtoMV = i;
            }
        }

        //Percorre a matriz de forma invertida afim de identificar a quantidade de vendas por dia
        for (int j = 0; j < quantidade[0].length; j++) {
            //Redefine a variavel de quantidade de vendas por dia
            somaDia = 0;
            for (int i = 0; i < quantidade.length; i++) {
                //Recebe o total de vendas na semana no dia na posição atual
                somaDia += quantidade[i][j];
            }

            //Verifica se o dia atual possui a maior quantidade de vendas
            if (somaDia > maiorSomaDia) {
                //Recebe a quantidade considerada atualmente como maior
                maiorSomaDia = somaDia;
                //Recebe a posição do dia na posição atual
                diaMV = j;
            }
        }

        //Recebe produto referente a posição capturada anteriormente
        String produto = identificarProduto(produtoMV);
        //Recebe produto referente a posição capturada anteriormente
        String dia = identificarDia(diaMV);

        //Imprime o produto com mais vendas e sua quantidade de vendas
        System.out.println("\nProduto mais vendido da semana: '" + produto + "' com " + maiorSomaProduto + " vendas!");
        //Imprime o dia da semana com mais vendas e sua quantidade de vendas
        System.out.println("Dia da semana com mais vendas: " + dia + " com " + maiorSomaDia + " produtos vendidos!\n");
    }

    /*
        Melhorias a serem feitas:
            -Não permitir a inserção de valores negativos
            -Identificar quando varios produtos/dias possuem a mesma quantidade de vendas
            ...
     */
}
