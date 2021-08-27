package ajchimaera.userbase;

	import org.slf4j.Logger;
	import org.slf4j.LoggerFactory;
	import org.springframework.boot.CommandLineRunner;
	import org.springframework.context.annotation.Bean;
	import org.springframework.context.annotation.Configuration;

	@Configuration
	class LoadDatabase {

	  private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

	  @Bean
	  CommandLineRunner initDatabase(UserRepository repository) {

	    return args -> {
	      log.info("Preloading " + repository.save(new User("Bilbo", "Baggins", "bilbobaggins@bagend.com")));
	      log.info("Preloading " + repository.save(new User("Frodo", "Baggins", "frodobaggins@bagend.com")));
	      log.info("Preloading " + repository.save(new User("Samwise", "Gamgee", "samgamgee@bagshot.com")));
	      log.info("Preloading " + repository.save(new User("Hamfast", "Gamgee", "gaffer@bagshot.com")));
	      log.info("Preloading " + repository.save(new User("Rosie", "Gamgee", "rosiecotton@greendragon.com")));
	    };
	  }
	}
