package pt.ulisboa.tecnico.socialsoftware.auth.apis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pt.ulisboa.tecnico.socialsoftware.auth.services.AuthUserProvidedService;
import pt.ulisboa.tecnico.socialsoftware.auth.services.FenixEduInterface;
import pt.ulisboa.tecnico.socialsoftware.common.dtos.auth.AuthDto;
import pt.ulisboa.tecnico.socialsoftware.common.exceptions.TutorException;

import static pt.ulisboa.tecnico.socialsoftware.common.exceptions.ErrorMessage.INVALID_LOGIN_CREDENTIALS;

@RestController
public class AuthController {

    @Autowired
    private AuthUserProvidedService authUserProvidedService;

    @Value("${base.url}")
    private String baseUrl;

    @Value("${oauth.consumer.key}")
    private String oauthConsumerKey;

    @Value("${oauth.consumer.secret}")
    private String oauthConsumerSecret;

    @Value("${callback.url}")
    private String callbackUrl;

    @GetMapping("/auth/fenix")
    public AuthDto fenixAuth(@RequestParam String code) {
        FenixEduInterface fenix = new FenixEduInterface(baseUrl, oauthConsumerKey, oauthConsumerSecret, callbackUrl);
        fenix.authenticate(code);
        return this.authUserProvidedService.fenixAuth(fenix);
    }

    @GetMapping("/auth/external")
    public AuthDto externalUserAuth(@RequestParam String email, @RequestParam String password) {
        try {
            return authUserProvidedService.externalUserAuth(email, password);
        } catch (TutorException e) {
            throw new TutorException(INVALID_LOGIN_CREDENTIALS);
        }
    }

    @GetMapping("/auth/demo/student")
    public AuthDto demoStudentAuth(@RequestParam Boolean createNew) {
        return this.authUserProvidedService.demoStudentAuth(createNew);
    }

    @GetMapping("/auth/demo/teacher")
    public AuthDto demoTeacherAuth() {
        return this.authUserProvidedService.demoTeacherAuth();
    }

    @GetMapping("/auth/demo/admin")
    public AuthDto demoAdminAuth() {
        return this.authUserProvidedService.demoAdminAuth();
    }

}