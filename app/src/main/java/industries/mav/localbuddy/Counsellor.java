package industries.mav.localbuddy;

import android.util.Log;

public class Counsellor
{
    private String MemberFirstName;
    private String MemberLastName;
    private String MemberImgUrl;
    private String PartyAbbreviation;
    private String MemberTitle;
    private String ConstituencyName;
    private String TwitterHandle;

    private HandlerFinder hFinder = null;

    public Counsellor() {}

    public Counsellor(String MemberFirstName, String MemberLastName, String MemberImgUrl, String PartyAbbreviation, String MemberTitle, String ConstituencyName)
    {
        this.MemberFirstName = MemberFirstName;
        this.MemberLastName = MemberLastName;
        this.MemberImgUrl = MemberImgUrl;
        this.PartyAbbreviation = PartyAbbreviation;
        this.MemberTitle = MemberTitle;
        this.ConstituencyName = ConstituencyName;
    }

    public void setMemberImageUrl(String MemberImageUrl) { this.MemberImgUrl = MemberImageUrl; }
    public void setPartyAbbreviation(String PartyAbbreviation) { this.PartyAbbreviation = PartyAbbreviation; }
    public void setMemberTitle(String MemberTitle) { this.MemberTitle = MemberTitle; }
    public void setConstituencyName(String ConstituencyName) { this.ConstituencyName = ConstituencyName; }
    public void setHandle(String handle) { this.TwitterHandle = handle; }


    public String getMemberFirstName() { return this.MemberFirstName; }
    public String getMemberLastName() { return this.MemberLastName; }
    public String getMemberFullName() { return this.getMemberFirstName() + " " + this.getMemberLastName(); }
    public String getMemberImgUrl() { return this.MemberImgUrl; }
    public String getPartyAbbreviation() { return this.PartyAbbreviation.toUpperCase(); }
    public String getMemberTitle() { return this.MemberTitle; }
    public String getConstituencyName() { return this.ConstituencyName; }
    public String getTwitterHandle() { return this.TwitterHandle; }


}
