package edu.fatec.lp2.exercicio2;

import java.util.ArrayList;
import java.util.List;

public class ListaCompra implements Calculavel {
    private List<ItemCompra> itensCompra;  // Mudança de array para ArrayList
    private int qtdeMax;

    public ListaCompra(int qtdeMax) {
        this.itensCompra = new ArrayList<>();  // Inicializa o ArrayList
        this.qtdeMax = qtdeMax;
    }

    public void incluir(ItemCompra item) {
        if (itensCompra.size() < qtdeMax) {
            itensCompra.add(item);  // Adiciona o item à lista
        } else {
            System.out.println("Máximo de compras atingido.");
        }
    }

    @Override
    public double calcularPreco() {
        double precoTotal = 0;
        for (ItemCompra item : itensCompra) {
            precoTotal += item.calcularPreco();  // O cálculo já inclui a quantidade
        }
        return precoTotal;
    }

    public void listarCompras() {
        System.out.println("Lista de Compras:");
        for (ItemCompra item : itensCompra) {
            Produto produto = item.getProduto();
            double precoComDesconto = item.calcularPreco() / item.getQuantidade();  // Para obter o preço unitário
            System.out.println("Produto: " + produto.getNome() +
                    ", Quantidade: " + item.getQuantidade() +
                    ", Preço Unitário (com desconto): R$ " + String.format("%.2f", precoComDesconto) +
                    ", Preço Total: R$ " + String.format("%.2f", item.calcularPreco()));
        	}
        }

        public int getQtdeMax() {
            return qtdeMax;
        }

        public void setQtdeMax(int qtdeMax) {
            this.qtdeMax = qtdeMax;
        }
}
