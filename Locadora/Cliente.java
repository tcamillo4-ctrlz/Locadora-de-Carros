public class Cliente {

    String nome;
    int idade;
    int cpf;
    String endereco;
    double total;

    public void informacoes_Cliente(String nome, int idade, int cpf, String endereco, double total) {
        System.out.println("NOME     = " + nome);
        System.out.println("IDADE    = " + idade);
        System.out.println("CPF      = " + cpf);
        System.out.println("ENDEREÇO = " + endereco);
        System.out.println("TOTAL A PAGAR   = R$ " + total);

    }

    public void set_Total(double novo_total) {
        total = novo_total;
    }

    public void get_Total() {
        System.out.println("TOTAL A PAGAR   = R$ " + total);  
    }


    public static void main(String[] args) {
        
        System.out.println("CLIENTE 1: ");
        Cliente cliente1 = new Cliente();
        cliente1.informacoes_Cliente("Tiago", 18, 528695948, "SJC", 75.99);

        System.out.println("CLIENTE 2: ");
        Cliente cliente2 = new Cliente();
        cliente2.set_Total(105.45);
        cliente2.get_Total();

    }
    
}