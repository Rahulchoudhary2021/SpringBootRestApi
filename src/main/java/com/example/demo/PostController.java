package com.example.demo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.service.PostService;

@RestController
@RequestMapping("/api")
public class PostController {

    @Autowired
    private PostService postService;
    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/createNewPost")
    public ResponseEntity<Object> createPost(@RequestBody Post post) {
        try {
            Post savedPost = postService.savePost(post);
            String timeApiUrl = "http://worldtimeapi.org/api/timezone/Asia/Kolkata";
            ResponseEntity<String> response = restTemplate.getForEntity(timeApiUrl, String.class);
            
            Map<String, Object> result = new HashMap<>();
            result.put("db_post", savedPost);
            result.put("http_outbound", response.getBody());
            
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
