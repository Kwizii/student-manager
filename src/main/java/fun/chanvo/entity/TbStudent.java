package fun.chanvo.entity;

import java.time.LocalDate;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 *
 * </p>
 *
 * @author Chanvo
 * @since 2020-12-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class TbStudent implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    private Integer id;
    /**
     * 姓名
     */
    private String name;

    /**
     * 出生日期
     */
    private LocalDate birth;

    /**
     * 性别
     */
    private Integer sex;

    /**
     * 民族
     */
    private String nation;

    /**
     * 籍贯
     */
    private String hometown;

    /**
     * 入学年份
     */
    private LocalDate schoolDate;

    /**
     * 学院
     */
    private String college;

    /**
     * 班级
     */
    private String klass;

    /**
     * 专业
     */
    private String major;

    /**
     * 学制
     */
    private Integer schoolYear;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 学号
     */
    private String schoolNo;

    /**
     * 身份证号
     */
    private String idNo;

    /**
     * 家庭住址
     */
    private String address;

    /**
     * 手机号
     */
    private String phone;


}
