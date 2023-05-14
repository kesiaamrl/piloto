package classes;

public class Piloto extends Pessoa {
    private String breve;
    @Override
    public String toString() {
        String texto="";
        texto+="Nome: " + getNome();
        texto+="\nCPF: " + getCpf();
        texto+="\nBreve: " + getBreve();

        return texto;
    }

    public String getBreve() {
        return breve;
    }

    public void setBreve(String breve) {
        this.breve = breve;
    }

}

