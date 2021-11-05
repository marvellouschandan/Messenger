package com.epam.chat.repositories;

import java.util.Optional;

public interface UserSessionRepository {

	Optional<String> getSessionId(String username);

	void setUserSession(String username, String sessionId);

}