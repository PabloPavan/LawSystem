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
package br.com.em.vo;

/**
 *
 * @author pablo
 */
public class AgendaVo {

    private String hora_agenda;
    private String atividade_agenda;
    private String numero_processo;
    private String numero_cliente;
    private String acao_processo;

    public String getHora_agenda() {
        return hora_agenda;
    }

    public void setHora_agenda(String hora_agenda) {
        this.hora_agenda = hora_agenda;
    }

    public String getAtividade_agenda() {
        return atividade_agenda;
    }

    public void setAtividade_agenda(String atividade_agenda) {
        this.atividade_agenda = atividade_agenda;
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

}
