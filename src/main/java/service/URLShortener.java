package service;

import configs.Constants;
import exceptions.SEOKeywordExists;
import exceptions.SEOKeywordLengthExceeded;
import repo.URLStoreRepo;
import utils.URLUtils;

import java.util.concurrent.locks.ReentrantLock;

public class URLShortener {

    ReentrantLock lock;

    public URLShortener() {
        lock = new ReentrantLock();
    }

    public String createShortURL(String url, String keyword) {

        if (!URLUtils.validateSEOKeyword(keyword)) {
            throw new SEOKeywordLengthExceeded(Constants.SEO_KEYWORD_INVALID);
        } else if (!URLUtils.validateURL(url)) {
            throw new RuntimeException(Constants.URL_INVALID);
        }

        URLStoreRepo urlStoreRepo = URLStoreRepo.getURLStoreInstance();
        keyword = keyword.toUpperCase();

        try {
            lock.lock();
            //critical section
            if (urlStoreRepo.ifSEOKeywordExists(keyword)) {
                throw new SEOKeywordExists(Constants.SEO_KEYWORD_EXISTS);
            }

            urlStoreRepo.putShortUrl(keyword, url);
            String shortURL = URLUtils.formURL(keyword);
            return shortURL;

        } finally {
            lock.unlock();
        }
    }
    //redirect();
}
