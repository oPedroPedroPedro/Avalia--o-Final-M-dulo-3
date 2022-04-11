import java.util.Scanner;

public class LojaQueExplode {
    public static void main(String[] args) throws Exception {
        
        Scanner scanner = new Scanner(System.in);
        Sistema sistema = new Sistema();
        int opcao;
        
        try {
            do{
                System.out.println("\n****\nMENU\n****\n");
                System.out.println("1 - Cadastrar produto");
                System.out.println("2 - Consultar produto");
                System.out.println("3 - Listar produtos");
                System.out.println("4 - Vendas por período");
                System.out.println("5 - Realizar venda");
                System.out.println("0 - Sair");
                System.out.print("Opção: ");
                opcao = scanner.nextInt();
                scanner.nextLine();

                switch (opcao) {
                    case 1:
                    //CADASTRAR
                        limpa();
                        System.out.println("-----------------------------------------------------------------------------------------------------");
                        System.out.println("                                               CADASTRAR                                             ");
                        System.out.println("-----------------------------------------------------------------------------------------------------");
                        
                        System.out.print("Digite o código do produto a ser cadastrado: ");
                        String codigoDoProduto = scanner.nextLine();
                            if(codigoDoProduto.matches("")){
                                System.out.println("\nO Código do produto não pode ser vazio!");
                                System.out.print("\nPressione 'ENTER' para continuar.");
                                scanner.nextLine();
                                limpa();
                                break;
                            }
                            if(codigoDoProduto.matches(".*[A-z].*")){
                                System.out.println("\nO Código do produto deve conter somente números!");
                                System.out.print("\nPressione 'ENTER' para continuar.");
                                scanner.nextLine();
                                limpa();
                                break;
                            }
                        System.out.print("Digite o nome do produto a ser cadastrado: ");
                        String nomeDoProduto = scanner.nextLine();
                            if(nomeDoProduto.matches("")){
                                System.out.println("\nO Nome do Produto não pode ser vazio!");
                                System.out.println("\nPressione 'ENTER' para continuar.");
                                scanner.nextLine();
                                limpa();
                                break;
                            }
                        System.out.print("Digite o valor do produto a ser cadastrado: ");
                        double valorUnitario = scanner.nextDouble();
                            if(valorUnitario <= 0){
                                System.out.println("\nO Valor do produto deve ser maior que 0!");
                                System.out.println("\nPressione 'ENTER' para continuar.");
                                scanner.nextLine();
                                limpa();
                                break;
                            }
                        System.out.print("Digite quantos '" + nomeDoProduto + 
                            "' existem (existirão) no estoque: ");
                        int quantidadeEstoque = scanner.nextInt();
                        scanner.nextLine();
                            if(quantidadeEstoque <= 0){
                                System.out.println("\nDeve haver pelo menos um exemplar do produto para estoque!");
                                System.out.println("\nPressione 'ENTER' para continuar.");
                                scanner.nextLine();
                                limpa();
                                break;
                            }
                        Produto produto = new Produto(codigoDoProduto, nomeDoProduto, valorUnitario, quantidadeEstoque);
                        sistema.cadastrar(produto);


                        System.out.print("\nProduto cadastrado com sucesso! Pressione 'ENTER' para continuar.");
                        scanner.nextLine();
                        limpa();
                        break;
                
                    case 2:
                    //CONSULTAR
                        limpa();
                        System.out.println("-----------------------------------------------------------------------------------------------------");
                        System.out.println("                                               CONSULTAR                                             ");
                        System.out.println("-----------------------------------------------------------------------------------------------------");
                        System.out.print("Digite o código do produto a ser consultado: ");
                        String codigoBuscando = scanner.next();
                            if(codigoBuscando.matches("")){
                                System.out.println("\nO Código do produto não pode ser vazio!");
                                System.out.print("\nPressione 'ENTER' para continuar.");
                                scanner.nextLine();
                                limpa();
                                break;
                            }
                            if(codigoBuscando.matches(".*[A-z].*")){
                                System.out.println("\nO Código do produto deve conter somente números!");
                                System.out.print("\nPressione 'ENTER' para continuar.");
                                scanner.nextLine();
                                scanner.nextLine();
                                limpa();
                                break;
                            }
                        scanner.nextLine();
                        sistema.buscar(codigoBuscando);
                        System.out.print("\nPressione 'ENTER' para continuar.");
                        scanner.nextLine();
                        limpa();
                        break;
                    
                    case 3:
                    //LISTAR
                        limpa();
                        System.out.println("-----------------------------------------------------------------------------------------------------");
                        System.out.println("                                                 LISTAR                                              ");
                        System.out.println("-----------------------------------------------------------------------------------------------------");
                        sistema.listar();
                        
                        System.out.print("\nPressione 'ENTER' para continuar.");
                        scanner.nextLine();
                        limpa();
                        break;

                    case 4:
                    //VENDAS POR PERÍODO
                        limpa();
                        System.out.println("-----------------------------------------------------------------------------------------------------");
                        System.out.println("                                          VENDAS POR PERÍODO                                         ");
                        System.out.println("-----------------------------------------------------------------------------------------------------");
                        sistema.relatorio();

                        System.out.print("\nPressione 'ENTER' para continuar.");
                        scanner.nextLine();
                        limpa();
                        break;

                    case 5:
                    //FAZER VENDA
                        limpa();
                        System.out.println("-----------------------------------------------------------------------------------------------------");
                        System.out.println("                                              FAZER VENDA                                            ");
                        System.out.println("-----------------------------------------------------------------------------------------------------");
                        System.out.print("Digite a data de hoje: ");
                        String data = scanner.nextLine();
                        if(data.matches("")){
                            System.out.println("\nA data não pode ser vazia!");
                            System.out.println("\nPressione 'ENTER' para continuar.");
                            scanner.nextLine();
                            limpa();
                            break;
                        }
                        if(data.matches(".*[A-z].*")){
                            System.out.println("\nA data não pode conter letras (dd/mm/aaaa)");
                            System.out.println("\nPressione 'ENTER' para continuar.");
                            scanner.nextLine();
                            limpa();
                            break;
                        }
                        if(!data.matches("\\d{2}/\\d{2}/\\d{4}")){
                            System.out.println("\nA data deve estar na ordem correta! (dd/mm/aaaa)");
                            System.out.println("\nPressione 'ENTER' para continuar.");
                            scanner.nextLine();
                            limpa();
                            break;
                        }

                        System.out.print("Digite o código do produto para realizar a venda: ");
                        String codigoVenda = scanner.next();
                        scanner.nextLine();

                        sistema.vender(codigoVenda, data);

                        scanner.nextLine();
                        limpa();
                        break;
                }

                if(opcao < 0 || opcao > 5){
                    System.out.println("Opção Inválida! Pressione 'ENTER' para continuar!");
                    scanner.nextLine();
                }

            }while(opcao != 0);

        } catch (Exception e) {
            System.out.println("\nOcorreu um erro! Encerrando o Programa.\n");
            System.exit(0);
        }

        System.out.println("Fim do programa!\n");

        scanner.close();

    }
    
    private static void limpa(){
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }
}
