package com.reworked.album;

import com.reworked.payload.AlbumResponse;
import com.reworked.payload.ApiResponse;
import com.reworked.payload.PagedResponse;
import com.reworked.payload.request.AlbumRequest;
import org.springframework.http.ResponseEntity;

public interface AlbumService {

	PagedResponse<AlbumResponse> getAllAlbums(int page, int size);

	ResponseEntity<Album> addAlbum(AlbumRequest albumRequest, Long userId);

	ResponseEntity<Album> getAlbum(Long id);

//	ResponseEntity<AlbumResponse> updateAlbum(Long id, AlbumRequest newAlbum, Long userId);
//
//	ResponseEntity<ApiResponse> deleteAlbum(Long id, Long userId);
//
//	PagedResponse<Album> getUserAlbums(String username, int page, int size);

}
