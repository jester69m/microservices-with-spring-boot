package com.reworked.tag;

import com.reworked.payload.ApiResponse;
import com.reworked.payload.PagedResponse;

public interface TagService {

	PagedResponse<Tag> getAllTags(int page, int size);

	Tag getTag(Long id);

	Tag addTag(Tag tag);

//	Tag updateTag(Long id, Tag newTag, Long currentUser);
//
//	ApiResponse deleteTag(Long id, Long currentUser);

}
