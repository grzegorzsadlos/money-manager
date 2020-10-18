package pl.sda.moneymanager.controller.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/github-int")
public class GitHubIntegrationController {


    private static final String myRepoUrl = "https://api.github.com/users/grzegorzsadlos/repos";

    private final RestTemplate restTemplate;

    public GitHubIntegrationController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/my-repos")
    public String myRepos(){
        //kontroler nie powinien posiadać logiki tylko użyć serwisu
            return restTemplate.getForObject(myRepoUrl, String.class);
        }

}
