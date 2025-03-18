#include <stdio.h>
#include <stdlib.h>
#include <locale.h>
#include "No.h"

// Fun��o para inserir no final
void inserir_fim(No **lista, int num) {
	setlocale(LC_ALL,"Portuguese");
	
    No *novo = malloc(sizeof(No));  
    
    if (novo) {
        novo->valor = num;
        novo->proximo = NULL;  
        
        printf("Endere�o da lista (par�metro de entrada): %p\n", (void*)*lista);
        printf("Conte�do da lista (par�metro de entrada): ");
        
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
        
        printf("Valor do novo n�: %d\n", novo->valor);
        printf("Pr�ximo endere�o do novo n�: %p\n", (void*)novo->proximo);

        if (*lista == NULL) {
            *lista = novo;  
        } else {
            No *aux = *lista;
            while (aux->proximo) {
                aux = aux->proximo;
            }
            aux->proximo = novo;  
        }
        
        printf("Endere�o do novo n�: %p\n", (void*)novo);
        printf("Conte�do do novo n�: %d\n\n", novo->valor);
    } else {
        printf("Erro ao alocar mem�ria.\n");
    }
}

