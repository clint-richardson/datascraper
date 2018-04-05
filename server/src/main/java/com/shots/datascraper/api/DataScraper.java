package com.shots.datascraper.api;

import com.shots.datascraper.api.resources.HelloWorldResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import com.example.helloworld.resources.HelloWorldResource;
import com.example.helloworld.health.TemplateHealthCheck;


public class DataScraper extends Application<DataScraperConfiguration>{

  public static void main(String[] args) throws Exception {
    new DataScraper().run(args);
  }

  @Override
  public String getName() {
    return "DataScraper";
  }

  @Override
  public void initialize(Bootstrap<DataScraperConfiguration> bootstrap) {
    // nothing to do yet
  }

  @Override
  public void run(DataScraperConfiguration configuration,
                  Environment environment) {
    final HelloWorldResource helloWorldResource = new HelloWorldResource(
            configuration.getTemplate(),
            configuration.getDefaultName()
    );
    environment.jersey().register(helloWorldResource);
  }

}
