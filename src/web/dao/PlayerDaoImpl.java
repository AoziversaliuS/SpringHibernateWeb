package web.dao;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import web.pojo.Player;

@Component
public class PlayerDaoImpl {
	
	@Resource
	private SessionFactory sf;
	
	public void add(Player p){
		Session session = sf.getCurrentSession();
		System.out.println("PlayerDaoImplÖÐµÄ session="+session.hashCode());
		session.save(p);
	}
	
	public Player getPlayer(int id){
		Session session = sf.getCurrentSession();
//		session.save(null);
		return (Player)session.get(Player.class, id);
	}

}
