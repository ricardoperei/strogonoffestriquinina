import java.io.IOException;
import java.util.Scanner;

public class View
	 {
	     private static Scanner input;
		private static Scanner input2;
		private static Scanner input3;

		public static void main(String[] args) throws IOException, ClassNotFoundException {
	    	   
	    	 input = new Scanner (System.in);
	    	 
        	 Model empresas;
    	 	 Model clientes;
    	 	 
    	 	 //Inicializa as listas de clientes e empresas
    	 	 clientes = new Model();//Controlo.openC();
    	 	 clientes.setClientes(Controller.lerC());
    	 	 
	     empresas = new Model();//Controlo.openE();
	     empresas.setEmpresas(Controller.lerE());
    	 	 /**
	     //Registar empresa 
    	 	 
         Empresa e1 = new Empresa("Felipe",123456, "felipe@poo.com", "Braga", "123", 0.13, "Hotelaria");
         empresas.registarEmpresa(e1);
    	 	 
    	 	 Cliente c1 = new Cliente("Ricardo", 1234567, "ricardo@poo.com", "Braga", "123", 123, 123, 0.23, 123);
    	 	 clientes.registarCliente(c1);
    	 	 */
	    	 	int caso =1;
	         
	        //Menu principal
	        while(caso!=0) {
	         
             Menus.menuPrincipal();
             caso = input.nextInt();
	             
	             
	             switch(caso) {
	                 case 0: { 
	                     System.out.println ("Ate à proxima."); 
	                     Controller.guardaE(empresas.getEmpresas());
	                     Controller.guardaC(clientes.getClientes());
	                     break;
	                 }
	                 
	               //Menu logIn Empresa
	                 case 1: {

			         
			         
			         	while(caso!=0) {
	           
	             
			             Menus.menu2cliente();
			             caso = input.nextInt();
			             
			             switch(caso) {
			                
			             	//Sai do menu de logIn cliente para o principal 
			             	case 0: { 
			                     System.out.println ("Ate à proxima."); 
			                     Controller.guardaC(clientes.getClientes());
			                     break;
			                 }
			                 
			                 //Efetuar logIn Cliente 
			                 case 1: {
			                     
			                	 	Cliente cliente;
			                	 	int nif;
			                     String password = new String();
			                     
			                     System.out.print("Insira o seu nif: ");
			                     nif = input.nextInt();
			                     
			                     System.out.print("Insira a Palavra-Passe: ");
			                     password = input.next();
			                     
			                     //gera um objeto da classe Cliente
			                     cliente = new Cliente ();
			                     System.out.println("Regista novo cliente");
			                     
			                     //iguala esse objeto ao do array clientes que está na classe Admin
			                     cliente = Controller.logInCliente(nif,password,clientes);
			                     System.out.println("Iguala novo cliente");
			                     
			                     if(cliente==null) {
			                         System.out.println ("Cliente não existe ou nif/palavra-passe incorretos. Tente outra vez");
			                     }
			                     else
			                     {
			                         loginC(nif,clientes);
			                         caso=-1;
			                     }
			                     break;
			                 }
			                 
			                 // Registar um novo utilizador 
			                 case 2: {
			                     Controller.RegistarCliente(clientes);
			                     break;
			                 }    
			             }
			             
			         }
	              }
	                 
	                 //Menu logIn Empresa
	                 case 2: {
	                	 	
	                	 	caso = 1;
			         	while(caso!=0) {
	           
	             
			             Menus.menu2empresa();
			             caso = input.nextInt();
			             
			             switch(caso) {
			                
			             	//Sai do menu de logIn empresa para o principal 
			             	case 0: { 
			                     System.out.println ("Ate à proxima."); 
			                     Controller.guardaE(empresas.getEmpresas());
			                     break;
			                 }
			                 
			                 //Efetuar logIn Empresa 
			                 case 1: {
			                     Empresa empresa;
			                	 	int nif;
			                     String password = new String();
			                     
			                     System.out.print ("Insira o seu nif: ");
			                     nif = input.nextInt();
			                     
			                     System.out.print("Insira a Palavra-Passe: ");
			                     password = input.next();
			                     
			                     empresa = Controller.logInEmpresa(nif,password,empresas);
			                     
			                     if(empresa==null) {
			                         System.out.println ("Empresa não existe ou nif/palavra-passe incorretos. Tente outra vez");
			                     }
			                     else
			                     {
			                         loginE(nif,empresas);
			                         caso=-1;
			                     }
			                     break;
			                 }
			                 
			                 // Registar um novo utilizador 
			                 case 2: {
			                     Controller.RegistarEmpresa(empresas);
			                     break;
			                 }    
			             }
			             
			         }
	              }
	           }
	      }
	  }
	 
	     
	                 
	  // Menu logIn da empresa
	     public static void loginE(int nif, Model empresas) throws IOException {
	         
	    	 	input2 = new Scanner (System.in);
	    	 	int caso = -1;
	         System.out.print('\f');
	         Empresa empresa = empresas.getEmpresa(nif);
	                 /* Login*/
	         		while(caso!=0) {
	                System.out.println ("\nBem Vindo "+ empresa.getNome() +"!\n");
	                Menus.menuEmpresa();
	                caso = input2.nextInt();
	     
	             }
	     }
	     
	  // Menu logIn do cliente
	     public static void loginC(int nif, Model clientes) throws IOException {
	         
	    	 	input3 = new Scanner (System.in);
	    	 	int caso = -1;
	         System.out.print('\f');
	         Cliente cliente = clientes.getCliente(nif);
	                 /* Login*/
	         		while(caso!=0) {
	                System.out.println ("\nBem Vindo "+ cliente.getNome() +"!\n");
	                Menus.menuCliente();
	                caso = input3.nextInt();
	     
	             }
	     }  
	 }

