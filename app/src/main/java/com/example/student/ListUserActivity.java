package com.example.student;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ListUserActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_user_in_recycle_view);

        RecyclerView rvUserView = findViewById(R.id.rvUserView);

        UserStorage.getInstance().sortUsers();

        rvUserView.setLayoutManager(new LinearLayoutManager(this));
        UserListAdapter adapter = new UserListAdapter(UserStorage.getInstance().getUsers());
        rvUserView.setAdapter(adapter);
    }
}
