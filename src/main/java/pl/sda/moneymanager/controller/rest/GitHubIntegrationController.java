package pl.sda.moneymanager.controller.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import pl.sda.moneymanager.dto.GithubRepoDto;
import pl.sda.moneymanager.service.GitHubService;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/github-int")
public class GitHubIntegrationController {


//    private static final String myRepoUrl = "https://api.github.com/users/grzegorzsadlos/repos";

    private final RestTemplate restTemplate;
    private final GitHubService gitHubService;


    public GitHubIntegrationController(final RestTemplate restTemplate, GitHubService gitHubService) {
        this.restTemplate = restTemplate;
        this.gitHubService = gitHubService;
    }

    //    @GetMapping("/my-repos")
    //    public String myRepos(){
    //        //kontroler nie powinien posiadać logiki tylko użyć serwisu
    //            return restTemplate.getForObject(myRepoUrl, String.class);
    //        }
    // zmieniamy na
    @GetMapping("/my-repos")
    public List<GithubRepoDto> myRepos() {
        return gitHubService.allUserRepos();


        // po refaktoryzacji do GitHubService
        //kontroler nie powinien posiadać logiki tylko użyć serwisu

        //            List.class
        //            List<GithubRepoDto>.class  chcielibyśmy zrobić ale nie zadziała
        //            var requestResult = restTemplate.getForObject(myRepoUrl, GithubRepoDto[].class);
        //            return Arrays.asList(requestResult);
    }
}
