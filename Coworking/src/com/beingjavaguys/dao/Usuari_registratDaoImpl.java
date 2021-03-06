package com.beingjavaguys.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.beingjavaguys.domain.Usuari_registrat;


@Repository("usuari_registratDao")
public class Usuari_registratDaoImpl implements Usuari_registratDao {

	@Autowired
	private SessionFactory sessionfactory;

	@Override
	public void saveUsuari_registrat(Usuari_registrat usuari_registrat) {
		Session session = sessionfactory.getCurrentSession();
		session.beginTransaction();
		System.out.println("USUARI:"+usuari_registrat.getemail());
		session.save(usuari_registrat);
		session.getTransaction().commit();
		session.flush();
		session.close();
		
	}

	@Override
	public List<Usuari_registrat> getUsuari_registrat() {
		@SuppressWarnings("unchecked")
		List<Usuari_registrat> userlist = sessionfactory.getCurrentSession()
				.createCriteria(Usuari_registrat.class).list();
		return userlist;
	}

}
