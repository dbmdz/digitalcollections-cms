package de.digitalcollections.cudami.admin.controller.view;

import de.digitalcollections.commons.springmvc.controller.AbstractController;
import de.digitalcollections.cudami.client.CudamiClient;
import de.digitalcollections.cudami.client.CudamiLocalesClient;
import de.digitalcollections.cudami.client.exceptions.HttpException;
import de.digitalcollections.cudami.client.view.CudamiRenderingTemplatesClient;
import de.digitalcollections.model.paging.Order;
import de.digitalcollections.model.paging.PageRequest;
import de.digitalcollections.model.paging.PageResponse;
import de.digitalcollections.model.paging.Sorting;
import de.digitalcollections.model.view.RenderingTemplate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/** Controller for rendering template management pages. */
@Controller
public class RenderingTemplatesController extends AbstractController {

  private static final Logger LOGGER = LoggerFactory.getLogger(RenderingTemplatesController.class);

  private final CudamiLocalesClient localeService;
  private final CudamiRenderingTemplatesClient service;

  public RenderingTemplatesController(CudamiClient cudamiClient) {
    this.localeService = cudamiClient.forLocales();
    this.service = cudamiClient.forRenderingTemplates();
  }

  @ModelAttribute("menu")
  protected String module() {
    return "renderingTemplates";
  }

  @GetMapping("/renderingtemplates/new")
  public String create() {
    return "renderingtemplates/create";
  }

  @GetMapping("/api/renderingtemplates/new")
  @ResponseBody
  public RenderingTemplate createModel() {
    return service.create();
  }

  @GetMapping("/renderingtemplates/{uuid}/edit")
  public String edit(@PathVariable UUID uuid, Model model) throws HttpException {
    RenderingTemplate template = service.findOne(uuid);
    model.addAttribute("name", template.getName());
    model.addAttribute("uuid", template.getUuid());
    return "renderingtemplates/edit";
  }

  @GetMapping("/api/renderingtemplates")
  @ResponseBody
  public PageResponse<RenderingTemplate> findAll(
      @RequestParam(name = "pageNumber", required = false, defaultValue = "0") int pageNumber,
      @RequestParam(name = "pageSize", required = false, defaultValue = "25") int pageSize)
      throws HttpException {
    List<Order> orders = new ArrayList<>();
    Order labelOrder = new Order("label");
    labelOrder.setSubProperty(localeService.getDefaultLanguage().getLanguage());
    orders.addAll(Arrays.asList(labelOrder, new Order("name")));
    Sorting sorting = new Sorting(orders);
    PageRequest pageRequest = new PageRequest(pageNumber, pageSize, sorting);
    return service.find(pageRequest);
  }

  @GetMapping("/api/renderingtemplates/{uuid}")
  @ResponseBody
  public RenderingTemplate get(@PathVariable UUID uuid) throws HttpException {
    return service.findOne(uuid);
  }

  @GetMapping("/renderingtemplates")
  public String list() {
    return "renderingtemplates/list";
  }

  @PostMapping("/api/renderingtemplates/new")
  public ResponseEntity save(@RequestBody RenderingTemplate template) {
    try {
      RenderingTemplate templateDb = service.save(template);
      return ResponseEntity.status(HttpStatus.CREATED).body(templateDb);
    } catch (HttpException e) {
      LOGGER.error("Cannot save rendering template: ", e);
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }
  }

  @PutMapping("/api/renderingtemplates/{uuid}")
  public ResponseEntity update(@PathVariable UUID uuid, @RequestBody RenderingTemplate template) {
    try {
      RenderingTemplate templateDb = service.update(uuid, template);
      return ResponseEntity.ok(templateDb);
    } catch (HttpException e) {
      LOGGER.error("Cannot update rendering template with uuid={}", uuid, e);
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }
  }
}
