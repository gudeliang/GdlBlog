package gdl.blog.Provider;

import com.alibaba.fastjson.JSON;
import gdl.blog.Dto.AccessTokenParam;
import gdl.blog.Dto.GitHubUser;
import okhttp3.*;
import org.springframework.stereotype.Component;

@Component
public class GitHubProvider {

    public String getAccessToken(AccessTokenParam accessTokenParam) {
        MediaType mediaType = MediaType.get("application/json; charset=utf-8");
        OkHttpClient okHttpClient = new OkHttpClient();

        //创建请求body
        RequestBody requestBody = RequestBody.create(mediaType, JSON.toJSONString(accessTokenParam));

        //创建Request
        Request request = new Request.Builder()
                .url("https://github.com/login/oauth/access_token")
                .post(requestBody)
                .build();

        //接收返回值
        try {
            Response response = okHttpClient.newCall(request).execute();
            String token = response.body().string();
            return token;
        } catch (Exception exception) {
            String message = exception.getMessage();
        }

        return null;
    }

    public GitHubUser GetGitHubUser(String token) {
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder()
                .addHeader("Authorization", "token " + token)
                .url("https://api.github.com/user")
                .build();
        try {
            Response response = okHttpClient.newCall(request).execute();
            String string = response.body().string();
            GitHubUser gitHubUser = JSON.parseObject(string, GitHubUser.class);
            return gitHubUser;
        } catch (Exception exception) {
            String message = exception.getMessage();
        }
        return null;
    }

}
