package org.example.proxies;

import org.example.model.Comment;
import org.springframework.stereotype.Component;

@Component
public interface CommentNotificationProxy {
    void sendComment(Comment comment);
}
