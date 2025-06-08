
package org.automation.bug.ws.ws.error;

/**
 * Created by shantonu on 5/29/17.
 */
public interface ErrorMessages {

    String INVALID_CAPTCHA="Please enter valid security text";
    String INVALID_FIELD="Please enter valid field value";
    String REQUEST_VALIDATION_ERROR="Invalid request!";
    String FIELD_VALIDATION_ERROR="Please enter valid field value";
    String USER_UNAUTHORIZED="User not authorized to perform this operation!";
    String METHOD_NOT_ALLOWED="Request not allowed!";
    String ITEM_NOT_FOUND="Item not found";
    String USERNAME_ALREADY_EXISTS="User name already exist";
    String EMAIL_ALREADY_EXISTS="Email already exists";
    String USERNAME_AVAILABLE="User name available";
    String USER_ROLES_ALLOWED="User role allowed";
    String EMAIL_AVAILABLE="Email available";
    String USER_REGISTERED="User registered";
    String USER_ACTIVATED="User activated";
    String USER_INVITATION_EMAIL_SENT="User activation email sent";
    String USER_ALREADY_EXISTS="User already exists";
    String USER_DOES_NOT_EXIST="User does not exists";
    String USER_REGISTRATION_FAILED="User registration failed";
    String INVALID_EMAIL="Invalid email";
    String INVALID_USERNAME="Invalid user name";
    String USERNAME_AND_PASSWORD_REQUIRED="User name password required";
    String INVALID_USERNAME_OR_PASSWORD="Invalid user name or password";
    String CAPTCHA_REQUIRED="Please enter security text";
    String USERNAME_NOT_FOUND="User name not found";
    String USER_IS_DISABLED="User is disabled";
    String USER_DOES_NOT_HAVE_ACCESS="User does not have access";
    String USER_ROLE_DOES_NOT_PERMIT="User does not have permit";
    String USER_ROLE_ERROR="User role error";
    String INVALID_USERNAME_OR_EMAIL="Invalid user name or email";
    String USER_NOT_FOUND_BY_TOKEN="User not found by token";
    String USERNAME_OR_EMAIL_REQUIRED="User or email required";
    String TOKEN_IS_INVALID="Token is invalid";
    String TOKEN_IS_EXPIRED="Token is expired";
    String PASSWORDS_DONT_MATCH="Password did not match";
    String INVALID_OLD_PASSWORD="Invalid old password";
    String EMAILS_DOES_NOT_MATCH="Email does not match";
    String USER_HAS_BEEN_UPDATED="User has been updated";
    String USER_NOT_LOGGED_IN="User not logged in";
    String USER_MANUAL_NOT_FOUND="User manual not found";
    String STATIC_FILE_LOADING_ERROR="Static file loading error";
    String PROJECT_ALREADY_EXISTS="Project already exists";
    String INVALID_PROJECT="Invalid project";
    String INVALID_DATE_RANGE="Invalid date";
    String RESOURCE_LOADING_ERROR="Resource loading error";
    String ADDRESS_NOT_FOUND="Address not found";
    String INVALID_STATUS="Invalid status";
    String FILE_ALREADY_EXISTS="File already exists";
    String JSON_PARSE_ERROR="Json parse error";
    String FILE_NOT_FOUND="File not found";
    String PROJECT_DOES_NOT_EXIST="Project does not exists";
    String REQUEST_MEDIA_TYPE_NOT_SUPPORTED="Required media type not supported";
    String CATEGORY_NOT_FOUND="Category not supported";
    String USER_PROFILE_NOT_FOUND="User profile not found";
    String COMPANY_ALREADY_EXISTS="Company already exists";
    String COMPANY_DOES_NOT_EXIST="Company does not exists";
    String EMAIL_NOT_VERIFIED="Please verify your email first to invite other user";
    String UNKNOWN_SERVER_ERROR="Something went wrong in data processing! Please contact support@oworkpower.com";
    String TEAM_MEMBER_ALREADY_EXISTS="Team member already exists!";
    String SELECT_SUB_CATEGORY="Please select sub category first!";
    String SKILL_ALREADY_EXISTS="Skill already exists";
    String DELETE_PROFILE_ERROR_HAS_INVITATION="Could not delete profile which has invitation linked!";
    String DELETE_PROFILE_ERROR_HAS_ENDORSEMENT="Could not delete profile which has endorsement linked!";
    String DELETE_PROFILE_ERROR_HAS_JOB_APPLICATION="Could not delete profile which has job application linked!";
    String DELETE_COMPANY_ERROR_HAS_INVITATION="Could not delete company which has invitation!";
    String DELETE_COMPANY_ERROR_HAS_PROJECT="Could not delete company which has project!";
    String DELETE_COMPANY_ERROR_HAS_TEAM="Could not delete company which has team!";
    String DELETE_PROJECT_ERROR_HAS_JOB="Could not delete project which has job!";
    String DELETE_PROJECT_ERROR_HAS_TEAM="Could not delete project which has team!";
    String DELETE_PROJECT_ERROR_HAS_MANAGER_INVITATION="Could not delete project which has manager invitation!";
    String DELETE_PROJECT_ERROR_HAS_MANAGER="Could not delete project which has manager!";
    String DELETE_TEAM_ERROR_HAS_PROJECT="Could not delete team which has project!";
    String DELETE_TEAM_ERROR_HAS_MEMBERS="Could not delete team which has member!";
    String DELETE_TEAM_ERROR_HAS_INVITATIONS="Could not delete team which has invitation!";
    String DELETE_JOB_ERROR_HAS_CANDIDATE="Could not delete job which has candidate!";
    String DELETE_JOB_ERROR_HAS_HIRE="Could not delete job which has hire!";
    String DELETE_JOB_ERROR_HAS_CONTRACT="Could not delete job which has contract!";


}