/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jmresler.spring.aw.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author John
 */
@Entity
@Table(name = "StateProvince", catalog = "AdventureWorks2017", schema = "Person")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StateProvince.findAll", query = "SELECT s FROM StateProvince s"),
    @NamedQuery(name = "StateProvince.findByStateProvinceID", query = "SELECT s FROM StateProvince s WHERE s.stateProvinceID = :stateProvinceID"),
    @NamedQuery(name = "StateProvince.findByStateProvinceCode", query = "SELECT s FROM StateProvince s WHERE s.stateProvinceCode = :stateProvinceCode"),
    @NamedQuery(name = "StateProvince.findByTerritoryID", query = "SELECT s FROM StateProvince s WHERE s.territoryID = :territoryID"),
    @NamedQuery(name = "StateProvince.findByRowguid", query = "SELECT s FROM StateProvince s WHERE s.rowguid = :rowguid"),
    @NamedQuery(name = "StateProvince.findByModifiedDate", query = "SELECT s FROM StateProvince s WHERE s.modifiedDate = :modifiedDate")})
public class StateProvince implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "StateProvinceID")
    private Integer stateProvinceID;
    @Basic(optional = false)
    @Column(name = "StateProvinceCode")
    private String stateProvinceCode;
    @Basic(optional = false)
    @Column(name = "TerritoryID")
    private int territoryID;
    @Basic(optional = false)
    @Column(name = "rowguid")
    private String rowguid;
    @Basic(optional = false)
    @Column(name = "ModifiedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stateProvinceID")
    private Collection<Address> addressCollection;
    @JoinColumn(name = "CountryRegionCode", referencedColumnName = "CountryRegionCode")
    @ManyToOne(optional = false)
    private CountryRegion countryRegionCode;

    public StateProvince() {
    }

    public StateProvince(Integer stateProvinceID) {
        this.stateProvinceID = stateProvinceID;
    }

    public StateProvince(Integer stateProvinceID, String stateProvinceCode, int territoryID, String rowguid, Date modifiedDate) {
        this.stateProvinceID = stateProvinceID;
        this.stateProvinceCode = stateProvinceCode;
        this.territoryID = territoryID;
        this.rowguid = rowguid;
        this.modifiedDate = modifiedDate;
    }

    public Integer getStateProvinceID() {
        return stateProvinceID;
    }

    public void setStateProvinceID(Integer stateProvinceID) {
        this.stateProvinceID = stateProvinceID;
    }

    public String getStateProvinceCode() {
        return stateProvinceCode;
    }

    public void setStateProvinceCode(String stateProvinceCode) {
        this.stateProvinceCode = stateProvinceCode;
    }

    public int getTerritoryID() {
        return territoryID;
    }

    public void setTerritoryID(int territoryID) {
        this.territoryID = territoryID;
    }

    public String getRowguid() {
        return rowguid;
    }

    public void setRowguid(String rowguid) {
        this.rowguid = rowguid;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    @XmlTransient
    public Collection<Address> getAddressCollection() {
        return addressCollection;
    }

    public void setAddressCollection(Collection<Address> addressCollection) {
        this.addressCollection = addressCollection;
    }

    public CountryRegion getCountryRegionCode() {
        return countryRegionCode;
    }

    public void setCountryRegionCode(CountryRegion countryRegionCode) {
        this.countryRegionCode = countryRegionCode;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (stateProvinceID != null ? stateProvinceID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StateProvince)) {
            return false;
        }
        StateProvince other = (StateProvince) object;
        if ((this.stateProvinceID == null && other.stateProvinceID != null) || (this.stateProvinceID != null && !this.stateProvinceID.equals(other.stateProvinceID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jmresler.spring.aw.entities.StateProvince[ stateProvinceID=" + stateProvinceID + " ]";
    }
    
}