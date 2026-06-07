
import java.util.*;
/*
Alunos: Heloísa da Silva Nunes Ribeiro e Yasmine Oliveira Belmiro 
Disciplina: Estrutura de Dados I
Data: 06/06
Objetivo: Gerenciar e representar a estrutura principal do grafo 
utilizando uma lista de adjacência, um Map que liga o nome de um 
vértice a uma lista de suas arestas.
*/

public class Grafo {
    private Map<String, List<Aresta>> vertices = new HashMap<>();

    public void adicionarVertice(String nome) {
        vertices.putIfAbsent(nome, new ArrayList<>()); // Adiciona apenas se não existir no Map
    }

    public void adicionarAresta(String origem, String destino, int peso) {
        adicionarVertice(origem);
        adicionarVertice(destino);

        // Como o grafo da imagem não tem setas de direção, ele é não-direcionado.
        // Aresta vai e volta com o mesmo peso.
        vertices.get(origem).add(new Aresta(destino, peso));
        vertices.get(destino).add(new Aresta(origem, peso));
    }

    public boolean buscarCidade(String inicio, String destino) {
        if (vertices.isEmpty()) {
            System.out.println("O grafo está vazio!!");
            return false;
        }
        
        Set<String> visitados = new HashSet<>();
        Pilha<String> pilha = new Pilha<>();

        pilha.push(inicio);

        while (!pilha.isEmpty()) {
            String atual = pilha.pop();

            // Antes de olhar os vizinhos, verificamos: este é o nosso destino?
            if (atual.equals(destino)) {
                System.out.println("Cidade '" + destino + "' encontrada!");
                return true;
            }

            // Se não for o destino, continuamos a busca normalmente
            if (!visitados.contains(atual)) {
                visitados.add(atual);

                List<Aresta> vizinhos = vertices.get(atual);
                if (vizinhos != null) {
                    for (Aresta aresta : vizinhos) {
                        if (!visitados.contains(aresta.destino)) {
                            pilha.push(aresta.destino);
                        }
                    }
                }
            }
        }

        // Se o 'while' terminar (a pilha esvaziou) e o código chegou até aqui,
        // significa que andamos por todo o grafo conectado e não achamos o destino.
        System.out.println("A cidade " + destino + " não está presente no grafo!");
        return false;
    }

    // Classe auxiliar interna para guardar o estado de saltos na pilha
    private static class Passo {
        String cidade;
        int saltos;

        public Passo(String cidade, int saltos) {
            this.cidade = cidade;
            this.saltos = saltos;
        }
    }

    public int calculaDistanciaEntreCidades(String origem, String destino) {
        if (vertices.isEmpty()) {
            System.out.println("O grafo está vazio!!");
            return -1;
        }

        Set<String> visitados = new HashSet<>();
        Pilha<Passo> pilha = new Pilha<>();

        // O nó inicial entra com distância 0
        pilha.push(new Passo(origem, 0));

        while (!pilha.isEmpty()) {
            Passo atual = pilha.pop();

            // Achamos o destino? Retorna a quantidade de saltos dados até aqui
            if (atual.cidade.equals(destino)) {
                return atual.saltos;
            }

            if (!visitados.contains(atual.cidade)) {
                visitados.add(atual.cidade);

                List<Aresta> vizinhos = vertices.get(atual.cidade);
                if (vizinhos != null) {
                    for (Aresta aresta : vizinhos) {
                        if (!visitados.contains(aresta.destino)) {
                            // Empilha o vizinho somando +1 na distância do nó atual
                            pilha.push(new Passo(aresta.destino, atual.saltos + 1));
                        }
                    }
                }
            }
        }

        // Se a pilha esvaziar e não acharmos o destino
        return -1;
    }

    public int totalCidades() {
        return vertices.size();
    }
}