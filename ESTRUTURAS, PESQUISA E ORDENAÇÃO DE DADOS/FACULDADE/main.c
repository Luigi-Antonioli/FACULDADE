#include <stdio.h>
#include <stdlib.h>
#include "No.h"

int main(void) {
    int opcao, valor, anterior;
    No *lista = NULL;
    
    do {
        printf("\n0 Sair\n1 - Inserir no início\n2 - Inserir no fim\n3 - Inserir no meio\n4 - Inserir ordenado\n5 - Imprimir\n");
        scanf("%d", &opcao);
        
        switch(opcao) {
            case 1:
                printf("Valor: ");
                scanf("%d", &valor);
                inserir_inicio(&lista, valor);
                break;
            case 2: 
                printf("Valor: ");
                scanf("%d", &valor);
                inserir_fim(&lista, valor);
                break;
            case 3:
                printf("Valor a ser inserido e valor de referência: ");
                scanf("%d%d", &valor, &anterior);
                inserir_meio(&lista, valor, anterior);
                break;
            case 4:
                printf("Valor: ");
                scanf("%d", &valor);
                inserir_ordenado(&lista, valor);
                break;
            case 5:
                imprimir(lista);
                break;
            default:
                if (opcao != 0) {
                    printf("Opção inválida.\n");
                }
        }
    } while(opcao != 0);
    return 0;
}

