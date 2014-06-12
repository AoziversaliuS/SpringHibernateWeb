package web.aop;

import javax.annotation.Resource;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PlayerAspect {
	
	@Resource
	private SessionFactory sf;
	
	@Pointcut("execution(public * web.dao.*.*(..))")
	public void method(){}
	
	@Around("method()")
	public void around(ProceedingJoinPoint pjp) throws Throwable{
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		System.out.println("AspectÖÐµÄ session="+session.hashCode());
		pjp.proceed();
		session.getTransaction().commit();
	}

}
