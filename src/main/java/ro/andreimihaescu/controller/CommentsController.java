package ro.andreimihaescu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ro.andreimihaescu.dto.CommentDTO;
import ro.andreimihaescu.service.CommentsService;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
public class CommentsController {

    @Autowired
    private CommentsService commentsService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Boolean addComment(@RequestBody CommentDTO commentDTO){
        return commentsService.addComment(commentDTO);
    }

    @RequestMapping(value = "/{videoId}", method = RequestMethod.GET)
    public List<CommentDTO> getCommentsForVideoId(@PathVariable("videoId")Long videoId){
        return commentsService.getCommentsForVideoId(videoId);
    }
}
