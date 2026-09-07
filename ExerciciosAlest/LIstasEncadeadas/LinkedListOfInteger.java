public class LinkedListOfInteger {

    // Classe interna Node
    private class Node {
        public Integer element;
        public Node next;

        public Node(Integer element) {
            this.element = element;
            next = null;
        }

        public Node(Integer element, Node next) {
            this.element = element;
            this.next = next;
        }
    }


    // Referência para o primeiro elemento da lista encadeada.
    private Node head;
    // Referência para o último elemento da lista encadeada.
    private Node tail;
    // Contador para a quantidade de elementos que a lista contem.
    private int count;


    /**
     * Construtor da lista.
     */
    public LinkedListOfInteger() {
        head = null;
        tail = null;
        count = 0;
    }

    /**
     * Esvazia a lista
     */
    public void clear() {
        head = null;
        tail = null;
        count = 0;
    }

    /**
     * Adiciona um elemento ao final da lista.
     *
     * @param element elemento a ser adicionado ao final da lista
     */
    public void add(Integer element) {
        Node n = new Node(element);
        if (head == null) {
            head = n;
        } else {
            tail.next = n;
        }
        tail = n;
        count++;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();

        Node aux = head;

        while (aux != null) {
            s.append(aux.element.toString());
            s.append("\n");
            aux = aux.next;
        }

        return s.toString();
    }

    ///////////////////////////////////////////////////
    //// EXERCICIOS - VEJA SLIDES E ENUNACIADO
    ///////////////////////////////////////////////////

    public boolean isEmpty(){
    return count == 0;
    }


    // 2 - implemente o método size
    public int size(){
        return count;
    }

    // 3 - implemente o método get
    public Integer get(int index) {
    if (index < 0 || index >= count) {
        throw new IndexOutOfBoundsException("Índice inválido: " + index);
    }

    Node aux = head;
    for (int i = 0; i < index; i++) {
        aux = aux.next;
    }

    return aux.element;
}

// set

    public Integer set(int index, Integer element) {
    if (index < 0 || index >= count) {
        throw new IndexOutOfBoundsException("Índice inválido: " + index);
    }

    Node aux = head;
    for (int i = 0; i < index; i++) {
        aux = aux.next;
    }

    Integer old = aux.element;
    aux.element = element;
    return old;
}


//contais

public boolean contains(Integer element) {
    Node aux = head;
    while (aux != null) {
        if (aux.element.equals(element)) {
            return true;
        }
        aux = aux.next;
    }
    return false;
}

//add
public void add(int index, Integer element) {
    if (index < 0 || index > count) {
        throw new IndexOutOfBoundsException("Índice inválido: " + index);
    }

    // inserção no início
    if (index == 0) {
        Node n = new Node(element, head);
        head = n;
        if (count == 0) {
            tail = n;
        }
    } else {
        // encontra o nó ANTERIOR à posicao de inserção
        Node prev = head;
        for (int i = 0; i < index - 1; i++) {
            prev = prev.next;
        }

        Node n = new Node(element, prev.next);
        prev.next = n;

        // se inseriu no final, atualiza tail
        if (n.next == null) {
            tail = n;
        }
    }

    count++;
}

//remove
public boolean remove(Integer element) {
    if (head == null) {
        return false;
    }

    // caso especial: elemento está no head
    if (head.element.equals(element)) {
        head = head.next;
        count--;
        if (head == null) {
            tail = null; // lista ficou vazia
        }
        return true;
    }

    // percorre a lista mantendo o nó anterior
    Node prev = head;
    Node aux = head.next;

    while (aux != null) {
        if (aux.element.equals(element)) {
            prev.next = aux.next;
            if (aux == tail) {
                tail = prev; // removeu o último elemento
            }
            count--;
            return true;
        }
        prev = aux;
        aux = aux.next;
    }

    return false;
}

    /* Exemplo - veja o main
    Lista:
        2
        4
        8
        lista.get(1)
        Elemento na segunda posicao da lista: 4
     */

    //assinatura do metodo
    //public Integer get(int index)
}
