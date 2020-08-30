
package acme.features.administrator.notices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.Notices;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractShowService;

@Service
public class AdministratorNoticesShowService implements AbstractShowService<Administrator, Notices> {

	@Autowired
	private AdministratorNoticesRepository repository;


	@Override
	public boolean authorise(final Request<Notices> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(final Request<Notices> request, final Notices entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "headerPicture", "title", "creation", "deadline", "body", "links");
	}

	@Override
	public Notices findOne(final Request<Notices> request) {
		assert request != null;

		Notices result;
		int id;

		id = request.getModel().getInteger("id");
		result = this.repository.findOneById(id);

		return result;
	}

}
