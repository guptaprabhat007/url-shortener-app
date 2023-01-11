package URLShortenerTest;

import exceptions.SEOKeywordExists;
import org.junit.Assert;
import org.junit.Test;
import service.URLShortener;

public class URLShortenerTest {

    @Test
    public void testCreateShortURL() {

        String url = "http://looooong.com/somepath";
        String keyword = "MY-NEW-WS";
        String expectedShortURL = "http://short.com/MY-NEW-WS";

        URLShortener urlShortener = new URLShortener();

        String actualShortURL = urlShortener.createShortURL(url, keyword);
        Assert.assertEquals(expectedShortURL, actualShortURL);

    }

    @Test
    public void testDuplicateSEOKeywordShortURL() {

        String url = "http://looooong.com/somepath";
        String keyword = "MY-NEW-WS";
        String expectedShortURL = "http://short.com/MY-NEW-WS";

        String url2 = "http://test.com/sometestpath";
        String keyword2 = "MY-NEW-WS";

        URLShortener urlShortener = new URLShortener();

        String actualShortURL = urlShortener.createShortURL(url, keyword);
        Boolean throwException = false;
        try {
            String actualShortURL2 = urlShortener.createShortURL(url2, keyword2);
        } catch (SEOKeywordExists seoKeywordExists) {
            throwException = true;
        } finally {
            Assert.assertSame(throwException, true);
        }
    }
}
