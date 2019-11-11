package org.sonatype.mavenbook.ch07;

import org.apache.commons.io.IOUtils;
import org.junit.Assert;
import org.junit.Test;

import java.io.InputStream;

public class YahooParserTest {
    @Test
    public void replaceMe() throws Exception {
        Assert.assertTrue(true);
        InputStream data =
                getClass().getClassLoader().getResourceAsStream("data/test.dat");
        String ret = IOUtils.toString(data);
        Assert.assertEquals("hello", ret);
    }
}
