import java.io.*;
import java.util.*;
import java.text.DecimalFormat;


public class Controller 
{
	private static Scanner input = new Scanner (System.in);
	
	
	//Chamamos Admin empresas para ir á classe Admin e mexer com o map das empresas
    public static int RegistarEmpresa (Model model) {
        String nome="",email="",morada="",password="", tipoAtividade="";
        int nif=0;
        double deducaoFiscal=0.0;
        Scanner input = new Scanner(System.in);
        
        System.out.println ("\nOla! Seja Bem-vindo ao registo na aplicação JavaFatura");
        
        while(!(Integer.toString(nif).matches("[0-9]{9}")) || model.containsEmpresa(nif)) {
			if(!(model.containsEmpresa(nif)))
					System.out.print("Por favor insira o seu nif (9 digitos): ");
			else
				System.out.println("NIF ja existente. Por favor insira um novo nif:");
				nif = input.nextInt();
		    }
		    
		    while(!(password.matches("[a-zA-Z0-9]*[A-Z]+[a-zA-Z0-9]*")) || !(password.matches("[a-zA-Z0-9]*[0-9]+[a-zA-Z0-9]*")) || !(password.matches("[a-zA-Z0-9]*[a-z]+[a-zA-Z0-9]*")) || !(password.matches("[a-zA-Z0-9]{6,}"))) {
		    		System.out.print("Por favor insira a sua password: ");
		    		password = input.next();
		    }
		    
		    while(!(nome.matches("[a-zA-z]+"))) {
		    		System.out.print("Por favor insira o seu nome: ");
		    		nome = input.next();
		    }
		    
		    while(!(email.matches("[a-z0-9._-]+@[a-z]+.[a-z]+"))) {
		    		System.out.print("Por favor insira o seu email: ");
		        email = input.next();
		    }
		    
		    while(!(morada.matches("[a-zA-Z]+"))) {
		    		System.out.print("Por favor insira a sua morada: ");
		    		morada = input.next();
		    }
		    int caso =1;
	         
             Menus.menuTipoAtividade();
             caso = input.nextInt();
	             
	             
	             switch(caso) {
	                 case 1: { 
	                     tipoAtividade="Saude";
	                     deducaoFiscal=0.06;
	                     break;
	                 }
	                 case 2: { 
	                     tipoAtividade="Alimentacao";
	                     deducaoFiscal=0.06;
	                     break;
	                 }
	                 case 3: { 
	                     tipoAtividade="Restauracao";
	                     deducaoFiscal=0.13;
	                     break;
	                 }
	                 case 4: { 
	                     tipoAtividade="Educacao";
	                     deducaoFiscal=0.13;
	                     break;
	                 }
	                 case 5: { 
	                     tipoAtividade="Hotelaria";
	                     deducaoFiscal=0.23;
	                     break;
	                 }
	                 case 6: { 
	                     tipoAtividade="Bens essenciais";
	                     deducaoFiscal=0.06;
	                     break;
	                 }
	                 case 7: { 
	                     tipoAtividade="Transportes";
	                     deducaoFiscal=0.13;
	                     break;
	                 }
	                 case 8: { 
	                     tipoAtividade="Outros";
	                     deducaoFiscal=0.23;
	                     break;
	                 }
	             }
	             
	        
        Empresa novo = new Empresa (nome, nif,email, morada, password, deducaoFiscal, tipoAtividade);
        if(model.registarEmpresa(novo)) 
            System.out.println("\nBem-Vindo a JavaFatura!! faça já o seu Log-in para aceder ao seu perfil.");
        else
    			System.out.println("\n\nEste NIF já está a ser utilizado !! \nUtilizador não Registado !!\n");
        return 0;
    }
    
  //Chamamos Admin empresas para ir á classe Admin e mexer com o map das empresas
    public static int RegistarCliente (Model model) {
        String nome="",email="",morada="",password="";
        int nif=0, numeroAgregados, numeroFiscais;
        double coeficiente;
        Scanner input = new Scanner(System.in);
        
        System.out.println ("\nOla! Seja Bem-vindo ao registo na aplicação JavaFatura");
        
        while(!(Integer.toString(nif).matches("[0-9]{9}")) || model.containsCliente(nif)) {
    			if(!(model.containsCliente(nif)))
    					System.out.print("Por favor insira o seu nif (9 digitos): ");
    			else
    				System.out.println("NIF ja existente. Por favor insira um novo nif:");
    			nif = input.nextInt();
        }
        
        while(!(password.matches("[a-zA-Z0-9]*[A-Z]+[a-zA-Z0-9]*")) || !(password.matches("[a-zA-Z0-9]*[0-9]+[a-zA-Z0-9]*")) || !(password.matches("[a-zA-Z0-9]*[a-z]+[a-zA-Z0-9]*")) || !(password.matches("[a-zA-Z0-9]{6,}"))) {
        		System.out.print("Por favor insira a sua password: ");
        		password = input.next();
        }
        
        while(!(nome.matches("[a-zA-z]+"))) {
        		System.out.print("Por favor insira o seu nome: ");
        		nome = input.next();
        }
        
        while(!(email.matches("[a-z0-9._-]+@[a-z]+.[a-z]+"))) {
        		System.out.print("Por favor insira o seu email: ");
            email = input.next();
        }
        
        while(!(morada.matches("[a-zA-Z]+"))) {
        		System.out.print("Por favor insira a sua morada: ");
        		morada = input.next();
        }
        
        System.out.print("Por favor insira o numero de pessoas do Agregado Familiar: ");
        numeroAgregados = input.nextInt();
        System.out.print("Por favor insira o numero Fiscais dos elemntos do agregado: ");
        numeroFiscais = input.nextInt();
        System.out.print("Por favor insira qual situação na segugança social: ");
        coeficiente = input.nextDouble();

            
        Cliente novo = new Cliente (nome, nif, email, morada, password, numeroAgregados, numeroFiscais, coeficiente);
        if(model.registarCliente(novo)) 
            System.out.println("\nBem-Vindo a JavaFatura!! faça já o seu Log-in para aceder ao seu perfil.");
        else
        		System.out.println("\n\nEste NIF já está a ser utilizado !! \nUtilizador não Registado !!\n");
        return 0;
    }
    
    /**
     * Abre um ficheiro com Empresas se existir
     */
    
    
    public static void guardaModel(Model model) throws FileNotFoundException, IOException { 
	    	FileOutputStream fp = new FileOutputStream("model.txt");
	    	ObjectOutputStream oos = new ObjectOutputStream(fp);
	    	oos.writeObject(model);
	    	oos.flush();
	    	fp.close();
	    	oos.close();
    }
    
    
		@SuppressWarnings("unchecked")
		public static Model carregaModel() throws IOException, ClassNotFoundException {
			Model model;
			File file = new File("model.txt");
			if(!file.exists())
				file.createNewFile();
			try {
		    		FileInputStream fp = new FileInputStream("model.txt");
		        	ObjectInputStream ois = new ObjectInputStream(fp);
		        	model = (Model) ois.readObject();
		        	fp.close();
		        	ois.close();
		    		} catch (EOFException e) {
		    			model = new Model();
		    		}
		    			
			return model;
    }
    
 
		/**
		 * Log In Empresa
		 */
		public static Empresa logInEmpresa (int nif, String password, Model model){
		    if(model.getEmpresas().containsKey(nif))
		      if(model.getEmpresas().get(nif).getPassword().equals(password))
		          return model.getEmpresa(nif);
			return null;
		}
		
		/**
		 * Log In Cliente
		 */
		public static Cliente logInCliente (int nif, String password, Model model){
		    if(model.getClientes().containsKey(nif))
		      if(model.getClientes().get(nif).getPassword().equals(password))
		          return model.getCliente(nif);
		    return null;
		}
		
		/**
		 * Altera dados da empresa
		 
		public static void altDadosEmpresa(Empresa empresa) {
			Menus.menuEmpresaAltDados();
			Scanner input = new Scanner(System.in);
			int caso=1;
			
			while(caso!=0) {
				caso = input.nextInt();
				
				switch(caso) {
					case 1:
						System.out.print("\f");
		                System.out.println("Escreva o seu novo email:");
		                String x = input.next();
			                while(!(x.matches("[a-z0-9._-]+@[a-z]+.[a-z]+"))) {
			            		System.out.print("Por favor insira o seu email: ");
			                x = input.next();
			                }
		                empresa.setEmail(x);
		                System.out.println("O seu email foi alterado com sucesso");
		                Menus.menuEmpresa();
		                break;
		                
					case 2:
					    System.out.print("\f");
		                System.out.println("Escreva a sua nova password:");
		                x = input.next();
			                while(!(x.matches("[a-zA-Z0-9]*[A-Z]+[a-zA-Z0-9]*")) || !(x.matches("[a-zA-Z0-9]*[0-9]+[a-zA-Z0-9]*")) || !(x.matches("[a-zA-Z0-9]*[a-z]+[a-zA-Z0-9]*")) || !(x.matches("[a-zA-Z0-9]{6,}"))) {
					    		System.out.print("Por favor insira a sua password: ");
					    		x = input.next();
			                }
		                empresa.setPassword(x);
		                System.out.println("A sua password foi alterada com sucesso");
		                Menus.menuEmpresa();
		                break;
		              
					case 3:
						System.out.print("\f");
		                System.out.println("Escreva a sua nova morada:");
		                x = input.next();
			                while(!(x.matches("[a-zA-Z]+"))) {
					    		System.out.print("Por favor insira a sua morada: ");
					    		x = input.next();
			                }
		                empresa.setMorada(x);
		                System.out.println("A sua morada foi alterada com sucesso");
		                Menus.menuEmpresa();
		                break;
		                
				}
			}
		}
		*/
		
		/**
		public static void menuPrincipalEmpresa(Empresa empresa) {
			
			Scanner input = new Scanner (System.in);
			int caso = 1;
			
			while(caso!=0) {
				switch(caso) {
					case 1:
						altDadosEmpresa(empresa);
						break;
					
					case 5:
						empresa.toStringEmpresa();
						break;
				}
			}
			
			
		}*/
		
}
    
   