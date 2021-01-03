package org.jbsmit.blackboardRestClient.model;

import java.time.Instant;
import java.util.List;

public class User {
    /*
     * The primary ID of the user.
     */
    private String id;

    /*
     * A secondary unique ID for the user.  Used by LTI launches and other inter-server operations.
     */
    private String uuid;

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
     * The date this user was created.
     */
    private Instant created;

    /*
     * The date this user was last modified.
     */
    private Instant modified;

    /*
     * The date this user last logged in.
     */
    private Instant lastLogin;

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

        public Available getAvailable() {
            return available;
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

        public String getGiven() {
            return given;
        }

        public Name setGiven(String given) {
            this.given = given;
            return this;
        }

        public String getFamily() {
            return family;
        }

        public Name setFamily(String family) {
            this.family = family;
            return this;
        }

        public String getMiddle() {
            return middle;
        }

        public Name setMiddle(String middle) {
            this.middle = middle;
            return this;
        }

        public String getOther() {
            return other;
        }

        public Name setOther(String other) {
            this.other = other;
            return this;
        }

        public String getSuffix() {
            return suffix;
        }

        public Name setSuffix(String suffix) {
            this.suffix = suffix;
            return this;
        }

        public String getTitle() {
            return title;
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

        public String getTitle() {
            return title;
        }

        public Job setTitle(String title) {
            this.title = title;
            return this;
        }

        public String getDepartment() {
            return department;
        }

        public Job setDepartment(String department) {
            this.department = department;
            return this;
        }

        public String getCompany() {
            return company;
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

        public String getHomePhone() {
            return homePhone;
        }

        public Contact setHomePhone(String homePhone) {
            this.homePhone = homePhone;
            return this;
        }

        public String getMobilePhone() {
            return mobilePhone;
        }

        public Contact setMobilePhone(String mobilePhone) {
            this.mobilePhone = mobilePhone;
            return this;
        }

        public String getBusinessPhone() {
            return businessPhone;
        }

        public Contact setBusinessPhone(String businessPhone) {
            this.businessPhone = businessPhone;
            return this;
        }

        public String getBusinessFax() {
            return businessFax;
        }

        public Contact setBusinessFax(String businessFax) {
            this.businessFax = businessFax;
            return this;
        }

        public String getEmail() {
            return email;
        }

        public Contact setEmail(String email) {
            this.email = email;
            return this;
        }

        public String getWebPage() {
            return webPage;
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

        public String getStreet1() {
            return street1;
        }

        public Address setStreet1(String street1) {
            this.street1 = street1;
            return this;
        }

        public String getStreet2() {
            return street2;
        }

        public Address setStreet2(String street2) {
            this.street2 = street2;
            return this;
        }

        public String getCity() {
            return city;
        }

        public Address setCity(String city) {
            this.city = city;
            return this;
        }

        public String getState() {
            return state;
        }

        public Address setState(String state) {
            this.state = state;
            return this;
        }

        public String getZipCode() {
            return zipCode;
        }

        public Address setZipCode(String zipCode) {
            this.zipCode = zipCode;
            return this;
        }

        public String getCountry() {
            return country;
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

        public String getId() {
            return id;
        }

        public Locale setId(String id) {
            this.id = id;
            return this;
        }

        public Calendar getCalendar() {
            return calendar;
        }

        public Locale setCalendar(Calendar calendar) {
            this.calendar = calendar;
            return this;
        }

        public FirstDayOfWeek getFirstDayOfWeek() {
            return firstDayOfWeek;
        }

        public Locale setFirstDayOfWeek(FirstDayOfWeek firstDayOfWeek) {
            this.firstDayOfWeek = firstDayOfWeek;
            return this;
        }
    }

    public static class Avatar {
        /*
         * The location for retrieving the user's avatar
         *
         * **Since**: 3800.13.0
         */
        private String viewUrl;

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

        public String getViewUrl() {
            return viewUrl;
        }

        public Avatar setViewUrl(String viewUrl) {
            this.viewUrl = viewUrl;
            return this;
        }

        public Source getSource() {
            return source;
        }

        public Avatar setSource(Source source) {
            this.source = source;
            return this;
        }

        public String getUploadId() {
            return uploadId;
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

    public String getId() {
        return id;
    }

    public User setId(String id) {
        this.id = id;
        return this;
    }

    public String getUuid() {
        return uuid;
    }

    public User setUuid(String uuid) {
        this.uuid = uuid;
        return this;
    }

    public String getExternalId() {
        return externalId;
    }

    public User setExternalId(String externalId) {
        this.externalId = externalId;
        return this;
    }

    public String getDataSourceId() {
        return dataSourceId;
    }

    public User setDataSourceId(String dataSourceId) {
        this.dataSourceId = dataSourceId;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public User setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getStudentId() {
        return studentId;
    }

    public User setStudentId(String studentId) {
        this.studentId = studentId;
        return this;
    }

    public EducationLevel getEducationLevel() {
        return educationLevel;
    }

    public User setEducationLevel(EducationLevel educationLevel) {
        this.educationLevel = educationLevel;
        return this;
    }

    public Gender getGender() {
        return gender;
    }

    public User setGender(Gender gender) {
        this.gender = gender;
        return this;
    }

    public Instant getBirthDate() {
        return birthDate;
    }

    public User setBirthDate(Instant birthDate) {
        this.birthDate = birthDate;
        return this;
    }

    public Instant getCreated() {
        return created;
    }

    public User setCreated(Instant created) {
        this.created = created;
        return this;
    }

    public Instant getModified() {
        return modified;
    }

    public User setModified(Instant modified) {
        this.modified = modified;
        return this;
    }

    public Instant getLastLogin() {
        return lastLogin;
    }

    public User setLastLogin(Instant lastLogin) {
        this.lastLogin = lastLogin;
        return this;
    }

    public List<String> getInstitutionRoleIds() {
        return institutionRoleIds;
    }

    public User setInstitutionRoleIds(List<String> institutionRoleIds) {
        this.institutionRoleIds = institutionRoleIds;
        return this;
    }

    public List<SystemRoleEnum> getSystemRoleIds() {
        return systemRoleIds;
    }

    public User setSystemRoleIds(List<SystemRoleEnum> systemRoleIds) {
        this.systemRoleIds = systemRoleIds;
        return this;
    }

    public Availability getAvailability() {
        return availability;
    }

    public User setAvailability(Availability availability) {
        this.availability = availability;
        return this;
    }

    public Name getName() {
        return name;
    }

    public User setName(Name name) {
        this.name = name;
        return this;
    }

    public Job getJob() {
        return job;
    }

    public User setJob(Job job) {
        this.job = job;
        return this;
    }

    public Contact getContact() {
        return contact;
    }

    public User setContact(Contact contact) {
        this.contact = contact;
        return this;
    }

    public Address getAddress() {
        return address;
    }

    public User setAddress(Address address) {
        this.address = address;
        return this;
    }

    public Locale getLocale() {
        return locale;
    }

    public User setLocale(Locale locale) {
        this.locale = locale;
        return this;
    }

    public Avatar getAvatar() {
        return avatar;
    }

    public User setAvatar(Avatar avatar) {
        this.avatar = avatar;
        return this;
    }
}

