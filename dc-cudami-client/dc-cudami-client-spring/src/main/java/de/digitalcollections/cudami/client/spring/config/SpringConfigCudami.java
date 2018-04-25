package de.digitalcollections.cudami.client.spring.config;

import de.digitalcollections.cudami.client.feign.Cudami;
import de.digitalcollections.cudami.client.feign.Environment;
import de.digitalcollections.cudami.client.feign.api.CudamiClient;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "de.digitalcollections.cudami.client.spring")
public class SpringConfigCudami {

  @Value(value = "${cudami.environment:#{null}}")
  private Optional<String> cudamiEnvironment;

  @Value(value = "${custom.server.address}")
  private String cudamiServerAddress;

  @Bean
  public CudamiClient cudamiClient() {
    Cudami cudami;
    if (cudamiEnvironment.isPresent()) {
      cudami = new Cudami(Environment.fromString(cudamiEnvironment.get()));
    } else {
      cudami = new Cudami(cudamiServerAddress);
    }
    return cudami.cudamiClient();
  }
}
