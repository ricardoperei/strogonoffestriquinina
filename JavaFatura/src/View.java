import java.io.IOException;
import java.util.Scanner;

public class View
	 {
	    private static Scanner input;
		

		public static void main(String[] args) throws IOException, ClassNotFoundException {
	    	   
	    	 input = new Scanner (System.in);
	    	 
        	 Model model;
    	 	 
    	 	 //Inicializa as listas de clientes e empresas
    	 	 model = new Model(Controller.carregaModel());

	 	 int caso =1;
	     while(caso!=0) {
	     
	    	 //Abre o menu principal
	    	 Menus.menuPrincipal();
	     caso = input.nextInt();

	         switch(caso) {
	             case 0: { 
	                System.out.println("Até á próxima!!"); 
	            	 	Controller.guardaModel(model);
	                 break;
	             }
	             
	           //Menu logIn/registo do cliente
	             case 1: {
	            	 		Controller.menuCliente(model);
	            	 		break;
	             }
	             
	             //Menu logIn/registo duma empresa
	             case 2: {
	            	 		Controller.menuEmpresa(model);
	            	 		break;
	             }
	         }
  }
}
	 
	             
	  // Menu logIn da empresa
	     public static void loginE(int nif, Model model) throws IOException {
	         
	    	 	input = new Scanner (System.in);
	    	 	int caso = -1;
	         System.out.print('\f');
	         Empresa empresa = model.getEmpresa(nif);
	                 /* Login*/
	         		while(caso!=0) {
		                System.out.println ("\nBem Vindo "+ empresa.getNome() +"!\n");
		                Controller.menuPrincipalEmpresa(empresa);
	                }
	     }
	     
	  // Menu logIn do cliente
	     public static void loginC(int nif, Model model) throws IOException {
	         
	    	 	input = new Scanner (System.in);
	    	 	int caso = -1;
	         System.out.print('\f');
	         Cliente cliente = model.getCliente(nif);
	                 /* Login*/
	         		while(caso!=0) {
	         			System.out.println ("\nBem Vindo "+ cliente.getNome() +"!\n");
		                Controller.menuPrincipalCliente(cliente);
	         		}
	     }  
	 
}

