

public class Produto {

    Produto(){
    }

    public Produto(String codigoDoProduto, String nomeDoProduto, double valorUnitario, int quantidadeEstoque){
        this.codigoDoProduto = codigoDoProduto;
        this.nomeDoProduto = nomeDoProduto;
        this.valorUnitario = valorUnitario;
        this.quantidadeEstoque = quantidadeEstoque;
    }

    String codigoDoProduto = null;
    String nomeDoProduto;
    double valorUnitario;
    int quantidadeEstoque;

    public String getCodigoDoProduto() {
        return codigoDoProduto;
    }

    public void setCodigoDoProduto(String codigoDoProduto) {
        this.codigoDoProduto = codigoDoProduto;
    }

    public String getNomeDoProduto() {
        return nomeDoProduto;
    }

    public void setNomeDoProduto(String nomeDoProduto) {
        this.nomeDoProduto = nomeDoProduto;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }
    
    @Override
    public String toString() {
        return "Código do Produto: " + codigoDoProduto + "  //  Nome do Produto: " + nomeDoProduto +
            "  //  Quantidade em Estoque: " + quantidadeEstoque + "  //  Valor Unitário: " + valorUnitario;
    }
}
