package org.example.pagamento;

import java.util.UUID;

public class PixPagamento implements Pagamento {

    @Override
    public String pagar(double valor) {
        // Lógica para gerar o pagamento via PIX
        // Simulando um processo de pagamento
        return "Pagamento confirmado com sucesso via PIX. Chave de Autenticação: 12345678-1234-1234-12345678";
    }

    @Override
    public String getTipo() {
        return "PIX";
    }
}
