package com.doccuty.epill.userdrugplan;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.doccuty.epill.drug.Drug;
import com.doccuty.epill.user.User;

import de.uniks.networkparser.interfaces.SendableEntity;

@Entity
@Table(name="user_drug_plan")
public class UserDrugPlan implements SendableEntity {

    public UserDrugPlan() {

    }

    //==========================================================================
    public static final String PROPERTY_ID = "id";

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;

    public long getId()
    {
        return this.id;
    }

    public void setId(long value)
    {
        if (this.id != value) {

            double oldValue = this.id;
            this.id = value;
            this.firePropertyChange(PROPERTY_ID, oldValue, value);
        }
    }

    public UserDrugPlan withId(long value)
    {
        setId(value);
        return this;
    }


    @Override
    public String toString()
    {
        StringBuilder result = new StringBuilder();
        result.append(" ").append(this.getId()).append(" ").append(this.getDrug());
        return result.substring(1);
    }

    //Planned Timestamp for drug taking==========================================================================
    public static final String PROPERTY_DATETIME_INTAKE_PLANNED = "datetime_intake_planned";

    @Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date dateTimePlanned;

    public Date getDatetimeIntakePlanned()
    {
        return this.dateTimePlanned;
    }

    public void setDateTimePlanned(Date value)
    {
        if (this.dateTimePlanned != value) {
            Date oldValue = this.dateTimePlanned;
            this.dateTimePlanned = value;
            this.firePropertyChange(PROPERTY_DATETIME_INTAKE_PLANNED, oldValue, value);
        }
    }

    public UserDrugPlan withTimestamp(Date value)
    {
        setDateTimePlanned(value);
        return this;
    }
    //==========================================================================

    /********************************************************************
     * <pre>
     *              many                       one
     * UserDrugPlan ----------------------------------- Drug
     *              userDrugPlans                   drug
     * </pre>
     */

    public static final String PROPERTY_DRUG = "drug";

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="iddrug")
    private Drug drug = null;

    public Drug getDrug()
    {
        return this.drug;
    }

    public boolean setDrug(Drug value)
    {
        boolean changed = false;

        if (this.drug != value)
        {
            Drug oldValue = this.drug;

            if (this.drug != null)
            {
                this.drug = null;
                oldValue.withUserDrugPlans(this);
            }

            this.drug = value;
            if (value != null)
            {
                value.withUserDrugPlans(this);
            }

            firePropertyChange(PROPERTY_DRUG, oldValue, value);
            changed = true;
        }

        return changed;
    }

    public UserDrugPlan withDrug(Drug value)
    {
        setDrug(value);
        return this;
    }

    public Drug createDrug()
    {
        Drug value = new Drug();
        withDrug(value);
        return value;
    }

    /********************************************************************
     * <pre>
     *              many                       one
     * UserDrugPlan ----------------------------------- User
     *              userDrugPlans                   user
     * </pre>
     */
    public static final String PROPERTY_USER = "user";
    @ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name="iduser")
    private User user = null;

    public User getUser()
    {
        return this.user;
    }

    public boolean setUser(User value)
    {
        boolean changed = false;

        if (this.user != value)
        {
            User oldValue = this.user;
            if (this.user != null)
            {
                this.user = null;
                oldValue.withoutUserDrugPlans(this);
            }
            this.user = value;
            if (value != null)
            {
                value.withoutUserDrugPlans(this);
            }

            firePropertyChange(PROPERTY_USER, oldValue, value);
            changed = true;
        }

        return changed;
    }

    public UserDrugPlan withUser(User value)
    {
        setUser(value);
        return this;
    }

    //==========================================================================


    public void removeYou()
    {
        setDrug(null);
        setUser(null);
        setDateTimePlanned(null);
        firePropertyChange("REMOVE_YOU", this, null);
    }


    //TODO: listener really necessary here?==========================================================================
    protected PropertyChangeSupport listeners = null;
    public boolean firePropertyChange(String propertyName, Object oldValue, Object newValue)
    {
        if (listeners != null) {
            listeners.firePropertyChange(propertyName, oldValue, newValue);
            return true;
        }
        return false;
    }

    public boolean addPropertyChangeListener(PropertyChangeListener listener)
    {
        if (listeners == null) {
            listeners = new PropertyChangeSupport(this);
        }
        listeners.addPropertyChangeListener(listener);
        return true;
    }

    public boolean addPropertyChangeListener(String propertyName, PropertyChangeListener listener) {
        if (listeners == null) {
            listeners = new PropertyChangeSupport(this);
        }
        listeners.addPropertyChangeListener(propertyName, listener);
        return true;
    }

    public boolean removePropertyChangeListener(PropertyChangeListener listener) {
        if (listeners == null) {
            listeners.removePropertyChangeListener(listener);
        }
        listeners.removePropertyChangeListener(listener);
        return true;
    }

    public boolean removePropertyChangeListener(String propertyName,PropertyChangeListener listener) {
        if (listeners != null) {
            listeners.removePropertyChangeListener(propertyName, listener);
        }
        return true;
    }
}
