#ifndef NO_H
#define NO_H

// Estrutura do nó da lista encadeada
typedef struct no {
    int valor;          // Valor armazenado no nó
    struct no *proximo; // Ponteiro para o próximo nó
} No;

// Funções para manipulação da lista encadeada
void inserir_fim(No **lista, int num);      // Função para inserir no final da lista
void imprimir(No *lista);                   // Função para imprimir a lista
void inserir_inicio(No **lista, int num);   // Função para inserir no início da lista
void inserir_meio(No **lista, int num, int ant); // Função para inserir no meio
void inserir_ordenado(No **lista, int num); // Função para inserir de forma ordenada

#endif // NO_H

