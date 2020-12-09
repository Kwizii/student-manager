package fun.chanvo.page;

import cn.hutool.core.io.resource.ClassPathResource;
import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.StrUtil;
import fun.chanvo.entity.TbStudent;
import fun.chanvo.service.ITbStudentService;
import fun.chanvo.service.impl.TbStudentServiceImpl;
import fun.chanvo.util.SpringUtil;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.time.LocalDate;

public class StudentAddPage extends JDialog {

    private final JTextField fieldBirth;
    private final JTextField fieldNation;
    private final JTextField fieldSchoolYear;
    private final JTextField fieldSchoolDate;
    private final JTextField fieldKlass;
    private final JTextField fieldMajor;
    private final JTextField fieldSchoolNo;
    private final JTextField fieldName;
    private final JTextField fieldCollege;
    private final JTextField fieldPhone;
    private final JTextField fieldIdNo;
    private final JTextField fieldHometown;
    private final JTextField fieldAddr;
    private ITbStudentService studentService;

    private void initService() {
        studentService = SpringUtil.getContext().getBean(TbStudentServiceImpl.class);
    }

    public StudentAddPage() {
        initService();
        setTitle("学生录入");
        setIconImage(getToolkit().getImage(new ClassPathResource("images/usermanager.png").getAbsolutePath()));
        setModal(true);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        //设置窗口大小
        setBounds(100, 100, 600, 540);
        //设置居中显示
        setLocationRelativeTo(null);
        //设置不可编辑
        setResizable(false);
        JPanel contentPane = new JPanel();
        contentPane.setLayout(null);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        Border titleBorder = BorderFactory.createTitledBorder("学生录入");
        contentPane.setBorder(titleBorder);
        setContentPane(contentPane);
        JLabel labelTitle = new JLabel("学生录入");
        labelTitle.setBounds(210, 10, 142, 32);
        labelTitle.setFont(new Font("宋体", Font.PLAIN, 24));
        contentPane.add(labelTitle);

        JLabel label1 = new JLabel("学    号");
        label1.setBounds(50, 60, 80, 15);
        contentPane.add(label1);
        fieldSchoolNo = new JTextField();
        fieldSchoolNo.setBounds(110, 57, 150, 21);
        fieldSchoolNo.setColumns(10);
        contentPane.add(fieldSchoolNo);

        JLabel label2 = new JLabel("学生姓名");
        label2.setBounds(280, 60, 80, 15);
        contentPane.add(label2);
        fieldName = new JTextField();
        fieldName.setColumns(10);
        fieldName.setBounds(340, 57, 150, 21);
        contentPane.add(fieldName);

        JLabel label3 = new JLabel("性    别");
        label3.setBounds(50, 100, 80, 15);
        contentPane.add(label3);
        JRadioButton genderBoyRadio = new JRadioButton("男");
        genderBoyRadio.setBounds(110, 100, 50, 21);
        genderBoyRadio.setSelected(true);
        JRadioButton genderGirlRadio = new JRadioButton("女");
        genderGirlRadio.setBounds(200, 100, 50, 21);
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(genderBoyRadio);
        buttonGroup.add(genderGirlRadio);
        contentPane.add(genderBoyRadio);
        contentPane.add(genderGirlRadio);

        JLabel label4 = new JLabel("出生日期");
        label4.setBounds(280, 100, 80, 15);
        contentPane.add(label4);
        fieldBirth = new JTextField();
        fieldBirth.setColumns(10);
        fieldBirth.setBounds(340, 97, 150, 21);
        contentPane.add(fieldBirth);

        JLabel label5 = new JLabel("学    院");
        label5.setBounds(50, 140, 80, 15);
        contentPane.add(label5);
        fieldCollege = new JTextField();
        fieldCollege.setBounds(110, 137, 150, 21);
        fieldCollege.setColumns(10);
        contentPane.add(fieldCollege);

        JLabel label6 = new JLabel("专    业");
        label6.setBounds(280, 140, 80, 15);
        contentPane.add(label6);
        fieldMajor = new JTextField();
        fieldMajor.setColumns(10);
        fieldMajor.setBounds(340, 137, 150, 21);
        contentPane.add(fieldMajor);

        JLabel label7 = new JLabel("班    级");
        label7.setBounds(50, 180, 80, 15);
        contentPane.add(label7);
        fieldKlass = new JTextField();
        fieldKlass.setBounds(110, 177, 150, 21);
        fieldKlass.setColumns(10);
        contentPane.add(fieldKlass);

        JLabel label8 = new JLabel("入学年份");
        label8.setBounds(280, 180, 80, 15);
        contentPane.add(label8);
        fieldSchoolDate = new JTextField();
        fieldSchoolDate.setColumns(10);
        fieldSchoolDate.setBounds(340, 177, 150, 21);
        contentPane.add(fieldSchoolDate);

        JLabel label9 = new JLabel("学    制");
        label9.setBounds(50, 220, 80, 15);
        contentPane.add(label9);
        fieldSchoolYear = new JTextField();
        fieldSchoolYear.setBounds(110, 217, 150, 21);
        fieldSchoolYear.setColumns(10);
        contentPane.add(fieldSchoolYear);

        JLabel label10 = new JLabel("联系电话");
        label10.setBounds(280, 220, 80, 15);
        contentPane.add(label10);
        fieldPhone = new JTextField();
        fieldPhone.setColumns(10);
        fieldPhone.setBounds(340, 217, 150, 21);
        contentPane.add(fieldPhone);

        JLabel label11 = new JLabel("籍     贯");
        label11.setBounds(50, 260, 80, 15);
        contentPane.add(label11);
        fieldHometown = new JTextField();
        fieldHometown.setBounds(110, 257, 150, 21);
        fieldHometown.setColumns(10);
        contentPane.add(fieldHometown);

        JLabel label12 = new JLabel("民    族");
        label12.setBounds(280, 260, 80, 15);
        contentPane.add(label12);
        fieldNation = new JTextField();
        fieldNation.setColumns(10);
        fieldNation.setBounds(340, 257, 150, 21);
        contentPane.add(fieldNation);

        JLabel label13 = new JLabel("身份证号");
        label13.setBounds(50, 300, 80, 15);
        contentPane.add(label13);
        fieldIdNo = new JTextField();
        fieldIdNo.setColumns(10);
        fieldIdNo.setBounds(110, 297, 380, 21);
        contentPane.add(fieldIdNo);

        JLabel label14 = new JLabel("地    址");
        label14.setBounds(50, 340, 80, 15);
        contentPane.add(label14);
        fieldAddr = new JTextField();
        fieldAddr.setColumns(10);
        fieldAddr.setBounds(110, 337, 380, 21);
        contentPane.add(fieldAddr);

        JButton btnSubmit = new JButton("提交");
        //添加用户
        btnSubmit.addActionListener(e -> {
            //数据检查
            boolean check = StrUtil.isAllNotBlank(
                    fieldSchoolNo.getText(),
                    fieldName.getText(),
                    fieldCollege.getText(),
                    fieldMajor.getText(),
                    fieldKlass.getText(),
                    fieldSchoolDate.getText(),
                    fieldSchoolYear.getText(),
                    fieldPhone.getText(),
                    fieldBirth.getText(),
                    fieldHometown.getText(),
                    fieldNation.getText(),
                    fieldIdNo.getText(),
                    fieldAddr.getText());
            check = check && NumberUtil.isNumber(fieldSchoolYear.getText());
            if (!check) {
                JOptionPane.showMessageDialog(null, "填写错误，请重新填写", "提示", JOptionPane.ERROR_MESSAGE);
                return;
            }
            try {
                TbStudent student = new TbStudent();
                student.setSchoolNo(fieldSchoolNo.getText());
                student.setName(fieldName.getText());
                student.setCollege(fieldCollege.getText());
                student.setMajor(fieldMajor.getText());
                student.setKlass(fieldKlass.getText());
                student.setSchoolDate(LocalDate.parse(fieldSchoolDate.getText()));
                student.setSchoolYear(Integer.valueOf(fieldSchoolYear.getText()));
                student.setPhone(fieldPhone.getText());
                student.setBirth(LocalDate.parse(fieldBirth.getText()));
                student.setHometown(fieldHometown.getText());
                student.setNation(fieldNation.getText());
                student.setIdNo(fieldIdNo.getText());
                student.setAddress(fieldAddr.getText());
                student.setSex(genderBoyRadio.isSelected() ? 1 : 0);
                //注册
                boolean suc = studentService.save(student);
                if (suc) {
                    JOptionPane.showMessageDialog(null, "添加成功", "Message", JOptionPane.INFORMATION_MESSAGE);
                    setVisible(false);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "添加失败", "Message", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "修改失败，信息格式错误或学号重复", "操作失败", JOptionPane.ERROR_MESSAGE);
            }

        });

        btnSubmit.setBounds(70, 400, 90, 23);
        contentPane.add(btnSubmit);

        JButton btnReset = new JButton("取消");
        btnReset.setBounds(400, 400, 90, 23);
        contentPane.add(btnReset);
    }

}
