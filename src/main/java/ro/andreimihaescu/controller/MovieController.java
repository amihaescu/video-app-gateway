package ro.andreimihaescu.controller;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.andreimihaescu.dto.MovieResponse;
import ro.andreimihaescu.service.MovieService;
import ro.andreimihaescu.utils.MultipartFileSender;

import javax.servlet.http.HttpServletResponse;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/movies")
public class MovieController {

    private final static Logger LOGGER = Logger.getLogger(MovieController.class);

    @Autowired
    private MovieService movieService;

    @RequestMapping("/list")
    public List<MovieResponse> getMovieListByUserRole() {
        List<MovieResponse> list = movieService.getMovieListByUserRole();
        return  list;
    }

    @RequestMapping("/{video}")
    public void getMovie(@PathVariable("video")Long videoNo, HttpServletRequest request, HttpServletResponse response) throws Exception{
        LOGGER.info(String.format("Serving video %d", videoNo));
        MultipartFileSender.fromPath(Paths.get("/media/andrei/Data2/Downloads/Silicon.Valley.S03E01.HDTV.x264-KILLERS/Silicon.Valley.S03E01.HDTV.x264-KILLERS.mkv"))
                .with(request)
                .with(response)
                .serveResource();
    }
}
