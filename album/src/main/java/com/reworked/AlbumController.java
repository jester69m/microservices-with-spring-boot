package com.reworked;

import com.reworked.exception.ResponseEntityErrorException;
import com.reworked.payload.AlbumResponse;
import com.reworked.payload.ApiResponse;
import com.reworked.payload.PagedResponse;
import com.reworked.payload.PhotoResponse;
import com.reworked.payload.request.AlbumRequest;
import com.reworked.photo.PhotoService;
import com.reworked.utils.AppConstants;
import com.reworked.utils.AppUtils;
import com.reworked.utils.CurrentUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/albums")
public class AlbumController {
	@Autowired
	private AlbumService albumService;

	@Autowired
	private PhotoService photoService;

	@ExceptionHandler(ResponseEntityErrorException.class)
	public ResponseEntity<ApiResponse> handleExceptions(ResponseEntityErrorException exception) {
		return exception.getApiResponse();
	}

	@GetMapping
	public PagedResponse<AlbumResponse> getAllAlbums(
			@RequestParam(name = "page", required = false, defaultValue = AppConstants.DEFAULT_PAGE_NUMBER) Integer page,
			@RequestParam(name = "size", required = false, defaultValue = AppConstants.DEFAULT_PAGE_SIZE) Integer size) {
		AppUtils.validatePageNumberAndSize(page, size);

		return albumService.getAllAlbums(page, size);
	}

	@PostMapping
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<Album> addAlbum(@Valid @RequestBody AlbumRequest albumRequest, @CurrentUser UserPrincipal currentUser) {
		return albumService.addAlbum(albumRequest, currentUser);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Album> getAlbum(@PathVariable(name = "id") Long id) {
		return albumService.getAlbum(id);
	}

	@PutMapping("/{id}")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public ResponseEntity<AlbumResponse> updateAlbum(@PathVariable(name = "id") Long id, @Valid @RequestBody AlbumRequest newAlbum,
			@CurrentUser UserPrincipal currentUser) {
		return albumService.updateAlbum(id, newAlbum, currentUser);
	}

	@DeleteMapping("/{id}")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public ResponseEntity<ApiResponse> deleteAlbum(@PathVariable(name = "id") Long id, @CurrentUser UserPrincipal currentUser) {
		return albumService.deleteAlbum(id, currentUser);
	}

	@GetMapping("/{id}/photos")
	public ResponseEntity<PagedResponse<PhotoResponse>> getAllPhotosByAlbum(@PathVariable(name = "id") Long id,
																			@RequestParam(name = "page", required = false, defaultValue = AppConstants.DEFAULT_PAGE_NUMBER) Integer page,
																			@RequestParam(name = "size", required = false, defaultValue = AppConstants.DEFAULT_PAGE_SIZE) Integer size) {

		PagedResponse<PhotoResponse> response = photoService.getAllPhotosByAlbum(id, page, size);

		return new ResponseEntity<>(response, HttpStatus.OK);
	}

}
