 import java.util.*;
 import java.io.Serializable;

public class Model 
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
            if(!this.empresas.containsKey(novaEmpresa.getNif()))
                this.empresas.put(novaEmpresa.getNif(),novaEmpresa);
            else return false;
            
            return false;
      }
        
      /**
       * Registar um novo Cliente
       */
      public boolean registarCliente(Cliente novoCliente){
            if(!this.clientes.containsKey(novoCliente.getNif())) {
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
        return this.empresas.containsKey(nif);
      }
      

      /**
       * Verifica se contem o cliente
       */
      public boolean containsCliente(int nif){
    	  if(!(clientes==null)) {
    	  System.out.println("contains" +clientes);
        return this.clientes.containsKey(nif);
    	  }
    	  else
    	  {
    		  this.clientes=new HashMap<Integer,Cliente>();
    		  return true;
    	  }
    		  
      }
      
}
