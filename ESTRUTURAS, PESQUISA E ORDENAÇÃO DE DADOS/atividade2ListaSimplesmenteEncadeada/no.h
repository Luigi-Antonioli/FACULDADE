#ifndef NO_H
#define NO_H

// Estrutura do n� da lista encadeada
typedef struct no {
    int valor;          // Valor armazenado no n�
    struct no *proximo; // Ponteiro para o pr�ximo n�
} No;

// Fun��es para manipula��o da lista encadeada
void inserir_fim(No **lista, int num);      // Fun��o para inserir no final da lista
void imprimir(No *lista);                   // Fun��o para imprimir a lista
void inserir_inicio(No **lista, int num);   // Fun��o para inserir no in�cio da lista
void inserir_meio(No **lista, int num, int ant); // Fun��o para inserir no meio
void inserir_ordenado(No **lista, int num); // Fun��o para inserir de forma ordenada

#endif // NO_H

