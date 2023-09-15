package com.reworked.category;

import com.reworked.exception.UnauthorizedException;
import com.reworked.payload.ApiResponse;
import com.reworked.payload.PagedResponse;
import org.springframework.http.ResponseEntity;

public interface CategoryService {

	PagedResponse<Category> getAllCategories(int page, int size);

	ResponseEntity<Category> getCategory(Long id);

	ResponseEntity<Category> addCategory(Category category, Long userId);

//	ResponseEntity<Category> updateCategory(Long id, Category newCategory, Long userId)
//			throws UnauthorizedException;
//
//	ResponseEntity<ApiResponse> deleteCategory(Long id, Long userId) throws UnauthorizedException;

}
