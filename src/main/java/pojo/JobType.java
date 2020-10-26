package pojo;

/**
 * 根据tb_type表字段封装一个实体类
 */

public class JobType {
    private Integer typeSign;//类型标记
    private String typeName;//类型名称
    private String typeIntro;//类型介绍

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

    @Override
    public String toString() {
        return "JobType{" +
                "typeSign=" + typeSign +
                ", typeName='" + typeName + '\'' +
                ", typeIntro='" + typeIntro + '\'' +
                '}';
    }
}
