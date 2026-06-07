/*
Alunos: Heloísa da Silva Nunes Ribeiro e Yasmine Oliveira Belmiro 
Disciplina: Estrutura de Dados I;
Data: 06/06;
Objetivo: Representar as conexões entre os vértices do grafo.  
*/

public class Aresta {
    String destino; // Ex: "B"
    int peso;       // Ex: 1

    public Aresta(String destino, int peso) {
        this.destino = destino;
        this.peso = peso;
    }
}