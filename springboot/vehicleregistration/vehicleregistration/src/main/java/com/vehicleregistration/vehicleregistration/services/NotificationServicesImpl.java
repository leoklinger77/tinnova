package com.vehicleregistration.vehicleregistration.services;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class NotificationServicesImpl implements NotificationServices {
    private List<String> notification = new ArrayList<String>();
    @Override
    public void addNotification(String msg) {
        notification.add(msg);
    }

    @Override
    public boolean hasNotification() {
        return notification.size() > 0;
    }

    @Override
    public List<String> getAllNotification() {
        return notification;
    }
}
