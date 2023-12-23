package backendjava.amadeuscasestudy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class AmadeuscasestudyApplication {

    public static void main(String[] args) {
        SpringApplication.run(AmadeuscasestudyApplication.class, args);
    }

}
