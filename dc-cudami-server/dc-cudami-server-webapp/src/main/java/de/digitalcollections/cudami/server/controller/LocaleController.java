package de.digitalcollections.cudami.server.controller;

import de.digitalcollections.cudami.server.business.api.service.LocaleService;
import java.util.List;
import java.util.Locale;
import org.jsondoc.core.annotation.Api;
import org.jsondoc.core.annotation.ApiMethod;
import org.jsondoc.core.annotation.ApiResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(description = "The locale/language controller", name = "Locale and language controller")
public class LocaleController {

  @Autowired private LocaleService service;

  @ApiMethod(description = "Get default language")
  @GetMapping(value = {"/latest/languages/default", "/v2/languages/default"})
  @ApiResponseObject
  public Locale getDefaultLanguage() {
    return new Locale(service.getDefaultLanguage());
  }

  @ApiMethod(description = "Get default locale")
  @GetMapping(value = {"/latest/locales/default", "/v2/locales/default", "/v1/locales/default"})
  @ApiResponseObject
  public Locale getDefaultLocale() {
    return service.getDefaultLocale();
  }

  @ApiMethod(description = "Get all supported languages")
  @GetMapping(value = {"/latest/languages", "/v2/languages"})
  @ApiResponseObject
  public List<String> getSupportedLanguages() {
    return service.getSupportedLanguages();
  }

  @ApiMethod(description = "Get all supported locales")
  @GetMapping(value = {"/latest/locales", "/v2/locales", "/v1/locales"})
  @ApiResponseObject
  public List<Locale> getSupportedLocales() {
    return service.getSupportedLocales();
  }
}
