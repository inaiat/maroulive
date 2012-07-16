/*
 *  Copyright 2010 inaiat.
 * 
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 * 
 *       http://www.apache.org/licenses/LICENSE-2.0
 * 
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *  under the License.
 */
package ${package}.persistence;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public abstract class AbstractHibernateDaoImpl<T extends Serializable, KeyType extends Serializable>
        extends HibernateDaoSupport implements AbstractGenericDao<T, KeyType> {

    protected Class<T> domainClass = getDomainClass();

    /**
     * Method to return the class of the domain object
     */
    protected abstract Class<T> getDomainClass();

    @Autowired
    protected void setupSessionFactory(SessionFactory sessionFactory) {
        setSessionFactory(sessionFactory);
    }

    public T load(KeyType id) {
        return getHibernateTemplate().load(domainClass, id);
    }

    public void update(T t) {
        getHibernateTemplate().update(t);
    }

    public void save(T t) {
        getHibernateTemplate().save(t);
    }

    public void saveOrUpdate(T t) {
        getHibernateTemplate().saveOrUpdate(t);
    }

    public void delete(T t) {
        getHibernateTemplate().delete(t);
    }

    @SuppressWarnings("unchecked")
    public List<T> getList() {
        return (getHibernateTemplate().find("from " + domainClass.getName() + " x"));
    }

    public void deleteById(KeyType id) {
        Object obj = load(id);
        getHibernateTemplate().delete(obj);
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    public void deleteAll() {
        getHibernateTemplate().execute(new HibernateCallback() {

            public Object doInHibernate(Session session) throws HibernateException {
                String hqlDelete = "delete " + domainClass.getName();
                @SuppressWarnings("unused")
                int deletedEntities = session.createQuery(hqlDelete).executeUpdate();
                return null;
            }
        });
    }

    public T get(KeyType id) {
        return (T) getHibernateTemplate().get(domainClass, id);
    }

    public int count() {
        @SuppressWarnings("unchecked")
        List<T> list = getHibernateTemplate().find(
                "select count(*) from " + domainClass.getName() + " x");
        Integer count = (Integer) list.get(0);
        return count;
    }

    @SuppressWarnings("unchecked")
    public List<T> findByCriteria(DetachedCriteria criteria) {
        return getHibernateTemplate().findByCriteria(criteria);

    }

    @SuppressWarnings("unchecked")
	public T getUniqueResultByCriteria(DetachedCriteria criteria) {
        return (T) criteria.getExecutableCriteria(getSession()).uniqueResult();
    }    
    
    public Query createQuery(String hql) {
    	return getSession().createQuery(hql);
    }
    
}
