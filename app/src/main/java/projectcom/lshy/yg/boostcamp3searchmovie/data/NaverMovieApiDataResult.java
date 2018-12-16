package projectcom.lshy.yg.boostcamp3searchmovie.data;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by User on 2018-12-16.
 */
public class NaverMovieApiDataResult {
    public NaverMovieApiData naverMovieApiData;
    public List<MovieInfo> getMovieList(){
        return naverMovieApiData.movieInfos;
    }
}
