package industries.mav.localbuddy;

public class Counsellor
{

    public String MemberName;
    public String MemberImageUrl;
    public String PartyAbbreviation;
    public String MemberTitle;
    public String ConstituencyName;

    public Counsellor(String MemberName, String MemberImageUrl, String party, String title, String constituency)
    {
        this.MemberName = MemberName;
        this.MemberImageUrl = MemberImageUrl;
        this.PartyAbbreviation = party;
        this.MemberTitle = title;
        this.ConstituencyName = constituency;
    }

    public void setMemberName(String name) { this.MemberName = name; }
    public void setMemberImageUrl(String imageURL) { this.MemberImageUrl = imageURL; }
    public void setPartyAbbreviation(String party) { this.PartyAbbreviation = party; }
    public void setMemberTitle(String title) { this.MemberTitle = title; }
    public void setConstituencyName(String constituency) { this.ConstituencyName = constituency; }

    public String getMemberName() { return this.MemberName; }
    public String getMemberImageUrl() { return this.MemberImageUrl; }
    public String getPartyAbbreviation() { return this.PartyAbbreviation; }
    public String getMemberTitle() { return this.MemberTitle; }
    public String getConstituencyName() { return this.ConstituencyName; }
}
