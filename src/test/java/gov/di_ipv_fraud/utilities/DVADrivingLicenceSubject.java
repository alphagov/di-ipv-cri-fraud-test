package gov.di_ipv_fraud.utilities;

public enum DVADrivingLicenceSubject implements TestInput {
    DVADrivingLicenceSubjectHappyBilly(
            "55667788",
            "BATSON",
            "BILLY",
            "26",
            "07",
            "1981",
            "01",
            "10",
            "2042",
            "19",
            "04",
            "2001",
            "NW3 5RG"),
    DVADrivingLicenceSubjectUnhappySelina(
            "88776655",
            "KYLE",
            "SELINA",
            "12",
            "08",
            "1985",
            "04",
            "08",
            "2032",
            "14",
            "09",
            "2009",
            "E20 2AQ"),
    IncorrectDVADrivingLicenceNumber(
            "88776655",
            "BATSON",
            "BILLY",
            "26",
            "07",
            "1981",
            "01",
            "10",
            "2042",
            "19",
            "04",
            "2001",
            "NW3 5RG"),
    IncorrectDVADateOfBirth(
            "55667788",
            "BATSON",
            "BILLY",
            "12",
            "08",
            "1985",
            "01",
            "10",
            "2042",
            "19",
            "04",
            "2001",
            "NW3 5RG"),
    IncorrectDVALastName(
            "55667788",
            "KYLE",
            "BILLY",
            "26",
            "07",
            "1981",
            "01",
            "10",
            "2042",
            "19",
            "04",
            "2001",
            "NW3 5RG"),
    IncorrectDVAFirstName(
            "55667788",
            "BATSON",
            "SELINA",
            "26",
            "07",
            "1981",
            "01",
            "10",
            "2042",
            "19",
            "04",
            "2001",
            "NW3 5RG"),
    IncorrectDVAIssueDate(
            "55667788",
            "BATSON",
            "BILLY",
            "26",
            "07",
            "1981",
            "01",
            "10",
            "2042",
            "14",
            "09",
            "2009",
            "NW3 5RG"),
    IncorrectDVAValidToDate(
            "55667788",
            "BATSON",
            "BILLY",
            "26",
            "07",
            "1981",
            "04",
            "08",
            "2032",
            "19",
            "04",
            "2001",
            "NW3 5RG"),
    IncorrectDVAPostcode(
            "55667788",
            "BATSON",
            "BILLY",
            "26",
            "07",
            "1981",
            "01",
            "10",
            "2042",
            "19",
            "04",
            "2001",
            "E20 2AQ");
    private String dvaLicenceNumber,
            lastName,
            firstName,
            birthDay,
            birthMonth,
            birthYear,
            validToDay,
            validToMonth,
            validToYear,
            issueDay,
            issueMonth,
            issueYear,
            postcode;

    DVADrivingLicenceSubject(
            String dvaLicenceNumber,
            String lastName,
            String firstName,
            String birthDay,
            String birthMonth,
            String birthYear,
            String validToDay,
            String validToMonth,
            String validToYear,
            String issueDay,
            String issueMonth,
            String issueYear,
            String postcode) {
        this.dvaLicenceNumber = dvaLicenceNumber;
        this.lastName = lastName;
        this.firstName = firstName;
        this.birthDay = birthDay;
        this.birthMonth = birthMonth;
        this.birthYear = birthYear;
        this.validToDay = validToDay;
        this.validToMonth = validToMonth;
        this.validToYear = validToYear;
        this.issueDay = issueDay;
        this.issueMonth = issueMonth;
        this.issueYear = issueYear;
        this.postcode = postcode;
    }

    public String getDVAlicenceNumber() {
        return dvaLicenceNumber;
    }

    public String getlastName() {
        return lastName;
    }

    public String getfirstName() {
        return firstName;
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

    public String getpostcode() {
        return postcode;
    }
}
