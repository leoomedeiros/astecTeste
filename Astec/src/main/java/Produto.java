import java.math.BigDecimal;
import java.util.Date;

public class Produto {
    /*
String cor
int quantidade
String descricao*/
    
  private int codigoProduto;

  private int codigoBanco;

  private String nomeProduto;

  private String descricao;

  private BigDecimal tamanho;

  private BigDecimal preco;

  private String categoria;
  
  private String cor;
  
  private int quantidade;
  
  private Date dtCadastro;

    public Produto(int codigoProduto, int codigoBanco, String nomeProduto, String descricao, BigDecimal tamanho, BigDecimal preco, String categoria, String cor, int quantidade, Date dtCadastro) {
        this.codigoProduto = codigoProduto;
        this.codigoBanco = codigoBanco;
        this.nomeProduto = nomeProduto;
        this.descricao = descricao;
        this.tamanho = tamanho;
        this.preco = preco;
        this.categoria = categoria;
        this.cor = cor;
        this.quantidade = quantidade;
        this.dtCadastro = dtCadastro;
    }

  

    public int getCodigoProduto() {
        return codigoProduto;
    }

    public void setCodigoProduto(int codigoProduto) {
        this.codigoProduto = codigoProduto;
    }

    public int getCodigoBanco() {
        return codigoBanco;
    }

    public void setCodigoBanco(int codigoBanco) {
        this.codigoBanco = codigoBanco;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getTamanho() {
        return tamanho;
    }

    public void setTamanho(BigDecimal tamanho) {
        this.tamanho = tamanho;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Date getDtCadastro() {
        return dtCadastro;
    }

    public void setDtCadastro(Date dtCadastro) {
        this.dtCadastro = dtCadastro;
    }

}
