package pt.ulisboa.tecnico.socialsoftware.apigateway.apis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pt.ulisboa.tecnico.socialsoftware.auth.domain.AuthUser;
import pt.ulisboa.tecnico.socialsoftware.tutor.statistics.StatsDto;
import pt.ulisboa.tecnico.socialsoftware.tutor.statistics.StatsService;

import java.security.Principal;

@RestController
public class StatsController {

    @Autowired
    private StatsService statsService;

    @GetMapping("/executions/{executionId}/stats")
    @PreAuthorize("hasRole('ROLE_STUDENT') and hasPermission(#executionId, 'EXECUTION.ACCESS')")
    public StatsDto getStats(Principal principal, @PathVariable int executionId) {
        AuthUser authUser = (AuthUser) ((Authentication) principal).getPrincipal();

        return statsService.getStats(authUser.getUserSecurityInfo().getId(), executionId);
    }
}