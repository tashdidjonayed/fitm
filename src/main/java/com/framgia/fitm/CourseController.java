package com.framgia.fitm;

import java.util.List;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.framgia.fitm.bean.CourseBean;
import com.framgia.fitm.model.Course;
import com.framgia.fitm.service.CourseService;
import com.framgia.fitm.util.Constants;

@Controller
public class CourseController {
	private static final Logger logger = LoggerFactory.getLogger(CourseController.class);

	@Autowired
	private CourseService courseService;

	@GetMapping("/courseList")
	public String init(Model model, Integer offset, Integer maxResults) {
		logger.info(" Course home page");
		List<CourseBean> courses = courseService.list(offset, maxResults);
		if (courses.isEmpty()) {
			model.addAttribute("css", "danger");
			model.addAttribute("msg", "Courses not found");
		}
		model.addAttribute("course", new Course());
		model.addAttribute("courses", courses);
		model.addAttribute("count", courseService.count());
		model.addAttribute("offset", offset);
		model.addAttribute("max", Constants.MAX);
		return "coursehome";
	}

	@RequestMapping(value = "/course/{id}", method = RequestMethod.GET)
	public String showCourse(@PathVariable("id") int id, Model model) {
		logger.info("detail Course");
		CourseBean course = courseService.showCourse(id);
		if (course == null) {
			model.addAttribute("css", "danger");
			model.addAttribute("msg", "Course not found");
		}
		model.addAttribute("course", course);
		return "/course";
	}

	@RequestMapping(value = "/course/{id}/delete", method = RequestMethod.DELETE)
	public String deleteCourse(@PathVariable("id") int id, final RedirectAttributes redirectAttributes) {
		logger.info("delete Course");
		if (courseService.deleteCourse(id)) {
			redirectAttributes.addFlashAttribute("css", "success");
			redirectAttributes.addFlashAttribute("msg", "Course is deleted!");
		} else {
			redirectAttributes.addFlashAttribute("css", "error");
			redirectAttributes.addFlashAttribute("msg", "Delete Course fails!!!!");
		}
		return "redirect:/";
	}

	@RequestMapping(value = "/course/{id}/edit", method = RequestMethod.GET)
	public String showUpdatecourseForm(@PathVariable("id") int id, Model model) {
		model.addAttribute("courseForm", courseService.showCourse(id));
		model.addAttribute("status", Constants.EDIT);
		return "courseForm";
	}

	@RequestMapping(value = "/course", method = RequestMethod.POST)
	public String saveOrUpdateCourse(@ModelAttribute("courseForm") @Valid Course courseForm, BindingResult result,
			Model model, final RedirectAttributes redirectAttributes) {

		logger.info("create or update");
		if (result.hasErrors()) {
			if (courseForm.getCourse_id() == null)
				model.addAttribute("status", Constants.ADD);
			else
				model.addAttribute("status", Constants.EDIT);
			return "courseForm";
		} else {
			if (courseForm.getCourse_id() == null) {
				// new
				redirectAttributes.addFlashAttribute("msg", "Course added successfully!");
			} else {
				// update
				redirectAttributes.addFlashAttribute("msg", "Course updated successfully!");
			}
			courseService.saveOrupdateCourse(courseForm);
			return "redirect:/";
		}
	}

	@RequestMapping(value = "/course/add", method = RequestMethod.GET)
	public String showAddcourseForm(Model model) {
		logger.info("showAddcourseForm()");
		model.addAttribute("courseForm", new Course());
		model.addAttribute("status", Constants.ADD);
		return "courseForm";
	}

}
