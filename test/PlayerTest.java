import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import web.pojo.Player;
import web.type.Skill;


public class PlayerTest {

	
	private static SessionFactory sf;
	private Session session;
	
	@Test
	public void test() {
		List<Player> players = new ArrayList<Player>();
		for(int i=1;i<=10;i++){
			Player p = (Player) session.get(Player.class, i);
			players.add(p);
		}
		((Player) session.get(Player.class, 40)).setPlayers(players);
		
	}
	@Test
	public void testGet() {
		Player p  = ((Player) session.get(Player.class, 40));
		System.out.println(p.getPlayers());
	}

	
	@BeforeClass
	public static void init(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml","hib-config.xml");
		sf = (SessionFactory) ac.getBean("sessionFactory");
	}
	@AfterClass
	public static void release(){
		sf.close();
	}
	@Before
	public void before(){
		session  = sf.getCurrentSession();
		session.beginTransaction();
	}
	@After
	public void after(){
		session.getTransaction().commit();
	}

}
