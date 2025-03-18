#include <stdio.h>
#include <stdlib.h>
#include <locale.h>
#include "No.h"

// Função para inserir no final
void inserir_fim(No **lista, int num) {
	setlocale(LC_ALL,"Portuguese");
	
    No *novo = malloc(sizeof(No));  
    
    if (novo) {
        novo->valor = num;
        novo->proximo = NULL;  
        
        printf("Endereço da lista (parâmetro de entrada): %p\n", (void*)*lista);
        printf("Conteúdo da lista (parâmetro de entrada): ");
        
        if (*lista == NULL) {
            printf("Lista vazia.\n");
        } else {
            No *aux = *lista;
            while (aux) {
                printf("%d ", aux->valor);
                aux = aux->proximo;
            }
        }
        printf("\n");
        
        printf("Valor do novo nó: %d\n", novo->valor);
        printf("Próximo endereço do novo nó: %p\n", (void*)novo->proximo);

        if (*lista == NULL) {
            *lista = novo;  
        } else {
            No *aux = *lista;
            while (aux->proximo) {
                aux = aux->proximo;
            }
            aux->proximo = novo;  
        }
        
        printf("Endereço do novo nó: %p\n", (void*)novo);
        printf("Conteúdo do novo nó: %d\n\n", novo->valor);
    } else {
        printf("Erro ao alocar memória.\n");
    }
}

