package projectcom.lshy.yg.boostcamp3searchmovie.data;

import com.google.gson.annotations.SerializedName;

/**
 * Created by User on 2018-12-16.
 */
public class MovieInfo {
    private String image;
    @SerializedName("title") String title;
    @SerializedName("link")  String link;
    @SerializedName("actor") String actor;
    @SerializedName("director") String director;
    @SerializedName("pubDate")  String pubDate;
     String userRating;

    public MovieInfo(String title, String userRating, String pubDate, String director, String actor ){
        this.title = title;
        this.userRating =userRating;
        this.pubDate = pubDate;
        this.director = director;
        this.actor = actor;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public float getUserRating() {
        return  Float.parseFloat(userRating);
    }

    public void setUserRating(String userRating) {
        this.userRating = userRating;
    }
}
