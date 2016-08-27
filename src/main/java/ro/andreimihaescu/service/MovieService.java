package ro.andreimihaescu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ro.andreimihaescu.dto.MovieResponse;
import ro.andreimihaescu.dto.MovieResponseBuilder;

import java.util.*;

@Service
public class MovieService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    public List<MovieResponse> getMovieListByUserRole() {
        List<HashMap> listOfMaps = restTemplate.getForObject("http://video-service/api/movies/list", List.class);
        ServiceInstance serviceInstance = discoveryClient.getInstances("video-service").stream().findAny().orElse(null);
        String host = serviceInstance.getHost();
        Integer port = serviceInstance.getPort();
        List<MovieResponse> returnList = new ArrayList<>();
        for (HashMap map : listOfMaps){
            returnList.add(new MovieResponseBuilder()
                    .withId((Integer)map.get("id"))
                    .withEpisode((String)map.get("episode"))
                    .withImage((String)map.get("image"))
                    .withShow((String)map.get("show"))
                    .withUrl(String.format("http://%s:%s%s",host, port,(String)map.get("url")))
                    .build()
            );
        }
        System.out.println("Return list size "+returnList.size());
        return returnList;
    }
}
