#ifndef ENDERECO
#define ENDERECO

typedef struct{
	char rua[50];
	char bairro[50];
	char cidade[50];
	char pais[50];
	int num, cep;
}Endereco;

void imprimirEndereco(entereco, end);

Endereco lerEndereco();

#endif

