package com.company;

import com.company.controllers.EventController;

import com.company.controllers.RegisterEventController;
import com.company.controllers.UserController;
import com.company.data.PostgresDB;
import com.company.data.interfaces.IDB;
import com.company.repositories.EventRepositories;
import com.company.repositories.UsersRepositories;
import com.company.repositories.interfaces.IEventRepositories;


public class Main {
    public static void main(String[] args) {
        IDB db = new PostgresDB();
        IEventRepositories eventRepositories = new EventRepositories(db);
        UsersRepositories usersRepositories = new UsersRepositories(db);
        UserController userController = new UserController(usersRepositories);
        EventController eventController = new EventController(eventRepositories);
        RegisterEventController registerEventController = new RegisterEventController();
        EventApplication app = new EventApplication(userController,eventController,registerEventController);
        app.start();
    }
}
