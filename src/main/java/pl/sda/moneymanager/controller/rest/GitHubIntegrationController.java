package pl.sda.moneymanager.controller.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import pl.sda.moneymanager.dto.GithubRepoDto;
import pl.sda.moneymanager.service.GitHubService;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/github-int")
@Slf4j
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
        log.info("my repos");
        return gitHubService.allUserRepos();// po refaktoryzacji do GitHubService
        //kontroler nie powinien posiadać logiki tylko użyć serwisu
        //            List.class
        //            List<GithubRepoDto>.class  chcielibyśmy zrobić ale nie zadziała
        //            var requestResult = restTemplate.getForObject(myRepoUrl, GithubRepoDto[].class);
        //            return Arrays.asList(requestResult);
    }

    @GetMapping("/repos/{userName}")
    public List<GithubRepoDto> userRepos(@PathVariable("userName") String userName) {
        log.info("user repos, user name = [{}]", userName);
        return gitHubService.allReposOfGivenUser(userName);
    }

    //Create = 201 + header location
    @PostMapping("/repos")
//                           weź json'a z ciała requestu
    public ResponseEntity<GithubRepoDto> createRepo (@RequestBody GithubRepoDto repoToCreate){
        log.info("repo to create: [{}]", repoToCreate);
        return  ResponseEntity.created(URI.create("/repos/1")).build();
    }



}
