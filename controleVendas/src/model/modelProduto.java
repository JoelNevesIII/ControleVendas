package model;

/**
 *
 * @author Joel
 */
public class modelProduto {
    private int id_area;
    private String nome;
    private String descricao;
    private double quantidade;
    private double est_max;
    private double est_min;
    private boolean controla_est;
    private double comissao;
    private double valor_venda;
    private double valor_custo;

    public int getId_area() {
        return id_area;
    }

    public void setId_area(int id_area) {
        this.id_area = id_area;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }

    public double getEst_max() {
        return est_max;
    }

    public void setEst_max(double est_max) {
        this.est_max = est_max;
    }

    public double getEst_min() {
        return est_min;
    }

    public void setEst_min(double est_min) {
        this.est_min = est_min;
    }

    public boolean isControla_est() {
        return controla_est;
    }

    public void setControla_est(boolean controla_est) {
        this.controla_est = controla_est;
    }

    public double getComissao() {
        return comissao;
    }

    public void setComissao(double comissao) {
        this.comissao = comissao;
    }

    public double getValor_venda() {
        return valor_venda;
    }

    public void setValor_venda(double valor_venda) {
        this.valor_venda = valor_venda;
    }

    public double getValor_custo() {
        return valor_custo;
    }

    public void setValor_custo(double valor_custo) {
        this.valor_custo = valor_custo;
    }
    
    
    
}
