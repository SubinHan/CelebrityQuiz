package com.example.celebrityquiz;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;

import java.util.List;

public class GameDataAdapter extends RecyclerView.Adapter {

    private GameDataManager gameDataManager;
    private String userEmail;
    private Context context;
    private int expandedPosition;
    private int previousExpandedPosition;


    public GameDataAdapter(Context context) {
        this.context = context;
        this.gameDataManager = GameDataManager.getInstance();
        this.userEmail = FirebaseAuth.getInstance().getCurrentUser().getEmail();
        this.expandedPosition = -1;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layoutInflater = LayoutInflater.from(context).inflate(R.layout.review_item, parent, false);

        return new RecyclerView.ViewHolder(layoutInflater) {
        };
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        TextView date = holder.itemView.findViewById(R.id.dateText);
        TextView domain = holder.itemView.findViewById(R.id.domainText);
        TextView score = holder.itemView.findViewById(R.id.scoreText);
        Button button = holder.itemView.findViewById(R.id.reviewButton);
        final RecyclerView recyclerView = holder.itemView.findViewById(R.id.expandableRecyclerView);

        List<GameData> gameDataList = gameDataManager.getGameDataListOrderById(userEmail);
        GameData gameData = gameDataList.get(position);
        if (gameData.getDate() != null)
            date.setText(gameData.getDate());
        if (gameData.getDomain() != null)
            domain.setText(gameData.getDomain());
        score.setText(String.valueOf(gameData.getScore()));

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.d("subin", "onCLick");
                Intent intent = new Intent(context, QuizActivity.class);
                intent.putExtra("isReview", true);
                intent.putExtra("position", position);
                context.startActivity(intent);
            }
        });

        // Wrong quizzes


        ImageView icon = holder.itemView.findViewById(R.id.isExpandedIcon);
        SolutionAdapter solutionAdapter = new SolutionAdapter(gameData.getWrongQuizzes(), context);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(solutionAdapter);

        final boolean isExpanded = position == expandedPosition;
        View view = holder.itemView.findViewById(R.id.itemBody);

        if (isExpanded) {
            recyclerView.setVisibility(View.VISIBLE);
            icon.setImageResource(R.drawable.arrow_expanded);
        } else {
            recyclerView.setVisibility(View.GONE);
            icon.setImageResource(R.drawable.arrow_collapsed);
        }

        if (isExpanded)
            previousExpandedPosition = position;

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expandedPosition = isExpanded ? -1 : position;
                notifyItemChanged(previousExpandedPosition);
                notifyItemChanged(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.gameDataManager.getGameDataListOrderById(userEmail).size();
    }
}
