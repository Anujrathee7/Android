package com.example.student;

import android.content.Context;
import android.util.Log;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserStorage {
    private static UserStorage instance;
    private List<User> userList;

    private UserStorage() {
        userList = new ArrayList<>();
    }

    public static synchronized UserStorage getInstance() {
        if (instance == null) {
            instance = new UserStorage();
        }
        return instance;
    }

    public void addUser(User user) {
        userList.add(user);
    }

    public void saveData(Context context) {
        try {
            ObjectOutputStream rocketWriter = new ObjectOutputStream(context.openFileOutput("users.data", Context.MODE_PRIVATE));
            rocketWriter.writeObject(userList);
            rocketWriter.close();
        } catch (IOException e) {
            Log.d("RocketApp: Storage", "Saving User failed");
        }
    }


    public void loadData(Context context) {
        try {
            ObjectInputStream rocketReader = new ObjectInputStream(context.openFileInput("users.data"));
            userList = (ArrayList<User>) rocketReader.readObject();
            rocketReader.close();
        } catch (FileNotFoundException e) {
            Log.d("RocketApp: Storage","Reading user was unsuccessful");
            e.printStackTrace();
        } catch (IOException e) {
            Log.d("RocketApp: Storage","Reading user was unsuccessful");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            Log.d("RocketApp: Storage","Reading user was unsuccessful");
            e.printStackTrace();
        }
    }


    public void sortUsers() {
        Collections.sort(userList, (user1, user2) -> user1.getLastName().compareTo(user2.getLastName()));
    }

    public List<User> getUsers() {
        return userList;
    }
}
