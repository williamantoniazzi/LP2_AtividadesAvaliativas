package edu.fatec.lp2.exercicio1.mensagens;

public class MsgAudio extends Mensagem{
    private int duracao;

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    @Override
    public void sendMessage(String msg) {
        System.out.println("Enviando mensagem de áudio com duração de " + duracao + " segundos.");
    }
}
