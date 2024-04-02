package com.example.student;

// UserListAdapter.java
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.UserViewHolder> {
    private List<User> userList;

    public UserListAdapter(List<User> userList) {
        this.userList = userList;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_list_item, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        User user = userList.get(position);
        holder.bind(user);
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    static class UserViewHolder extends RecyclerView.ViewHolder {
        TextView textFirstName, textLastName, textEmail, textDegreeProgram, textDegree;

        UserViewHolder(@NonNull View itemView) {
            super(itemView);
            textFirstName = itemView.findViewById(R.id.textFirstName);
            textLastName = itemView.findViewById(R.id.textLastName);
            textEmail = itemView.findViewById(R.id.textEmail);
            textDegreeProgram = itemView.findViewById(R.id.textDegreeProgram);
            textDegree = itemView.findViewById(R.id.textUserDegrees);
        }

        void bind(User user) {
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
}
