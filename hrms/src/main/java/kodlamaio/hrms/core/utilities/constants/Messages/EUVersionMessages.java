package kodlamaio.hrms.core.utilities.constants.Messages;



public class EUVersionMessages {
	
	//General
	public static String NationalityIdentityAlreadyExist = "This nationality identity already exists";

	// JobPosition
	public static String JobPositionListed = "Job positions listed.";
	public static String JobPositionListedById = "Job position list by id.";
	public static String ErrorJobPositionNotFound = "Job position not found.";
	public static String JobPositionAdded = "Job position added.";
	public static String JobPositionDeleted = "Job position deleted.";
	public static String JobPositionUpdated = "Job position updated.";
	public static String ErrorWithTheSameName = "Two jobs position with the same name cannot be created.";

	// Candidate
	public static String CandidatesListed = "Candidates listed.";
	public static String CandidateListedById = "Candidate list by id.";
	public static String CandidateAdded = "Candidate added.";
	public static String CandidateDeleted = "Candidate deleted.";
	public static String CandidateUpdated = "Candidate updated.";
	public static String ErrorCandidatesExist = "Email and nationality identity ID is exists.";
	public static String ErrorCandidateNotFound = "Candidate not found.";
	public static String ErrorCandidateEmailInvalid = "Candidate's email is invalid.";
	public static String CandidateAddedButVerificationRequired = "The job seeker registration is successful. Please verify your account with the verification link sent to your e-mail address. (NOTE: You cannot login without verification)";

	// Employer
	public static String EmployersListed = "Employers listed.";
	public static String EmployerListedById = "Employer list by id.";
	public static String ErrorEmployerNotFound = "Employer not found.";
	public static String EmployerAdded = "Employer added.";
	public static String EmployerDeleted = "Employer deleted.";
	public static String EmployerUpdated = "Employer updated.";
	public static String ErrorEmployerEmailInvalid = "Employer email is invalid.";
	public static String ErrorEmployerUnconfirmed = "This mployer does not have employee confirmation.";
	public static String ErrorEmployerExists = "Employer exists.";

	// Auth
	public static String ErrorAllInfoNotEntered= "All information must be entered.";
	public static String ErrorPasswordConfirm = "Passwords do not match.";

	// Verification
	public static String ErrorVerificationCodeUnmatched= "Verification code does not match.";
	public static String EmployerConfirmationIsDelayed= "Employer confirmation is delayed.";
	public static String EmployerConfirmationIsDenied = "Employer confirmation is denied";
	public static String EmployerConfirmationIsAccepted = "Employer confirmation is accepted.";

	// City
	public static String CitiesListed = "Cities listed.";
	public static String CityAdded = "City added.";

	// JobAdvertisement
	public static String JobAdvertisementListed = "Job advertisement listed..";
	public static String JobAdvertisementListedByActive = "Job advertisement listed by active.";
	public static String JobAdvertisementSortedByActive = "Job advertisement sorted by active.";
	public static String JobAdvertisementListedByEmployerIdActive = "Job advertisement listed by employer id and active.";
	public static String JobAdvertisementPagedByActive = "Job advertisement paged by active.";
	public static String JobAdvertisementDtoListed = "Job advertisement dto listed.";
	
	

}
