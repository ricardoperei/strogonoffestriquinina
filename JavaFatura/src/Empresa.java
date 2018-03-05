import java.io.Serializable;
import java.util.*;

public class Empresa extends Contribuintes implements Serializable
{
  
  private String tipoAtividade;
  private double deducaoFiscal;
  
  Map <Cliente,List<Fatura>> faturasCliente;
  List <Fatura> faturasTotal;
  
  public Empresa(){
      super("",0,"","","");
      this.tipoAtividade="";
      this.deducaoFiscal=0.0;
  }
  
  public Empresa(String nome, int nif, String email, String morada, String password, double deducaoFiscal, String tipoAtividade){
      super(nome, nif, email, morada, password);
      this.tipoAtividade=tipoAtividade;
      this.deducaoFiscal=deducaoFiscal;
  }
  
  public Empresa(Empresa e){
	  super(e.getNome(), e.getNif(), e.getEmail(),e.getMorada(), e.getPassword());
      this.tipoAtividade=e.getTipoAtividade();
      this.deducaoFiscal=e.getDeducaoFiscal();
  }
   
  /**Getters*/
  public String getTipoAtividade(){
      return tipoAtividade;
  } 
  public double getDeducaoFiscal(){
     return deducaoFiscal; 
  }
  
  /**Setters*/
  public void setTipoAtividade(String tipoAtividade){
      this.tipoAtividade=tipoAtividade;
  }
  public void setDeducaoFiscal(double deducaoFiscal){
      this.deducaoFiscal=deducaoFiscal;
  }
  
//Método equals - recebe Object como parametro 
  public boolean equals(Object o) {
	     if (this == o) return true;
	     if ((o == null) || (this.getClass() != o.getClass())) return false;
	     Empresa e = (Empresa) o;
	     return true;
	    }
  
  /**Converte para uma representação textual*/
  public String toStringEmpresa(){
        StringBuilder s = new StringBuilder();
	        s.append("Nome: " + super.getNome() + "\n");
	        s.append("NIF: " + super.getNif() + "\n");
	        s.append("Email: " + super.getEmail() + "\n");
	        s.append("Morada: " + super.getMorada() + "\n");
	        	s.append("Setor de Atividade: "+ tipoAtividade + "\n");
            
        return s.toString(); 
    }
  
  /**Cria um clone da Empresa*/
  public Empresa clone(){
      return new Empresa(this);
  }

}
