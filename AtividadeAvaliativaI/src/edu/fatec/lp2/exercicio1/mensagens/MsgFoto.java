package edu.fatec.lp2.exercicio1.mensagens;

public class MsgFoto extends Mensagem{
    private int tamanho;

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    @Override
    public void sendMessage(String msg) {
        System.out.println("Enviando mensagem com foto com tamanho de " + tamanho + " bytes.");
    }
}
