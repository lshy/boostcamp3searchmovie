package projectcom.lshy.yg.boostcamp3searchmovie;

import android.databinding.DataBindingUtil;
import android.databinding.ObservableArrayList;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;



import projectcom.lshy.yg.boostcamp3searchmovie.data.MovieInfo;
import projectcom.lshy.yg.boostcamp3searchmovie.data.NaverMovieApiData;
import projectcom.lshy.yg.boostcamp3searchmovie.databinding.ActivityMainBinding;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity {

    private MovieListAdapter movieListAdapter;
    private ObservableArrayList<MovieInfo> movieList;

    private ActivityMainBinding activityMainBinding;


    public void onSearchBtnClick(View v){
        AsyncTask.execute(new Runnable(){
            public void run() {
                Retrofit retrofit = new Retrofit.Builder().baseUrl("https://openapi.naver.com/").addConverterFactory(GsonConverterFactory.create()).build();

                NaverMovieService naverMovieService = retrofit.create(NaverMovieService.class);
                try {
                    String query = activityMainBinding.movieSearchText.getText().toString();
                    naverMovieService.getMovieList(query).enqueue(new Callback<NaverMovieApiData>() {

                        @Override
                        public void onResponse(Call<NaverMovieApiData> call, Response<NaverMovieApiData> response) {
                            NaverMovieApiData naverMovieApiData = response.body();
                            movieList.clear();
                            int size = naverMovieApiData.movieInfos.size();
                            if(size == 0){
                                Toast.makeText(getApplicationContext(), "\'"+query+"\' 검색 결과는 없습니다.", Toast.LENGTH_LONG).show();
                            }else{
                                movieList.addAll(naverMovieApiData.movieInfos);
                            }

                        }
                        @Override
                        public void onFailure(Call<NaverMovieApiData> call, Throwable t) {
                            Toast.makeText(getApplicationContext(), "오류 발생", Toast.LENGTH_SHORT).show();

                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });


    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        movieListAdapter = new MovieListAdapter();
        movieList = new ObservableArrayList<>();

        activityMainBinding.movieListView.setHasFixedSize(true);
        activityMainBinding.movieListView.setAdapter(movieListAdapter);
        activityMainBinding.setMovieList(movieList);

    }


}
