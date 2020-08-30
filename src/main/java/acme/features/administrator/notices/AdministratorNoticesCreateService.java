
package acme.features.administrator.notices;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.Configuration;
import acme.entities.Notices;
import acme.framework.components.Errors;
import acme.framework.components.HttpMethod;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractCreateService;

@Service
public class AdministratorNoticesCreateService implements AbstractCreateService<Administrator, Notices> {

	@Autowired
	AdministratorNoticesRepository repository;


	@Override
	public boolean authorise(final Request<Notices> request) {
		assert request != null;
		return true;
	}

	@Override
	public void bind(final Request<Notices> request, final Notices entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors, "moment");
	}

	@Override
	public void unbind(final Request<Notices> request, final Notices entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "headerPicture", "title", "deadline", "body", "links");

		if (request.isMethod(HttpMethod.GET)) {
			model.setAttribute("accept", "false");
		} else {
			request.transfer(model, "accept");
		}
	}

	@Override
	public Notices instantiate(final Request<Notices> request) {
		Notices result;

		result = new Notices();
		LocalDateTime creation;

		creation = LocalDateTime.now();
		result.setCreation(creation);
		return result;

	}

	@Override
	public void validate(final Request<Notices> request, final Notices entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		Configuration config;
		config = this.repository.findManyConfiguration().stream().findFirst().get();

		if (!errors.hasErrors("headerPicture")) {
			boolean isSpam = config.isSpam(entity.getHeaderPicture());
			errors.state(request, !isSpam, "headerPicture", "administrator.notices.error.spam");
		}

		if (!errors.hasErrors("body")) {
			boolean isSpam = config.isSpam(entity.getBody());
			errors.state(request, !isSpam, "body", "administrator.notices.error.spam");
		}

		if (!errors.hasErrors("links")) {
			boolean isSpam = config.isSpam(entity.getLinks());
			errors.state(request, !isSpam, "links", "administrator.notices.error.spam");
		}

		if (!errors.hasErrors("accept")) {
			Boolean isAccepted = request.getModel().getBoolean("accept");
			errors.state(request, isAccepted, "accept", "administrator.notices.error.must-accept");
		}

		if (!errors.hasErrors("deadline")) {
			boolean isAfter = entity.getDeadline().isAfter(LocalDateTime.now());
			errors.state(request, isAfter, "deadline", "administrator.notices.error.deadlineIsAfter");
		}

	}

	@Override
	public void create(final Request<Notices> request, final Notices entity) {

		LocalDateTime creation;
		creation = LocalDateTime.now();
		entity.setCreation(creation);
		this.repository.save(entity);
	}

}
