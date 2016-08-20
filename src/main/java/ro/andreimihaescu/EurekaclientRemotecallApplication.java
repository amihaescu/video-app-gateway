package ro.andreimihaescu;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.crypto.encrypt.TextEncryptor;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker
public class EurekaclientRemotecallApplication {

    private static final Logger LOGGER = Logger.getLogger(EurekaclientRemotecallApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(EurekaclientRemotecallApplication.class, args);
    }

    @Bean
    TextEncryptor getTextEncryptor() {
        String password = getRandomHexString(128);
        String salt = getRandomHexString(128);
        LOGGER.info("Creating text encryptor");
        return Encryptors.queryableText(password, salt);
    }

    @LoadBalanced
    @Bean
    RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    private String getRandomHexString(int numchars){
        Random r = new Random();
        StringBuffer sb = new StringBuffer();
        while(sb.length() < numchars){
            sb.append(Integer.toHexString(r.nextInt()));
        }

        return sb.toString().substring(0, numchars);
    }


}
