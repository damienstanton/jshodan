package com.fooock.shodan.mock;

import com.fooock.shodan.ApiService;
import com.fooock.shodan.ReadJson;
import com.fooock.shodan.model.Host;
import com.fooock.shodan.model.query.QueryReport;
import com.fooock.shodan.model.tag.TagReport;
import com.fooock.shodan.model.user.Account;
import com.fooock.shodan.model.user.ApiStatus;
import com.google.gson.Gson;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.mock.BehaviorDelegate;
import rx.Observable;

/**
 *
 */
public class ApiRestMock implements ApiService {

    private final Gson gson = new Gson();
    private final BehaviorDelegate<ApiService> behaviorDelegate;

    public ApiRestMock(BehaviorDelegate<ApiService> behaviorDelegate) {
        this.behaviorDelegate = behaviorDelegate;
    }

    @Override
    public Observable<QueryReport> queries(@Query("key") String apiKey) {
        return null;
    }

    @Override
    public Observable<QueryReport> queries(@Query("key") String apiKey, @Query("page") int page) {
        return null;
    }

    @Override
    public Observable<QueryReport> queries(@Query("key") String apiKey, @Query("page") int page, @Query("sort") String sort) {
        return null;
    }

    @Override
    public Observable<QueryReport> queries(@Query("key") String apiKey, @Query("page") int page, @Query("sort") String sort, @Query("order") String order) {
        return null;
    }

    @Override
    public Observable<QueryReport> searches(@Query("key") String apiKey, @Query("query") String query) {
        QueryReport queryReport = gson.fromJson(ReadJson.readFile("query_search.json"), QueryReport.class);
        return behaviorDelegate.returningResponse(queryReport).searches(apiKey, query);
    }

    @Override
    public Observable<QueryReport> searches(@Query("key") String apiKey, @Query("query") String query, @Query("page") int page) {
        return null;
    }

    @Override
    public Observable<TagReport> tags(@Query("key") String apiKey) {
        TagReport tagReport = gson.fromJson(ReadJson.readFile("tags.json"), TagReport.class);
        return behaviorDelegate.returningResponse(tagReport).tags(apiKey);
    }

    @Override
    public Observable<TagReport> tags(@Query("key") String apiKey, @Query("size") int tagNumber) {
        return null;
    }

    @Override
    public Observable<Host> host(@Path("ip") String ip, @Query("key") String apiKey) {
        Host host = gson.fromJson(ReadJson.readFile("shodan_host.json"), Host.class);
        return behaviorDelegate.returningResponse(host).host(ip, apiKey);
    }

    @Override
    public Observable<Host> host(@Path("ip") String ip, @Query("key") String apiKey, @Query("history") boolean history) {
        return null;
    }

    @Override
    public Observable<Host> host(@Path("ip") String ip, @Query("key") String apiKey, @Query("history") boolean history, @Query("minify") boolean minify) {
        Host host = gson.fromJson(ReadJson.readFile("shodan_host_minified.json"), Host.class);
        return behaviorDelegate.returningResponse(host).host(ip, apiKey, history, minify);
    }

    @Override
    public Observable<Account> account(@Query("key") String apiKey) {
        Account account = gson.fromJson(
                ReadJson.readFile("account.json"), Account.class);
        return behaviorDelegate.returningResponse(account).account(apiKey);
    }

    @Override
    public Observable<ApiStatus> info(@Query("key") String apiKey) {
        ApiStatus apiStatus = gson.fromJson(ReadJson.readFile("api_info.json"), ApiStatus.class);
        return behaviorDelegate.returningResponse(apiStatus).info(apiKey);
    }

    @Override
    public Observable<String> ip(@Query("key") String apiKey) {
        return null;
    }

    @Override
    public Observable<Float> honeyScore(@Path("ip") String ip, @Query("key") String apiKey) {
        return null;
    }
}