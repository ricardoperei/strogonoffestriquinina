import java.time.LocalDate;

public class Fatura
{
    private int numFiscalEmp;
    private String designacao;
    private LocalDate data;
    private int numFiscalCli;
    private String descricao;
    private String natureza; // actividade economica da despesa
    private double valor;
    
    public Fatura(){
      this.numFiscalEmp=0;
      this.designacao="";
      this.data = LocalDate.of(0000, 0, 0);
      this.numFiscalCli=0;
      this.descricao="";
      this.natureza="";
      this.valor=0.0;
    }
    
    public Fatura(int numFiscalEmp, String designacao, LocalDate data, int numFiscalCli, String descricao,String natureza,double valor){
        this.numFiscalEmp=numFiscalEmp;
        this.designacao=designacao;
        this.data=data;
        this.numFiscalCli=numFiscalCli;
        this.descricao=descricao;
        this.natureza=natureza;
        this.valor=valor;
    }
    public Fatura(Fatura factura){
     this.numFiscalEmp=factura.getNumFiscalEmp();
     this.designacao=factura.getDesignacao();
     this.data=factura.getData();
     this.numFiscalCli=factura.getNumFiscalCli();
     this.descricao=factura.getDescricao();
     this.natureza=factura.getNatureza();
     this.valor=factura.getValor();
     
    }
    
    public int getNumFiscalEmp(){
     return numFiscalEmp;
    }
    
    public String getDesignacao(){
        return designacao;
    }
    
    public LocalDate getData(){
        return data;
    }
    
    public int getNumFiscalCli(){
     return numFiscalCli;   
    }
    
    public String getDescricao(){
        return descricao;
    }
    
    public String getNatureza(){
        return natureza;
    }
    
    public double getValor(){
        return valor;
    }
    
    public void setNumFiscalEmp(int numFiscalEmp){
        this.numFiscalEmp=numFiscalEmp;
      }
    
    public void setDesignacao(String designacao){
        this.designacao=designacao;
      }
    
    public void setData(LocalDate data){
        this.data=data;
      }
    
    public void setNumFiscalCli(int numFiscalCli){
        this.numFiscalCli=numFiscalCli;
      }
    
    public void setNatureza(String natureza){
        this.natureza=natureza;
      }
    
    public void setValor(double valor){
        this.valor=valor;
      }
}
