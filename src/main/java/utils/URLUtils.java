package utils;

import configs.Constants;

public class URLUtils {

    public static String formURL(String resource) {

        String shortURL = "";
        if (resource != null) {
            shortURL = Constants.HTTP + "://" + Constants.DNS + "/" + resource;
        }
        return shortURL;
    }

    public static Boolean validateSEOKeyword(String seoKeyword) {

        if (seoKeyword == null)
            return false;

        else if (seoKeyword.trim().length() == 0 || seoKeyword.trim().length() > Constants.MAX_SEO_KEYWORD_LENGTH)
            return false;

        return true;
    }

    public static Boolean validateURL(String url) {

        if (url == null)
            return false;
            //TODO:: validate url using regex
        else if (url.trim().length() == 0)
            return false;
        return true;
    }
}
