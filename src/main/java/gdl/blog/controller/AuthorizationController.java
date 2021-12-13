package gdl.blog.controller;

import gdl.blog.Dto.AccessTokenParam;
import gdl.blog.Dto.GitHubUser;
import gdl.blog.Provider.GitHubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthorizationController {

    @Autowired
    GitHubProvider gitHubProvider;

    @GetMapping("/callback")
    public String CallBack(@RequestParam(name = "code") String code,//code是获取token的重要参数
                           @RequestParam(name = "state") String state) {

        AccessTokenParam accessTokenParam = new AccessTokenParam();
        accessTokenParam.setClient_id("4caf32ba015199bb2b65");//github获取
        accessTokenParam.setClient_secret("5f96b87856e1ac66a385497d586d39eab56b61f5");//github获取
        accessTokenParam.setCode(code);

        //拿到token
        //格式：access_token=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&scope=user&token_type=bearer
        String token = gitHubProvider.getAccessToken(accessTokenParam);

        //提取token
        token = token.split("&")[0].split("=")[1];

        //获取git用户信息
        GitHubUser gitHubUser = gitHubProvider.GetGitHubUser(token);

        return "Index";
    }

}
