package com.completable.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

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
	
	public CompletableFuture<List<User>> saveUser(MultipartFile file) throws Exception{
		long start = System.currentTimeMillis();
		List<User> users = parseCSVFile(file);
		logger.info("saving list of users, {}" , users.size(), ""+Thread.currentThread());
		List<User> usersReturn = userRepository.saveAll(users);
		long end = System.currentTimeMillis();
		logger.info("Total time {}", (end - start));
		return CompletableFuture.completedFuture(usersReturn);
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
