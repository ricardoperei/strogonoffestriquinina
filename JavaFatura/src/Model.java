 import java.util.*;
 import java.io.Serializable;

public class Model implements Serializable
{
     
      private HashMap<Integer,Empresa> empresas;
      private HashMap<Integer,Cliente> clientes;
        
      public Model(){
          empresas = new HashMap<Integer,Empresa>();
          clientes = new HashMap<Integer,Cliente>();
      }
      
      public Model(Model a){
        this.empresas = a.getEmpresas();
        this.clientes = a.getClientes();
      }
      
      public HashMap<Integer,Empresa> getEmpresas(){
        HashMap<Integer,Empresa> e = new HashMap<Integer,Empresa>();
        
        Iterator<HashMap.Entry<Integer,Empresa>> itE = empresas.entrySet().iterator();
        while(itE.hasNext()){
            HashMap.Entry<Integer,Empresa> entry = itE.next();
            e.put(entry.getKey(),entry.getValue().clone());
        }
        
        return e;
      }
      
      public HashMap<Integer,Cliente> getClientes(){
        HashMap<Integer,Cliente> c = new HashMap<Integer,Cliente>();
        
        Iterator<HashMap.Entry<Integer,Cliente>> itC = clientes.entrySet().iterator();
        while(itC.hasNext()){
            HashMap.Entry<Integer,Cliente> entry = itC.next();
            c.put(entry.getKey(),entry.getValue().clone());
        }
        
        return c;
      }
      
      public void setClientes(HashMap<Integer,Cliente> clientes) {
    	  	this.clientes=clientes;
      }
      
      public void setEmpresas(HashMap<Integer,Empresa> empresas) {
  	  	this.empresas=empresas;
    }
      
      /**
       * Dado o endereço de utilizador retorna a empresa se existir
       */
      public Empresa getEmpresa(int nif){
            return this.empresas.get(nif);
      }
      
      /**
       * Dado o endereço de utilizador retorna o cliente se existir
       */
      public Cliente getCliente(int nif){
            return this.clientes.get(nif);
      }
      
      /**
       * Registar uma nova Empresa
       */
      public boolean registarEmpresa(Empresa novaEmpresa){
            if(!this.empresas.containsKey(novaEmpresa.getNif()) && !this.clientes.containsKey(novaEmpresa.getNif())) {
            		System.out.println("novaEmpresa: "+novaEmpresa);
                this.empresas.put(novaEmpresa.getNif(),novaEmpresa);
            }
                else return false;
            
            return false;
      }
        
      /**
       * Registar um novo Cliente
       */
      public boolean registarCliente(Cliente novoCliente){
            if(!this.clientes.containsKey(novoCliente.getNif()) && !this.empresas.containsKey(novoCliente.getNif())) {
            	System.out.println("novoCliente: "+novoCliente);
                this.clientes.put(novoCliente.getNif(),novoCliente);
            }
            else return false;
            
            return false;
      }
      
      /**
       * Remover Empresa
       */
      public boolean removerEmpresa(Empresa nif){
          return null != this.empresas.remove(nif.getNif());
      }
      
      /**
       * Remover Cliente
       */
      public boolean removerCliente(Cliente nif){
          return null != this.clientes.remove(nif.getNif());
      }
      

      
      /** 
       * Converte para uma representação textual  
       */   
      public String toString() {
       StringBuilder sb = new StringBuilder();
       
       for(HashMap.Entry<Integer,Empresa> entry : empresas.entrySet()){
            sb.append(empresas.get(entry.getKey()).toString());
            sb.append("\n");
        }
       
       for(HashMap.Entry<Integer,Cliente> entry : clientes.entrySet()){
           sb.append(clientes.get(entry.getKey()).toString());
           sb.append("\n");
       }
        return sb.toString();
      }
      
      /*
       * Verifica se contem a empresa
       */
      public boolean containsEmpresa(int nif){
    	  if(!(empresas==null)) 
        return this.empresas.containsKey(nif);
    	  else
    	  {
    		  this.empresas=new HashMap<Integer,Empresa>();
    		  return true;
    	  }
    		  
      }
      

      /**
       * Verifica se contem o cliente
       */
      public boolean containsCliente(int nif){
    	  if(!(clientes==null)) 
        return this.clientes.containsKey(nif);
    	  else
    	  {
    		  this.clientes=new HashMap<Integer,Cliente>();
    		  return true;
    	  }
    		  
      }
      
      
      //############# Fatugas ##############
      
      public static int RegistarFatura (Model model, Empresa empresa) {
          int numFiscalEmp=0, numFiscalCli=0;
          String designacao="", descricao="",natureza="";
          int data=00/00/0000;
          double valor=0.0;
              Scanner input = new Scanner(System.in);
              
              System.out.println ("\nOla! Emitir nova Fatura");
              
              numFiscalEmp=empresa.getNif();
              
              while(!(Integer.toString(numFiscalCli).matches("[0-9]{9}")) || model.containsCliente(numFiscalCli)) {
      			if(!(model.containsCliente(numFiscalCli)))
      					System.out.print("NIF inválido, tente novamente");
      			else
      				System.out.println("NIF ja existente. Por favor insira um novo nif:");
      			numFiscalCli = input.nextInt();
              }
              
              
              while(!(designacao.matches("[a-zA-z]+"))) {
              		System.out.print("Por favor insira o seu nome: ");
              		designacao = input.next();
              }
              
              while(!(descricao.matches("[a-zA-Z]+"))) {
              		System.out.print("Por favor insira a sua morada: ");
              		descricao = input.next();
              }
              while(!(designacao.matches("[a-zA-z]+"))) {
          		System.out.print("Por favor insira o seu nome: ");
          		designacao = input.next();
              }
              
              System.out.print("Por favor insira o valor ");
              valor = input.nextDouble();

                  
              Fatura nova = new Fatura ();
              
              return 0;
          }

          
      
}
