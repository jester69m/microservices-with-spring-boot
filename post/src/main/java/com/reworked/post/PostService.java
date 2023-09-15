package com.reworked.post;

import com.reworked.payload.ApiResponse;
import com.reworked.payload.PagedResponse;
import com.reworked.payload.PostRequest;
import com.reworked.payload.PostResponse;

public interface PostService {

	PagedResponse<Post> getAllPosts(int page, int size);

//	PagedResponse<Post> getPostsByCreatedBy(String username, int page, int size);

	PagedResponse<Post> getPostsByCategory(Long id, int page, int size);

	PagedResponse<Post> getPostsByTag(Long id, int page, int size);

//	Post updatePost(Long id, PostRequest newPostRequest, Long currentUser);
//	ApiResponse deletePost(Long id, Long currentUser);
//	PostResponse addPost(PostRequest postRequest, Long currentUser);

	Post getPost(Long id);

}
