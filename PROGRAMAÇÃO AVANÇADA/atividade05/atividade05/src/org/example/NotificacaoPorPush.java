package org.example;

public class NotificacaoPorPush implements InterfaceNotificacao {

    @Override
    public void enviarMensagem(String textoMensagem) {
        System.out.println("Enviando uma Notificação Push com a seguinte mensagem: " + textoMensagem);
    }
}
