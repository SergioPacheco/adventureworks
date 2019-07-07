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
@Table(name = "SalesReason", catalog = "AdventureWorks2017", schema = "Sales")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SalesReason.findAll", query = "SELECT s FROM SalesReason s"),
    @NamedQuery(name = "SalesReason.findBySalesReasonID", query = "SELECT s FROM SalesReason s WHERE s.salesReasonID = :salesReasonID"),
    @NamedQuery(name = "SalesReason.findByModifiedDate", query = "SELECT s FROM SalesReason s WHERE s.modifiedDate = :modifiedDate")})
public class SalesReason implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "SalesReasonID")
    private Integer salesReasonID;
    @Basic(optional = false)
    @Column(name = "ModifiedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "salesReason")
    private Collection<SalesOrderHeaderSalesReason> salesOrderHeaderSalesReasonCollection;

    public SalesReason() {
    }

    public SalesReason(Integer salesReasonID) {
        this.salesReasonID = salesReasonID;
    }

    public SalesReason(Integer salesReasonID, Date modifiedDate) {
        this.salesReasonID = salesReasonID;
        this.modifiedDate = modifiedDate;
    }

    public Integer getSalesReasonID() {
        return salesReasonID;
    }

    public void setSalesReasonID(Integer salesReasonID) {
        this.salesReasonID = salesReasonID;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    @XmlTransient
    public Collection<SalesOrderHeaderSalesReason> getSalesOrderHeaderSalesReasonCollection() {
        return salesOrderHeaderSalesReasonCollection;
    }

    public void setSalesOrderHeaderSalesReasonCollection(Collection<SalesOrderHeaderSalesReason> salesOrderHeaderSalesReasonCollection) {
        this.salesOrderHeaderSalesReasonCollection = salesOrderHeaderSalesReasonCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (salesReasonID != null ? salesReasonID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SalesReason)) {
            return false;
        }
        SalesReason other = (SalesReason) object;
        if ((this.salesReasonID == null && other.salesReasonID != null) || (this.salesReasonID != null && !this.salesReasonID.equals(other.salesReasonID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jmresler.spring.aw.entities.SalesReason[ salesReasonID=" + salesReasonID + " ]";
    }
    
}
