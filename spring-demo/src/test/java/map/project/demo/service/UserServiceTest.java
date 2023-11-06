package map.project.demo.service;

import java.util.Collections;

import map.project.demo.data.model.User;
import map.project.demo.data.repository.UserRepository;
import map.project.demo.util.Validators;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {
    @Mock
    UserRepository userRepository;

    @InjectMocks
    UserService userService;

    @Test
    public void saveUser() {
        userService.save("me");

        verify(userRepository).save(any(User.class));
    }

    @Test
    public void saveUserDuplicateName() {
        when(userRepository.findByName(any(String.class))).thenReturn(Collections.singletonList(mock(User.class)));

        assertThatThrownBy((() -> userService.save("me")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("User already exists");

        verify(userRepository, never()).save(any(User.class));
    }

    @Test
    public void saveUserBadName() {
        try (MockedStatic<Validators> mockedStatic = mockStatic(Validators.class)) {
            mockedStatic.when(() -> Validators.validateName(any(String.class))).thenReturn(false);

            assertThatThrownBy((() -> userService.save("me")))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("Invalid name");

            verify(userRepository, never()).save(any(User.class));
        }
    }

}