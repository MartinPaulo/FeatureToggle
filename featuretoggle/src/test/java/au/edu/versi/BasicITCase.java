package au.edu.versi;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.net.MalformedURLException;

import org.junit.Test;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class BasicITCase {

    @Test
    public void test() throws FailingHttpStatusCodeException, MalformedURLException, IOException {
        final WebClient webClient = new WebClient();
        final HtmlPage page = (HtmlPage) webClient.getPage("http://localhost:8080");
        assertEquals("Hello", page.getTitleText());

        final String pageAsXml = page.asXml();
        assertTrue(pageAsXml.contains("<body class=\"page\">"));

        final String pageAsText = page.asText();
        assertTrue(pageAsText.contains("Welcome to our basic web application."));
    }

}
