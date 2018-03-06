import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Cliente extends Contribuintes implements Serializable
{
    
	//variaveis de instancia
    private int numeroAgregados;
    private int numeroFiscais;
    private int coeficiente;
   
    
    public List<Fatura> fatCliente;
    public List<Fatura> fatClientePend;
    
    public Cliente(){
       super("",0,"","","");
       this.numeroAgregados=0;
       this.numeroFiscais=0;
       this.coeficiente=0;
       this.fatCliente = new ArrayList<Fatura>();
       this.fatClientePend = new ArrayList<Fatura>();
        
    }
    
    public Cliente( String nome, int nif, String email, String morada,String password,int numeroAgregados, int numeroFiscais, int coeficiente){
         super(nome, nif, email, morada, password);
         this.numeroAgregados=numeroAgregados;
         this.numeroFiscais=numeroFiscais;
         this.coeficiente=coeficiente;
         this.fatCliente=new ArrayList<Fatura>();
         this.fatClientePend= new ArrayList<Fatura>();
    }
    
    public Cliente(Cliente cliente){
    		super(cliente.getNome(), cliente.getNif(), cliente.getEmail(), cliente.getMorada(), cliente.getPassword());
        this.numeroAgregados=cliente.getNumeroAgregados();
        this.numeroFiscais=cliente.getNumeroFiscais();
        this.coeficiente=cliente.getCoeficiente();
        this.fatCliente=cliente.getFaturaCliente();
        this.fatClientePend=cliente.getFaturaClientePend();
        
    }
    
    /**Getters*/
    public int getNumeroAgregados(){
        return numeroAgregados;
    }
    public int getNumeroFiscais(){
        return numeroFiscais;
        
    }
    public List<Fatura> getFaturaCliente(){
        return this.fatCliente.stream()
                            .collect(Collectors.toList());
    }
    public List<Fatura> getFaturaClientePend(){
        return this.fatClientePend.stream()
                            .collect(Collectors.toList());
    }
    public int getCoeficiente(){
     return coeficiente;   
    }
    
    
    /**Setters*/
    public void setNumeroAgregados(int numeroAgregados){
      this.numeroAgregados=numeroAgregados;
    }
    public void setNumeroFiscais(int numeroFiscais){
      this.numeroFiscais=numeroFiscais;
    }
    public void setCoeficiente(int coeficiente){
      this.coeficiente=coeficiente;
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
    
    public String toStringCliente(){
        StringBuilder s = new StringBuilder();
	        s.append("Nome: " + super.getNome() + "\n");
	        s.append("NIF: " + super.getNif() + "\n");
	        s.append("Email: " + super.getEmail() + "\n");
	        s.append("Morada: " + super.getMorada() + "\n");
	        s.append("Numero de pessoas do Agregado Familiar: " + numeroAgregados + "\n");
	        s.append("Coeficiente: " + coeficiente + "\n");
            
        return s.toString(); 
    }
    
    

    /**
     * ################ FATURAS ###############
     */
    
  //Confirmar se é assim que se faz
  		//Vai ao array fatClientes e devolve todas as faturas que estão lá dentro
  		public ArrayList<Fatura> getFaturasCliente(){
  		    ArrayList<Fatura> f = new ArrayList<Fatura>();
  		    
  		    Iterator<Fatura> it = fatCliente.iterator();
  		    while(it.hasNext()){
  		        //Confirmar o que meter para ir buscar o fatCliente
  		    		Fatura faturas = it.next();
  		        f.add(faturas);
  		    }
  		    
  		    return f;
  		  }
  		
  		public void setFaturasCliente(ArrayList<Fatura> fatCliente) {
  		  	this.fatCliente=fatCliente;
  		}
  		
  		public ArrayList<Fatura> getFaturasClientePend(){
  		    ArrayList<Fatura> f = new ArrayList<Fatura>();
  		    
  		    Iterator<Fatura> it = fatClientePend.iterator();
  		    while(it.hasNext()){
  		        Fatura fatura = it.next();
  		        f.add(fatura);
  		    }
  		    
  		    return f;
  		  }
  		
  		public void setFaturasClientePend(ArrayList<Fatura> fatClientePend) {
  		  	this.fatClientePend=fatClientePend;
  		}
    
  		/**
         * Registar uma Fatura
         */
        public boolean verificaFatura(Fatura novaFatura){
              if(!fatCliente.contains(novaFatura)) {
              	System.out.println("nova Fatura: "+novaFatura);
                  this.fatCliente.add(novaFatura);
              }
              else return false;
              
              return false;
        }
        
        
        
        
        
}
