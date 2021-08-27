package ajchimaera.userbase;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class UserController {

	private final UserRepository repository;
	private final UserModelAssembler assembler;

	UserController(UserRepository repository, UserModelAssembler assembler) {
		this.repository = repository;
		this.assembler = assembler;
	}

	// List all users in repository
	@GetMapping("/users")
	CollectionModel<EntityModel<User>> all() {
		List<EntityModel<User>> users = ((Collection<User>) repository.findAll()).stream() //
				.map(assembler::toModel) //
				.collect(Collectors.toList());
		return CollectionModel.of(users, linkTo(methodOn(UserController.class).all()).withSelfRel());
	}

	// List all with specific last name
	@GetMapping("/users/{lastName}")
	CollectionModel<EntityModel<User>> lastName(@PathVariable String lastName) {
		List<EntityModel<User>> users = ((Collection<User>) repository.findByLastName(lastName)).stream() //
				.map(assembler::toModel) //
				.collect(Collectors.toList());
		return CollectionModel.of(users, linkTo(methodOn(UserController.class).lastName(lastName)).withSelfRel());
	}

	// Insert new user into repository
	@PostMapping("/users")
	ResponseEntity<?> newUser(@RequestBody User newUser) {
		EntityModel<User> entityModel = assembler.toModel(repository.save(newUser));

		return ResponseEntity //
				.created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()) //
				.body(entityModel);
	}

	// Single item details for reference link
	@GetMapping("/users/user/{id}")
	EntityModel<User> one(@PathVariable Long id) {
		User user = repository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
		return assembler.toModel(user);
	}

}