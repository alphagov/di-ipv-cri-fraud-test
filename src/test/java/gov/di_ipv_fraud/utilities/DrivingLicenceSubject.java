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
    IncorrectDateOfBirth("PARKE610112PBFGH", "PARKER", "PETER", "BENJAMIN", "09", "10", "1962", "09", "12", "2062", "23", "05", "1982", "12", "BS98 1TL");

    private String licenceNumber, lastName, firstName, middleNames, birthDay, birthMonth, birthYear, validToDay, validToMonth, validToYear, issueDay, issueMonth, issueYear, issueNumber, postcode;


    DrivingLicenceSubject(String licenceNumber, String lastName, String firstName, String middleNames, String birthDay, String birthMonth, String birthYear, String validToDay, String validToMonth, String validToYear, String issueDay, String issueMonth, String issueYear, String issueNumber, String postcode ) {
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