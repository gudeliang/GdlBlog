package gdl.blog.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccessTokenParam {

    private String client_id;

    private String client_secret;

    private String code;

    private String redirect_uri;
}
