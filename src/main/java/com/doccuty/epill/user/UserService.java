package com.doccuty.epill.user;

import java.security.SecureRandom;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.doccuty.epill.authentication.AuthenticationService;
import com.doccuty.epill.country.CountryRepository;
import com.doccuty.epill.drug.Drug;
import com.doccuty.epill.drug.DrugRepository;
import com.doccuty.epill.gender.Gender;
import com.doccuty.epill.gender.GenderRepository;
import com.doccuty.epill.iteminvocation.ItemInvocation;
import com.doccuty.epill.language.LanguageRepository;
import com.doccuty.epill.model.DrugFeature;
import com.doccuty.epill.model.PackagingTopic;

/**
 * Handle all CRUD operations for posts.
 */
@Service
public class UserService {

	private static final Logger LOG = LoggerFactory.getLogger(UserService.class);

	@Autowired
	UserRepository repository;

	@Autowired
	DrugRepository drugRepository;

	@Autowired
	LanguageRepository languageRepository;

	@Autowired
	CountryRepository countryRepository;

	@Autowired
	GenderRepository genderRepository;

	@Autowired
	AuthenticationService authenticationService;

	public List<User> getAllUsers() {
		return (List<User>) repository.findAll();
	}

	public SimpleUser findByUsername(String username) {
		return repository.findByUsername(username);
	}

	public User findUserById(long id) {
		return repository.findUserById(id);
	}

	public User saveUser(User user) {

		if (repository.findByUsername(user.getUsername()) != null)
			return null;

		if (repository.findByEmail(user.getEmail()) != null)
			return null;

		final SecureRandom random = new SecureRandom();
		final byte[] randomByte = new byte[30];
		random.nextBytes(randomByte);

		final String salt = randomByte.toString();
		final String encryptedPassword = authenticationService.hashPassword(salt, user.getPassword());
		user.withPassword(encryptedPassword).withSalt(salt);

		if (user.getGender() != null) {
			final Gender gender = genderRepository.findOne(user.getGender().getId());
			user.setGender(gender);
		}

		user = repository.save(user);

		LOG.info("User={} was saved ", user);

		return user;
	}

	public User updateUserSettings(User usr) {

		User user = repository.findOne(getCurrentUser().getId());

		if (user == null)
			return null;

		/*
		 * update preferred font size and level of detail
		 */

		user.withPreferredFontSize(usr.getPreferredFontSize()).withLevelOfDetail(usr.getLevelOfDetail());

		/*
		 * update preferred packaging topics
		 */

		user.getPreferredPackagingTopic().clear();

		for (final PackagingTopic value : usr.getPreferredPackagingTopic()) {
			user.withPreferredPackagingTopic(value);
		}

		/*
		 * update preferred drug features
		 */

		user.getPreferredDrugFeature().clear();

		for (final DrugFeature value : usr.getPreferredDrugFeature()) {
			user.withPreferredDrugFeature(value);
		}

		user = repository.save(user);

		return user;
	}

	public User updateUserData(User usr) {

		User user = repository.findOne(getCurrentUser().getId());

		if (user == null)
			return null;

		user.withFirstname(usr.getFirstname()).withLastname(usr.getLastname()).withEmail(usr.getEmail())
				.withDateOfBirth(usr.getDateOfBirth()).withPreferredFontSize(usr.getPreferredFontSize())
				.withLevelOfDetail(usr.getLevelOfDetail()).withRedGreenColorblind(usr.getRedGreenColorblind());

		if (usr.getUsername() != null)
			user.withUsername(usr.getUsername());

		if (usr.getLanguage() != null)
			user.setLanguage(languageRepository.findOne(usr.getLanguage().getId()));

		if (usr.getCountry() != null)
			user.setCountry(countryRepository.findOne(usr.getCountry().getId()));

		if (usr.getGender() != null)
			user.setGender(genderRepository.findOne(usr.getGender().getId()));

		user = repository.save(user);

		LOG.info("User={} was updated ", user);

		return user;
	}

	public User updateUserPassword(User usr) {

		User user = repository.findOne(getCurrentUser().getId());

		if (user == null)
			return null;

		final SecureRandom random = new SecureRandom();
		final byte[] salt = new byte[20];
		random.nextBytes(salt);

		final String encryptedPassword = authenticationService.hashPassword(salt.toString(), user.getPassword());
		user.withPassword(encryptedPassword).withSalt(salt.toString());

		user = repository.save(user);

		return user;
	}

	public User getUserById(long id) {
		final User user = repository.findOne(id);
		return user;
	}

	public SimpleUser getSimpleUserById(long id) {
		final SimpleUser user = repository.findOneSimple(id);
		return user;
	}

	public boolean deleteUser(long id) {
		repository.delete(id);
		return true;
	}

	public boolean deleteCurrentUser() {
		final User user = getCurrentUser();

		if (user == null)
			return false;

		repository.delete(user.getId());
		return true;
	}

	/**
	 * Sets the current user to anonymous.
	 */
	public void setAnonymous() {
		setCurrentUser(-1L, "<anonymous>");
	}

	/**
	 * Check if the current user is not authenticated.
	 *
	 * @return true if the user is not authenticated.
	 */
	public boolean isAnonymous() {
		return getCurrentUser().getId() == -1L;
	}

	/**
	 * Retrieve the currently active user or null, if no user is logged in.
	 *
	 * @return the current user.
	 */
	public User getCurrentUser() {
		return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	}

	/**
	 * Set a user for the current request.
	 *
	 * @param id    user id
	 * @param email user email
	 */
	public void setCurrentUser(Long id, String email) {
		final User user = new User();
		user.setId(id);
		user.setEmail(email);
		final UsernamePasswordAuthenticationToken secAuth = new UsernamePasswordAuthenticationToken(user, null);
		SecurityContextHolder.getContext().setAuthentication(secAuth);
	}

	/**
	 * get a list of all gender in database
	 * 
	 * @return List<Gender>
	 */

	public List<Gender> getAllGender() {
		return genderRepository.findAll();
	}

	/**
	 * add a drug to user remember list
	 * 
	 * @param drug
	 * @param user
	 */

	public boolean addDrugToUserTakingList(Drug drug) {

		drug = drugRepository.findOne(drug.getId());

		if (drug == null)
			return false;

		final User user = repository.findOne(getCurrentUser().getId());
		if (user == null)
			return false;

		user.withTakingDrug(drug);

		repository.save(user);

		return true;
	}

	/**
	 * add a drug to user remember list
	 * 
	 * @param drug
	 * @param user
	 */

	public boolean removeDrugFromUserTakingList(Drug drug) {

		drug = drugRepository.findOne(drug.getId());

		if (drug == null)
			return false;

		final User user = repository.findOne(getCurrentUser().getId());
		if (user == null)
			return false;

		user.withoutTakingDrug(drug);

		repository.save(user);

		return true;
	}

	/**
	 * add a drug to user remember list
	 * 
	 * @param drug
	 * @param user
	 */

	public boolean addDrugToUserRememberList(Drug drug) {

		drug = drugRepository.findOne(drug.getId());

		if (drug == null)
			return false;

		final User user = repository.findOne(getCurrentUser().getId());
		if (user == null)
			return false;

		user.withRememberedDrug(drug);

		repository.save(user);

		return true;
	}

	/**
	 * remove a drug from user favorites
	 * 
	 * @param drug
	 * @param user
	 */

	public boolean removeDrugFromUserRememberList(Drug drug) {

		drug = drugRepository.findOne(drug.getId());

		if (drug == null)
			return false;

		final User user = repository.findOne(getCurrentUser().getId());

		if (user == null)
			return false;

		user.withoutRememberedDrug(drug);

		repository.save(user);

		return true;
	}

	public User saveItemInvocation(ItemInvocation click) {
		final User user = repository.findOne(click.getUser().getId());

		if (user == null)
			return null;

		click.setUser(user);

		return repository.save(user);
	}

}
