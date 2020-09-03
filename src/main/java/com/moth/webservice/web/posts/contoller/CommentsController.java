package com.moth.webservice.web.posts.contoller;

import com.moth.webservice.web.posts.dto.CommentsRequestDTO;
import com.moth.webservice.web.posts.dto.PostsSaveRequestDTO;
import com.moth.webservice.web.posts.service.CommentsSevice;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CommentsController {

    private CommentsSevice commentsSevice;

    @PostMapping("/api/posts/{postId}/comments/{commentsId}")
    public String updateComment(@PathVariable Long postId, @PathVariable Long commentsId,
                                @RequestBody PostsSaveRequestDTO postsSaveRequestDto,
                                @RequestBody CommentsRequestDTO commentsRequestDTO){
        
        return "/";
    }
}
