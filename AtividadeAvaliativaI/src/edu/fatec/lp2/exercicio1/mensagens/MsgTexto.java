package edu.fatec.lp2.exercicio1.mensagens;

public class MsgTexto extends Mensagem{
    private int numChar;

    public int getNumChar() {
        return numChar;
    }

    public void setNumChar(int numChar) {
        this.numChar = numChar;
    }

    @Override
    public void sendMessage(String msg) {
        System.out.println("Enviando mensagem de texto: " + msg);
    }
}
