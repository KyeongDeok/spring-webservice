package com.moth.webservice.web.posts.contoller;

import com.moth.webservice.web.posts.service.CommentsSevice;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CommentsController {

    private CommentsSevice commentsSevice;
    
}
