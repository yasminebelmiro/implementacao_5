/*
Alunos: Heloísa da Silva Nunes Ribeiro e Yasmine Oliveira Belmiro 
Disciplina: Estrutura de Dados I
Data: 06/06
Objetivo: Implementação manual de uma estrutura de dados do tipo Pilha genérica (LIFO), desenvolvida a partir de uma lista subjacente.
*/
import java.util.ArrayList;
import java.util.List;

// Implementação manual da pilha genérica usando uma lista base
public class Pilha<T> {
    private List<T> elementos = new ArrayList<>();

    // Operação básica: Empilhar
    public void push(T elemento) {
        elementos.add(elemento);
    }

    // Operação básica: Desempilhar (remove e retorna o topo)
    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("A pilha está vazia!");
        }
        return elementos.remove(elementos.size() - 1);
    }

    // Operação básica: Verificar se está vazia
    public boolean isEmpty() {
        return elementos.isEmpty();
    }

    // Operação auxiliar: Olhar o topo sem remover
    public T peek() {
        if (isEmpty()) {
            return null;
        }
        return elementos.get(elementos.size() - 1);
    }
}