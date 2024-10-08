package edu.fatec.lp2.exercicio1;

import java.util.ArrayList;
import java.util.Scanner; // import Scanner para leitura do console
import java.time.LocalTime; // import a classe para pegar a hora atual
import java.time.format.DateTimeFormatter; // import para formatar a hora

import edu.fatec.lp2.exercicio1.mensagens.Mensagem;
import edu.fatec.lp2.exercicio1.mensagens.MsgFoto;
import edu.fatec.lp2.exercicio1.mensagens.MsgTexto;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Inicializar Scanner para ler entradas
        ArrayList<Contatinho> contatos = new ArrayList<>();

        // Criar contato 1
        Contatinho cont1 = new Contatinho();
        System.out.println("Digite o nome do contato 1:");
        cont1.setNome(sc.nextLine());

        // Validar telefone com +Código + DDD + 9 dígitos
        String telefone1;
        do {
            System.out.println("Digite o telefone do contato 1 (Formato: +CódigoDDD9Números):");
            telefone1 = sc.nextLine();
        } while (!telefone1.matches("\\+\\d{2}\\d{2}\\d{9}")); // Regex para validar o formato

        cont1.setCelular(telefone1);
        contatos.add(cont1);

        // Criar contato 2
        Contatinho cont2 = new Contatinho();
        System.out.println("Digite o nome do contato 2:");
        cont2.setNome(sc.nextLine());

        // Validar telefone com +Código + DDD + 9 dígitos
        String telefone2;
        do {
            System.out.println("Digite o telefone do contato 2 (Formato: +CódigoDDD9Números):");
            telefone2 = sc.nextLine();
        } while (!telefone2.matches("\\+\\d{2}\\d{2}\\d{9}"));

        cont2.setCelular(telefone2);
        contatos.add(cont2);

        // Criar mensagens
        ArrayList<Mensagem> mensagens = new ArrayList<>();
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss"); // Pegando data e hora atual em formato (HH:mm:ss)

        // Mensagem 1 para o contato 1
        Mensagem msg1 = new MsgTexto();
        System.out.println("Digite a mensagem para " + cont1.getNome() + ":");
        String conteudo1 = sc.nextLine();
        msg1.setHoraEnvio(LocalTime.now().format(formatter)); // Pode ser fixo ou também lido do usuário
        msg1.setDestinatario(cont1);
        msg1.setConteudo(conteudo1);
        msg1.sendMessage(conteudo1);
        mensagens.add(msg1);

        // Mensagem 2 para o contato 2
        Mensagem msg2 = new MsgFoto(); // Pode usar MsgTexto ou MsgFoto
        System.out.println("Digite a mensagem para " + cont2.getNome() + ":");
        String conteudo2 = sc.nextLine();
        msg2.setHoraEnvio(LocalTime.now().format(formatter)); // Pode ser fixo ou também lido do usuário
        msg2.setDestinatario(cont2);
        msg2.setConteudo(conteudo2);
        msg2.sendMessage(conteudo2);
        mensagens.add(msg2);

        // Inicializa o WhatsApp com os contatos e mensagens
        Whatsapp wp = new Whatsapp(contatos, mensagens);

        // Listar contatos e mensagens
        wp.listarContatos();
        System.out.println("--------------");
        wp.listarMensagens();
        
        sc.close();
    }
}
