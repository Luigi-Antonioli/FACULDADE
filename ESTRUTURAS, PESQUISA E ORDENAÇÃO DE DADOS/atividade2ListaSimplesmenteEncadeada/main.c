#include <stdio.h>
#include <stdlib.h>
#include <locale.h>
#include "No.h"

void imprimir_endereco_e_conteudo(No *lista) {
    setlocale(LC_ALL,"Portuguese");
	
	printf("Endereço da lista: %p\n", (void*)lista);
    printf("Conteúdo da lista: ");
    
    if (lista == NULL) {
        printf("Lista vazia.\n");
    } else {
        No *aux = lista;
        while (aux) {
            printf("%d ", aux->valor);
            aux = aux->proximo;
        }
    }
    printf("\n\n");
}

int main(void) {
	setlocale(LC_ALL,"Portuguese");
	
    int opcao, valor;
    No *lista = NULL;
    
    valor = 10;
    printf("Antes da inserção do valor %d:\n", valor);
    imprimir_endereco_e_conteudo(lista);
    inserir_fim(&lista, valor);
    
    valor = 20;
    printf("Antes da inserção do valor %d:\n", valor);
    imprimir_endereco_e_conteudo(lista);
    inserir_fim(&lista, valor);
    
    valor = 30;
    printf("Antes da inserção do valor %d:\n", valor);
    imprimir_endereco_e_conteudo(lista);
    inserir_fim(&lista, valor);
    
    valor = 40;
    printf("Antes da inserção do valor %d:\n", valor);
    imprimir_endereco_e_conteudo(lista);
    inserir_fim(&lista, valor);
    
    printf("Lista final:\n");
    imprimir_endereco_e_conteudo(lista);
    
    return 0;
}

