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
@Table(name = "modelo_tb_usuario", catalog = "emodelo", schema = "")
@NamedQueries({
    @NamedQuery(name = "ModeloTbUsuario.findAll", query = "SELECT m FROM ModeloTbUsuario m")
    , @NamedQuery(name = "ModeloTbUsuario.findByIdUsuario", query = "SELECT m FROM ModeloTbUsuario m WHERE m.idUsuario = :idUsuario")
    , @NamedQuery(name = "ModeloTbUsuario.findByLoginUsuario", query = "SELECT m FROM ModeloTbUsuario m WHERE m.loginUsuario = :loginUsuario")
    , @NamedQuery(name = "ModeloTbUsuario.findBySenhaUsuario", query = "SELECT m FROM ModeloTbUsuario m WHERE m.senhaUsuario = :senhaUsuario")
    , @NamedQuery(name = "ModeloTbUsuario.findByInativoUsuario", query = "SELECT m FROM ModeloTbUsuario m WHERE m.inativoUsuario = :inativoUsuario")})
public class ModeloTbUsuario implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_usuario")
    private Integer idUsuario;
    @Column(name = "login_usuario")
    private String loginUsuario;
    @Column(name = "senha_usuario")
    private String senhaUsuario;
    @Column(name = "inativo_usuario")
    private Boolean inativoUsuario;

    public ModeloTbUsuario() {
    }

    public ModeloTbUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        Integer oldIdUsuario = this.idUsuario;
        this.idUsuario = idUsuario;
        changeSupport.firePropertyChange("idUsuario", oldIdUsuario, idUsuario);
    }

    public String getLoginUsuario() {
        return loginUsuario;
    }

    public void setLoginUsuario(String loginUsuario) {
        String oldLoginUsuario = this.loginUsuario;
        this.loginUsuario = loginUsuario;
        changeSupport.firePropertyChange("loginUsuario", oldLoginUsuario, loginUsuario);
    }

    public String getSenhaUsuario() {
        return senhaUsuario;
    }

    public void setSenhaUsuario(String senhaUsuario) {
        String oldSenhaUsuario = this.senhaUsuario;
        this.senhaUsuario = senhaUsuario;
        changeSupport.firePropertyChange("senhaUsuario", oldSenhaUsuario, senhaUsuario);
    }

    public Boolean getInativoUsuario() {
        return inativoUsuario;
    }

    public void setInativoUsuario(Boolean inativoUsuario) {
        Boolean oldInativoUsuario = this.inativoUsuario;
        this.inativoUsuario = inativoUsuario;
        changeSupport.firePropertyChange("inativoUsuario", oldInativoUsuario, inativoUsuario);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsuario != null ? idUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ModeloTbUsuario)) {
            return false;
        }
        ModeloTbUsuario other = (ModeloTbUsuario) object;
        if ((this.idUsuario == null && other.idUsuario != null) || (this.idUsuario != null && !this.idUsuario.equals(other.idUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.em.admin.ModeloTbUsuario[ idUsuario=" + idUsuario + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }

}
