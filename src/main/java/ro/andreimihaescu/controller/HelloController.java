package ro.andreimihaescu.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class HelloController {

    private static final Logger LOGGER = Logger.getLogger(HelloController.class);

    @Autowired
    private RestTemplate restTemplate;


    @RequestMapping(value = "/hello/{name}")
    @HystrixCommand(fallbackMethod = "localHello")
    public String sayHelloTo(@PathVariable("name") String name) {
        String serverResponse = restTemplate.getForObject(String.format("http://hello-app/hello/%s", name), String.class);
        return serverResponse;
    }


    public String localHello(String name){
        return String.format("Hello %s, I am your local server!", name);
    }
}
