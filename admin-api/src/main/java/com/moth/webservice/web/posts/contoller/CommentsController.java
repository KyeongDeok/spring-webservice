package com.moth.webservice.web.posts.contoller;

import com.moth.webservice.web.posts.dto.CommentsRequestDTO;
import com.moth.webservice.web.posts.dto.PostsSaveRequestDTO;
import com.moth.webservice.web.posts.service.CommentsSevice;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class CommentsController {

    private final CommentsSevice commentsSevice;

    @GetMapping("/api/posts/{postId}/comments/{commentsId}")
    public String getComment(@PathVariable Long postId, @PathVariable Long commentsId,
                                @RequestBody PostsSaveRequestDTO postsSaveRequestDto,
                                @RequestBody CommentsRequestDTO commentsRequestDTO){

        return "/";
    }

    @GetMapping("api/posts/{postId}/comments")
    public String getComments(@PathVariable Long postId, @RequestBody CommentsRequestDTO commentsRequestDTO){
        return "/";
    }

    @PostMapping("api/posts/{postId}/comments")
    public String createComment(@PathVariable Long postId, @RequestBody CommentsRequestDTO commentsRequestDTO){
        return "/";
    }
}
