package projectcom.lshy.yg.boostcamp3searchmovie;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;


import projectcom.lshy.yg.boostcamp3searchmovie.data.NaverMovieApiData;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

/**
 * Created by User on 2018-12-16.
 */
public interface NaverMovieService {
    @Headers({
            "X-Naver-Client-Id:yHdkVo6uGlyVJ5wcGYfB",
            "X-Naver-Client-Secret: PwuTJmbKsj"
    })
    @GET("v1/search/movie.json")
    Call<NaverMovieApiData> getMovieList(@Query("query") String query);
}
