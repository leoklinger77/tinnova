package com.vehicleregistration.vehicleregistration.services;

import java.util.List;

public interface NotificationServices {
    void addNotification(String msg);
    boolean hasNotification();
    List<String> getAllNotification();
}
