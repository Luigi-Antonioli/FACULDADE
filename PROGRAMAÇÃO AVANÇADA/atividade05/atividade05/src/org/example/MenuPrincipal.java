package org.example;
import java.util.Scanner;

public class MenuPrincipal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Exibe o menu de escolha de notificação
        System.out.println("Bem-vindo ao sistema de notificações!");
        System.out.println("Escolha um tipo de notificação para enviar:");
        System.out.println("1: Enviar um E-mail");
        System.out.println("2: Enviar um SMS");
        System.out.println("3: Enviar uma Notificação Push");

        // Lê a escolha do usuário e remove espaços extras
        String tipoNotificacaoEscolhida = scanner.nextLine().trim();

        // Solicita ao usuário a mensagem que deseja enviar
        System.out.println("Por favor, digite a mensagem que você quer enviar:");
        String textoMensagem = scanner.nextLine();

        // Cria a notificação com base na escolha do usuário
        InterfaceNotificacao notificacaoEscolhida = TiposDeNotificacoes.criarNotificacao(tipoNotificacaoEscolhida);

        // Envia a mensagem escolhida
        notificacaoEscolhida.enviarMensagem(textoMensagem);

        // Fecha o scanner
        scanner.close();
    }
}
