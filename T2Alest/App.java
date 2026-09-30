public class App {
    public static void main(String[] args) {
        DoubleLinkedListOfInteger l = new DoubleLinkedListOfInteger();
        l.add(10);
        l.add(20);
        l.add(30);
        l.add(40);
        l.add(50);
        l.add(60);
        l.add(70);
        l.add(80);
        
        System.out.println(l);
        System.out.println("size="+l.size());
      
        
    //    System.out.println("Get da posicao 2: " + l.get(2));
    //    System.out.println("Get da posicao 6: " + l.get(6));
        
    //    System.out.println("Trocou " + l.set(2, 35) + " por 35 na posicao 2.");
        
     //   System.out.println("Removeu 50? " + l.remove(50));
    //System.out.println("Removeu 57? " + l.remove(57));
        
        System.out.println(l);
        
      
        DoubleLinkedListOfInteger l2 = new DoubleLinkedListOfInteger();
        l2.add(35);
        l2.add(5);
        l2.add(50);
        l2.add(60);
        l2.add(20);
        l2.add(10);

        System.out.println("Conteudo lista l2:\n" + l2);

        // ---- Teste dos metodos do Trabalho II ----
        System.out.println("contains(30): " + l.contains(30));
        System.out.println("contains(35): " + l.contains(35));
        System.out.println("indexOf(50): " + l.indexOf(50));
        System.out.println("indexOf(99): " + l.indexOf(99));

        System.out.println("Get da posicao 2: " + l.get(2));
        System.out.println("Trocou " + l.set(2, 35) + " por 35 na posicao 2.");
        l.add(0, 5);
        l.add(l.size(), 90);
        System.out.println("Apos add(0,5) e add(size,90):\n" + l);

        System.out.println("Removeu 50? " + l.remove(50));
        System.out.println("Removeu 57? " + l.remove(57));
        System.out.println("removeByIndex(1): " + l.removeByIndex(1));
        l.add(35);
        System.out.println("contaOcorrencias(35): " + l.contaOcorrencias(35));
        System.out.println("removeAll(35): " + l.removeAll(35));
        System.out.println(l);

        int[] sub = l.subList(1, 4);
        for (int i = 0; i < sub.length; i++) {
            System.out.println("subList(1,4)[" + i + "]: " + sub[i]);
        }

        l2.sort();
        System.out.println("l2 apos sort:\n" + l2);
        l2.reverse();
        System.out.println("l2 apos reverse:\n" + l2);
        l2.add(7);
        System.out.println("removeImpares: " + l2.removeImpares());
        System.out.println("l2 apos removeImpares:\n" + l2);
        l2.clear();
        System.out.println("l2 apos clear: size=" + l2.size() + " isEmpty=" + l2.isEmpty());

             
       
 
    }
    
}