package com.example.student;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class UserViewHolder extends RecyclerView.ViewHolder {
    TextView textFirstName, textLastName, textEmail, textDegreeProgram, textDegree;

    public UserViewHolder(@NonNull View itemView) {
        super(itemView);
        textFirstName = itemView.findViewById(R.id.textFirstName);
        textLastName = itemView.findViewById(R.id.textLastName);
        textEmail = itemView.findViewById(R.id.textEmail);
        textDegreeProgram = itemView.findViewById(R.id.textDegreeProgram);
        textDegree = itemView.findViewById(R.id.textUserDegrees);
    }

    public void bind(User user) {
        textFirstName.setText(user.getFirstName());
        textLastName.setText(user.getLastName());
        textEmail.setText(user.getEmail());
        textDegreeProgram.setText(user.getDegreeProgram());
        textDegree.setText(formatDegreeList(user.getDegreeList()));
    }

    private String formatDegreeList(List<String> degrees) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < degrees.size(); i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(degrees.get(i));
        }
        return sb.toString();
    }
}
