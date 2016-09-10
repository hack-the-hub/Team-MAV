package industries.mav.localbuddy;

public class Counsellor
{
    private String MemberFirstName;
    private String MemberLastName;
    private String MemberImageUrl;
    private String PartyAbbreviation;
    private String MemberTitle;
    private String ConstituencyName;

    public Counsellor() {}

    public Counsellor(String MemberFirstName, String MemberLastName, String MemberImageUrl, String PartyAbbreviation, String MemberTitle, String ConstituencyName)
    {
        this.MemberFirstName = MemberFirstName;
        this.MemberLastName = MemberLastName;
        this.MemberImageUrl = MemberImageUrl;
        this.PartyAbbreviation = PartyAbbreviation;
        this.MemberTitle = MemberTitle;
        this.ConstituencyName = ConstituencyName;
    }

    public void setMemberImageUrl(String MemberImageUrl) { this.MemberImageUrl = MemberImageUrl; }
    public void setPartyAbbreviation(String PartyAbbreviation) { this.PartyAbbreviation = PartyAbbreviation; }
    public void setMemberTitle(String MemberTitle) { this.MemberTitle = MemberTitle; }
    public void setConstituencyName(String ConstituencyName) { this.ConstituencyName = ConstituencyName; }


    public String getMemberFullName() { return (this.MemberFirstName + " " + this.MemberLastName); }
    public String getMemberImageUrl() { return this.MemberImageUrl; }
    public String getPartyAbbreviation() { return this.PartyAbbreviation; }
    public String getMemberTitle() { return this.MemberTitle; }
    public String getConstituencyName() { return this.ConstituencyName; }
}
