package ro.andreimihaescu.dto;


public class MovieResponse {

    private Long id;
    private String show;
    private String episode;
    private String image;
    private String url;

    public MovieResponse(Long id, String show, String episode, String image, String url) {
        this.id = id;
        this.show = show;
        this.episode = episode;
        this.image = image;
        this.url = url;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getShow() {
        return show;
    }

    public void setShow(String show) {
        this.show = show;
    }

    public String getEpisode() {
        return episode;
    }

    public void setEpisode(String episode) {
        this.episode = episode;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
