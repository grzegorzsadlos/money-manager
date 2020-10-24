package pl.sda.moneymanager.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.sda.moneymanager.dto.GithubRepoDto;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class GitHubService {
    //    private static final String myRepoUrl = "https://api.github.com/users/grzegorzsadlos/repos";
    public static final String REPO_USER = "user";

    private static final String myRepoUrl = String.format("https://api.github.com/users/{%s}/repos", REPO_USER);
    private final RestTemplate restTemplate;

    public GitHubService(final RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<GithubRepoDto> allUserRepos(){
            return allReposOfGivenUser("grzegorzsadlos");
            }

    public List<GithubRepoDto> allReposOfGivenUser(String repoUser){
        Map<String, ?> params = Map.of(REPO_USER, repoUser);
        log.info("getting all repos for user: [{}]", repoUser);
        var requestResult = restTemplate.getForObject(myRepoUrl, GithubRepoDto[].class, params);

        log.info("number of elements in result: [{}]", requestResult!=null?requestResult.length:0);

        log.debug("all repos:{}", Arrays.toString(requestResult));

        return requestResult!=null?Arrays.asList(requestResult): Collections.emptyList();
    }

}
