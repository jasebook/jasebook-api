package com.makersacademy.acebook.model;

import com.makersacademy.acebook.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void test() {
        User user = new User("annatan");
        userRepository.save(user);

        long i = user.getUser_id();
        Optional<User> byId = userRepository.findById(i);
        if (byId.isPresent()) {
            assertThat(byId.get(), equalTo(user));
        }
    }
}
