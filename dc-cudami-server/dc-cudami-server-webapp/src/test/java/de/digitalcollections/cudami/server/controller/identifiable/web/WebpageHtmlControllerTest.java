package de.digitalcollections.cudami.server.controller.identifiable.web;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.io.Resources;
import de.digitalcollections.cudami.server.business.api.service.identifiable.web.WebpageService;
import de.digitalcollections.cudami.server.config.SpringConfigBackendForTest;
import de.digitalcollections.cudami.server.config.SpringConfigBusinessForTest;
import de.digitalcollections.model.identifiable.web.Webpage;
import de.digitalcollections.model.jackson.DigitalCollectionsObjectMapper;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.UUID;
import javax.xml.XMLConstants;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.SchemaFactory;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

@AutoConfigureMockMvc
@ActiveProfiles("TEST")
@SpringBootTest(classes = {SpringConfigBusinessForTest.class, SpringConfigBackendForTest.class})
public class WebpageHtmlControllerTest {

  @Autowired private MockMvc mockMvc;

  @MockBean private WebpageService webpageService;

  @Test
  public void shouldReturnValidHtml() throws Exception {
    prepareWebpageMock();
    MvcResult result =
        mockMvc
            .perform(get("/latest/webpages/{uuid}.html", "00000000-0000-0000-0000-000000000000"))
            .andExpect(status().isOk())
            .andReturn();
    String content = result.getResponse().getContentAsString();
    File contentFile = File.createTempFile("content", ".html");
    contentFile.deleteOnExit();
    Files.write(contentFile.toPath(), content.getBytes());

    SAXParserFactory factory = SAXParserFactory.newInstance();
    factory.setValidating(true);
    factory.setNamespaceAware(true);

    SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);

    factory.setSchema(
        schemaFactory.newSchema(
            new Source[] {new StreamSource(new ClassPathResource("xhtml11.xsd").getFile())}));

    SAXParser parser = factory.newSAXParser();
    XMLReader reader = parser.getXMLReader();

    assertThatCode(() -> reader.parse(new InputSource(contentFile.getAbsolutePath())))
        .doesNotThrowAnyException();
  }

  private void prepareWebpageMock() {
    final ObjectMapper mapper = new DigitalCollectionsObjectMapper();
    Webpage dummyWebpage;
    try {
      final String dummyWebpageJson =
          Resources.toString(Resources.getResource("webpage.json"), Charset.defaultCharset());
      dummyWebpage = mapper.readValue(dummyWebpageJson, Webpage.class);
    } catch (IOException ex) {
      dummyWebpage = new Webpage();
    }
    Mockito.when(webpageService.get(UUID.fromString("00000000-0000-0000-0000-000000000000")))
        .thenReturn(dummyWebpage);
  }
}
