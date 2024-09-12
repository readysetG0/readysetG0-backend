package com.readysetgo.traveltracker.group.application.port.out;

public interface CreateGroupPort {

    void createGroup(String destination, String title, String password, String thumbnailUrl);
}
