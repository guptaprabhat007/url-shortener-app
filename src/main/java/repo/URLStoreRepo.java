package repo;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class URLStoreRepo {

    Map<String, String> urlStore;

    public static URLStoreRepo INSTANCE;

    private URLStoreRepo() {
        urlStore = new ConcurrentHashMap<>();
    }

    public static URLStoreRepo getURLStoreInstance() {

        if (INSTANCE == null)
            INSTANCE = new URLStoreRepo();
        return INSTANCE;
    }

    public Boolean ifSEOKeywordExists(String keyword){
        return urlStore.containsKey(keyword);
    }

    public void putShortUrl(String keyword, String url){
        urlStore.put(keyword, url);
    }
}
