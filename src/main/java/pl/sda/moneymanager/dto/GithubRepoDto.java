package pl.sda.moneymanager.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class GithubRepoDto {
    @JsonProperty("id")
    private long projectId;

    @JsonProperty("name")
    private String projectName;

    //bieże JSONA full_name  --> i mapuje na projectFullName
//    jeżeli nazwa obiektu taka sama jak w JSON to nie
//    musimy używać adnotacji @JsonProperty("******")
    @JsonProperty("full_name")
    private String projectFullName;

    private ProjectOwnerDto owner;  //"owner" musi zgadzać się z nazwą obiektu w JSON'ie



    //           "id": 231973450,
//        "node_id": "MDEwOlJlcG9zaXRvcnkyMzE5NzM0NTA=",
//        "name": "github-slideshow",

}
