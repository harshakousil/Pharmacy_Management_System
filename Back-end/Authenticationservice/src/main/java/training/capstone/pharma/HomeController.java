package training.capstone.pharma;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

/**
 * The controller class for handling home-related endpoints.
 */
@RestController
@RequestMapping("/")
@CrossOrigin(origins = "http://localhost:3000")
public class HomeController {

    @Autowired
    private UserService userService;

    /**
     * Validates user login credentials.
     *
     * @param user The user object containing login information.
     * @return The user details if login is successful.
     * @throws ResponseStatusException If the user doesn't exist or login fails.
     */
    @PostMapping("/login")
    public UserEO validateLogin(@RequestBody UserEO user) {
        String email = user.getEmail();
        UserEO userDetails = userService.findByEmail(email);
        if (userDetails != null) {
            return userDetails;
        } else {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, "User Doesn't exist");
        }
    }
}
