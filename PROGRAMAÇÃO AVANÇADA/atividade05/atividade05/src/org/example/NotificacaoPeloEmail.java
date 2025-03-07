package org.example;

public class NotificacaoPeloEmail implements InterfaceNotificacao {

    @Override
    public void enviarMensagem(String textoMensagem) {
        System.out.println("Enviando um E-mail com a seguinte mensagem: " + textoMensagem);
    }
}
