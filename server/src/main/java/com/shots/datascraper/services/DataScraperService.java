package com.shots.datascraper.services;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class DataScraperService {

  public DataScraperService(){};

  public Document get_doc(String url){
    try {
      Document  doc = Jsoup.connect(url).get();
      return doc;
    } catch (IOException e) {
      e.printStackTrace();
      return Document.createShell("");
    }
  }
}
