package com.reworked.photo;

import com.reworked.payload.ApiResponse;
import com.reworked.payload.PagedResponse;
import com.reworked.payload.PhotoRequest;
import com.reworked.payload.PhotoResponse;

public interface PhotoService {

	PagedResponse<PhotoResponse> getAllPhotos(int page, int size);

	PhotoResponse getPhoto(Long id);

//	PhotoResponse updatePhoto(Long id, PhotoRequest photoRequest, UserPrincipal currentUser);
//
//	PhotoResponse addPhoto(PhotoRequest photoRequest, UserPrincipal currentUser);
//
//	ApiResponse deletePhoto(Long id, UserPrincipal currentUser);

	PagedResponse<PhotoResponse> getAllPhotosByAlbum(Long albumId, int page, int size);

}