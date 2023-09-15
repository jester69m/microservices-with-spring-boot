package com.reworked.comment;

import com.reworked.payload.ApiResponse;
import com.reworked.payload.CommentRequest;
import com.reworked.payload.PagedResponse;

public interface CommentService {

	PagedResponse<Comment> getAllComments(Long postId, int page, int size);

	Comment addComment(CommentRequest commentRequest, Long postId, Long currentUser);

	Comment getComment(Long postId, Long id);

//	Comment updateComment(Long postId, Long id, CommentRequest commentRequest, Long currentUser);
//
//	ApiResponse deleteComment(Long postId, Long id, Long currentUser);

}
