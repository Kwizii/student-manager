package fun.chanvo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import fun.chanvo.entity.TbStudent;

import java.io.IOException;
import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author Chanvo
 * @since 2020-12-09
 */
public interface ITbStudentService extends IService<TbStudent> {

    Object[][] getTableData();

    Object[][] getTableData(String input);

    String exportExcel(List<Integer> ids) throws IOException;
}
