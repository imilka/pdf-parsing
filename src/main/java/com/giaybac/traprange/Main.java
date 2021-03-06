package com.giaybac.traprange;

import com.giaybac.traprange.parser.InputFileInfo;
import com.giaybac.traprange.parser.Parser;
import com.giaybac.traprange.strategies.Strategy2;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOCase;
import org.apache.commons.io.filefilter.DirectoryFileFilter;
import org.apache.commons.io.filefilter.IOFileFilter;
import org.apache.commons.io.filefilter.SuffixFileFilter;
import org.apache.log4j.BasicConfigurator;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

/**
 * Created with IntelliJ IDEA.
 * User: imilka
 * Date: 27.03.16
 * Time: 0:32
 */
public class Main {
  public static void main(String[] args) throws IOException {
    BasicConfigurator.configure();

    String[] extensions = new String[] {"pdf"};
    IOFileFilter filter = new SuffixFileFilter(extensions, IOCase.INSENSITIVE);
    Iterator iter = FileUtils.iterateFiles(new File("/Users/imilka/Downloads/ЭКБ_2015/01"), filter, DirectoryFileFilter.DIRECTORY);

    File test = (File) iter.next();
    parseFile(test);
  }

  private static void parseFile(File pdf) throws IOException {
    System.out.println(pdf);

    InputFileInfo fileInfo = new InputFileInfo(pdf, new Strategy2(), 6, 8);
    String result = new Parser(fileInfo).parse().getStringCsv();
    System.out.println(result);
  }
}
