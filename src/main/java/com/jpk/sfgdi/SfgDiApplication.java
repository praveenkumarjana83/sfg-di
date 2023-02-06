package com.jpk.sfgdi;

import com.jpk.sfgdi.config.SFGConfiguration;
import com.jpk.sfgdi.controllers.*;
import com.jpk.sfgdi.datasource.FakeDataSource;
import com.jpk.sfgdi.services.PrototypeBean;
import com.jpk.sfgdi.services.SingletonBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.logging.Level;
import java.util.logging.Logger;

@SpringBootApplication
public class SfgDiApplication {
	private static final Logger logger = Logger.getLogger("SfgDiApplication");

	public static void main(String[] args) {
		ApplicationContext cntxt = SpringApplication.run(SfgDiApplication.class, args);
		MyController controller = (MyController) cntxt.getBean("myController");
		logger.log(Level.INFO, "----- Primary Bean ------");
		String greetings = controller.sayHello();
		logger.log(Level.INFO, greetings);

		logger.log(Level.INFO, "---- Property Injected Controller ----");
		PropertyInjectedController propertyInjectedController = (PropertyInjectedController) cntxt.getBean("propertyInjectedController");
		logger.log(Level.INFO, propertyInjectedController.getGreeting());

		logger.log(Level.INFO, "---- Setter Injected Controller ----");
		SetterInjectedController setterInjectedController = (SetterInjectedController) cntxt.getBean("setterInjectedController");
		logger.log(Level.INFO, setterInjectedController.getGreeting());

		logger.log(Level.INFO, "---- Constructor Injected Controller ----");
		ConstructorInjectedController constructorInjectedController = (ConstructorInjectedController) cntxt.getBean("constructorInjectedController");
		logger.log(Level.INFO, constructorInjectedController.getGreeting());

		logger.log(Level.INFO, "------ Profile Example --------");
		I18nController i18nController = (I18nController) cntxt.getBean("i18nController");
		String greeting = i18nController.sayGreeting();
		logger.log(Level.INFO, greeting);

		logger.log(Level.INFO, "------- Pet Service ---------");
		PetController petController = (PetController) cntxt.getBean("petController");
		String bestPetType = petController.getPetType();
		logger.log(Level.INFO, bestPetType);

		SingletonBean sb = (SingletonBean) cntxt.getBean("singletonBean");
		logger.log(Level.INFO, sb.getMyScope());
		SingletonBean sb1 = cntxt.getBean(SingletonBean.class);
		logger.log(Level.INFO, sb1.getMyScope());

		PrototypeBean pb = (PrototypeBean) cntxt.getBean("prototypeBean");
		logger.log(Level.INFO, pb.getMyScope());
		PrototypeBean pb1 = cntxt.getBean(PrototypeBean.class);
		logger.log(Level.INFO, pb1.getMyScope());

		FakeDataSource fakeDataSource = cntxt.getBean(FakeDataSource.class);
		logger.log(Level.INFO, () -> "Username: " + fakeDataSource.getUsername());
		logger.log(Level.INFO, () -> "Password: " + fakeDataSource.getPassword());
		logger.log(Level.INFO, () -> "JDBC URL: " + fakeDataSource.getJdbcURL());

		System.out.println("-------- Config Props Bean -------");
		SFGConfiguration sfgConfiguration = cntxt.getBean(SFGConfiguration.class);
		logger.log(Level.INFO, () -> sfgConfiguration.getUsername());
		logger.log(Level.INFO, () -> sfgConfiguration.getPassword());
		logger.log(Level.INFO, () -> sfgConfiguration.getJdbcURL());
	}

}
