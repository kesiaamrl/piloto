package classes;

public class Pessoa {
    private String nome;
    private String cpf;
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
        if (cpf.length() !=11){
            System.out.println("CPF inválido. O mesmo deve conter 11 dígitos!");
        } else{
            System.out.println("CPF válido.");
        }
    }

}
