package de.digitalcollections.cudami.admin.controller.security;

import de.digitalcollections.commons.springmvc.controller.AbstractController;
import de.digitalcollections.cudami.admin.business.api.service.exceptions.ServiceException;
import de.digitalcollections.cudami.admin.business.api.service.security.UserService;
import de.digitalcollections.cudami.admin.paging.PageConverter;
import de.digitalcollections.cudami.admin.paging.PageWrapper;
import de.digitalcollections.cudami.admin.paging.PageableConverter;
import de.digitalcollections.model.paging.PageRequest;
import de.digitalcollections.model.paging.PageResponse;
import de.digitalcollections.model.security.Role;
import de.digitalcollections.model.security.User;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import javax.validation.Valid;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/** Controller for all "Users" pages. */
@Controller
@SessionAttributes(value = {"user"})
public class UserController extends AbstractController {

  private final MessageSource messageSource;
  private final UserService service;

  public UserController(MessageSource messageSource, UserService service) {
    this.messageSource = messageSource;
    this.service = service;
  }

  @ModelAttribute("menu")
  protected String module() {
    return "users";
  }

  @ModelAttribute("allRoles")
  protected List<Role> populateAllRoles() {
    return Arrays.asList(Role.values());
  }

  @InitBinder("user")
  protected void initBinder(WebDataBinder binder) {
    //        binder.setDisallowedFields("password");
    //        binder.addValidators(mySpecialUserValidator);
  }

  @GetMapping("/users/{uuid}/activate")
  public String activate(
      @PathVariable UUID uuid, Model model, RedirectAttributes redirectAttributes)
      throws ServiceException {
    User user = service.activate(uuid);
    String message =
        messageSource.getMessage(
            "msg.user_activated", new Object[] {user.getEmail()}, LocaleContextHolder.getLocale());
    redirectAttributes.addFlashAttribute("success_message", message);
    return "redirect:/users";
  }

  @GetMapping("/users/new")
  public String create(Model model) {
    model.addAttribute("user", service.create());
    return "users/create";
  }

  @PostMapping("/users/new")
  public String create(
      @RequestParam("pwd1") String password1,
      @RequestParam("pwd2") String password2,
      @ModelAttribute(name = "user") @Valid User user,
      BindingResult results,
      Model model,
      SessionStatus status,
      RedirectAttributes redirectAttributes)
      throws ServiceException {
    verifyBinding(results);
    if (results.hasErrors()) {
      return "users/create";
    }
    User userDb = service.create(user, password1, password2, (Errors) results);
    if (results.hasErrors()) {
      return "users/create";
    }
    status.setComplete();
    String message =
        messageSource.getMessage("msg.created_successfully", null, LocaleContextHolder.getLocale());
    redirectAttributes.addFlashAttribute("success_message", message);
    return "redirect:/users/" + userDb.getUuid().toString();
  }

  @GetMapping("/users/{uuid}/deactivate")
  public String deactivate(
      @PathVariable UUID uuid, Model model, RedirectAttributes redirectAttributes)
      throws ServiceException {
    User user = service.deactivate(uuid);
    String message =
        messageSource.getMessage(
            "msg.user_deactivated",
            new Object[] {user.getEmail()},
            LocaleContextHolder.getLocale());
    redirectAttributes.addFlashAttribute("warning_message", message);
    return "redirect:/users";
  }

  @GetMapping("/users/{uuid}/edit")
  public String edit(@PathVariable UUID uuid, Model model) throws ServiceException {
    model.addAttribute("user", service.findOne(uuid));
    return "users/edit";
  }

  @PostMapping("/users/{uuid}/edit")
  public String edit(
      @PathVariable UUID uuid,
      @RequestParam(name = "pwd1", required = false) String password1,
      @RequestParam(name = "pwd2", required = false) String password2,
      @ModelAttribute(name = "user") @Valid User user,
      BindingResult results,
      Model model,
      SessionStatus status,
      RedirectAttributes redirectAttributes)
      throws ServiceException {
    verifyBinding(results);
    if (results.hasErrors()) {
      return "users/edit";
    }
    service.update(user, password1, password2, (Errors) results);
    if (results.hasErrors()) {
      return "users/edit";
    }
    status.setComplete();
    String message =
        messageSource.getMessage(
            "msg.changes_saved_successfully", null, LocaleContextHolder.getLocale());
    redirectAttributes.addFlashAttribute("success_message", message);
    return "redirect:/users/" + uuid;
  }

  @GetMapping("/users")
  public String list(
      Model model,
      @PageableDefault(
              sort = {"email"},
              direction = Sort.Direction.ASC,
              size = 25)
          Pageable pageable)
      throws ServiceException {
    final PageRequest pageRequest = PageableConverter.convert(pageable);
    final PageResponse pageResponse = service.find(pageRequest);
    Page page = PageConverter.convert(pageResponse, pageRequest);
    model.addAttribute("page", new PageWrapper(page, "/users"));
    return "users/list";
  }

  @GetMapping("/users/updatePassword")
  public String updatePassword(Model model) throws ServiceException {
    User currentUser =
        service.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
    model.addAttribute("user", currentUser);
    return "users/edit-password";
  }

  // TODO: Simplify user management
  @PostMapping("/users/updatePassword")
  public String updatePassword(
      @RequestParam("pwd1") String password1,
      @RequestParam("pwd2") String password2,
      @ModelAttribute(name = "user") @Valid User user,
      BindingResult results,
      Model model,
      SessionStatus status,
      RedirectAttributes redirectAttributes)
      throws ServiceException {
    verifyBinding(results);
    String errorMessage =
        messageSource.getMessage(
            "error.password_change_failed", null, LocaleContextHolder.getLocale());
    if (results.hasErrors()) {
      model.addAttribute("error_message", errorMessage);
      return "users/edit-password";
    }
    service.update(user, password1, password2, (Errors) results);
    if (results.hasErrors()) {
      model.addAttribute("error_message", errorMessage);
      return "users/edit-password";
    }
    status.setComplete();
    String message =
        messageSource.getMessage(
            "msg.changed_password_successfully", null, LocaleContextHolder.getLocale());
    redirectAttributes.addFlashAttribute("success_message", message);
    return "redirect:/";
  }

  @GetMapping("/users/{uuid}")
  public String view(@PathVariable UUID uuid, Model model) throws ServiceException {
    model.addAttribute("user", service.findOne(uuid));
    return "users/view";
  }
}
