package com.shots.datascraper.api;

import com.shots.datascraper.api.resources.HelloWorldResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import com.shots.datascraper.api.health.ScraperHealthCheck;
import io.dropwizard.assets.AssetsBundle;


public class DataScraper extends Application<DataScraperConfiguration>{

  public static void main(String[] args) throws Exception {
    new DataScraper().run(args);
  }

  @Override
  public String getName() {
    return "DataScraper";
  }

  @Override
  public void initialize(final Bootstrap<DataScraperConfiguration> bootstrap) {
    bootstrap.addBundle(new AssetsBundle("/public/", "/"));
  }

  @Override
  public void run(DataScraperConfiguration configuration,
                  Environment environment) {
    final HelloWorldResource helloWorldResource = new HelloWorldResource(
            configuration.getTemplate(),
            configuration.getDefaultName()
    );
    final ScraperHealthCheck healthCheck =
            new ScraperHealthCheck(configuration.getTemplate());
    environment.healthChecks().register("template", healthCheck);
    environment.jersey().register(helloWorldResource);
  }

}
