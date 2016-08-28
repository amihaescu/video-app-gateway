package ro.andreimihaescu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.encrypt.TextEncryptor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ro.andreimihaescu.dto.CommentDTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class CommentsService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private TextEncryptor textEncryptor;

    public Boolean addComment(CommentDTO commentDTO) {
        return restTemplate.postForEntity("http://comments-service/api/comments/add", commentDTO, Boolean.class).getBody();
    }

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
}
