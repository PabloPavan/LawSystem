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
package br.com.em.admin;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author pablo
 */
@Entity
@Table(name = "modelo_tb_vara", catalog = "emodelo", schema = "")
@NamedQueries({
    @NamedQuery(name = "ModeloTbVara.findAll", query = "SELECT m FROM ModeloTbVara m")
    , @NamedQuery(name = "ModeloTbVara.findByIdVara", query = "SELECT m FROM ModeloTbVara m WHERE m.idVara = :idVara")
    , @NamedQuery(name = "ModeloTbVara.findByNomeVara", query = "SELECT m FROM ModeloTbVara m WHERE m.nomeVara = :nomeVara")
    , @NamedQuery(name = "ModeloTbVara.findByJuizVara", query = "SELECT m FROM ModeloTbVara m WHERE m.juizVara = :juizVara")
    , @NamedQuery(name = "ModeloTbVara.findByRuaVara", query = "SELECT m FROM ModeloTbVara m WHERE m.ruaVara = :ruaVara")
    , @NamedQuery(name = "ModeloTbVara.findByNumeroVara", query = "SELECT m FROM ModeloTbVara m WHERE m.numeroVara = :numeroVara")
    , @NamedQuery(name = "ModeloTbVara.findByComplementoVara", query = "SELECT m FROM ModeloTbVara m WHERE m.complementoVara = :complementoVara")
    , @NamedQuery(name = "ModeloTbVara.findByBairroVara", query = "SELECT m FROM ModeloTbVara m WHERE m.bairroVara = :bairroVara")
    , @NamedQuery(name = "ModeloTbVara.findByCepVara", query = "SELECT m FROM ModeloTbVara m WHERE m.cepVara = :cepVara")
    , @NamedQuery(name = "ModeloTbVara.findByCidadeVara", query = "SELECT m FROM ModeloTbVara m WHERE m.cidadeVara = :cidadeVara")
    , @NamedQuery(name = "ModeloTbVara.findByEstadoVara", query = "SELECT m FROM ModeloTbVara m WHERE m.estadoVara = :estadoVara")
    , @NamedQuery(name = "ModeloTbVara.findByTelefoneVara", query = "SELECT m FROM ModeloTbVara m WHERE m.telefoneVara = :telefoneVara")
    , @NamedQuery(name = "ModeloTbVara.findByEmailVara", query = "SELECT m FROM ModeloTbVara m WHERE m.emailVara = :emailVara")})
public class ModeloTbVara implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_vara")
    private Integer idVara;
    @Column(name = "nome_vara")
    private String nomeVara;
    @Column(name = "juiz_vara")
    private String juizVara;
    @Column(name = "rua_vara")
    private String ruaVara;
    @Column(name = "numero_vara")
    private Integer numeroVara;
    @Column(name = "complemento_vara")
    private String complementoVara;
    @Column(name = "bairro_vara")
    private String bairroVara;
    @Column(name = "cep_vara")
    private String cepVara;
    @Column(name = "cidade_vara")
    private String cidadeVara;
    @Column(name = "estado_vara")
    private String estadoVara;
    @Column(name = "telefone_vara")
    private String telefoneVara;
    @Column(name = "email_vara")
    private String emailVara;

    public ModeloTbVara() {
    }

    public ModeloTbVara(Integer idVara) {
        this.idVara = idVara;
    }

    public Integer getIdVara() {
        return idVara;
    }

    public void setIdVara(Integer idVara) {
        Integer oldIdVara = this.idVara;
        this.idVara = idVara;
        changeSupport.firePropertyChange("idVara", oldIdVara, idVara);
    }

    public String getNomeVara() {
        return nomeVara;
    }

    public void setNomeVara(String nomeVara) {
        String oldNomeVara = this.nomeVara;
        this.nomeVara = nomeVara;
        changeSupport.firePropertyChange("nomeVara", oldNomeVara, nomeVara);
    }

    public String getJuizVara() {
        return juizVara;
    }

    public void setJuizVara(String juizVara) {
        String oldJuizVara = this.juizVara;
        this.juizVara = juizVara;
        changeSupport.firePropertyChange("juizVara", oldJuizVara, juizVara);
    }

    public String getRuaVara() {
        return ruaVara;
    }

    public void setRuaVara(String ruaVara) {
        String oldRuaVara = this.ruaVara;
        this.ruaVara = ruaVara;
        changeSupport.firePropertyChange("ruaVara", oldRuaVara, ruaVara);
    }

    public Integer getNumeroVara() {
        return numeroVara;
    }

    public void setNumeroVara(Integer numeroVara) {
        Integer oldNumeroVara = this.numeroVara;
        this.numeroVara = numeroVara;
        changeSupport.firePropertyChange("numeroVara", oldNumeroVara, numeroVara);
    }

    public String getComplementoVara() {
        return complementoVara;
    }

    public void setComplementoVara(String complementoVara) {
        String oldComplementoVara = this.complementoVara;
        this.complementoVara = complementoVara;
        changeSupport.firePropertyChange("complementoVara", oldComplementoVara, complementoVara);
    }

    public String getBairroVara() {
        return bairroVara;
    }

    public void setBairroVara(String bairroVara) {
        String oldBairroVara = this.bairroVara;
        this.bairroVara = bairroVara;
        changeSupport.firePropertyChange("bairroVara", oldBairroVara, bairroVara);
    }

    public String getCepVara() {
        return cepVara;
    }

    public void setCepVara(String cepVara) {
        String oldCepVara = this.cepVara;
        this.cepVara = cepVara;
        changeSupport.firePropertyChange("cepVara", oldCepVara, cepVara);
    }

    public String getCidadeVara() {
        return cidadeVara;
    }

    public void setCidadeVara(String cidadeVara) {
        String oldCidadeVara = this.cidadeVara;
        this.cidadeVara = cidadeVara;
        changeSupport.firePropertyChange("cidadeVara", oldCidadeVara, cidadeVara);
    }

    public String getEstadoVara() {
        return estadoVara;
    }

    public void setEstadoVara(String estadoVara) {
        String oldEstadoVara = this.estadoVara;
        this.estadoVara = estadoVara;
        changeSupport.firePropertyChange("estadoVara", oldEstadoVara, estadoVara);
    }

    public String getTelefoneVara() {
        return telefoneVara;
    }

    public void setTelefoneVara(String telefoneVara) {
        String oldTelefoneVara = this.telefoneVara;
        this.telefoneVara = telefoneVara;
        changeSupport.firePropertyChange("telefoneVara", oldTelefoneVara, telefoneVara);
    }

    public String getEmailVara() {
        return emailVara;
    }

    public void setEmailVara(String emailVara) {
        String oldEmailVara = this.emailVara;
        this.emailVara = emailVara;
        changeSupport.firePropertyChange("emailVara", oldEmailVara, emailVara);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVara != null ? idVara.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ModeloTbVara)) {
            return false;
        }
        ModeloTbVara other = (ModeloTbVara) object;
        if ((this.idVara == null && other.idVara != null) || (this.idVara != null && !this.idVara.equals(other.idVara))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.em.admin.ModeloTbVara[ idVara=" + idVara + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }

}
