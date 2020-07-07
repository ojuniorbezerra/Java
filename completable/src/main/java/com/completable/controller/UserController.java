package com.completable.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.completable.entity.User;
import com.completable.service.UserService;

@RestController
public class UserController {
	
	
	@Autowired
	private UserService userService;
	Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@PostMapping(value = "/users", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity saveUsers(@RequestParam(value = "files") MultipartFile[] files) throws Exception {
		long start = System.currentTimeMillis();
		for(MultipartFile part : files) {
			userService.saveUser(part);
		}
		long end = System.currentTimeMillis();
		logger.info("Total time {}", (end - start));
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	
	@PostMapping(value = "/usersThreads", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity saveUsersThreads(@RequestParam(value = "files") MultipartFile[] files) throws Exception {
		userService.saveUserThread(files); 
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	@GetMapping(value = "/users", produces = "application/json")
    public CompletableFuture<ResponseEntity> findAllUsers() {
       return userService.findAllUsers().thenApply(ResponseEntity::ok);
    }
	
	@GetMapping(value = "/getUsersByThread", produces = "application/json")
    public CompletableFuture<ResponseEntity> getUsers(){
		
		List<CompletableFuture<List<User>>> completableFutures = new ArrayList(); 
		completableFutures.add(userService.findAllUsers());
		completableFutures.add(userService.findAllUsers());
		completableFutures.add(userService.findAllUsers());
		completableFutures.add(userService.findAllUsers());
		/**

		CompletableFuture.allOf(completableFutures.toArray(new CompletableFuture<?>[0]))
				 .thenAccept(justVoid -> {
					 final List<User> users = completableFutures.stream()
					            .flatMap(completableFuture -> completableFuture.join().stream())
					            .collect(Collectors.toList());
					 System.out.println(users);
				    });
		 * 
		 */		
		return CompletableFuture.allOf(completableFutures.toArray(new CompletableFuture[completableFutures.size()]))
				    .thenApply(v -> completableFutures.stream()
				        .map(CompletableFuture::join)
				        .collect(Collectors.toList())
				    ).thenApply(ResponseEntity::ok);
		
	 }

}
