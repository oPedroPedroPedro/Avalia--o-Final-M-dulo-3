public class Vendas {
    
    Vendas(){
    }

    public Vendas(String dataVenda, String codigoVenda, String nomeVenda, int quantidadeVenda, double valorProduto, double valorVenda){
        this.dataVenda = dataVenda;
        this.codigoVenda = codigoVenda;
        this.nomeVenda = nomeVenda;
        this.quantidadeVenda = quantidadeVenda;
        this.valorProduto = valorProduto;
        this.valorVenda = valorVenda;
    }

    String dataVenda;
    String codigoVenda;
    String nomeVenda;
    int quantidadeVenda;
    double valorProduto;
    double valorVenda;

    public String getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(String dataVenda) {
        this.dataVenda = dataVenda;
    }

    public String getCodigoVenda() {
        return codigoVenda;
    }

    public void setCodigoVenda(String codigoVenda) {
        this.codigoVenda = codigoVenda;
    }

    public String getNomeVenda() {
        return nomeVenda;
    }

    public void setNomeVenda(String nomeVenda) {
        this.nomeVenda = nomeVenda;
    }

    public int getQuantidadeVenda() {
        return quantidadeVenda;
    }

    public void setQuantidadeVenda(int quantidadeVenda) {
        this.quantidadeVenda = quantidadeVenda;
    }

    public double getValorProduto() {
        return valorProduto;
    }

    public void setValorProduto(double valorProduto) {
        this.valorProduto = valorProduto;
    }

    public double getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(double valorVenda) {
        this.valorVenda = valorVenda;
    }

    @Override
    public String toString() {
        return "\nData da venda: " + dataVenda + "  //  Nome do Produto Vendido: " + nomeVenda +
            "  //  Valor do Produto: " + valorProduto + "\nQuantidade: " + quantidadeVenda +
                "  //  Valor Total da Venda: " + valorVenda;
    }
}
