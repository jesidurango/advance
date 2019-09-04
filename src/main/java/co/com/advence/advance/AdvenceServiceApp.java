package co.com.advence.advance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import co.com.advence.advance.v1.service.RoleServiceImpl;
import co.com.advence.advance.v1.service.interfaces.RoleService;

@SpringBootApplication
public class AdvenceServiceApp {
    public static void main( String[] args ) {
    	SpringApplication.run(AdvenceServiceApp.class, args);
    }
    
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
    	return new BCryptPasswordEncoder();
    }
    
    @Bean
    public RoleService roleService() {
    	return new RoleServiceImpl();
    }
}
