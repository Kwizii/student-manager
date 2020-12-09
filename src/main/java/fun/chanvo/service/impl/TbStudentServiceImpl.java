package fun.chanvo.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import fun.chanvo.entity.TbStudent;
import fun.chanvo.mapper.TbStudentMapper;
import fun.chanvo.service.ITbStudentService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author Chanvo
 * @since 2020-12-09
 */
@Service
public class TbStudentServiceImpl extends ServiceImpl<TbStudentMapper, TbStudent> implements ITbStudentService {

    @Override
    public Object[][] getTableData() {
        return getTableData(null);
    }

    @Override
    public Object[][] getTableData(String input) {
        LambdaQueryWrapper<TbStudent> wrappers = new LambdaQueryWrapper<>();
        if (StrUtil.isNotBlank(input)) {
            wrappers.like(TbStudent::getName, input).or().like(TbStudent::getSchoolNo, input);
        }
        List<TbStudent> list = list(wrappers);
        Object[][] data = new Object[list.size()][20];
        for (int i = 0; i < list.size(); i++) {
            TbStudent s = list.get(i);
            data[i][0] = s.getId();
            data[i][1] = statusDesc(s.getStatus());
            data[i][2] = s.getSchoolNo();
            data[i][3] = s.getName();
            data[i][4] = s.getSex() == 1 ? "男" : "女";
            data[i][5] = s.getCollege();
            data[i][6] = s.getMajor();
            data[i][7] = s.getKlass();
            data[i][8] = s.getSchoolDate();
            data[i][9] = s.getSchoolYear();
            data[i][10] = s.getPhone();
            data[i][11] = s.getBirth();
            long age = s.getBirth().until(LocalDate.now(), ChronoUnit.YEARS);
            data[i][12] = age;
            data[i][13] = s.getHometown();
            data[i][14] = s.getNation();
            data[i][15] = s.getIdNo();
            data[i][16] = s.getAddress();
        }
        return data;
    }

    private String statusDesc(int status) {
        switch (status) {
            case 0:
                return "在读";
            case 1:
                return "毕业";
            case 2:
                return "休学";
            case 3:
                return "退学";
            default:
                return "UNKNOWN";
        }
    }
}
