/*
Alunos: Heloísa da Silva Nunes Ribeiro e Yasmine Oliveira Belmiro 
Disciplina: Estrutura de Dados I
Data: 06/06
Objetivo: Atuar como o ponto de entrada do programa.
*/
public class Main {
    public static void main(String[] args) {
        Grafo grafo = new Grafo();

        // --- MONTAGEM DO GRAFO ---

        // Arestas Horizontais (Linha 1)
        grafo.adicionarAresta("A", "B", 1);
        grafo.adicionarAresta("B", "C", 18);
        grafo.adicionarAresta("C", "D", 20);

        // Arestas Horizontais (Linha 2)
        grafo.adicionarAresta("E", "F", 10);
        grafo.adicionarAresta("F", "G", 13);
        grafo.adicionarAresta("G", "H", 22);

        // Arestas Horizontais (Linha 3)
        grafo.adicionarAresta("I", "J", 11);
        grafo.adicionarAresta("J", "K", 4);
        grafo.adicionarAresta("K", "L", 23);

        // Arestas Horizontais (Linha 4)
        grafo.adicionarAresta("M", "N", 1);
        grafo.adicionarAresta("N", "O", 9);
        grafo.adicionarAresta("O", "P", 8);

        // Arestas Verticais (Coluna 1)
        grafo.adicionarAresta("A", "E", 2);
        grafo.adicionarAresta("E", "I", 5);
        grafo.adicionarAresta("I", "M", 3);

        // Arestas Verticais (Coluna 2)
        grafo.adicionarAresta("B", "F", 4);
        grafo.adicionarAresta("F", "J", 6);
        grafo.adicionarAresta("J", "N", 9);

        // Arestas Verticais (Coluna 3)
        grafo.adicionarAresta("C", "G", 1);
        grafo.adicionarAresta("G", "K", 11);
        grafo.adicionarAresta("K", "O", 12);

        // Arestas Verticais (Coluna 4)
        grafo.adicionarAresta("D", "H", 4);
        grafo.adicionarAresta("H", "L", 5);
        grafo.adicionarAresta("L", "P", 9);

        // --- EXECUTANDO OS MÉTODOS ---

        // 1. Contagem de cidades
        int totalCidades = grafo.totalCidades();
        System.out.println("Quantidade total de cidades no grafo: " + totalCidades);
        System.out.println();

        // 2. Buscando cidades
        boolean achouP = grafo.buscarCidade("A", "P");
        boolean achouX = grafo.buscarCidade("A", "X"); // Cidade inexistente

        // 3. Distância entre cidades
        int distanciaA_P = grafo.calculaDistanciaEntreCidades("A", "P");
        int distanciaA_F = grafo.calculaDistanciaEntreCidades("A", "F");
        int distanciaA_X = grafo.calculaDistanciaEntreCidades("A", "X");

        System.out.println("\nDistância de 'A' até 'P': " + distanciaA_P);
        System.out.println("Distância de 'A' até 'F': " + distanciaA_F);
        System.out.println("Distância até 'X': " + distanciaA_X);
    }
}
