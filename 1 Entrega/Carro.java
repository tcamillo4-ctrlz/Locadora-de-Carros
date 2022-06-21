public class Carro{

    // Atributos da Classe -> Características

    String placa;
    double potencia;
    String modelo;
    String cor;
    String marca;
    boolean cambio_automatico;
    int ano;
    float preco;

    // Métodos -> Ações

    public void andar() {
        System.out.println("ANDANDO...");
    }

    public boolean frear() {
        System.out.println("FREANDO...");
        return true;
    }

    public void correr(int velocidade) {
        System.out.println("CARRO CORRENDO A " + velocidade + "KM/H");
    }
     
    public static void main (String[] args) {

        // Instânciando Objetos da Classe
        Carro C1 = new Carro();

        C1.ano = 2020;
        C1.cor = "vermelho";
        C1.andar();

        Carro C2 = new Carro();

        C2.cambio_automatico = true;
        C2.marca = "FIAT";
        C2.correr(75);

    }

}