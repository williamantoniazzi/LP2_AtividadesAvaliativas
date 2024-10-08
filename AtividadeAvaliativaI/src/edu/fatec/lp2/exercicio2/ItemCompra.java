package edu.fatec.lp2.exercicio2;

public class ItemCompra implements Calculavel{
    private int quantidade;
    private Produto produto;
    private double desconto;

    public ItemCompra(Produto produto, double desconto) {
        this.produto = produto;
        this.desconto = desconto;
    }

    @Override
    public double calcularPreco() {
        if (desconto <= produto.getDescontoMaximo()) {
            double precoComDesconto = produto.getPreco() * (1 - desconto / 100);
            return precoComDesconto * quantidade;  // aqui multiplicará pela quantidade
        } else {
            System.out.println("Desconto inválido. Usando preço sem desconto.");
            return produto.getPreco() * quantidade;
        }
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }
}
