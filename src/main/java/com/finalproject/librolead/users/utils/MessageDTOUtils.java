package com.finalproject.librolead.users.utils;

import com.finalproject.librolead.users.dto.MessageDTO;
import com.finalproject.librolead.users.entity.User;

public class MessageDTOUtils {

    public static MessageDTO creationMessage(User createdUser) {
        return returnMessage(createdUser, "created");
    }

    public static MessageDTO updatedMessage(User updatedUser) {
        return returnMessage(updatedUser, "updated");
    }

    private static MessageDTO returnMessage(User updatedUser, String action) {
        String createdUsername = updatedUser.getUsername();
        Long createdId = updatedUser.getId();
        String createdUserMessage = String.format("User %s with ID %s successfully %s", createdUsername, createdId, action);
        return MessageDTO.builder()
                .message(createdUserMessage)
                .build();
    }
}
