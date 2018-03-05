import java.io.IOException;
import java.util.Scanner;

public class View
	 {
	     private static Scanner input;
		private static Scanner input2;
		private static Scanner input3;

		public static void main(String[] args) throws IOException, ClassNotFoundException {
	    	   
	    	 input = new Scanner (System.in);
	    	 
        	 Model model;
    	 	 
    	 	 //Inicializa as listas de clientes e empresas
    	 	 model = new Model(Controller.carregaModel());
    	 	 
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
	                     Controller.guardaModel(model);
	                     
	                     break;
	                 }
	                 
	               //Menu logIn Cliente
	                 case 1: {

			         
			         
			         	while(caso!=0) {
	           
	             
			             Menus.menu2cliente();
			             caso = input.nextInt();
			             
			             switch(caso) {
			                
			             	//Sai do menu de logIn cliente para o principal 
			             	case 0: { 
			                     System.out.println ("Ate à proxima."); 
			                     Controller.guardaModel(model);
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
			                     cliente = Controller.logInCliente(nif,password,model);
			                     if(cliente==null) {
			                         System.out.println ("Cliente não existe ou nif/palavra-passe incorretos. Tente outra vez");
			                     }
			                     else
			                     {
			                         loginC(nif,model);
			                         caso=-1;
			                     }
			                     break;
			                 }
			                 
			                 // Registar um novo utilizador 
			                 case 2: {
			                     Controller.RegistarCliente(model);
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
			                     Controller.guardaModel(model);
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
			                     
			                     empresa = Controller.logInEmpresa(nif,password,model);
			                     
			                     if(empresa==null) {
			                         System.out.println ("Empresa não existe ou nif/palavra-passe incorretos. Tente outra vez");
			                     }
			                     else
			                     {
			                         loginE(nif,model);
			                         caso=-1;
			                     }
			                     break;
			                 }
			                 
			                 // Registar um novo utilizador 
			                 case 2: {
			                     Controller.RegistarEmpresa(model);
			                     break;
			                 }    
			             }
			             
			         }
	              }
	           }
	      }
	  }
	 
	     
	                 
	  // Menu logIn da empresa
	     public static void loginE(int nif, Model model) throws IOException {
	         
	    	 	input2 = new Scanner (System.in);
	    	 	int caso = -1;
	         System.out.print('\f');
	         Empresa empresa = model.getEmpresa(nif);
	                 /* Login*/
	         		while(caso!=0) {
	                System.out.println ("\nBem Vindo "+ empresa.getNome() +"!\n");
	                Menus.menuEmpresa();
	                caso = input2.nextInt();
	                
	                
	                
	             }
	     }
	     
	  // Menu logIn do cliente
	     public static void loginC(int nif, Model model) throws IOException {
	         
	    	 	input3 = new Scanner (System.in);
	    	 	int caso = -1;
	         System.out.print('\f');
	         Cliente cliente = model.getCliente(nif);
	                 /* Login*/
	         		while(caso!=0) {
	                System.out.println ("\nBem Vindo "+ cliente.getNome() +"!\n");
	                Menus.menuCliente();
	                caso = input3.nextInt();
	     
	             }
	     }  
	 }

