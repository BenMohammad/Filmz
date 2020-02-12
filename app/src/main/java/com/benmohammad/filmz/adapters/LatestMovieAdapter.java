package com.benmohammad.filmz.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.benmohammad.filmz.R;
import com.benmohammad.filmz.networking.LatestMovie;

import java.util.List;

public class LatestMovieAdapter extends RecyclerView.Adapter<LatestMovieAdapter.ViewHolder> {

    private List<LatestMovie> mLatestMovieList;
    private final Listener mListener;

    public void bindMovie(List<LatestMovie> movies) {
        mLatestMovieList = movies;
        notifyDataSetChanged();
    }

    public interface Listener {
        void onMovieItemClicked(LatestMovie movie);
    }

    public LatestMovieAdapter(Listener listener) {
        this.mListener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.view_latest_movie_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        LatestMovie movie = mLatestMovieList.get(position);
        holder.mTitle.setText(movie.getTitle());
        holder.mRating.setText(movie.getVoteAverage());
    }


    @Override
    public int getItemCount() {
        if(mLatestMovieList == null) {
            return 0;
        } else {
            return mLatestMovieList.size();
        }
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView mTitle;
        private TextView mRating;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mTitle = itemView.findViewById(R.id.latest_movie_id);
            mRating = itemView.findViewById(R.id.latest_movie_vote_id);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mListener.onMovieItemClicked(mLatestMovieList.get(getAdapterPosition()));
                }
            });

        }
    }
}
