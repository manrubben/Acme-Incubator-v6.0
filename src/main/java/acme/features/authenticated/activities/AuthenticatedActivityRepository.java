
package acme.features.authenticated.activities;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.Activity;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuthenticatedActivityRepository extends AbstractRepository {

	@Query("select a from Activity a where a.id = ?1")
	Activity findOneById(int idJob);

	@Query("select a from Activity a where a.investmentRound.id = ?1")
	Collection<Activity> findManyByInvestmentRound(int idInvestmentRound);

}
