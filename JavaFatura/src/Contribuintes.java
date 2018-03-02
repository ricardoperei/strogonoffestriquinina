import java.io.Serializable;

public abstract class Contribuintes implements Serializable
{
  /** Variáveis de instância */
  private String nome;
  private int nif;
  private String email;
  private String morada;
  private String password;
   
  public Contribuintes(String nome, int nif, String email, String morada, String password){
      this.nome= nome;
      this.nif=nif;
      this.email=email;
      this.morada=morada;
      this.password=password;
    }
  
  public Contribuintes(Contribuintes contribuinte){
      this.nome=contribuinte.getNome();
      this.nif=contribuinte.getNif();
      this.email=contribuinte.getEmail();
      this.morada=contribuinte.getMorada();
      this.password=contribuinte.getPassword();
    }

  /**Setters*/
  public String getNome(){
      return this.nome;
    }
  public int getNif(){
      return this.nif;
    }
  public String getEmail(){
      return this.email;
    }
  public String getMorada(){
      return this.morada;
    }
  public String getPassword(){
      return this.password;
    }
  
  /**Getters*/
  public void setNome(String novoNome){
      this.nome=novoNome;}    
  public void setNif(int novoNif){
      this.nif=novoNif;}
  public void setEmail(String novoEmail){
      this.email=novoEmail;
    }
  public void setMorada(String novaMorada){
      this.morada=novaMorada;
    }
  public void setPassword(String novaPassword) {
      this.password=novaPassword;
    }
  
  /**Converte para uma representação textual*/
  public String toString(){
        StringBuilder s = new StringBuilder();
            s.append("Nome: " + nome + "\n");
            s.append("NIF: " + nif + "\n");
            s.append("Email: " + email + "\n");
            s.append("Morada: " + morada + "\n");
            s.append("Password: " + password + "\n");
            
        return s.toString(); 
    }
    
  /**Método equals*/
  
  /**Método clone*/
  
  
    
}
