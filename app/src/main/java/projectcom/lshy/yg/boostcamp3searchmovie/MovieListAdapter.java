package projectcom.lshy.yg.boostcamp3searchmovie;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import projectcom.lshy.yg.boostcamp3searchmovie.data.MovieInfo;
import projectcom.lshy.yg.boostcamp3searchmovie.databinding.MovieListViewItemBinding;

/**
 * Created by User on 2018-12-16.
 */
public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.MovieViewHolder> {

    private List<MovieInfo> movieList;

    MovieListAdapter(){
        this.movieList = new ArrayList<>();
    }

    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MovieListViewItemBinding mbinding = MovieListViewItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);

        return new MovieViewHolder(mbinding);
    }

    @Override
    public void onBindViewHolder(MovieViewHolder holder, int position) {
        MovieInfo movieInfo = movieList.get(position);
        holder.bind(movieInfo);
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }
    public void setItem(List<MovieInfo> movie){
        if(movie == null){
            return;
        }
        this.movieList = movie;
        notifyDataSetChanged();

    }
    class MovieViewHolder extends RecyclerView.ViewHolder{
        MovieListViewItemBinding mbinding;

        public MovieViewHolder(MovieListViewItemBinding mbinding) {
            super(mbinding.getRoot());
            this.mbinding = mbinding;
        }


        void bind(MovieInfo movieInfo){
            mbinding.setVariable(projectcom.lshy.yg.boostcamp3searchmovie.BR.movieInfo, movieInfo);
            mbinding.title.setText(Html.fromHtml(movieInfo.getTitle(), Html.FROM_HTML_MODE_LEGACY));
            mbinding.rating.setRating(movieInfo.getUserRating()/2);

            Glide.with(mbinding.getRoot().getContext()).load(movieInfo.getImage()).into(mbinding.thumnail);

            mbinding.itemcontiner.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mbinding.getRoot().getContext().startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse( movieInfo.getLink())));

                }
            });
        }


    }

}
