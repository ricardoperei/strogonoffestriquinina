import java.io.*;
import java.util.*;
import java.text.DecimalFormat;


public class Controller 
{
	private static Scanner input = new Scanner (System.in);
	//Chamamos Admin empresas para ir á classe Admin e mexer com o map das empresas
    public static int RegistarEmpresa (Model empresas) {
        String nome,email,morada,password, tipoAtividade;
        int nif;
        double deducaoFiscal;
        Scanner input = new Scanner(System.in);
        
        System.out.println ("\nOla! Seja Bem-vindo ao registo na aplicação JavaFatura");
        System.out.println ("Por favor insira um nif:");
        nif= input.nextInt();
        //verifica se um nif ja existe
        while(empresas.containsEmpresa(nif)){
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
        //Fazer atraves de um switch para escolher a atividade depois
        System.out.print("Por favor insira o tipo da sua atividade: ");
        tipoAtividade = input.next();
        System.out.print("Por favor insira qual a dedução fiscal da sua empresa: ");
        deducaoFiscal = input.nextDouble();
            
        Empresa novo = new Empresa (nome, nif, email, morada, password, deducaoFiscal, tipoAtividade);
        if(empresas.registarEmpresa(novo)) {
            System.out.print("\f");
            System.out.println("\nBem-Vindo a JavaFatura!! faça já o seu Log-in para aceder ao seu perfil.");
        }
        return 0;
    }
    
  //Chamamos Admin empresas para ir á classe Admin e mexer com o map das empresas
    public static int RegistarCliente (Model model) {
        String nome="",email="",morada="",password="";
        int nif=0, numeroAgregados, numeroFiscais, codigo;
        double coeficiente;
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
        System.out.print("Por favor insira qual o seu coeficiente: ");
        coeficiente = input.nextDouble();
        System.out.print("Por favor insira o seu codigo: ");
        codigo = input.nextInt();

            
        Cliente novo = new Cliente (nome, nif, email, morada, password, numeroAgregados, numeroFiscais, coeficiente, codigo);
        if(model.registarCliente(novo)) {
            System.out.print("\f");
            System.out.println("\nBem-Vindo a JavaFatura!! faça já o seu Log-in para aceder ao seu perfil.");
        }
        return 0;
    }
    
    /**
     * Abre um ficheiro com Empresas se existir
     */
    
    
    public static void guardaC(HashMap<Integer,Cliente> utilizadores) throws FileNotFoundException, IOException { 
    	FileOutputStream fp = new FileOutputStream("clientes.txt");
    	ObjectOutputStream oos = new ObjectOutputStream(fp);
    	oos.writeObject(utilizadores);
    	oos.flush();
    	fp.close();
    	oos.close();
    	}
    
    public static void guardaE(HashMap<Integer,Empresa> empresas) throws FileNotFoundException, IOException { 
    	FileOutputStream fp = new FileOutputStream("empresas.txt");
    	ObjectOutputStream oos = new ObjectOutputStream(fp);
    	oos.writeObject(empresas);
    	oos.flush();
    	fp.close();
    	oos.close();
    	}
    
    public static HashMap<Integer,Cliente> lerC() throws IOException, ClassNotFoundException {
    	HashMap <Integer,Cliente> utilizadores ;
    File file = new File("clientes.txt");
    		if(!file.exists())
    			file.createNewFile();
    	try {
    		FileInputStream fp = new FileInputStream("clientes.txt");
        	ObjectInputStream ois = new ObjectInputStream(fp);
        	utilizadores = (HashMap<Integer,Cliente>) ois.readObject();
        	fp.close();
        	ois.close();
    		} catch (EOFException e) {
    			utilizadores = new HashMap<>();
    		}
    			
    	return utilizadores;
    		
    	
    }

    public static HashMap<Integer,Empresa> lerE() throws IOException, ClassNotFoundException {
    	HashMap <Integer,Empresa> utilizadores ;
    	File file = new File("empresas.txt");
		if(!file.exists())
			file.createNewFile();
    	try {
    		FileInputStream fp = new FileInputStream("empresas.txt");
        	ObjectInputStream ois = new ObjectInputStream(fp);
        	utilizadores = (HashMap<Integer,Empresa>) ois.readObject();
        	fp.close();
        	ois.close();
    		} catch (EOFException e) {
    			utilizadores = new HashMap<>();
    		}
    			
    	return utilizadores;
    		
    	
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
}
    
   