package dev.abidino.scheduler.message;

public interface MessageService {
    void sendMessage(String queue, String message);
}
