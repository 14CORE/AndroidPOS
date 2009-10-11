package com.mdss.pos.model.dao;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import com.mdss.pos.model.dao.PayOutTransactionDAO;
import org.hibernate.criterion.Order;

/**
 * This is an automatically generated DAO class which should not be edited.
 */
public abstract class BasePayOutTransactionDAO extends com.mdss.pos.model.dao._RootDAO {

	// query name references


	public static PayOutTransactionDAO instance;

	/**
	 * Return a singleton of the DAO
	 */
	public static PayOutTransactionDAO getInstance () {
		if (null == instance) instance = new PayOutTransactionDAO();
		return instance;
	}

	public Class getReferenceClass () {
		return com.mdss.pos.model.PayOutTransaction.class;
	}

    public Order getDefaultOrder () {
		return null;
    }

	/**
	 * Cast the object as a com.mdss.pos.model.PayOutTransaction
	 */
	public com.mdss.pos.model.PayOutTransaction cast (Object object) {
		return (com.mdss.pos.model.PayOutTransaction) object;
	}

	public com.mdss.pos.model.PayOutTransaction get(java.lang.Integer key)
	{
		return (com.mdss.pos.model.PayOutTransaction) get(getReferenceClass(), key);
	}

	public com.mdss.pos.model.PayOutTransaction get(java.lang.Integer key, Session s)
	{
		return (com.mdss.pos.model.PayOutTransaction) get(getReferenceClass(), key, s);
	}

	public com.mdss.pos.model.PayOutTransaction load(java.lang.Integer key)
	{
		return (com.mdss.pos.model.PayOutTransaction) load(getReferenceClass(), key);
	}

	public com.mdss.pos.model.PayOutTransaction load(java.lang.Integer key, Session s)
	{
		return (com.mdss.pos.model.PayOutTransaction) load(getReferenceClass(), key, s);
	}

	public com.mdss.pos.model.PayOutTransaction loadInitialize(java.lang.Integer key, Session s) 
	{ 
		com.mdss.pos.model.PayOutTransaction obj = load(key, s); 
		if (!Hibernate.isInitialized(obj)) {
			Hibernate.initialize(obj);
		} 
		return obj; 
	}

/* Generic methods */

	/**
	 * Return all objects related to the implementation of this DAO with no filter.
	 */
	public java.util.List<com.mdss.pos.model.PayOutTransaction> findAll () {
		return super.findAll();
	}

	/**
	 * Return all objects related to the implementation of this DAO with no filter.
	 */
	public java.util.List<com.mdss.pos.model.PayOutTransaction> findAll (Order defaultOrder) {
		return super.findAll(defaultOrder);
	}

	/**
	 * Return all objects related to the implementation of this DAO with no filter.
	 * Use the session given.
	 * @param s the Session
	 */
	public java.util.List<com.mdss.pos.model.PayOutTransaction> findAll (Session s, Order defaultOrder) {
		return super.findAll(s, defaultOrder);
	}

	/**
	 * Persist the given transient instance, first assigning a generated identifier. (Or using the current value
	 * of the identifier property if the assigned generator is used.) 
	 * @param payOutTransaction a transient instance of a persistent class 
	 * @return the class identifier
	 */
	public java.lang.Integer save(com.mdss.pos.model.PayOutTransaction payOutTransaction)
	{
		return (java.lang.Integer) super.save(payOutTransaction);
	}

	/**
	 * Persist the given transient instance, first assigning a generated identifier. (Or using the current value
	 * of the identifier property if the assigned generator is used.) 
	 * Use the Session given.
	 * @param payOutTransaction a transient instance of a persistent class
	 * @param s the Session
	 * @return the class identifier
	 */
	public java.lang.Integer save(com.mdss.pos.model.PayOutTransaction payOutTransaction, Session s)
	{
		return (java.lang.Integer) save((Object) payOutTransaction, s);
	}

	/**
	 * Either save() or update() the given instance, depending upon the value of its identifier property. By default
	 * the instance is always saved. This behaviour may be adjusted by specifying an unsaved-value attribute of the
	 * identifier property mapping. 
	 * @param payOutTransaction a transient instance containing new or updated state 
	 */
	public void saveOrUpdate(com.mdss.pos.model.PayOutTransaction payOutTransaction)
	{
		saveOrUpdate((Object) payOutTransaction);
	}

	/**
	 * Either save() or update() the given instance, depending upon the value of its identifier property. By default the
	 * instance is always saved. This behaviour may be adjusted by specifying an unsaved-value attribute of the identifier
	 * property mapping. 
	 * Use the Session given.
	 * @param payOutTransaction a transient instance containing new or updated state.
	 * @param s the Session.
	 */
	public void saveOrUpdate(com.mdss.pos.model.PayOutTransaction payOutTransaction, Session s)
	{
		saveOrUpdate((Object) payOutTransaction, s);
	}

	/**
	 * Update the persistent state associated with the given identifier. An exception is thrown if there is a persistent
	 * instance with the same identifier in the current session.
	 * @param payOutTransaction a transient instance containing updated state
	 */
	public void update(com.mdss.pos.model.PayOutTransaction payOutTransaction) 
	{
		update((Object) payOutTransaction);
	}

	/**
	 * Update the persistent state associated with the given identifier. An exception is thrown if there is a persistent
	 * instance with the same identifier in the current session.
	 * Use the Session given.
	 * @param payOutTransaction a transient instance containing updated state
	 * @param the Session
	 */
	public void update(com.mdss.pos.model.PayOutTransaction payOutTransaction, Session s)
	{
		update((Object) payOutTransaction, s);
	}

	/**
	 * Remove a persistent instance from the datastore. The argument may be an instance associated with the receiving
	 * Session or a transient instance with an identifier associated with existing persistent state. 
	 * @param id the instance ID to be removed
	 */
	public void delete(java.lang.Integer id)
	{
		delete((Object) load(id));
	}

	/**
	 * Remove a persistent instance from the datastore. The argument may be an instance associated with the receiving
	 * Session or a transient instance with an identifier associated with existing persistent state. 
	 * Use the Session given.
	 * @param id the instance ID to be removed
	 * @param s the Session
	 */
	public void delete(java.lang.Integer id, Session s)
	{
		delete((Object) load(id, s), s);
	}

	/**
	 * Remove a persistent instance from the datastore. The argument may be an instance associated with the receiving
	 * Session or a transient instance with an identifier associated with existing persistent state. 
	 * @param payOutTransaction the instance to be removed
	 */
	public void delete(com.mdss.pos.model.PayOutTransaction payOutTransaction)
	{
		delete((Object) payOutTransaction);
	}

	/**
	 * Remove a persistent instance from the datastore. The argument may be an instance associated with the receiving
	 * Session or a transient instance with an identifier associated with existing persistent state. 
	 * Use the Session given.
	 * @param payOutTransaction the instance to be removed
	 * @param s the Session
	 */
	public void delete(com.mdss.pos.model.PayOutTransaction payOutTransaction, Session s)
	{
		delete((Object) payOutTransaction, s);
	}
	
	/**
	 * Re-read the state of the given instance from the underlying database. It is inadvisable to use this to implement
	 * long-running sessions that span many business tasks. This method is, however, useful in certain special circumstances.
	 * For example 
	 * <ul> 
	 * <li>where a database trigger alters the object state upon insert or update</li>
	 * <li>after executing direct SQL (eg. a mass update) in the same session</li>
	 * <li>after inserting a Blob or Clob</li>
	 * </ul>
	 */
	public void refresh (com.mdss.pos.model.PayOutTransaction payOutTransaction, Session s)
	{
		refresh((Object) payOutTransaction, s);
	}


}