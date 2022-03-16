public class Funcionario {
    
    String nome;
    int idade;
    String cargo;
    double salario;

    public void informacoes_Funcionario(String nome, int idade, String cargo, double salario) {
        System.out.println("NOME     = " + nome);
        System.out.println("IDADE    = " + idade);
        System.out.println("CPF      = " + cargo);
        System.out.println("SALÁRIO  = R$ " + salario);

    }

    public void set_Salario(double novo_salario) {
        salario = novo_salario;
    }

    public void get_Salario() {
        System.out.println("SALÁRIO  = R$ " + salario);  
    }

    public static void main(String[] args) {
        
        System.out.println("FUNCIONÁRIO 1: ");
        Funcionario funcionario1 = new Funcionario();
        funcionario1.informacoes_Funcionario("Bianca", 24, "Estagiário(a)", 800.00);

        System.out.println("FUNCIONÁRIO 2: ");
        Funcionario funcionario2 = new Funcionario();
        funcionario2.set_Salario(850.45);
        funcionario2.get_Salario();


    }

}
