package model;

public class Cadastro {
    private String Nome;
    private String CPF;
    private int Telefone;
    private String Email;
    private String Logradouro;
    private int Numero;
    private String Complemento;
    private String Bairro;
    private String Localidade;
    private String UF;
    private String Obs;

    public Cadastro(String Nome, String CPF, int Telefone, String Email, String Logradouro, int Numero, String Complemento, String Bairro, String Localidade, String UF, String Obs) {
        this.Nome = Nome;
        this.CPF = CPF;
        this.Telefone = Telefone;
        this.Email = Email;
        this.Logradouro = Logradouro;
        this.Numero = Numero;
        this.Complemento = Complemento;
        this.Bairro = Bairro;
        this.Localidade = Localidade;
        this.UF = UF;
        this.Obs = Obs;
    }

    public Cadastro() {
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public int getTelefone() {
        return Telefone;
    }

    public void setTelefone(int Telefone) {
        this.Telefone = Telefone;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getLogradouro() {
        return Logradouro;
    }

    public void setLogradouro(String Logradouro) {
        this.Logradouro = Logradouro;
    }

    public int getNumero() {
        return Numero;
    }

    public void setNumero(int Numero) {
        this.Numero = Numero;
    }

    public String getComplemento() {
        return Complemento;
    }

    public void setComplemento(String Complemento) {
        this.Complemento = Complemento;
    }

    public String getBairro() {
        return Bairro;
    }

    public void setBairro(String Bairro) {
        this.Bairro = Bairro;
    }

    public String getLocalidade() {
        return Localidade;
    }

    public void setLocalidade(String Localidade) {
        this.Localidade = Localidade;
    }

    public String getUF() {
        return UF;
    }

    public void setUF(String UF) {
        this.UF = UF;
    }

    public String getObs() {
        return Obs;
    }

    public void setObs(String Obs) {
        this.Obs = Obs;
    }
    
    
}
