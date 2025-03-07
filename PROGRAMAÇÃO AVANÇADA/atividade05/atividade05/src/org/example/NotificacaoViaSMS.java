package org.example;

public class NotificacaoViaSMS implements InterfaceNotificacao {

    @Override
    public void enviarMensagem(String textoMensagem) {
        System.out.println("Enviando um SMS com a seguinte mensagem: " + textoMensagem);
    }
}
