/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.em.pojo;

/**
 *
 * @author pablo
 */
public class Cliente  {

    private Pessoa p = new Pessoa();
   

    private String id_cliente;
    private String id_pessoa;
    private String numero_cliente;
    private String filhos_cliente;
    private String conjugeNome_cliente;
    private String conjugeSalario_cliente;
    private String profisao_cliente;
    private String localTrabalho_cliente;
    private String requerenteSalario_cliente;
    private String relacaoBens_cliente;
    private String dataRegistro_cliente;
    private boolean defere_cliente;
    private boolean inativo_cliente;

    
     public Pessoa getP() {
        return p;
    }

    public void setP(Pessoa p) {
        this.p = p;
    }
    
    public String getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(String id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getId_pessoa() {
        return id_pessoa;
    }

    public void setId_pessoa(String id_pessoa) {
        this.id_pessoa = id_pessoa;
    }

    public String getNumero_cliente() {
        return numero_cliente;
    }

    public void setNumero_cliente(String numero_cliente) {
        this.numero_cliente = numero_cliente;
    }

    public String getFilhos_cliente() {
        return filhos_cliente;
    }

    public void setFilhos_cliente(String filhos_cliente) {
        this.filhos_cliente = filhos_cliente;
    }

    public String getConjugeNome_cliente() {
        return conjugeNome_cliente;
    }

    public void setConjugeNome_cliente(String conjugeNome_cliente) {
        this.conjugeNome_cliente = conjugeNome_cliente;
    }

    public String getConjugeSalario_cliente() {
        return conjugeSalario_cliente;
    }

    public void setConjugeSalario_cliente(String conjugeSalario_cliente) {
        this.conjugeSalario_cliente = conjugeSalario_cliente;
    }

    public String getProfisao_cliente() {
        return profisao_cliente;
    }

    public void setProfisao_cliente(String profisao_cliente) {
        this.profisao_cliente = profisao_cliente;
    }

    public String getLocalTrabalho_cliente() {
        return localTrabalho_cliente;
    }

    public void setLocalTrabalho_cliente(String localTrabalho_cliente) {
        this.localTrabalho_cliente = localTrabalho_cliente;
    }

 
    public String getDataRegistro_cliente() {
        return dataRegistro_cliente;
    }

    public void setDataRegistro_cliente(String dataRegistro_cliente) {
        this.dataRegistro_cliente = dataRegistro_cliente;
    }
  

    public boolean isDefere_cliente() {
        return defere_cliente;
    }

    public void setDefere_cliente(boolean defere_cliente) {
        this.defere_cliente = defere_cliente;
    }


    public boolean isInativo_cliente() {
        return inativo_cliente;
    }

    public void setInativo_cliente(boolean inativo_cliente) {
        this.inativo_cliente = inativo_cliente;
    }

    public String getRequerenteSalario_cliente() {
        return requerenteSalario_cliente;
    }

    public void setRequerenteSalario_cliente(String requerenteSalario_cliente) {
        this.requerenteSalario_cliente = requerenteSalario_cliente;
    }

    public String getRelacaoBens_cliente() {
        return relacaoBens_cliente;
    }

    public void setRelacaoBens_cliente(String relacaoBens_cliente) {
        this.relacaoBens_cliente = relacaoBens_cliente;
    }

   

}
