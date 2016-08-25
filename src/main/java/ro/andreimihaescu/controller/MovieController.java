package ro.andreimihaescu.controller;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.andreimihaescu.dto.MovieResponse;
import ro.andreimihaescu.utils.MultipartFileSender;

import javax.servlet.http.HttpServletResponse;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/movies")
public class MovieController {

    private final static Logger LOGGER = Logger.getLogger(MovieController.class);

    @RequestMapping("/list")
    public List<MovieResponse> getMovieListByUserRole() {

        return Arrays.asList(
                new MovieResponse(1L, "Silicon Valley", "S03E01", "","http://localhost:8081/api/movies/1"),
                new MovieResponse(2L, "Silicon Valley", "03E02", "", "http://localhost:8081/api/movies/2"),
                new MovieResponse(3L, "Silicon Valley", "S03E03", "", "http://localhost:8081/api/movies/3")
        );
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
