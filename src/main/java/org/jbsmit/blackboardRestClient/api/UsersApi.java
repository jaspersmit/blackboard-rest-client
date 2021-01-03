package org.jbsmit.blackboardRestClient.api;

import com.google.gson.reflect.TypeToken;
import java.time.Instant;
import java.util.List;

import org.jbsmit.blackboardRestClient.model.Session;
import org.jbsmit.blackboardRestClient.model.SystemRoleEnum;
import org.jbsmit.blackboardRestClient.model.User;
import org.jbsmit.blackboardRestClient.agentsupport.RestCall;
import org.jbsmit.blackboardRestClient.agentsupport.RestCallBuilder;
import org.jbsmit.blackboardRestClient.agentsupport.RestCallOption;

public class UsersApi {
    /*
     * Get Users
     *
     * Returns a list of users.
     *
     * At least one of the entitlements 'system.user.VIEW' or 'user.VIEW' are needed.
     *
     * Note: Users with the 'SystemAdmin' role are only included in the results if the logged on user also has this role.
     *
     * **Since**: 3000.1.0
     */
    public static RestCall<List<User>> getUsers(GetUsersOption... options) {
        return RestCallBuilder
            .start(new TypeToken<List<User>>() {})
            .get()
            .url("/learn/api/public/v1/users")
            .options(options)
            .build();
    }

    public static class GetUsersOption extends RestCallOption {
        /*
         * Search for users with userName properties that contain this value.
         *
         * **Since**: 3000.11.0
         */
        public static GetUsersOption userName(String userName) {
            return parameter("userName", userName, new GetUsersOption());
        }

        /*
         * Search for users with externalId properties that contain this value.
         *
         * **Since**: 3000.11.0
         */
        public static GetUsersOption externalId(String externalId) {
            return parameter("externalId", externalId, new GetUsersOption());
        }

        /*
         * Search for users with a created date relative to this value.  'createdCompare' may also be sent to control search behavior.
         *
         * **Since**: 3000.11.0
         */
        public static GetUsersOption created(Instant created) {
            return parameter("created", created, new GetUsersOption());
        }

        /*
         * Search for users with a modified date relative to this value.  'modifiedCompare' may also be sent to control search behavior.
         *
         * **Since**: 3700.1.0
         */
        public static GetUsersOption modified(Instant modified) {
            return parameter("modified", modified, new GetUsersOption());
        }

        /*
         * Used alongside the 'created' search parameter.  Supported values:
         *
         * - lessThan
         * - greaterOrEqual
         *
         * Defaults to greaterOrEqual if not specified.
         *
         * **Since**: 3000.11.0
         *
         *
         * | Type      | Description
         *  | --------- | --------- |
         * | lessThan |  |
         * | greaterOrEqual |  |
         *
         */
        public static GetUsersOption createdCompare(String createdCompare) {
            return parameter("createdCompare", createdCompare, new GetUsersOption());
        }

        /*
         * Search for users with this dataSourceId.  This may optionally be the data source's externalId using the syntax "externalId:math101".
         *
         * **Since**: 3000.11.0
         */
        public static GetUsersOption dataSourceId(String dataSourceId) {
            return parameter("dataSourceId", dataSourceId, new GetUsersOption());
        }

        /*
         * Search for users with name.family properties that contain this value.
         *
         * **Since**: 3000.11.0
         */
        public static GetUsersOption name_family(String name_family) {
            return parameter("name.family", name_family, new GetUsersOption());
        }

        /*
         * Search for users with availability.available properties that contain this value.
         *
         * **Since**: 3100.0.0
         *
         *
         * | Type      | Description
         *  | --------- | --------- |
         * | Yes |  |
         * | No |  |
         * | Disabled |   **Since**: 3100.0.0 |
         *
         */
        public static GetUsersOption availability_available(String availability_available) {
            return parameter("availability.available", availability_available, new GetUsersOption());
        }

        /*
         * Properties to sort by. This is a comma-delimited list of JSON properties, with an optional "(desc)" suffix to request a descending sort for that property. e.g. "name.family(desc),created" Supported fields are:
         *
         * - userName
         * - name.family
         * - externalId
         * - dataSourceId
         * - created
         *
         * **Since**: 3100.0.0
         */
        public static GetUsersOption sort(String sort) {
            return parameter("sort", sort, new GetUsersOption());
        }
    }

    /*
     * Create User
     *
     * Creates a user.
     *
     * The 'system.user.CREATE' entitlement is needed.
     *
     * **Since**: 2015.11.0
     */
    public static RestCall<User> createUser(CreateUserBody input) {
        return RestCallBuilder
            .start(new TypeToken<User>() {})
            .post()
            .url("/learn/api/public/v1/users")
            .body(input)
            .build();
    }

    public static class CreateUserBody {
        /*
         * An optional externally-defined unique ID for the user.  Defaults to the userName.
         *
         * Formerly known as 'batchUid'.
         */
        private String externalId;

        /*
         * The ID of the data source associated with this user.  This may optionally be the data source's externalId using the syntax "externalId:math101".
         */
        private String dataSourceId;

        /*
         * The userName property, shown in the UI.
         */
        private String userName;

        /*
         * The user's student ID name or number as defined by the school or institution.
         */
        private String studentId;

        /*
         * The user's login password.
         */
        private String password;

        /*
         * The education level of this user.
         *
         *
         * | Type      | Description
         *  | --------- | --------- |
         * | K8 | Kindergarten through 8th grade |
         * | HighSchool | Grades 9 through 12. |
         * | Freshman | College or university freshman. |
         * | Sophomore | College or university sophomore. |
         * | Junior | College or university junior. |
         * | Senior | College or university senior. |
         * | GraduateSchool | Graduate school student. |
         * | PostGraduateSchool | Post-graduate school student. |
         * | Unknown | Education Level is not known, or not specified. |
         *
         */
        private EducationLevel educationLevel;

        /*
         * The gender of this user.
         *
         *
         * | Type      | Description
         *  | --------- | --------- |
         * | Female | Female |
         * | Male | Male |
         * | Unknown | Gender is not known, or not specified. |
         *
         */
        private Gender gender;

        /*
         * The birth date of this user.
         */
        private Instant birthDate;

        /*
         * The primary and secondary institution roles assigned to this user. The primary institution role is the first item in the list, followed by all secondary institution roles sorted alphabetically.
         *
         * **Since**: 3300.3.0
         */
        private List<String> institutionRoleIds;

        /*
         * The system roles (the administrative user roles in the UI) for this user.  The first role in this list is the user's primary system role, while the remaining are secondary system roles.
         */
        private List<SystemRoleEnum> systemRoleIds;

        /*
         * Settings controlling availability of the user account.
         */
        private Availability availability;

        /*
         * Properties used to build the user's display name.
         */
        private Name name;

        /*
         * The user's job information.
         */
        private Job job;

        /*
         * The user's contact information.
         */
        private Contact contact;

        /*
         * The user's mailing address.
         */
        private Address address;

        /*
         * The user's localization settings.
         */
        private Locale locale;

        /*
         * The user's avatar metadata
         *
         * **Since**: 3800.13.0
         */
        private Avatar avatar;

        public static CreateUserBody create() {
            return new CreateUserBody();
        }

        public static class Availability {
            /*
             * Whether the user is available within the system. Unavailable users cannot log in.
             *
             *
             * | Type      | Description
             *  | --------- | --------- |
             * | Yes |  |
             * | No |  |
             * | Disabled |   **Since**: 3100.0.0 |
             *
             */
            private Available available;

            public static Availability create() {
                return new Availability();
            }

            public enum Available {
                Yes,
                No,
                Disabled
            }

            public Availability setAvailable(Available available) {
                this.available = available;
                return this;
            }
        }

        public static class Name {
            /*
             * The given (first) name of this user.
             */
            private String given;

            /*
             * The family (last) name of this user.
             */
            private String family;

            /*
             * The middle name of this user.
             */
            private String middle;

            /*
             * The other name (nickname) of this user.
             */
            private String other;

            /*
             * The suffix of this user's name.  Examples: Jr., III, PhD.
             */
            private String suffix;

            /*
             * The title of this user.  Examples: Mr., Ms., Dr.
             */
            private String title;

            public static Name create() {
                return new Name();
            }

            public Name setGiven(String given) {
                this.given = given;
                return this;
            }

            public Name setFamily(String family) {
                this.family = family;
                return this;
            }

            public Name setMiddle(String middle) {
                this.middle = middle;
                return this;
            }

            public Name setOther(String other) {
                this.other = other;
                return this;
            }

            public Name setSuffix(String suffix) {
                this.suffix = suffix;
                return this;
            }

            public Name setTitle(String title) {
                this.title = title;
                return this;
            }
        }

        public static class Job {
            /*
             * The user's job title.
             */
            private String title;

            /*
             * The department the user belongs to.
             */
            private String department;

            /*
             * The company the user works for.
             */
            private String company;

            public static Job create() {
                return new Job();
            }

            public Job setTitle(String title) {
                this.title = title;
                return this;
            }

            public Job setDepartment(String department) {
                this.department = department;
                return this;
            }

            public Job setCompany(String company) {
                this.company = company;
                return this;
            }
        }

        public static class Contact {
            /*
             * The user's home phone number.
             */
            private String homePhone;

            /*
             * The user's mobile phone number.
             */
            private String mobilePhone;

            /*
             * The user's business phone number.
             */
            private String businessPhone;

            /*
             * The user's business fax number.
             */
            private String businessFax;

            /*
             * The user's email address.
             */
            private String email;

            /*
             * The URL of the user's personal website.
             */
            private String webPage;

            public static Contact create() {
                return new Contact();
            }

            public Contact setHomePhone(String homePhone) {
                this.homePhone = homePhone;
                return this;
            }

            public Contact setMobilePhone(String mobilePhone) {
                this.mobilePhone = mobilePhone;
                return this;
            }

            public Contact setBusinessPhone(String businessPhone) {
                this.businessPhone = businessPhone;
                return this;
            }

            public Contact setBusinessFax(String businessFax) {
                this.businessFax = businessFax;
                return this;
            }

            public Contact setEmail(String email) {
                this.email = email;
                return this;
            }

            public Contact setWebPage(String webPage) {
                this.webPage = webPage;
                return this;
            }
        }

        public static class Address {
            /*
             * The street address of the user.
             */
            private String street1;

            /*
             * An additional field to store the street address of the user.
             */
            private String street2;

            /*
             * The city the user resides in.
             */
            private String city;

            /*
             * The state or province the user resides in.
             */
            private String state;

            /*
             * The zip code or postal code the user resides in.
             */
            private String zipCode;

            /*
             * The country the user resides in.
             */
            private String country;

            public static Address create() {
                return new Address();
            }

            public Address setStreet1(String street1) {
                this.street1 = street1;
                return this;
            }

            public Address setStreet2(String street2) {
                this.street2 = street2;
                return this;
            }

            public Address setCity(String city) {
                this.city = city;
                return this;
            }

            public Address setState(String state) {
                this.state = state;
                return this;
            }

            public Address setZipCode(String zipCode) {
                this.zipCode = zipCode;
                return this;
            }

            public Address setCountry(String country) {
                this.country = country;
                return this;
            }
        }

        public static class Locale {
            /*
             * The locale specified by the user.  This locale will be used anywhere the user is allowed to customize their locale; courses may force a specific locale, overriding the user's locale preference.
             */
            private String id;

            /*
             * The calendar type specified by the user.
             *
             *
             * | Type      | Description
             *  | --------- | --------- |
             * | Gregorian | Gregorian |
             * | GregorianHijri | Gregorian & Hijri |
             * | Hijri | Hijri |
             * | HijriGregorian | Hijri & Gregorian |
             *
             */
            private Calendar calendar;

            /*
             * The user's preferred first day of the week.
             *
             *
             * | Type      | Description
             *  | --------- | --------- |
             * | Sunday | Sunday |
             * | Monday | Monday |
             * | Saturday | Saturday |
             *
             */
            private FirstDayOfWeek firstDayOfWeek;

            public static Locale create() {
                return new Locale();
            }

            public enum Calendar {
                Gregorian,
                GregorianHijri,
                Hijri,
                HijriGregorian
            }

            public enum FirstDayOfWeek {
                Sunday,
                Monday,
                Saturday
            }

            public Locale setId(String id) {
                this.id = id;
                return this;
            }

            public Locale setCalendar(Calendar calendar) {
                this.calendar = calendar;
                return this;
            }

            public Locale setFirstDayOfWeek(FirstDayOfWeek firstDayOfWeek) {
                this.firstDayOfWeek = firstDayOfWeek;
                return this;
            }
        }

        public static class Avatar {
            /*
             * The source of the user's avatar
             *
             * **Since**: 3800.13.0
             *
             *
             * | Type      | Description
             *  | --------- | --------- |
             * | Default | The server default avatar |
             * | User | The user set his/her own avatar |
             * | System | A privileged user set the user's avatar to something other than default |
             *
             */
            private Source source;

            /*
             * The upload id of the avatar image file
             *
             * **Since**: 3800.13.0
             */
            private String uploadId;

            public static Avatar create() {
                return new Avatar();
            }

            public enum Source {
                Default,
                User,
                System
            }

            public Avatar setSource(Source source) {
                this.source = source;
                return this;
            }

            public Avatar setUploadId(String uploadId) {
                this.uploadId = uploadId;
                return this;
            }
        }

        public enum EducationLevel {
            K8,
            HighSchool,
            Freshman,
            Sophomore,
            Junior,
            Senior,
            GraduateSchool,
            PostGraduateSchool,
            Unknown
        }

        public enum Gender {
            Female,
            Male,
            Unknown
        }

        public CreateUserBody setExternalId(String externalId) {
            this.externalId = externalId;
            return this;
        }

        public CreateUserBody setDataSourceId(String dataSourceId) {
            this.dataSourceId = dataSourceId;
            return this;
        }

        public CreateUserBody setUserName(String userName) {
            this.userName = userName;
            return this;
        }

        public CreateUserBody setStudentId(String studentId) {
            this.studentId = studentId;
            return this;
        }

        public CreateUserBody setPassword(String password) {
            this.password = password;
            return this;
        }

        public CreateUserBody setEducationLevel(EducationLevel educationLevel) {
            this.educationLevel = educationLevel;
            return this;
        }

        public CreateUserBody setGender(Gender gender) {
            this.gender = gender;
            return this;
        }

        public CreateUserBody setBirthDate(Instant birthDate) {
            this.birthDate = birthDate;
            return this;
        }

        public CreateUserBody setInstitutionRoleIds(List<String> institutionRoleIds) {
            this.institutionRoleIds = institutionRoleIds;
            return this;
        }

        public CreateUserBody setSystemRoleIds(List<SystemRoleEnum> systemRoleIds) {
            this.systemRoleIds = systemRoleIds;
            return this;
        }

        public CreateUserBody setAvailability(Availability availability) {
            this.availability = availability;
            return this;
        }

        public CreateUserBody setName(Name name) {
            this.name = name;
            return this;
        }

        public CreateUserBody setJob(Job job) {
            this.job = job;
            return this;
        }

        public CreateUserBody setContact(Contact contact) {
            this.contact = contact;
            return this;
        }

        public CreateUserBody setAddress(Address address) {
            this.address = address;
            return this;
        }

        public CreateUserBody setLocale(Locale locale) {
            this.locale = locale;
            return this;
        }

        public CreateUserBody setAvatar(Avatar avatar) {
            this.avatar = avatar;
            return this;
        }
    }

    /*
     * Get User
     *
     * Loads a user.
     *
     * Properties returned will depend on the caller's entitlements.
     *
     * Callers with the entitlement 'user.VIEW' will always get a minimal set of core properties:
     *
     * - id
     * - name.given
     * - name.family
     * - name.middle
     * - systemRoleIds
     *
     * Depending on the Learn administrator customizable user field display settings, as well as the target user's personal visibility settings, the following fields might also be included:
     *
     * - userName
     * - educationLevel
     * - gender
     * - birthDate
     * - name.other
     * - name.suffix
     * - name.title
     * - job.*
     * - contact.*
     * - address.*
     *
     * Callers asking for their own user record get all fields listed above, plus:
     *
     * - locale.*
     *
     * All user properties are provided to callers with one of the entitlements 'system.user.properties.MODIFY', 'system.useradmin.generic.VIEW', or 'system.user.VIEW'.
     *
     * **Since**: 2015.11.0
     */
    public static RestCall<User> getUser(String userId) {
        return RestCallBuilder
            .start(new TypeToken<User>() {})
            .get()
            .url("/learn/api/public/v1/users/{userId}")
            .pathParam("userId", userId)
            .build();
    }

    /*
     * Delete User
     *
     * Deletes a user.
     *
     * The 'system.user.DELETE' entitlement is needed.
     *
     * **Since**: 2015.11.0
     */
    public static RestCall<Void> deleteUser(String userId) {
        return RestCallBuilder
            .start(new TypeToken<Void>() {})
            .delete()
            .url("/learn/api/public/v1/users/{userId}")
            .pathParam("userId", userId)
            .build();
    }

    /*
     * Update User
     *
     * Updates a user.
     *
     * Callers may update their own user record if they have the 'self.user.MODIFY' entitlement.  Updating other users requires the 'system.user.properties.MODIFY' entitlement.
     *
     * Certain properties may be edited by callers with more finely grained entitlements:
     *
     *  | Field                  | Entitlements Required                               |
     *  |------------------------|-----------------------------------------------------|
     *  | systemRoleIds          | system.user.MODIFY, system.user-system-role.MODIFY  |
     *  | availability.available | system.user.MODIFY, system.user.availability.MODIFY |
     *  | password               | system.user.MODIFY, system.user-password.MODIFY     |
     *
     *
     * **Since**: 2015.11.0
     */
    public static RestCall<User> updateUser(String userId, UpdateUserBody input) {
        return RestCallBuilder
            .start(new TypeToken<User>() {})
            .patch()
            .url("/learn/api/public/v1/users/{userId}")
            .pathParam("userId", userId)
            .body(input)
            .build();
    }

    public static class UpdateUserBody {
        /*
         * An optional externally-defined unique ID for the user.  Defaults to the userName.
         *
         * Formerly known as 'batchUid'.
         */
        private String externalId;

        /*
         * The ID of the data source associated with this user.  This may optionally be the data source's externalId using the syntax "externalId:math101".
         */
        private String dataSourceId;

        /*
         * The userName property, shown in the UI.
         */
        private String userName;

        /*
         * The user's student ID name or number as defined by the school or institution.
         */
        private String studentId;

        /*
         * The user's login password.
         */
        private String password;

        /*
         * The education level of this user.
         *
         *
         * | Type      | Description
         *  | --------- | --------- |
         * | K8 | Kindergarten through 8th grade |
         * | HighSchool | Grades 9 through 12. |
         * | Freshman | College or university freshman. |
         * | Sophomore | College or university sophomore. |
         * | Junior | College or university junior. |
         * | Senior | College or university senior. |
         * | GraduateSchool | Graduate school student. |
         * | PostGraduateSchool | Post-graduate school student. |
         * | Unknown | Education Level is not known, or not specified. |
         *
         */
        private EducationLevel educationLevel;

        /*
         * The gender of this user.
         *
         *
         * | Type      | Description
         *  | --------- | --------- |
         * | Female | Female |
         * | Male | Male |
         * | Unknown | Gender is not known, or not specified. |
         *
         */
        private Gender gender;

        /*
         * The birth date of this user.
         */
        private Instant birthDate;

        /*
         * The primary and secondary institution roles assigned to this user. The primary institution role is the first item in the list, followed by all secondary institution roles sorted alphabetically.
         *
         * **Since**: 3300.3.0
         */
        private List<String> institutionRoleIds;

        /*
         * The system roles (the administrative user roles in the UI) for this user.  The first role in this list is the user's primary system role, while the remaining are secondary system roles.
         */
        private List<SystemRoleEnum> systemRoleIds;

        /*
         * Settings controlling availability of the user account.
         */
        private Availability availability;

        /*
         * Properties used to build the user's display name.
         */
        private Name name;

        /*
         * The user's job information.
         */
        private Job job;

        /*
         * The user's contact information.
         */
        private Contact contact;

        /*
         * The user's mailing address.
         */
        private Address address;

        /*
         * The user's localization settings.
         */
        private Locale locale;

        /*
         * The user's avatar metadata
         *
         * **Since**: 3800.13.0
         */
        private Avatar avatar;

        public static UpdateUserBody create() {
            return new UpdateUserBody();
        }

        public static class Availability {
            /*
             * Whether the user is available within the system. Unavailable users cannot log in.
             *
             *
             * | Type      | Description
             *  | --------- | --------- |
             * | Yes |  |
             * | No |  |
             * | Disabled |   **Since**: 3100.0.0 |
             *
             */
            private Available available;

            public static Availability create() {
                return new Availability();
            }

            public enum Available {
                Yes,
                No,
                Disabled
            }

            public Availability setAvailable(Available available) {
                this.available = available;
                return this;
            }
        }

        public static class Name {
            /*
             * The given (first) name of this user.
             */
            private String given;

            /*
             * The family (last) name of this user.
             */
            private String family;

            /*
             * The middle name of this user.
             */
            private String middle;

            /*
             * The other name (nickname) of this user.
             */
            private String other;

            /*
             * The suffix of this user's name.  Examples: Jr., III, PhD.
             */
            private String suffix;

            /*
             * The title of this user.  Examples: Mr., Ms., Dr.
             */
            private String title;

            public static Name create() {
                return new Name();
            }

            public Name setGiven(String given) {
                this.given = given;
                return this;
            }

            public Name setFamily(String family) {
                this.family = family;
                return this;
            }

            public Name setMiddle(String middle) {
                this.middle = middle;
                return this;
            }

            public Name setOther(String other) {
                this.other = other;
                return this;
            }

            public Name setSuffix(String suffix) {
                this.suffix = suffix;
                return this;
            }

            public Name setTitle(String title) {
                this.title = title;
                return this;
            }
        }

        public static class Job {
            /*
             * The user's job title.
             */
            private String title;

            /*
             * The department the user belongs to.
             */
            private String department;

            /*
             * The company the user works for.
             */
            private String company;

            public static Job create() {
                return new Job();
            }

            public Job setTitle(String title) {
                this.title = title;
                return this;
            }

            public Job setDepartment(String department) {
                this.department = department;
                return this;
            }

            public Job setCompany(String company) {
                this.company = company;
                return this;
            }
        }

        public static class Contact {
            /*
             * The user's home phone number.
             */
            private String homePhone;

            /*
             * The user's mobile phone number.
             */
            private String mobilePhone;

            /*
             * The user's business phone number.
             */
            private String businessPhone;

            /*
             * The user's business fax number.
             */
            private String businessFax;

            /*
             * The user's email address.
             */
            private String email;

            /*
             * The URL of the user's personal website.
             */
            private String webPage;

            public static Contact create() {
                return new Contact();
            }

            public Contact setHomePhone(String homePhone) {
                this.homePhone = homePhone;
                return this;
            }

            public Contact setMobilePhone(String mobilePhone) {
                this.mobilePhone = mobilePhone;
                return this;
            }

            public Contact setBusinessPhone(String businessPhone) {
                this.businessPhone = businessPhone;
                return this;
            }

            public Contact setBusinessFax(String businessFax) {
                this.businessFax = businessFax;
                return this;
            }

            public Contact setEmail(String email) {
                this.email = email;
                return this;
            }

            public Contact setWebPage(String webPage) {
                this.webPage = webPage;
                return this;
            }
        }

        public static class Address {
            /*
             * The street address of the user.
             */
            private String street1;

            /*
             * An additional field to store the street address of the user.
             */
            private String street2;

            /*
             * The city the user resides in.
             */
            private String city;

            /*
             * The state or province the user resides in.
             */
            private String state;

            /*
             * The zip code or postal code the user resides in.
             */
            private String zipCode;

            /*
             * The country the user resides in.
             */
            private String country;

            public static Address create() {
                return new Address();
            }

            public Address setStreet1(String street1) {
                this.street1 = street1;
                return this;
            }

            public Address setStreet2(String street2) {
                this.street2 = street2;
                return this;
            }

            public Address setCity(String city) {
                this.city = city;
                return this;
            }

            public Address setState(String state) {
                this.state = state;
                return this;
            }

            public Address setZipCode(String zipCode) {
                this.zipCode = zipCode;
                return this;
            }

            public Address setCountry(String country) {
                this.country = country;
                return this;
            }
        }

        public static class Locale {
            /*
             * The locale specified by the user.  This locale will be used anywhere the user is allowed to customize their locale; courses may force a specific locale, overriding the user's locale preference.
             */
            private String id;

            /*
             * The calendar type specified by the user.
             *
             *
             * | Type      | Description
             *  | --------- | --------- |
             * | Gregorian | Gregorian |
             * | GregorianHijri | Gregorian & Hijri |
             * | Hijri | Hijri |
             * | HijriGregorian | Hijri & Gregorian |
             *
             */
            private Calendar calendar;

            /*
             * The user's preferred first day of the week.
             *
             *
             * | Type      | Description
             *  | --------- | --------- |
             * | Sunday | Sunday |
             * | Monday | Monday |
             * | Saturday | Saturday |
             *
             */
            private FirstDayOfWeek firstDayOfWeek;

            public static Locale create() {
                return new Locale();
            }

            public enum Calendar {
                Gregorian,
                GregorianHijri,
                Hijri,
                HijriGregorian
            }

            public enum FirstDayOfWeek {
                Sunday,
                Monday,
                Saturday
            }

            public Locale setId(String id) {
                this.id = id;
                return this;
            }

            public Locale setCalendar(Calendar calendar) {
                this.calendar = calendar;
                return this;
            }

            public Locale setFirstDayOfWeek(FirstDayOfWeek firstDayOfWeek) {
                this.firstDayOfWeek = firstDayOfWeek;
                return this;
            }
        }

        public static class Avatar {
            /*
             * The source of the user's avatar
             *
             * **Since**: 3800.13.0
             *
             *
             * | Type      | Description
             *  | --------- | --------- |
             * | Default | The server default avatar |
             * | User | The user set his/her own avatar |
             * | System | A privileged user set the user's avatar to something other than default |
             *
             */
            private Source source;

            /*
             * The upload id of the avatar image file
             *
             * **Since**: 3800.13.0
             */
            private String uploadId;

            public static Avatar create() {
                return new Avatar();
            }

            public enum Source {
                Default,
                User,
                System
            }

            public Avatar setSource(Source source) {
                this.source = source;
                return this;
            }

            public Avatar setUploadId(String uploadId) {
                this.uploadId = uploadId;
                return this;
            }
        }

        public enum EducationLevel {
            K8,
            HighSchool,
            Freshman,
            Sophomore,
            Junior,
            Senior,
            GraduateSchool,
            PostGraduateSchool,
            Unknown
        }

        public enum Gender {
            Female,
            Male,
            Unknown
        }

        public UpdateUserBody setExternalId(String externalId) {
            this.externalId = externalId;
            return this;
        }

        public UpdateUserBody setDataSourceId(String dataSourceId) {
            this.dataSourceId = dataSourceId;
            return this;
        }

        public UpdateUserBody setUserName(String userName) {
            this.userName = userName;
            return this;
        }

        public UpdateUserBody setStudentId(String studentId) {
            this.studentId = studentId;
            return this;
        }

        public UpdateUserBody setPassword(String password) {
            this.password = password;
            return this;
        }

        public UpdateUserBody setEducationLevel(EducationLevel educationLevel) {
            this.educationLevel = educationLevel;
            return this;
        }

        public UpdateUserBody setGender(Gender gender) {
            this.gender = gender;
            return this;
        }

        public UpdateUserBody setBirthDate(Instant birthDate) {
            this.birthDate = birthDate;
            return this;
        }

        public UpdateUserBody setInstitutionRoleIds(List<String> institutionRoleIds) {
            this.institutionRoleIds = institutionRoleIds;
            return this;
        }

        public UpdateUserBody setSystemRoleIds(List<SystemRoleEnum> systemRoleIds) {
            this.systemRoleIds = systemRoleIds;
            return this;
        }

        public UpdateUserBody setAvailability(Availability availability) {
            this.availability = availability;
            return this;
        }

        public UpdateUserBody setName(Name name) {
            this.name = name;
            return this;
        }

        public UpdateUserBody setJob(Job job) {
            this.job = job;
            return this;
        }

        public UpdateUserBody setContact(Contact contact) {
            this.contact = contact;
            return this;
        }

        public UpdateUserBody setAddress(Address address) {
            this.address = address;
            return this;
        }

        public UpdateUserBody setLocale(Locale locale) {
            this.locale = locale;
            return this;
        }

        public UpdateUserBody setAvatar(Avatar avatar) {
            this.avatar = avatar;
            return this;
        }
    }

    /*
     * Get User Avatar
     *
     * Gets a user's avatar image.
     *
     * The response is a http redirect rather then image raw data. It is up to the caller of the api to follow the redirect and download the image.
     *
     * The redirect link returned is signed on behalf of the user of the API. It is expiring, so it is not recommended for bookmarking. The caller of this API is checked for permissions to see the requested user's resource.
     *
     * **Since**: 3800.10.0
     */
    public static RestCall<Void> getUserAvatar(String userId) {
        return RestCallBuilder
            .start(new TypeToken<Void>() {})
            .get()
            .url("/learn/api/public/v1/users/{userId}/avatar")
            .pathParam("userId", userId)
            .build();
    }

    /*
     * Get Observees
     *
     * Returns a list of users being observed by a given user.
     *
     * The 'observer.associations.VIEW' entitlement is needed as well as being able to view the provided user.
     *
     * **Since**: 3500.5.0
     */
    public static RestCall<List<User>> getObservees(String userId) {
        return RestCallBuilder
            .start(new TypeToken<List<User>>() {})
            .get()
            .url("/learn/api/public/v1/users/{userId}/observees")
            .pathParam("userId", userId)
            .build();
    }

    /*
     * Get Observers
     *
     * Returns a list of users observing a given user.
     *
     * The 'observer.associations.VIEW' entitlement is needed as well as being able to view the provided user.
     *
     * **Since**: 3500.5.0
     */
    public static RestCall<List<User>> getObservers(String userId) {
        return RestCallBuilder
            .start(new TypeToken<List<User>>() {})
            .get()
            .url("/learn/api/public/v1/users/{userId}/observers")
            .pathParam("userId", userId)
            .build();
    }

    /*
     * Delete Observer
     *
     * Removes an observer/observee association.
     *
     * The 'system.observer_user.DELETE' entitlement is needed as well as being able to view the provided users.
     *
     * **Since**: 3500.5.0
     */
    public static RestCall<Void> deleteObserver(String userId, String observerId) {
        return RestCallBuilder
            .start(new TypeToken<Void>() {})
            .delete()
            .url("/learn/api/public/v1/users/{userId}/observers/{observerId}")
            .pathParam("userId", userId)
            .pathParam("observerId", observerId)
            .build();
    }

    /*
     * Create Observer
     *
     * Creates an observer/observee association. The user identified by userId must not have the OBSERVER system role. Similarly, the user identified by observerId must have the OBSERVER system role.
     *
     * The 'system.observer_user.CREATE' entitlement is needed as well as being able to view the provided users.
     *
     * **Since**: 3500.5.0
     */
    public static RestCall<User> createObserver(String userId, String observerId) {
        return RestCallBuilder
            .start(new TypeToken<User>() {})
            .put()
            .url("/learn/api/public/v1/users/{userId}/observers/{observerId}")
            .pathParam("userId", userId)
            .pathParam("observerId", observerId)
            .build();
    }

    /*
     * Get Current Active User By Id
     *
     * Displays active session information for a specific user.
     *
     * The entitlement system.user.sessions.VIEW is needed to request a user's active sessions.
     *
     * **Since**: 3800.4.0
     */
    public static RestCall<List<Session>> getCurrentActiveUserById(String userId) {
        return RestCallBuilder
            .start(new TypeToken<List<Session>>() {})
            .get()
            .url("/learn/api/public/v1/users/{userId}/sessions")
            .pathParam("userId", userId)
            .build();
    }
}
