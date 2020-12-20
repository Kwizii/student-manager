package fun.chanvo.entity;

import java.time.LocalDate;
import java.io.Serializable;

import cn.afterturn.easypoi.excel.annotation.Excel;
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
    @Excel(name = "序号")
    private Integer id;
    /**
     * 姓名
     */
    @Excel(name = "姓名")
    private String name;

    /**
     * 出生日期
     */
    @Excel(name = "出生日期", format = "yyyy年MM月dd日")
    private LocalDate birth;

    /**
     * 性别
     */
    @Excel(name = "性别", replace = {"男_1", "女_0"})
    private Integer sex;

    /**
     * 民族
     */
    @Excel(name = "民族")
    private String nation;

    /**
     * 籍贯
     */
    @Excel(name = "籍贯")
    private String hometown;

    /**
     * 入学年份
     */
    @Excel(name = "入学日期", format = "yyyy年MM月dd日")
    private LocalDate schoolDate;

    /**
     * 学院
     */
    @Excel(name = "学院")
    private String college;

    /**
     * 班级
     */
    @Excel(name = "班级")
    private String klass;

    /**
     * 专业
     */
    @Excel(name = "专业")
    private String major;

    /**
     * 学制
     */
    @Excel(name = "学制", suffix = "年")
    private Integer schoolYear;

    /**
     * 状态
     */
    @Excel(name = "状态", replace = {"在读_0", "休学_1", "退学_2"})
    private Integer status;

    /**
     * 学号
     */
    @Excel(name = "学号")
    private String schoolNo;

    /**
     * 身份证号
     */
    @Excel(name = "身份证号")
    private String idNo;

    /**
     * 家庭住址
     */
    @Excel(name = "家庭住址")
    private String address;

    /**
     * 手机号
     */
    @Excel(name = "手机号")
    private String phone;


}
