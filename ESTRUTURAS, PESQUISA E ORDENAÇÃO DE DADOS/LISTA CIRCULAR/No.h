#ifndef NO
#define NO

typedef struct no{
	int valor;
	struct no *proximo;
}No;

// se der errado nois tira
typedef struct{
	No *inicio;
	No *fim;
	int tam;
}Lista;

#endif
