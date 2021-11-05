package com.epam.chat.controller;

import java.security.Principal;

import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.annotation.SendToUser;

import com.epam.chat.models.ChatMessage;
import com.epam.constants.APIRoutes;

public interface ChatOperations {

	void register(ChatMessage chatMessage, SimpMessageHeaderAccessor headerAccessor, Principal principal);

	void sendMessage(ChatMessage chatMessage);

	ChatMessage sendPrivateMessage(ChatMessage chatMessage);

}