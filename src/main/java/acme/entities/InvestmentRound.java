
package acme.entities;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;
import org.springframework.format.annotation.DateTimeFormat;

import acme.entities.roles.Entrepreneur;
import acme.framework.datatypes.Money;
import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class InvestmentRound extends DomainEntity {

	// Serialisation identifier -----------------------------------------------

	private static final long	serialVersionUID	= 1L;

	// Attributes -------------------------------------------------------------

	@NotBlank
	@Pattern(regexp = "^[A-Z]{3}[-][0-9]{2}[-][0-9]{6}$", message = "{entrepreneur.investment-round.error.ticker-pattern}")
	private String				ticker;

	@DateTimeFormat(pattern = "dd-MM-yyyy HH:mm")
	@Past
	@NotNull
	private LocalDateTime		creation;

	@NotNull
	private Round				round;

	@NotBlank
	@Length(max = 255)
	private String				title;

	@NotBlank
	@Length(max = 255)
	private String				description;

	@NotNull
	@Valid
	private Money				money;

	@URL
	private String				link;

	@NotNull
	private Boolean				finalMode;

	// Relationships ----------------------------------------------------------

	@NotNull
	@Valid
	@ManyToOne(optional = false)
	private Entrepreneur		entrepreneur;

}
