package ro.andreimihaescu.dto;

public class MovieResponseBuilder {

    private Integer id;
    private String show;
    private String episode;
    private String image;
    private String url;

    public MovieResponseBuilder(){}

    public MovieResponseBuilder withId(Integer id){
        this.id = id;
        return this;
    }

    public MovieResponseBuilder withShow(String show){
        this.show = show;
        return this;
    }

    public MovieResponseBuilder withEpisode(String episode){
        this.episode = episode;
        return this;
    }

    public MovieResponseBuilder withImage(String image){
        this.image = image;
        return this;
    }

    public MovieResponseBuilder withUrl(String url){
        this.url = url;
        return this;
    }

    public MovieResponse build(){
        return new MovieResponse(id, show, episode,image,url);
    }
}
