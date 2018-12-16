package projectcom.lshy.yg.boostcamp3searchmovie.data;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by User on 2018-12-16.
 */
public class NaverMovieApiData {
    @SerializedName("items") public List<MovieInfo> movieInfos;
}
