package de.digitalcollections.cudami.admin.controller.identifiable.entity;

import de.digitalcollections.commons.springdata.domain.PageConverter;
import de.digitalcollections.commons.springdata.domain.PageWrapper;
import de.digitalcollections.commons.springdata.domain.PageableConverter;
import de.digitalcollections.commons.springmvc.controller.AbstractController;
import de.digitalcollections.cudami.admin.backend.api.repository.LocaleRepository;
import de.digitalcollections.cudami.admin.business.api.service.exceptions.IdentifiableServiceException;
import de.digitalcollections.cudami.client.CudamiProjectsClient;
import de.digitalcollections.cudami.client.exceptions.HttpException;
import de.digitalcollections.model.api.identifiable.entity.Project;
import de.digitalcollections.model.api.paging.PageRequest;
import de.digitalcollections.model.api.paging.PageResponse;
import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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
import org.springframework.web.bind.annotation.ResponseBody;

/** Controller for project management pages. */
@Controller
public class ProjectsController extends AbstractController {

  private static final Logger LOGGER = LoggerFactory.getLogger(ProjectsController.class);

  LocaleRepository localeRepository;
  CudamiProjectsClient cudamiProjectsClient;

  @Autowired
  public ProjectsController(
      LocaleRepository localeRepository, CudamiProjectsClient cudamiProjectsClient) {
    this.localeRepository = localeRepository;
    this.cudamiProjectsClient = cudamiProjectsClient;
  }

  @ModelAttribute("menu")
  protected String module() {
    return "projects";
  }

  @GetMapping("/projects/new")
  public String create(Model model) {
    model.addAttribute("activeLanguage", localeRepository.getDefaultLanguage());
    // model.addAttribute("parentUuid", parentUuid);
    return "projects/create";
  }

  @GetMapping("/api/projects/new")
  @ResponseBody
  public Project create() {
    return cudamiProjectsClient.createProject();
  }

  @GetMapping("/projects/{uuid}/edit")
  public String edit(@PathVariable UUID uuid, Model model) throws HttpException {
    Project project = cudamiProjectsClient.getProject(uuid);
    model.addAttribute("activeLanguage", localeRepository.getDefaultLanguage());
    model.addAttribute("uuid", project.getUuid());
    return "projects/edit";
  }

  @GetMapping("/api/projects/{uuid}")
  @ResponseBody
  public Project get(@PathVariable UUID uuid) throws HttpException {
    return cudamiProjectsClient.getProject(uuid);
  }

  @GetMapping("/projects")
  public String list(
      Model model,
      @PageableDefault(
              sort = {"label"},
              size = 25)
          Pageable pageable) {
    final PageRequest pageRequest = PageableConverter.convert(pageable);
    final PageResponse pageResponse = cudamiProjectsClient.findProjects(pageRequest);
    Page page = PageConverter.convert(pageResponse, pageRequest);
    model.addAttribute("page", new PageWrapper(page, "/projects"));
    return "projects/list";
  }

  @PostMapping("/api/projects/new")
  public ResponseEntity save(@RequestBody Project project) throws IdentifiableServiceException {
    try {
      Project projectDb = cudamiProjectsClient.saveProject(project);
      return ResponseEntity.status(HttpStatus.CREATED).body(projectDb);
    } catch (Exception e) {
      LOGGER.error("Cannot save project: ", e);
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }
  }

  @PutMapping("/api/projects/{uuid}")
  public ResponseEntity update(@PathVariable UUID uuid, @RequestBody Project project)
      throws IdentifiableServiceException {
    try {
      Project projectDb = cudamiProjectsClient.updateProject(project);
      return ResponseEntity.ok(projectDb);
    } catch (Exception e) {
      LOGGER.error("Cannot save project with uuid={}", uuid, e);
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }
  }

  @GetMapping("/projects/{uuid}")
  public String view(@PathVariable UUID uuid, Model model) throws HttpException {
    Project project = cudamiProjectsClient.getProject(uuid);
    model.addAttribute("availableLanguages", project.getLabel().getLocales());
    model.addAttribute("project", project);
    return "projects/view";
  }
}
