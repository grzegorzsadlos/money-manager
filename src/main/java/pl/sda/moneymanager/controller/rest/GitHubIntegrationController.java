package pl.sda.moneymanager.controller.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import pl.sda.moneymanager.dto.GithubRepoDto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/github-int")
public class GitHubIntegrationController {


    private static final String myRepoUrl = "https://api.github.com/users/grzegorzsadlos/repos";

    private final RestTemplate restTemplate;

    public GitHubIntegrationController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

                    //    @GetMapping("/my-repos")
                    //    public String myRepos(){
                    //        //kontroler nie powinien posiadać logiki tylko użyć serwisu
                    //            return restTemplate.getForObject(myRepoUrl, String.class);
                    //        }
                    // zmieniamy na

        @GetMapping("/my-repos")
    public List<GithubRepoDto> myRepos(){
        //kontroler nie powinien posiadać logiki tylko użyć serwisu

//            List.class
//            List<GithubRepoDto>.class  chcielibyśmy zrobić ale nie zadziała
            var requestResult = restTemplate.getForObject(myRepoUrl, GithubRepoDto[].class);
            return Arrays.asList(requestResult);
        }

}
