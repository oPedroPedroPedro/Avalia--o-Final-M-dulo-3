import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Sistema implements Funcionalidades {

    List<Produto> produtos = new ArrayList<>();
    List<Vendas> vendas = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    @Override
    public void cadastrar(Produto produto) {
        produtos.add( produto ); 
    }

    @Override
    public void buscar(String nome) {
        
        if ( produtos.isEmpty() ) {
            System.out.println("\nNão existem produtos cadastrados para buscar!");
        } else {
            boolean achei = false;
            Produto produto = null;
            for (Produto p : produtos) {
                if ( p.getCodigoDoProduto().equals(nome) ) {
                    achei = true;
                    produto = p;
                }
            }

            if (achei) {
                System.out.println("\nProduto Encontrado!");
                System.out.println( produto.toString() );
            } else {
                System.out.println("\nO Produto não foi Encontrado!");
            }
        }
    }

    @Override
    public void listar() {
        if ( produtos.isEmpty() ) {
            System.out.println("Lista vazia!");
        } else {
            for (Produto produto : produtos) {
                System.out.println( produto );
            }   
            DoubleSummaryStatistics rodape = produtos.stream()
            .collect(Collectors.summarizingDouble(Produto :: getValorUnitario));

            System.out.println("\n-----------------------------------------------------------------------------------------------------");
            System.out.println("                                                 RODAPÉ                                              ");
            System.out.println("-----------------------------------------------------------------------------------------------------");
            System.out.println("Valor mínimo: " + rodape.getMin() + "   Valor médio: " + rodape.getAverage()
                + "   Valor máximo: " + rodape.getMax());
        }         
    }

    @Override
    public void relatorio() {
        if ( vendas.isEmpty() ) {
            System.out.println("\nNenhuma venda Registrada!");
        } else {
            for (Vendas venda : vendas) {
                System.out.println( venda );
            }   
            DoubleSummaryStatistics rodape = vendas.stream()
            .collect(Collectors.summarizingDouble(Vendas :: getValorVenda));

            System.out.println("-----------------------------------------------------------------------------------------------------");
            System.out.println("                                                 RODAPÉ                                              ");
            System.out.println("-----------------------------------------------------------------------------------------------------");
            System.out.println("\nValor médio das vendas desse período de emissão: " + rodape.getAverage());
        }
    }

    @Override
    public void vender(String nome, String data) {
        boolean achei = false;
        boolean continuar = false;
        boolean bug = true;
        Vendas venda = new Vendas();
        
        for ( Produto p : produtos) {
            
            if (p.getCodigoDoProduto().equals(nome)) {
                System.out.print("Digite quantos(as) '" + p.nomeDoProduto + "' deseja vender: ");
                venda.setQuantidadeVenda(scanner.nextInt());
                
                if (venda.getQuantidadeVenda()>p.getQuantidadeEstoque()){
                    System.out.println("\nA quantidade desejada excede o estoque!" +
                        " Deseja continuar a\nvenda com a quantidade dísponivel no estoque? ("
                            + p.getQuantidadeEstoque() + ")");
                    System.out.println("1 - SIM");
                    System.out.println("2 - NÂO");
                    System.out.print("Opção: ");
                    int resposta = scanner.nextInt();
                    
                    while (resposta < 1 || resposta > 2) {
                        limpa();
                        System.out.print("\nDigite uma opção válida: ");
                        resposta = scanner.nextInt();
                    }
                    if (resposta == 1){
                        continuar = true;
                        bug = false;
                    }
                    if (resposta == 2){
                        System.out.println("\nVenda Cancelada!");
                        System.out.println("\nPressione 'ENTER' para continuar.");
                        scanner.nextLine();
                        bug = false;
                    }
                }
                else{
                    continuar = true;
                    bug = false;
                }
                if(continuar){
                    achei = true;

                    venda.setDataVenda(data);
                    venda.setNomeVenda(p.getNomeDoProduto());
                    venda.setCodigoVenda(p.getCodigoDoProduto());
                    venda.setValorProduto(p.getValorUnitario());
                    venda.setValorVenda(venda.getQuantidadeVenda() * venda.getValorProduto());
                    bug = false;
                }
            }
            if (achei) {
                limpa();
                System.out.println("-----------------------------------------------------------------------------------------------------");
                System.out.println("                                                VENDA                                                ");
                System.out.println("-----------------------------------------------------------------------------------------------------");
                System.out.println( venda.toString() );
                System.out.println("\nVenda realizada com sucesso! Pressione 'ENTER' para continuar!");
                p.quantidadeEstoque -= venda.quantidadeVenda;
                vendas.add( venda );
                bug = false;
            }
            if (bug){
                System.out.println("\nO Produto não foi Encontrado!");
                System.out.println("\nPresseione 'ENTER' para continaur!");
                scanner.nextLine();
                break;
            }
        }
        if (produtos.isEmpty()){
            System.out.println("\nNão Existem Produtos cadastrados para vender!");
            System.out.println("\nPressione 'ENTER' para continuar!");
            scanner.nextLine();
        }
    }

    public static void limpa(){
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }
}
