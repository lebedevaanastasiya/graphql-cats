package ql.graph.cats;

import co.dffrntlab.auth.AuthLibraryConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(AuthLibraryConfiguration.class)
public class CatsApplication {

    public static void main(String[] args) {
        SpringApplication.run(CatsApplication.class, args);
    }

}
