package projectcom.lshy.yg.boostcamp3searchmovie;

import android.databinding.BindingAdapter;
import android.databinding.ObservableArrayList;
import android.support.v7.widget.RecyclerView;

import projectcom.lshy.yg.boostcamp3searchmovie.data.MovieInfo;

/**
 * Created by User on 2018-12-16.
 */
public class AdapterBinding {
    @BindingAdapter("item")
    public static void bindItem(RecyclerView recyclerView, ObservableArrayList<MovieInfo> movie) {
        MovieListAdapter adapter = (MovieListAdapter) recyclerView.getAdapter();
        if (adapter != null) {
            adapter.setItem(movie);

        }
    }
}
