package gov.di_ipv_fraud.utilities;

public enum DrivingLicenceSubject implements TestInput {
    DrivingLicenceSubjectHappyPeter("PARKE610112PBFGH", "PARKER", "PETER", "BENJAMIN", "11", "10", "1962", "09", "12", "2062", "23", "05", "1982", "12", "BS98 1TL"),
    IncorrectDrivingLicenceNumber("PARKE610112PBFGI", "PARKER", "PETER", "BENJAMIN", "11", "10", "1962", "09", "12", "2062", "23", "05", "1982", "12", "BS98 1TL"),
    InvalidDrivingLicenceNumber("PARKE610102PBFGH", "PARKER", "PETER", "BENJAMIN", "11", "10", "1962", "09", "12", "2062", "23", "05", "1982", "12", "BS98 1TL"),
    IncorrectFirstName("PARKE610112PBFGH", "PARKER", "PETERE", "BENJAMIN", "11", "10", "1962", "09", "12", "2062", "23", "05", "1982", "12", "BS98 1TL"),
    IncorrectLastName("PARKE610112PBFGH", "PARKERINVALID", "PETER", "BENJAMIN", "11", "10", "1962", "09", "12", "2062", "23", "05", "1982", "12", "BS98 1TL"),
    IncorrectIssueDate("PARKE610112PBFGH", "PARKER", "PETER", "BENJAMIN", "11", "10", "1962", "09", "12", "2062", "01", "06", "1983", "12", "BS98 1TL"),
    IncorrectValidToDate("PARKE610112PBFGH", "PARKER", "PETER", "BENJAMIN", "11", "10", "1962", "11", "11", "2030", "23", "05", "1982", "12", "BS98 1TL"),
    IncorrectIssueNumber("PARKE610112PBFGH", "PARKER", "PETER", "BENJAMIN", "11", "10", "1962", "09", "12", "2062", "23", "05", "1982", "20", "BS98 1TL"),
    IncorrectPostcode("PARKE610112PBFGH", "PARKER", "PETER", "BENJAMIN", "11", "10", "1962", "09", "12", "2062", "23", "05", "1982", "12", "BS98 1AA"),
    IncorrectDateOfBirth("PARKE610112PBFGH", "PARKER", "PETER", "BENJAMIN", "09", "10", "1962", "09", "12", "2062", "23", "05", "1982", "12", "BS98 1TL"),
    InvalidLastNameWithNumbers("PARKE610112PBFGH", "PARKER123", "PETER", "BENJAMIN", "11", "10", "1962", "09", "12", "2062", "23", "05", "1982", "12", "BS98 1TL"),
    InvalidLastNameWithSpecialCharacters("PARKE610112PBFGH", "PARKER*$%", "PETER", "BENJAMIN", "11", "10", "1962", "09", "12", "2062", "23", "05", "1982", "12", "BS98 1TL"),
    NoLastName("PARKE610112PBFGH", "", "PETER", "BENJAMIN", "11", "10", "1962", "09", "12", "2062", "23", "05", "1982", "12", "BS98 1TL"),
    InvalidFirstNameWithNumbers("PARKE610112PBFGH", "PARKER", "PETERE987", "BENJAMIN", "11", "10", "1962", "09", "12", "2062", "23", "05", "1982", "12", "BS98 1TL"),
    InvalidFirstNameWithSpecialCharacters("PARKE610112PBFGH", "PARKER", "PETERE$£@", "BENJAMIN", "11", "10", "1962", "09", "12", "2062", "23", "05", "1982", "12", "BS98 1TL"),
    NoFirstName("PARKE610112PBFGH", "PARKER", "", "BENJAMIN", "11", "10", "1962", "09", "12", "2062", "23", "05", "1982", "12", "BS98 1TL"),
    InvalidMiddleNamesWithNumbers("PARKE610112PBFGH", "PARKER", "PETER", "BENJAMIN567", "11", "10", "1962", "09", "12", "2062", "23", "05", "1982", "12", "BS98 1TL"),
    InvalidMiddleNamesWithSpecialCharacters("PARKE610112PBFGH", "PARKER", "PETER", "BENJAMIN)(*", "11", "10", "1962", "09", "12", "2062", "23", "05", "1982", "12", "BS98 1TL"),
    InvalidDateOfBirth("PARKE610112PBFGH", "PARKER", "PETER", "BENJAMIN", "50", "72", "197", "09", "12", "2062", "23", "05", "1982", "12", "BS98 1TL"),
    DateOfBirthWithSpecialCharacters("PARKE610112PBFGH", "PARKER", "PETER", "BENJAMIN", "@", "%*", "19 7", "09", "12", "2062", "23", "05", "1982", "12", "BS98 1TL"),
    DateOfBirthInFuture("PARKE610112PBFGH", "PARKER", "PETER", "BENJAMIN", "10", "10", "2042", "09", "12", "2062", "23", "05", "1982", "12", "BS98 1TL"),
    NoDateOfBirth("PARKE610112PBFGH", "PARKER", "PETER", "BENJAMIN", "", "", "", "09", "12", "2062", "23", "05", "1982", "12", "BS98 1TL"),
    InvalidIssueDate("PARKE610112PBFGH", "PARKER", "PETER", "BENJAMIN", "11", "10", "1962", "09", "12", "2062", "AA", "BB", "ABCD", "12", "BS98 1TL"),
    IssueDateWithSpecialCharacters("PARKE610112PBFGH", "PARKER", "PETER", "BENJAMIN", "11", "10", "1962", "09", "12", "2062", "&^", "*£", "19 0", "12", "BS98 1TL"),
    IssueDateInFuture("PARKE610112PBFGH", "PARKER", "PETER", "BENJAMIN", "11", "10", "1962", "09", "12", "2062", "01", "02", "2042", "12", "BS98 1TL"),
    NoIssueDate("PARKE610112PBFGH", "PARKER", "PETER", "BENJAMIN", "11", "10", "1962", "09", "12", "2062", "", "", "", "12", "BS98 1TL"),
    InvalidValidToDate("PARKE610112PBFGH", "PARKER", "PETER", "BENJAMIN", "11", "10", "1962", "48", "10", "2030", "23", "05", "1982", "12", "BS98 1TL"),
    ValidToDateWithSpecialCharacters("PARKE610112PBFGH", "PARKER", "PETER", "BENJAMIN", "11", "10", "1962", "4*", "£$", "^&8", "23", "05", "1982", "12", "BS98 1TL"),
    ValidToDateInPast("PARKE610112PBFGH", "PARKER", "PETER", "BENJAMIN", "11", "10", "1962", "09", "12", "2000", "23", "05", "1982", "12", "BS98 1TL"),
    NoValidToDate("PARKE610112PBFGH", "PARKER", "PETER", "BENJAMIN", "11", "10", "1962", "", "", "", "23", "05", "1982", "12", "BS98 1TL"),
    DrivingLicenceNumLessThan16Char("PARKE6101", "PARKER", "PETER", "BENJAMIN", "11", "10", "1962", "09", "12", "2062", "23", "05", "1982", "12", "BS98 1TL"),
    DrivingLicenceNumberWithSpecialChar("PARKE£ %^&*^&*()", "PARKER", "PETER", "BENJAMIN", "11", "10", "1962", "09", "12", "2062", "23", "05", "1982", "12", "BS98 1TL"),
    DrivingLicenceNumberWithNumericChar("1234567890123456", "PARKER", "PETER", "BENJAMIN", "11", "10", "1962", "09", "12", "2062", "23", "05", "1982", "12", "BS98 1TL"),
    DrivingLicenceNumberWithAlphaChar("ABCDEFGHIJKLMNOP", "PARKER", "PETER", "BENJAMIN", "11", "10", "1962", "09", "12", "2062", "23", "05", "1982", "12", "BS98 1TL"),
    NoDrivingLicenceNumber("", "PARKER", "PETER", "BENJAMIN", "11", "10", "1962", "09", "12", "2062", "23", "05", "1982", "12", "BS98 1TL"),
    IssueNumberLessThan2Char("PARKE610112PBFGH", "PARKER", "PETER", "BENJAMIN", "11", "10", "1962", "09", "12", "2062", "23", "05", "1982", "1", "BS98 1TL"),
    IssueNumberWithSpecialChar("PARKE610112PBFGH", "PARKER", "PETER", "BENJAMIN", "11", "10", "1962", "09", "12", "2062", "23", "05", "1982", "$%", "BS98 1TL"),
    IssueNumberWithAlphanumericChar("PARKE610112PBFGH", "PARKER", "PETER", "BENJAMIN", "11", "10", "1962", "09", "12", "2062", "23", "05", "1982", "A1", "BS98 1TL"),
    IssueNumberWithAlphaChar("PARKE610112PBFGH", "PARKER", "PETER", "BENJAMIN", "11", "10", "1962", "09", "12", "2062", "23", "05", "1982", "AA", "BS98 1TL"),
    NoIssueNumber("PARKE610112PBFGH", "PARKER", "PETER", "BENJAMIN", "11", "10", "1962", "09", "12", "2062", "23", "05", "1982", "", "BS98 1TL"),
    PostcodeLessThan5Char("PARKE610112PBFGH", "PARKER", "PETER", "BENJAMIN", "11", "10", "1962", "09", "12", "2062", "23", "05", "1982", "12", "BS98"),
    PostcodeWithSpecialChar("PARKE610112PBFGH", "PARKER", "PETER", "BENJAMIN", "11", "10", "1962", "09", "12", "2062", "23", "05", "1982", "12", "B£$% 1$L"),
    PostcodeWithNumericChar("PARKE610112PBFGH", "PARKER", "PETER", "BENJAMIN", "11", "10", "1962", "09", "12", "2062", "23", "05", "1982", "12", "1234 567"),
    PostcodeWithAlphaChar("PARKE610112PBFGH", "PARKER", "PETER", "BENJAMIN", "11", "10", "1962", "09", "12", "2062", "23", "05", "1982", "12", "ABCD XYZ"),
    NoPostcode("PARKE610112PBFGH", "PARKER", "PETER", "BENJAMIN", "11", "10", "1962", "09", "12", "2062", "23", "05", "1982", "12", ""),
    InternationalPostcode("PARKE610112PBFGH", "PARKER", "PETER", "BENJAMIN", "11", "10", "1962", "09", "12", "2062", "23", "05", "1982", "12", "CA 95128");

    private String licenceNumber,
            lastName,
            firstName,
            middleNames,
            birthDay,
            birthMonth,
            birthYear,
            validToDay,
            validToMonth,
            validToYear,
            issueDay,
            issueMonth,
            issueYear,
            issueNumber,
            postcode;

    DrivingLicenceSubject(
            String licenceNumber,
            String lastName,
            String firstName,
            String middleNames,
            String birthDay,
            String birthMonth,
            String birthYear,
            String validToDay,
            String validToMonth,
            String validToYear,
            String issueDay,
            String issueMonth,
            String issueYear,
            String issueNumber,
            String postcode) {
        this.licenceNumber = licenceNumber;
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleNames = middleNames;
        this.birthDay = birthDay;
        this.birthMonth = birthMonth;
        this.birthYear = birthYear;
        this.validToDay = validToDay;
        this.validToMonth = validToMonth;
        this.validToYear = validToYear;
        this.issueDay = issueDay;
        this.issueMonth = issueMonth;
        this.issueYear = issueYear;
        this.issueNumber = issueNumber;
        this.postcode = postcode;
    }

    public String getlicenceNumber() {
        return licenceNumber;
    }

    public String getlastName() {
        return lastName;
    }

    public String getfirstName() {
        return firstName;
    }

    public String getmiddleNames() {
        return middleNames;
    }

    public String getbirthDay() {
        return birthDay;
    }

    public String getbirthMonth() {
        return birthMonth;
    }

    public String getbirthYear() {
        return birthYear;
    }

    public String getvalidtoDay() {
        return validToDay;
    }

    public String getvalidtoMonth() {
        return validToMonth;
    }

    public String getvalidtoYear() {
        return validToYear;
    }

    public String getlicenceIssueDay() {
        return issueDay;
    }

    public String getlicenceIssueMonth() {
        return issueMonth;
    }

    public String getlicenceIssueYear() {
        return issueYear;
    }

    public String getlicenceIssueNumber() {
        return issueNumber;
    }

    public String getpostcode() {
        return postcode;
    }
    
}