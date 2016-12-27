package com.example.sergey.checkpoint;

public class CurentUser {
    private static CurentUser userDAO;

    public static CurentUser getUserDAO() {
        if (userDAO == null) {
            userDAO = new CurentUser();
        }
        return userDAO;
    }

    private User user;

    public void save(User u) {
        user = u;
    }

    public boolean isLogin(User u) {
        if (user != null && user.equals(u)) {
            return true;
        }
        return false;

    }
}
