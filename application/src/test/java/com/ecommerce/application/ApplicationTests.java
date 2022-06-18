package com.ecommerce.application;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.ecommerce.application.model.User;
import com.ecommerce.application.repository.UserRepository;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
@Rollback(false)
class ApplicationTests {

	@Autowired
	UserRepository repo;
	

    @Autowired
    private TestEntityManager entityManager;
	@Test
	void contextLoads() {
	}

	@Test
	public void testCreateUser() {
	    User user = new User();
	    user.setEmail("ravikumar@gmail.com");
	    user.setPassword("ravi2020");
	    user.setFirstName("Ravi");
	    user.setLastName("Kumar");
	     
	    User savedUser = repo.save(user);
	     
	    User existUser = entityManager.find(User.class, savedUser.getId());
	     
	    assertThat(user.getEmail()).isEqualTo(existUser.getEmail());
	     
	}
	@Test
	public void findUser() {
		
		String email="kandulakalyan1436@gmail.com";
		User user=repo.findByEmail(email);
		System.out.println(user.getUserName());
			
	}
}
