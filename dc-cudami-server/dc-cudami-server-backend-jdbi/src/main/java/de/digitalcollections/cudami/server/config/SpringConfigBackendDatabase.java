package de.digitalcollections.cudami.server.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.digitalcollections.commons.jdbi.DcCommonsJdbiPlugin;
import de.digitalcollections.cudami.server.backend.impl.jdbi.plugins.JsonbJdbiPlugin;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.jdbi.v3.postgres.PostgresPlugin;
import org.jdbi.v3.spring4.JdbiFactoryBean;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;
import org.jooq.impl.DataSourceConnectionProvider;
import org.jooq.impl.DefaultConfiguration;
import org.jooq.impl.DefaultDSLContext;
import org.jooq.impl.DefaultExecuteListenerProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/** Database configuration. */
@Configuration
@ComponentScan(basePackages = {"de.digitalcollections.cudami.server.backend.impl.jdbi"})
@EnableTransactionManagement
public class SpringConfigBackendDatabase {

  private static final Logger LOGGER = LoggerFactory.getLogger(SpringConfigBackendDatabase.class);

  @Value("${spring.datasource.url}")
  String datasourceUrl;

  @Value("${spring.datasource.username}")
  String datasourceUsername;

  @Value("${spring.datasource.password}")
  String datasourcePassword;

  @Autowired private DataSource dataSource;

  @Autowired
  @Bean
  @Qualifier(value = "pds")
  public PersistentTokenRepository persistentTokenRepository(DataSource pds) {
    JdbcTokenRepositoryImpl tokenRepository = new JdbcTokenRepositoryImpl();
    tokenRepository.setDataSource(pds);
    return tokenRepository;
  }

  @Bean
  public JdbiFactoryBean jdbi(DataSource ds, ObjectMapper objectMapper) throws Exception {
    JdbiFactoryBean jdbiFactoryBean = new JdbiFactoryBean(ds);
    List plugins = new ArrayList();
    plugins.add(new SqlObjectPlugin());
    plugins.add(new PostgresPlugin());
    plugins.add(new DcCommonsJdbiPlugin());
    plugins.add(new JsonbJdbiPlugin(objectMapper));
    jdbiFactoryBean.setPlugins(plugins);
    return jdbiFactoryBean;
  }

  @Bean
  public DataSourceConnectionProvider connectionProvider() {
    return new DataSourceConnectionProvider(new TransactionAwareDataSourceProxy(dataSource));
  }

  @Bean
  public DefaultDSLContext dsl() {
    return new DefaultDSLContext(configuration());
  }

  @Bean
  public ExceptionTranslator exceptionTransformer() {
    return new ExceptionTranslator();
  }

  public DefaultConfiguration configuration() {
    //    org.jooq.meta.jaxb.Configuration configuration =
    //        new org.jooq.meta.jaxb.Configuration()
    //            .withJdbc(
    //                new Jdbc()
    //                    .withDriver("org.postgresql.Driver")
    //                    .withUrl(datasourceUrl)
    //                    .withUser(datasourceUsername)
    //                    .withPassword(datasourcePassword))
    //            .withGenerator(
    //                new Generator()
    //                    .withDatabase(
    //                        new Database()
    //                            .withName("org.jooq.meta.postgres.PostgresDatabase")
    //                            .withIncludes(".*")
    //                            .withExcludes("")
    //                            .withInputSchema("public"))
    //                    .withTarget(
    //                        new Target()
    //                            .withPackageName(
    //                                "de.digitalcollections.cudami.server.backend.impl.jooq")
    //                            .withDirectory("target/generated-sources/jooq")));
    //
    //    try {
    //      GenerationTool.generate(configuration);
    //    } catch (Exception ex) {
    //      LOGGER.error("JOOQ code generation failed!", ex);
    //    }

    DefaultConfiguration jooqConfiguration = new DefaultConfiguration();
    jooqConfiguration.set(connectionProvider());
    jooqConfiguration.set(new DefaultExecuteListenerProvider(exceptionTransformer()));
    return jooqConfiguration;
  }
}
