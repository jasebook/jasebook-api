package com.makersacademy.acebook.model;

import com.makersacademy.acebook.repository.PostRepository;
import com.makersacademy.acebook.repository.UserRepository;
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

//	@Test
//	public void postHasContent() {
//		Post post = new Post("hello", (long) 1);
//		assertThat(post.getContent(), containsString("hello"));
//	}

	@Test
	public void test() {
		Post alex = new Post("alex", (long) 1);
		User user = new User((long) 1, "annatan");

		// when
		userRepository.save(user);
		postRepository.save(alex);

		// then
		long i = alex.getId();
		Optional<Post> byId = postRepository.findById(i);
		if (byId.isPresent()) {
            assertThat(byId.get(), equalTo(alex));
        }
	}
}

