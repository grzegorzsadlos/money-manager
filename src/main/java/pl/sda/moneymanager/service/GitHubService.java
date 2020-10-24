package pl.sda.moneymanager.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.sda.moneymanager.dto.GithubRepoDto;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
@Slf4j
public class GitHubService {
    private static final String myRepoUrl = "https://api.github.com/users/grzegorzsadlos/repos";
    private final RestTemplate restTemplate;

    public GitHubService(final RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<GithubRepoDto> allUserRepos(){
        var requestResult = restTemplate.getForObject(myRepoUrl, GithubRepoDto[].class);
//        return Arrays.asList(requestResult!=null?requestResult:new GithubRepoDto[]{});
        return requestResult!=null?Arrays.asList(requestResult): Collections.emptyList();
    }
}
