import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.testng.Assert.*;

public class MainTest {

    @Test
    public void basicTestofTechs() throws IOException {//Test gets a list of technologies that were obtained by the web scraper and compares them to a hard coded list to check for correctness and completeness.
        WebScraper webScraper = new WebScraper();
        webScraper.scrape();
        ArrayList scrapedTechs = webScraper.getTechs();

        String [] hardTechs = {"Java 8 / JVM", "Groovy", "Egis Kernel","Hibernate / JPA", "Jetty", "Hazelcast", "PostgreSQL / MySQL / SQL Server", "Lucene", "TestNG", "C#", "Electron", "Golang", "Python", "Markdown", "Gitbook", "ES6 / Babel", "NPM", "Yarn",
                            "Gulp", "Selenium/Webdriver", "Karma / Jasmine", "ExtJS", "Angular (1 or 2)", "Vue.js", "WebComponents / Polymer 2.0", "React","Gradle","Ant", "Babel / Gulp", "npm", "Github", "CircleCI", "AppVeyor", "Jenkins", "Codacy", "Codecov",
                            "Amazon S3", "Nexus / JFrog", "Ubuntu LTS", "Docker", "PostgreSQL", "ansible", "VMWare ESXi", "VMWare vCenter", "Amazon EC2", "Amazon S3", "Amazon DynomoDB", "Cloudflare", "Google Drive", "Sendgrid", "Google Apps",
                            "Hipchat", "Discord", "Trello", "Fortigate", "Dell", "Docker Hub"};
        //hard coded list of technologies
        for (int i=0;i<hardTechs.length;i++) {
            assertEquals(scrapedTechs.get(i),hardTechs[i]);
        }
    }

}