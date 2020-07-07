package com.completable.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.completable.entity.User;
import com.completable.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	Logger logger = LoggerFactory.getLogger(UserService.class);
	
	public void saveUserThread( MultipartFile[] files) throws Exception{
		long start = System.currentTimeMillis();
		for(MultipartFile file : files){
			CompletableFuture.runAsync(() -> saveUser(file));
		}
		long end = System.currentTimeMillis();
		logger.info("Total time {}", (end - start));
	}
	
	
	public List<User> saveUser(MultipartFile file){
		try {
			List<User> users = parseCSVFile(file);
			List<User> usersReturn = userRepository.saveAll(users);
			return usersReturn;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public CompletableFuture<List<User>> findAllUsers() {
		List<User> users = userRepository.findAll();
		return CompletableFuture.completedFuture(users);
	}
	
   private List<User> parseCSVFile(final MultipartFile file) throws Exception {
        final List<User> users = new ArrayList();
        try {
            try (final BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
                String line;
                while ((line = br.readLine()) != null) {
                    final String[] data = line.split(",");
                    final User user = new User();
                    user.setName(data[0]);
                    user.setEmail(data[1]);
                    user.setGender(data[2]);
                    users.add(user);
                }
                return users;
            }
        } catch (final IOException e) {
            logger.error("Failed to parse CSV file {}", e);
            throw new Exception("Failed to parse CSV file {}", e);
        }
    }
}
