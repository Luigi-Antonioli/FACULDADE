package org.example;

public class TiposDeNotificacoes {

    // Método de fábrica que cria a instância correta de notificação
    public static InterfaceNotificacao criarNotificacao(String tipoNotificacaoEscolhida) {
        switch (tipoNotificacaoEscolhida) {
            case "1":
                return new NotificacaoPeloEmail();
            case "2":
                return new NotificacaoViaSMS();
            case "3":
                return new NotificacaoPorPush();
            default:
                throw new IllegalArgumentException("Tipo de notificação desconhecido");
        }
    }
}
