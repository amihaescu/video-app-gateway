package ro.andreimihaescu.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.encrypt.TextEncryptor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ro.andreimihaescu.dto.CommentDTO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

@Service
public class CommentsService {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "defaultAddComment")
    public Boolean addComment(CommentDTO commentDTO) {
        return restTemplate.postForEntity("http://comments-service/api/comments/add", commentDTO, Boolean.class).getBody();
    }

    @HystrixCommand(fallbackMethod = "defaultComments")
    public List<CommentDTO> getCommentsForVideoId(Long videoId) {
        List<HashMap> list = restTemplate.getForObject("http://comments-service/api/comments/" + videoId, List.class);
        List<CommentDTO> returnList = new ArrayList<>();
        for (HashMap hashMap : list) {
            returnList.add(new CommentDTO(
                    (Integer) hashMap.get("id"),
                    (String) hashMap.get("userName"),
                    (Integer) hashMap.get("movieId"),
                    (String) hashMap.get("text")
            ));
        }
        return returnList;
    }

    public Boolean defaultAddComment(CommentDTO commentDTO){
        return true;
    }

    public List<CommentDTO> defaultComments(Long videoId){
        return Collections.singletonList(new CommentDTO(1, "System", 0, "Failed to retrieve comments. Adding comments is also unavailable."));
    }
}
