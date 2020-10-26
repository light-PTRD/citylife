package pojo;

import java.util.Date;

/**
 * 封装两个表的字段
 */
public class Info {
    private Integer infoId;//信息表的id
    private Integer infoType;//类型字段
    private String infoTitle;//信息标题
    private String linkMan;//联系人
    private String infoPhone;//联系电话
    private Date infoDate;//创建时间
    private String infoState;//信息状态
    private String infoContent;//信息内容
    private String infoEmail;//邮箱
    private Integer infoPayFor;//是否付款
    private Integer typeSign;//信息类型的id
    private String typeName;//信息类型名称
    private String typeIntro;//信息介绍
    private Integer adminId;//信息所属哪个用户

    public Integer getInfoId() {
        return infoId;
    }

    public void setInfoId(Integer infoId) {
        this.infoId = infoId;
    }

    public Integer getInfoType() {
        return infoType;
    }

    public void setInfoType(Integer infoType) {
        this.infoType = infoType;
    }

    public String getInfoTitle() {
        return infoTitle;
    }

    public void setInfoTitle(String infoTitle) {
        this.infoTitle = infoTitle;
    }

    public String getLinkMan() {
        return linkMan;
    }

    public void setLinkMan(String linkMan) {
        this.linkMan = linkMan;
    }

    public String getInfoPhone() {
        return infoPhone;
    }

    public void setInfoPhone(String infoPhone) {
        this.infoPhone = infoPhone;
    }

    public Date getInfoDate() {
        return infoDate;
    }

    public void setInfoDate(Date infoDate) {
        this.infoDate = infoDate;
    }

    public String getInfoState() {
        return infoState;
    }

    public void setInfoState(String infoState) {
        this.infoState = infoState;
    }

    public String getInfoContent() {
        return infoContent;
    }

    public void setInfoContent(String infoContent) {
        this.infoContent = infoContent;
    }

    public String getInfoEmail() {
        return infoEmail;
    }

    public void setInfoEmail(String infoEmail) {
        this.infoEmail = infoEmail;
    }

    public Integer getInfoPayFor() {
        return infoPayFor;
    }

    public void setInfoPayFor(Integer infoPayFor) {
        this.infoPayFor = infoPayFor;
    }

    public Integer getTypeSign() {
        return typeSign;
    }

    public void setTypeSign(Integer typeSign) {
        this.typeSign = typeSign;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getTypeIntro() {
        return typeIntro;
    }

    public void setTypeIntro(String typeIntro) {
        this.typeIntro = typeIntro;
    }

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    @Override
    public String toString() {
        return "Info{" +
                "infoId=" + infoId +
                ", infoType=" + infoType +
                ", infoTitle='" + infoTitle + '\'' +
                ", linkMan='" + linkMan + '\'' +
                ", infoPhone='" + infoPhone + '\'' +
                ", infoDate=" + infoDate +
                ", infoState='" + infoState + '\'' +
                ", infoContent='" + infoContent + '\'' +
                ", infoEmail='" + infoEmail + '\'' +
                ", infoPayFor=" + infoPayFor +
                ", typeSign=" + typeSign +
                ", typeName='" + typeName + '\'' +
                ", typeIntro='" + typeIntro + '\'' +
                ", adminId=" + adminId +
                '}';
    }
}
