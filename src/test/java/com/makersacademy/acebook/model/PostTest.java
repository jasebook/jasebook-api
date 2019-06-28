package com.makersacademy.acebook.model;

import com.makersacademy.acebook.repository.PostRepository;
import com.makersacademy.acebook.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.Optional;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PostTest {

	@Autowired
	private PostRepository postRepository;

	@Autowired
	private UserRepository userRepository;

	User user;

	@Before
	public void setUp() {
		user = new User("antgeoff");
		userRepository.save(user);
	}

	@Test
	public void postHasContent() {
		Post post = new Post("hello", (long) 1);
		assertThat(post.getContent(), containsString("hello"));
	}

	@Test
	public void databaseFunctionalityTest() throws InterruptedException {
		long i = user.getUser_id();
		Optional<User> byId = userRepository.findById(i);

		Post alex = new Post("alex", byId.get().getUser_id());
		postRepository.save(alex);

		long i2 = alex.getId();
		Optional<Post> byId2 = postRepository.findById(i);
		if (byId2.isPresent()) {
            assertThat(byId2.get(), equalTo(alex));
        }
	}
}

