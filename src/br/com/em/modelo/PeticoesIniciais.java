/*
 * Copyright (C) 2017 pablo
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package br.com.em.modelo;

/**
 *
 * @author pablo
 */
public class PeticoesIniciais {

    private String id_peticoesIniciais;
    private String id_processo;
    private String id_cliente;
    private String data_peticoesIniciais;
    private String numero_processo;
    private String numero_cliente;
    private String acao_processo;
    private String numeroPasta_processo;
    private String nome_pessoa;
    private String sobrenome_pessoa;

    public String getId_peticoesIniciais() {
        return id_peticoesIniciais;
    }

    public void setId_peticoesIniciais(String id_peticoesIniciais) {
        this.id_peticoesIniciais = id_peticoesIniciais;
    }

    public String getId_processo() {
        return id_processo;
    }

    public void setId_processo(String id_processo) {
        this.id_processo = id_processo;
    }

    public String getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(String id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getData_peticoesIniciais() {
        return data_peticoesIniciais;
    }

    public void setData_peticoesIniciais(String data_peticoesIniciais) {
        this.data_peticoesIniciais = data_peticoesIniciais;
    }

    public String getNumero_processo() {
        return numero_processo;
    }

    public void setNumero_processo(String numero_processo) {
        this.numero_processo = numero_processo;
    }

    public String getNumero_cliente() {
        return numero_cliente;
    }

    public void setNumero_cliente(String numero_cliente) {
        this.numero_cliente = numero_cliente;
    }

    public String getAcao_processo() {
        return acao_processo;
    }

    public void setAcao_processo(String acao_processo) {
        this.acao_processo = acao_processo;
    }

    public String getNumeroPasta_processo() {
        return numeroPasta_processo;
    }

    public void setNumeroPasta_processo(String numeroPasta_processo) {
        this.numeroPasta_processo = numeroPasta_processo;
    }

    public String getNome_pessoa() {
        return nome_pessoa;
    }

    public void setNome_pessoa(String nome_pessoa) {
        this.nome_pessoa = nome_pessoa;
    }

    public String getSobrenome_pessoa() {
        return sobrenome_pessoa;
    }

    public void setSobrenome_pessoa(String sobrenome_pessoa) {
        this.sobrenome_pessoa = sobrenome_pessoa;
    }

}
