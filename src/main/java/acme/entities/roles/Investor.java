
package acme.entities.roles;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import acme.framework.entities.UserRole;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Investor extends UserRole {

	// Serialisation identifier -----------------------------------------------

	private static final long	serialVersionUID	= 1L;

	// Attributes -------------------------------------------------------------

	@NotBlank
	@Length(max = 255)
	private String				firmName;

	@NotBlank
	@Length(max = 255)
	private String				sector;

	@NotBlank
	@Length(max = 255)
	private String				profile;

	// Derived attributes -----------------------------------------------------

	// Relationships ----------------------------------------------------------

}
