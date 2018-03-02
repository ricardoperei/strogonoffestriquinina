import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

public class Cliente extends Contribuintes implements Serializable
{
    
	//variaveis de instancia
    private int numeroAgregados;
    private int numeroFiscais;
    private double coeficiente;
    private int codigo;
    
    public List<Fatura> minhasFaturas;
    
    public Cliente(){
       super("",0,"","","");
       this.numeroAgregados=0;
       this.numeroFiscais=0;
       this.coeficiente=0.0;
       this.codigo=0;
       this.minhasFaturas = new ArrayList<Fatura>();
        
    }
    
    public Cliente( String nome, int nif, String email, String morada,String password,int numeroAgregados, int numeroFiscais, double coeficiente, int codigo){
         super(nome, nif, email, morada, password);
         this.numeroAgregados=numeroAgregados;
         this.numeroFiscais=numeroFiscais;
         this.coeficiente=coeficiente;
         this.codigo=codigo;
         this.minhasFaturas=new ArrayList<Fatura>();
    }
    
    public Cliente(Cliente cliente){
    		super(cliente.getNome(), cliente.getNif(), cliente.getEmail(), cliente.getMorada(), cliente.getPassword());
        this.numeroAgregados=cliente.getNumeroAgregados();
        this.numeroFiscais=cliente.getNumeroFiscais();
        this.coeficiente=cliente.getCoeficiente();
        this.codigo=cliente.getCodigo();
        this.minhasFaturas=cliente.getFaturas();
        
    }
    
    /**Getters*/
    public int getNumeroAgregados(){
        return numeroAgregados;
    }
    public int getNumeroFiscais(){
        return numeroFiscais;
        
    }
    public List<Fatura> getFaturas(){
        return this.minhasFaturas.stream()
                            .collect(Collectors.toList());
    }
    public double getCoeficiente(){
     return coeficiente;   
    }
    public int getCodigo(){
        return codigo;
    }
    
    /**Setters*/
    public void setNumeroAgregados(int numeroAgregados){
      this.numeroAgregados=numeroAgregados;
    }
    public void setNumeroFiscais(int numeroFiscais){
      this.numeroFiscais=numeroFiscais;
    }
    public void setCoeficiente(double coeficiente){
      this.coeficiente=coeficiente;
    }
    public void setCodigo(int codigo){
      this.codigo=codigo;
    }
    
    
    // Método equals - recebe Object como parametro 
    public boolean equals(Object obj) {
      if(this == obj) return true;  // é o próprio
      if((obj == null) || (this.getClass() != obj.getClass())) return false;
      return (this == obj); //ver o que meter neste caso
    }  
    
    /** Cria e retorna uma cópia do utilizador */
    public Cliente clone() { 
        return new Cliente(this);
    }
}
