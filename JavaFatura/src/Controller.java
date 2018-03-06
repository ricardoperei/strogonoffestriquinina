
import java.io.*;
import java.util.*;


public class Controller 
{
	private static Scanner input = new Scanner (System.in);
	
	
    public static int RegistarEmpresa (Model model) {
        String nome,email,morada,password, tipoAtividade="";
        int nif;
        double deducaoFiscal=0.0;
        
        System.out.println ("\nOla! Seja Bem-vindo ao registo na aplicação JavaFatura");
        System.out.print ("Por favor insira um nif:");
        nif= input.nextInt();
        //verifica se um nif ja existe
        while(model.containsEmpresa(nif)){
            System.out.println("NIF ja existente. Por favor insira um novo nif:");
            nif= input.nextInt();
        }
        System.out.print("Por favor insira a sua password: ");
        password = input.next();
        System.out.print("Por favor insira o seu nome: ");
        nome = input.next();
        System.out.print("Por favor insira o seu email: ");
        email = input.next();
        System.out.print("Por favor insira a sua morada: ");
        morada = input.next();
        
        System.out.print("Por favor insira o tipo da sua atividade: ");
        Menus.menuTipoAtividade();
        int opcao = input.nextInt();
        
        		switch(opcao) {
    				case 1:
					deducaoFiscal=0.06;
					tipoAtividade="Saude";
				
    				case 2:
					deducaoFiscal=0.06;
					tipoAtividade="Alimentacao";
				
    				case 3:
					deducaoFiscal=0.13;
					tipoAtividade="Restauracao";
				
    				case 4:
					deducaoFiscal=0.06;
					tipoAtividade="Educacao";
				
    				case 5:
					deducaoFiscal=0.13;
					tipoAtividade="Hotelaria";
				
    				case 6:
					deducaoFiscal=0.06;
					tipoAtividade="Bens-essenciais";
				
    				case 7:
					deducaoFiscal=0.13;
					tipoAtividade="Transportes";
				
    				case 8:
					deducaoFiscal=0.23;
					tipoAtividade="Outros";
        		}
        		
        Empresa novo = new Empresa (nome, nif, email, morada, password, deducaoFiscal, tipoAtividade);
        
        if(model.registarEmpresa(novo))
        		System.out.println("\nBem-Vindo a JavaFatura!! Faça já o seu Log-in para aceder ao seu perfil.");
        //está a imprimir sempre esta mensagem
        else 
        		System.out.println("NIF ja existente. Por favor insira um novo nif:\n");
        return 0;
    }
    
    public static int RegistarCliente (Model model) {
        String nome="",email="",morada="",password="";
        int nif=0, numeroAgregados=0, numeroFiscais=0, coeficiente=0;
        Scanner input = new Scanner(System.in);
        
        System.out.println ("\nOla! Seja Bem-vindo ao registo na aplicação JavaFatura");
        System.out.println ("Por favor insira um nif: (9 digitos)");
        
        while(!(Integer.toString(nif).matches("[0-9]{9}")) || model.containsCliente(nif)) {
    			if(!(model.containsCliente(nif)))
    					System.out.print("Por favor insira o seu nif: ");
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
        System.out.print("Por favor insira o numero Fiscais: ");
        numeroFiscais = input.nextInt();
        
        System.out.println("Por favor insira qual o seu coeficiente: ");
        System.out.println("1 - Escalão A");
        System.out.println("2 - Escalão A");
        System.out.println("3 - Escalão A");
        coeficiente = input.nextInt();
            
        Cliente novo = new Cliente (nome, nif, email, morada, password, numeroAgregados, numeroFiscais, coeficiente);
        
        if(model.registarCliente(novo)) 
            System.out.println("\nBem-Vindo a JavaFatura!! faça já o seu Log-in para aceder ao seu perfil.");
        else 
    			System.out.println("Utilizador com este NIF já existe!!\n\nTente novamente" );
        return 0;
    }
    
    
    // Guarda todos os utilizadores num ficheiro .txt
    public static void guardaModel(Model model) throws FileNotFoundException, IOException { 
	    	FileOutputStream fp = new FileOutputStream("model.txt");
	    	ObjectOutputStream oos = new ObjectOutputStream(fp);
	    	oos.writeObject(model);
	    	oos.flush();
	    	fp.close();
	    	oos.close();
    	}
    
    
    // Carrega todos os utilizadores registados no programa
    public static Model carregaModel() throws IOException, ClassNotFoundException {
	    Model model ;
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
    
    //Seleciona o tipo de atividade e automaticamente a dedução fiscal
	@SuppressWarnings("unused")
	public static void selectTipoAtividade(int opcao) {
		double deducaoFiscal=0;
		String tipoAtividade="";
		
		if(opcao==1) {
			deducaoFiscal=0.06;
			tipoAtividade="Saude";
		}
		if(opcao==2) {
			deducaoFiscal=0.06;
			tipoAtividade="Alimentacao";
		}
		if(opcao==3) {
			deducaoFiscal=0.13;
			tipoAtividade="Restauracao";
		}
		if(opcao==4) {
			deducaoFiscal=0.06;
			tipoAtividade="Educacao";
		}
		if(opcao==5) {
			deducaoFiscal=0.13;
			tipoAtividade="Hotelaria";
		}
		if(opcao==6) {
			deducaoFiscal=0.06;
			tipoAtividade="Bens-essenciais";
		}
		if(opcao==7) {
			deducaoFiscal=0.13;
			tipoAtividade="Transportes";
		}
		if(opcao==8) {
			deducaoFiscal=0.23;
			tipoAtividade="Outros";
		}
		
	}
	
	   
	/**
	 * Log In Empresa
	 */
	public static Empresa logInEmpresa (int nif, String password, Model empresas){
	    if(empresas.getEmpresas().containsKey(nif))
	      if(empresas.getEmpresas().get(nif).getPassword().equals(password))
	          return empresas.getEmpresa(nif);
	    
		return new Empresa();
	}
	
	/**
	 * Log In Cliente
	 */
	public static Cliente logInCliente (int nif, String password, Model clientes){
	    if(clientes.getClientes().containsKey(nif))
	      if(clientes.getClientes().get(nif).getPassword().equals(password))
	          return clientes.getCliente(nif);
	    
	    return new Cliente();
	}
	
		
	public static void menuCliente(Model model) throws IOException {
		int caso = 1;
		
		while(caso!=0) {	
			Menus.menu2cliente();
			caso=input.nextInt();
			
			switch(caso) { 
		     	//Sai do menu de logIn cliente para o principal 
		     	case 0: { 
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
		             
		             //verifica se os dados do cliente estão registados
		             cliente = Controller.logInCliente(nif,password,model);
		             if(cliente==null) {
		                 System.out.println ("Cliente não existe ou nif/palavra-passe incorretos. Tente outra vez");
		             }
		             else
		             {
		                 View.loginC(nif,model);
		                 caso=-1;
		             }
		             break;
		         }
		         
		         // Registar um novo cliente 
		         case 2: {
		             Controller.RegistarCliente(model);
		             break;
		         }    
		     }
		}
	}
	
	public static void menuEmpresa(Model model) throws IOException {
		int caso=1;
		
		while(caso!=0) {
	        Menus.menu2empresa();
	        caso = input.nextInt();
	        
	        switch(caso) {
	        	//Sai do menu de logIn empresa para o principal 
	        	case 0: { 
	                Controller.guardaModel(model);
	                break;
	            } 
	            //Efetuar logIn Empresa 
	            case 1: {
	                //Chama um objeto do tipo empresa
	           	 	Empresa empresa;
	           	 	int nif;
	                String password = new String();
	                
	                System.out.print ("Insira o seu nif: ");
	                nif = input.nextInt();
	                
	                System.out.print("Insira a Palavra-Passe: ");
	                password = input.next();
	                
	                //Verifica se a empresa está bem registada
	                empresa = logInEmpresa(nif,password,model);
	                
	                if(empresa==null) {
	                    System.out.println ("Empresa não existe ou nif/palavra-passe incorretos. Tente outra vez");
	                }
	                else
	                {
	                    View.loginE(nif,model);
	                    caso=-1;
	                }
	                break;
	            }
	            
	            // Registar uma nova empresa 
	            case 2: {
	                RegistarEmpresa(model);
	                break;
	            }    
	        }
	        
	    }
	}
	
    public static void altDadosEmpresa(Empresa empresa) {
            Menus.menuEmpresaAltDados();
            Scanner input = new Scanner(System.in);
            int caso=1;
            
                caso = input.nextInt();
                
                switch(caso) {
                    case 1:
                        System.out.println("Escreva o seu novo email:");
                        String x = input.next();
                            while(!(x.matches("[a-z0-9._-]+@[a-z]+.[a-z]+"))) {
                                System.out.print("Por favor insira o seu email: ");
                            x = input.next();
                            }
                        empresa.setEmail(x);
                        System.out.println("O seu email foi alterado com sucesso");
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
                        break;
                        
                    case 0:
                    		menuPrincipalEmpresa(empresa);
                    		break;
                
            }
     }
  
    public static void menuPrincipalEmpresa(Empresa empresa) {
    			Menus.menuEmpresa();
            int caso = 0;
            
            caso=input.nextInt();
            
            while(caso!=0) {
                switch(caso) {
                    case 1:
                        altDadosEmpresa(empresa);
                        break;
                    
                    case 5:
                        System.out.println(empresa.toStringEmpresa());
                        break;
                }
            }
        }
    
    public static void altDadosCliente(Cliente cliente) {
        Menus.menuClienteAltDados();
        
        int caso=1;
        
            caso = input.nextInt();
            
            switch(caso) {
                case 1:
                    System.out.println("Escreva o seu novo email:");
                    String x = input.next();
                        while(!(x.matches("[a-z0-9._-]+@[a-z]+.[a-z]+"))) {
                            System.out.print("Por favor insira o seu email: ");
                        x = input.next();
                        }
                    cliente.setEmail(x);
                    System.out.println("O seu email foi alterado com sucesso");
                    break;
                    
                case 2:
                    System.out.println("Escreva a sua nova password:");
                    x = input.next();
                        while(!(x.matches("[a-zA-Z0-9]*[A-Z]+[a-zA-Z0-9]*")) || !(x.matches("[a-zA-Z0-9]*[0-9]+[a-zA-Z0-9]*")) || !(x.matches("[a-zA-Z0-9]*[a-z]+[a-zA-Z0-9]*")) || !(x.matches("[a-zA-Z0-9]{6,}"))) {
                            System.out.print("Por favor insira a sua password: ");
                            x = input.next();
                        }
                    cliente.setPassword(x);
                    System.out.println("A sua password foi alterada com sucesso");
                    break;
                  
                case 3:
                    System.out.println("Escreva a sua nova morada:");
                    x = input.next();
                        while(!(x.matches("[a-zA-Z]+"))) {
                            System.out.print("Por favor insira a sua morada: ");
                            x = input.next();
                        }
                    cliente.setMorada(x);
                    System.out.println("A sua morada foi alterada com sucesso");
                    break;
                    
                case 0:
                		menuPrincipalCliente(cliente);
                		break;
            
        }
 }
    
    public static void menuPrincipalCliente(Cliente cliente) {
		Menus.menuCliente();
		int caso = 0;
    
		caso=input.nextInt();
    
	        switch(caso) {
	            case 1:
	                altDadosCliente(cliente);
	                break;
	            
	            case 6:
	                System.out.println(cliente.toStringCliente());
	                break;
	                
	    }
	
    }

    
    
    
}
	    
   