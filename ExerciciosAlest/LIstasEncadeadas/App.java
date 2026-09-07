public class App {
    public static void main(String[] args) {
        LinkedListOfInteger lista = new LinkedListOfInteger();

        System.out.println("Tamanho da lista: " + lista.size());
        System.out.println("Lista vazia? " + lista.isEmpty());

        System.out.println("\nAdicionando elementos no final da lista...");
        lista.add(2);
        lista.add(4);
        lista.add(6);
        lista.add(8);
        lista.add(10);
        lista.add(12);
        System.out.println(lista);

        System.out.println("Tamanho da lista: " + lista.size());
        System.out.println("Lista vazia? " + lista.isEmpty());

        System.out.println("\nElemento na posicao 1: " + lista.get(1));
        System.out.println("Elemento na ultima posicao: " + lista.get(lista.size() - 1));

        System.out.println("\nTestando set(2, 100)...");
        Integer antigo = lista.set(2, 100);
        System.out.println("Elemento substituido: " + antigo);
        System.out.println(lista);

        System.out.println("Testando contains(100): " + lista.contains(100));
        System.out.println("Testando contains(999): " + lista.contains(999));

        System.out.println("\nTestando add(0, 1) - inserir no inicio...");
        lista.add(0, 1);
        System.out.println(lista);

        System.out.println("Testando add(3, 55) - inserir no meio...");
        lista.add(3, 55);
        System.out.println(lista);

        System.out.println("Testando add(lista.size(), 999) - inserir no final...");
        lista.add(lista.size(), 999);
        System.out.println(lista);

        System.out.println("\nTestando remove(55)...");
        boolean removeu = lista.remove(55);
        System.out.println("Removido? " + removeu);
        System.out.println(lista);

        System.out.println("Testando remove(999)...");
        System.out.println("Removido? " + lista.remove(999));
        System.out.println(lista);

        System.out.println("Testando remove(-1) [nao existe]...");
        System.out.println("Removido? " + lista.remove(-1));

        System.out.println("\nTestando clear()...");
        lista.clear();
        System.out.println("Lista vazia apos clear? " + lista.isEmpty());
        System.out.println("Tamanho apos clear: " + lista.size());
    }
}