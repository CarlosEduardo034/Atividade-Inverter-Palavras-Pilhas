class Pilha<T> {
    private Object[] elementos;
    private int topo;

    public Pilha(int capacidade) {
        elementos = new Object[capacidade];
        topo = -1;
    }

    public boolean estaVazia() {
        return topo == -1;
    }

    public boolean estaCheia() {
        return topo == elementos.length - 1;
    }

    public void push(T elemento) {
        if (estaCheia()) {
            throw new RuntimeException("Pilha cheia!");
        }
        elementos[++topo] = elemento;
    }

    @SuppressWarnings("unchecked")
    public T pop() {
        if (estaVazia()) {
            throw new RuntimeException("Pilha vazia!");
        }
        return (T) elementos[topo--];
    }
}

public class InverterPalavras {

    public static String inverterLetras(String frase) {
        StringBuilder resultado = new StringBuilder();
        String[] palavras = frase.split(" ");

        for (int i = 0; i < palavras.length; i++) {
            String palavra = palavras[i];
            if (palavra.isEmpty()) {
                resultado.append(" ");
                continue;
            }

            Pilha<Character> pilha = new Pilha<>(palavra.length());
            for (char c : palavra.toCharArray()) {
                pilha.push(c);
            }
            while (!pilha.estaVazia()) {
                resultado.append(pilha.pop());
            }

            if (i < palavras.length - 1) {
                resultado.append(" ");
            }
        }
        return resultado.toString();
    }

    public static void main(String[] args) {
        String exemplo1 = "UM CIENTISTA DA COMPUTACAO E UM TECNOLOGO EM SISTEMAS PARA INTERNET DEVEM RESOLVER OS PROBLEMAS LOGICAMENTE";
        String exemplo2 = "ESARF :ATERCES ODALERAHCAB ME AICNEIC AD OACATUPMOC E O GOLOGONCET ME SAMETSIS ARAP TENRETNI OD FI ONAIOG SUPMAC SOHNIRROM OAS SO SEROHLEM SOSRUC ED OACATUPMOC OD ODATSE ED .SAIOG";

        System.out.println("Exemplo 1:");
        System.out.println(inverterLetras(exemplo1));
        System.out.println("\nExemplo 2:");
        System.out.println(inverterLetras(exemplo2));
    }
}
