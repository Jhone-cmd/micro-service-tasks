package com.jhonecmd.service_tasks.dto;

import com.jhonecmd.service_tasks.communication.NotificationClient;

public record NotificationDTO(String message, String email)  {}
