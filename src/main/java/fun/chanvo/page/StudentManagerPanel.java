package fun.chanvo.page;

import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.StrUtil;
import fun.chanvo.entity.TbStudent;
import fun.chanvo.service.ITbStudentService;
import fun.chanvo.service.impl.TbStudentServiceImpl;
import fun.chanvo.util.SpringUtil;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @author Chanvo
 */
public class StudentManagerPanel extends JPanel {


    private ITbStudentService studentService;

    private final JTextField fieldBirth;
    private final JTextField fieldNation;
    private final JTextField fieldSchoolYear;
    private final JTextField fieldSchoolDate;
    private final JTextField fieldKlass;
    private final JTextField fieldMajor;
    private final JTextField fieldSearch;
    private final JTextField fieldId;
    private final JTextField fieldSchoolNo;
    private final JTextField fieldName;
    private final JTextField fieldCollege;
    private final JTextField fieldPhone;
    private final JTextField fieldIdNo;
    private final JTextField fieldHometown;
    private final JTextField fieldAddr;
    private final TableComponent table;
    private final JRadioButton radioButtonBoy;
    private final JRadioButton radioButtonGirl;

    private final Object[] columnNames = {"序号", "状态", "学号", "名字", "性别", "学院", "专业", "班级", "入学年份", "学制", "联系电话", "出生日期", "年龄", "籍贯", "民族", "身份证号", "住址"};
    private Object[][] rowData;

    public StudentManagerPanel() {
        initService();
        setBounds(0, 0, 1165, 730);
        setLayout(null);
        JButton studentAddBtn = new JButton("学生录入");
        // 添加员工
        studentAddBtn.addActionListener(e -> {
            StudentAddPage frame = new StudentAddPage();
            frame.setVisible(true);
        });
        studentAddBtn.setBounds(10, 10, 93, 23);
        add(studentAddBtn);
        JButton flushBtn = new JButton("刷新");
        flushBtn.setBounds(127, 10, 80, 23);
        add(flushBtn);

        fieldSearch = new JTextField("学号、姓名模糊搜索");
        fieldSearch.setBounds(236, 11, 389, 22);
        add(fieldSearch);
        fieldSearch.setColumns(10);

        JButton searchBtn = new JButton("搜索");
        searchBtn.addActionListener(e -> {
            //获取搜索框信息
            String input = fieldSearch.getText();
            //数据校验
            if (input == null || "".equals(input.trim())) {
                JOptionPane.showMessageDialog(null, "输入不能为空", "提示", JOptionPane.ERROR_MESSAGE);
                return;
            }
            //更新用户列表
            updateList(1, input);
        });
        searchBtn.setBounds(635, 10, 121, 23);
        add(searchBtn);

        JPanel studentListPanel = new JPanel();
        studentListPanel.setBorder(BorderFactory.createTitledBorder("学生列表"));
        studentListPanel.setBounds(10, 54, 746, 661);
        add(studentListPanel);

        // 设置表格数据
        rowData = studentService.getTableData();
        // 创建一个表格，指定 所有行数据 和 表头
        table = new TableComponent(rowData, columnNames);
        // 添加表头
        studentListPanel.add(table.getTableHeader());
        studentListPanel.setLayout(new BorderLayout(5, 5));
        JScrollPane scrollPane = new JScrollPane(table);
        // 将表格添加到滚动面板中
        studentListPanel.add(scrollPane);

        // 用户信息管理界面
        JPanel studentInfoPanel = new JPanel();
        studentInfoPanel.setBorder(BorderFactory.createTitledBorder("学生信息管理"));
        studentInfoPanel.setBounds(766, 54, 389, 661);
        add(studentInfoPanel);
        studentInfoPanel.setLayout(null);
        //设置管理
        JLabel labelId = new JLabel("序号");
        labelId.setBounds(37, 36, 54, 15);
        studentInfoPanel.add(labelId);
        fieldId = new JTextField();
        fieldId.setEnabled(false);
        fieldId.setBounds(101, 33, 263, 21);
        fieldId.setColumns(10);
        studentInfoPanel.add(fieldId);

        JLabel labelSchoolNo = new JLabel("学号");
        labelSchoolNo.setBounds(37, 66, 54, 15);
        studentInfoPanel.add(labelSchoolNo);
        fieldSchoolNo = new JTextField();
        fieldSchoolNo.setBounds(101, 63, 263, 21);
        fieldSchoolNo.setColumns(10);
        studentInfoPanel.add(fieldSchoolNo);

        JLabel labelName = new JLabel("学生姓名");
        labelName.setBounds(37, 106, 54, 15);
        studentInfoPanel.add(labelName);
        fieldName = new JTextField();
        fieldName.setBounds(101, 103, 263, 21);
        fieldName.setColumns(10);
        studentInfoPanel.add(fieldName);

        JLabel labelSex = new JLabel("用户性别");
        labelSex.setBounds(37, 146, 54, 15);
        studentInfoPanel.add(labelSex);
        radioButtonBoy = new JRadioButton("男");
        radioButtonBoy.setBounds(101, 143, 60, 21);
        studentInfoPanel.add(radioButtonBoy);
        radioButtonGirl = new JRadioButton("女");
        radioButtonGirl.setBounds(169, 143, 60, 21);
        studentInfoPanel.add(radioButtonGirl);
        ButtonGroup genderButtonGroup = new ButtonGroup();
        genderButtonGroup.add(radioButtonBoy);
        genderButtonGroup.add(radioButtonGirl);

        JLabel labelCollege = new JLabel("学院");
        labelCollege.setBounds(37, 190, 54, 15);
        studentInfoPanel.add(labelCollege);
        fieldCollege = new JTextField();
        fieldCollege.setBounds(101, 187, 263, 21);
        fieldCollege.setColumns(10);
        studentInfoPanel.add(fieldCollege);

        JLabel labelMajor = new JLabel("专业");
        labelMajor.setBounds(37, 230, 54, 15);
        studentInfoPanel.add(labelMajor);
        fieldMajor = new JTextField();
        fieldMajor.setBounds(101, 227, 263, 21);
        fieldMajor.setColumns(10);
        studentInfoPanel.add(fieldMajor);

        JLabel labelKlass = new JLabel("班级");
        labelKlass.setBounds(37, 270, 54, 15);
        studentInfoPanel.add(labelKlass);
        fieldKlass = new JTextField();
        fieldKlass.setBounds(101, 267, 263, 21);
        fieldKlass.setColumns(10);
        studentInfoPanel.add(fieldKlass);

        JLabel labelSchoolDate = new JLabel("入学年份");
        labelSchoolDate.setBounds(37, 300, 54, 15);
        studentInfoPanel.add(labelSchoolDate);
        fieldSchoolDate = new JTextField();
        fieldSchoolDate.setBounds(101, 297, 263, 21);
        fieldSchoolDate.setColumns(10);
        studentInfoPanel.add(fieldSchoolDate);

        JLabel labelSchoolYear = new JLabel("学制");
        labelSchoolYear.setBounds(37, 340, 54, 15);
        studentInfoPanel.add(labelSchoolYear);
        fieldSchoolYear = new JTextField();
        fieldSchoolYear.setBounds(101, 337, 263, 21);
        fieldSchoolYear.setColumns(10);
        studentInfoPanel.add(fieldSchoolYear);

        JLabel labelPhone = new JLabel("联系电话");
        labelPhone.setBounds(37, 370, 54, 15);
        studentInfoPanel.add(labelPhone);
        fieldPhone = new JTextField();
        fieldPhone.setColumns(10);
        fieldPhone.setBounds(101, 367, 263, 21);
        studentInfoPanel.add(fieldPhone);

        JLabel labelBirth = new JLabel("出生日期");
        labelBirth.setBounds(37, 410, 54, 15);
        studentInfoPanel.add(labelBirth);
        fieldBirth = new JTextField();
        fieldBirth.setColumns(10);
        fieldBirth.setBounds(101, 407, 263, 21);
        studentInfoPanel.add(fieldBirth);

        JLabel labelHomeTown = new JLabel("籍贯");
        labelHomeTown.setBounds(37, 440, 54, 15);
        studentInfoPanel.add(labelHomeTown);
        fieldHometown = new JTextField();
        fieldHometown.setColumns(10);
        fieldHometown.setBounds(101, 437, 263, 21);
        studentInfoPanel.add(fieldHometown);

        JLabel labelNation = new JLabel("民族");
        labelNation.setBounds(37, 470, 54, 15);
        studentInfoPanel.add(labelNation);
        fieldNation = new JTextField();
        fieldNation.setColumns(10);
        fieldNation.setBounds(101, 467, 263, 21);
        studentInfoPanel.add(fieldNation);

        JLabel labelIdNo = new JLabel("身份证");
        labelIdNo.setBounds(37, 510, 54, 15);
        studentInfoPanel.add(labelIdNo);
        fieldIdNo = new JTextField();
        fieldIdNo.setColumns(10);
        fieldIdNo.setBounds(101, 507, 263, 21);
        studentInfoPanel.add(fieldIdNo);

        JLabel labelAddr = new JLabel("地址");
        labelAddr.setBounds(37, 550, 54, 15);
        studentInfoPanel.add(labelAddr);
        fieldAddr = new JTextField();
        fieldAddr.setColumns(10);
        fieldAddr.setBounds(101, 547, 263, 21);
        studentInfoPanel.add(fieldAddr);

        JButton modBtn = new JButton("修改");
        modBtn.addActionListener(e -> {
            if (JOptionPane.showConfirmDialog(null, "确定修改？") == 0) {
                //id为空
                if (!NumberUtil.isNumber(fieldId.getText())) {
                    JOptionPane.showMessageDialog(null, "请选择一条要修改的信息", "提示", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                Integer id = Integer.valueOf(fieldId.getText());
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
                try{
                    TbStudent student = new TbStudent();
                    student.setId(id);
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
                    student.setSex(radioButtonBoy.isSelected() ? 1 : 0);
                    boolean result = studentService.updateById(student);
                    if (result) {
                        JOptionPane.showMessageDialog(null, "修改成功", "提示", JOptionPane.INFORMATION_MESSAGE);
                        clearField();
                        flushBtn.doClick();
                    } else {
                        JOptionPane.showMessageDialog(null, "修改失败", "提示", JOptionPane.ERROR_MESSAGE);
                    }
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null, "修改失败，信息格式错误或学号重复", "提示", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        modBtn.setBounds(37, 607, 93, 23);
        studentInfoPanel.add(modBtn);

        JButton delBtn = new JButton("删除");
        delBtn.addActionListener(e -> {
            if (JOptionPane.showConfirmDialog(null, "确定删除该用户？") == 0) {
                String id = fieldId.getText();
                if (StrUtil.isBlank(id)) {
                    JOptionPane.showMessageDialog(null, "请选择一个删除对象", "提示", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                boolean result = studentService.removeById(id);
                if (result) {
                    JOptionPane.showMessageDialog(null, "删除成功", "提示", JOptionPane.INFORMATION_MESSAGE);
                    clearField();
                    updateList(0, null);
                } else {
                    JOptionPane.showMessageDialog(null, "删除失败", "提示", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        delBtn.setBounds(271, 607, 93, 23);
        studentInfoPanel.add(delBtn);

        // 设置表格监听事件
        ListSelectionModel selectionModel = table.getSelectionModel();
        // 会响应两次，使用e.getValueIsAdjusting()判断，鼠标点击，getValueIsAdjusting() 返回True.
        // 鼠标释放,getValueIsAdjusting() 返回 False
        selectionModel.addListSelectionListener(e -> {
            if (e.getValueIsAdjusting()) {
                String str = e.getSource().toString();
                // 取出当前行
                String indexStr = str.substring(str.lastIndexOf("{") + 1, str.lastIndexOf("}"));
                if (!"".equals(str.trim()) && !"".equals(indexStr.trim())) {
                    // 获取当前行序号
                    int index = Integer.parseInt(indexStr);
                    Integer id = (Integer) rowData[index][0];
                    // 获取选中的用户信息
                    TbStudent selectStudent = studentService.getById(id);
                    if (selectStudent == null) {
                        JOptionPane.showMessageDialog(null, "查找出错", "提示", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    // 封装数据
                    fieldId.setText(selectStudent.getId().toString());
                    fieldSchoolNo.setText(selectStudent.getSchoolNo());
                    fieldName.setText(selectStudent.getName());
                    fieldCollege.setText(selectStudent.getCollege());
                    fieldMajor.setText(selectStudent.getMajor());
                    fieldKlass.setText(selectStudent.getKlass());
                    fieldSchoolDate.setText(selectStudent.getSchoolDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
                    fieldSchoolYear.setText(selectStudent.getSchoolYear().toString());
                    fieldPhone.setText(selectStudent.getPhone());
                    fieldBirth.setText(selectStudent.getBirth().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
                    fieldHometown.setText(selectStudent.getHometown());
                    fieldNation.setText(selectStudent.getNation());
                    fieldIdNo.setText(selectStudent.getIdNo());
                    fieldAddr.setText(selectStudent.getAddress());
                    //封装身份
                    if (selectStudent.getSex() == 1) {
                        radioButtonBoy.setSelected(true);
                    } else {
                        radioButtonGirl.setSelected(true);
                    }

                }
            }
        });
        flushBtn.addActionListener(e -> updateList(0, null));
    }

    private void updateList(int type, String input) {
        if (type == 0) {
            rowData = studentService.getTableData();
        }
        if (type == 1) {
            rowData = studentService.getTableData(input);
        }
        table.updateModel(rowData, columnNames);
        clearField();
    }

    /**
     * 清空输入框数据
     */
    private void clearField() {
        fieldId.setText("");
        fieldSchoolNo.setText("");
        fieldName.setText("");
        fieldCollege.setText("");
        fieldMajor.setText("");
        fieldKlass.setText("");
        fieldSchoolDate.setText("");
        fieldSchoolYear.setText("");
        fieldPhone.setText("");
        fieldBirth.setText("");
        fieldHometown.setText("");
        fieldNation.setText("");
        fieldIdNo.setText("");
        fieldAddr.setText("");
        radioButtonBoy.setSelected(true);
    }

    private void initService() {
        studentService = SpringUtil.getContext().getBean(TbStudentServiceImpl.class);
    }
}