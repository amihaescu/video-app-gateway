package ro.andreimihaescu.dto;

public class CommentDTO {

    private Integer id;
    private String userName;
    private Integer movieId;
    private String text;

    public CommentDTO() {
    }

    public CommentDTO(Integer id, String userName, Integer movieId, String text) {
        this.id = id;
        this.userName = userName;
        this.movieId = movieId;
        this.text = text;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
