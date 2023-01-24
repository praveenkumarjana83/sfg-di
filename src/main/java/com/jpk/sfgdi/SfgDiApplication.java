package com.jpk.sfgdi;

import com.jpk.sfgdi.controllers.*;
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

	}

}
