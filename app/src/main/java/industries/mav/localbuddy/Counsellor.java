package industries.mav.localbuddy;

public class Counsellor
{

    private String MemberName;
    private String MemberImageUrl;
    private String PartyAbbreviation;
    private String MemberTitle;
    private String ConstituencyName;

    public Counsellor(String MemberName, String MemberImageUrl, String PartyAbbreviation, String MemberTitle, String ConstituencyName)
    {
        this.MemberName = MemberName;
        this.MemberImageUrl = MemberImageUrl;
        this.PartyAbbreviation = PartyAbbreviation;
        this.MemberTitle = MemberTitle;
        this.ConstituencyName = ConstituencyName;
    }

    public void setMemberName(String MemberName) { this.MemberName = MemberName; }
    public void setMemberImageUrl(String MemberImageUrl) { this.MemberImageUrl = MemberImageUrl; }
    public void setPartyAbbreviation(String PartyAbbreviation) { this.PartyAbbreviation = PartyAbbreviation; }
    public void setMemberTitle(String MemberTitle) { this.MemberTitle = MemberTitle; }
    public void setConstituencyName(String ConstituencyName) { this.ConstituencyName = ConstituencyName; }


    public String getMemberName() { return this.MemberName; }
    public String getMemberImageUrl() { return this.MemberImageUrl; }
    public String getPartyAbbreviation() { return this.PartyAbbreviation; }
    public String getMemberTitle() { return this.MemberTitle; }
    public String getConstituencyName() { return this.ConstituencyName; }
}
