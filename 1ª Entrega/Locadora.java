public class Locadora {
    
    public static void main(String[] args) {
        
        System.out.println("NOVO CLIENTE : ");
        Cliente cliente1 = new Cliente();
        cliente1.informacoes_Cliente("Jorge", 35, 79851987, "JACAREI", 39.44);

        System.out.println("-----------------------");

        System.out.println("NOVO FUNCIONARIO : ");
        Funcionario funcionario1 = new Funcionario();
        funcionario1.informacoes_Funcionario("Mateus", 33, "Supervisor(a)", 1495.90);

        System.out.println("-----------------------");

        System.out.println("AÇÃO CARRO : ");
        Carro carro1 = new Carro();
        carro1.correr(71);

    }

}
