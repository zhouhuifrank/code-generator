package com.frankzhou.intelligence.bi.dao;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.frankzhou.common.base.ApiPageResultDTO;
import com.frankzhou.intelligence.bi.common.constants.IntelligenceBiConstant;
import com.frankzhou.intelligence.bi.domain.dto.chart.BiChartDTO;
import com.frankzhou.intelligence.bi.domain.dto.chart.BiChartQueryDTO;
import com.frankzhou.intelligence.bi.domain.entity.BiChart;
import com.frankzhou.intelligence.bi.mapper.BiChartMapper;
import jakarta.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description bi图表管理dao层
 * @date 2024-03-10
 */
@Component
public class BiChartDao extends ServiceImpl<BiChartMapper, BiChart> {

    @Resource
    private BiChartMapper biChartMapper;

    public boolean saveChart(BiChartDTO chartDTO) {
        BiChart chart = new BiChart();
        BeanUtils.copyProperties(chartDTO, chart);
        boolean success = this.save(chart);
        chartDTO.setId(chart.getId());
        return success;
    }

    public boolean updateChart(BiChartDTO chartDTO) {
        BiChart chart = new BiChart();
        BeanUtils.copyProperties(chartDTO, chart);
        return this.updateById(chart);
    }

    public List<BiChartDTO> queryChartList(BiChartQueryDTO queryDTO) {
        LambdaQueryWrapper<BiChart> queryWrapper = getQueryWrapper(queryDTO);
        List<BiChart> biChartList = biChartMapper.selectList(queryWrapper);

        List<BiChartDTO> chartDTOList = new ArrayList<>();
        for (BiChart chart : biChartList) {
            BiChartDTO chartDTO = new BiChartDTO();
            BeanUtils.copyProperties(chart, chartDTO);
            chartDTOList.add(chartDTO);
        }
        return chartDTOList;
    }

    public ApiPageResultDTO<List<BiChartDTO>> queryChartPage(BiChartQueryDTO queryDTO) {
        queryDTO.setStartRow((queryDTO.getCurrPage()-1)* queryDTO.getPageSize());
        String sort = queryDTO.getSort();
        boolean isAsc = sort.equals(IntelligenceBiConstant.SORT_ASC) ? true : false;
        LambdaQueryWrapper<BiChart> queryWrapper = getQueryWrapper(queryDTO);
        queryWrapper.orderBy(StrUtil.isNotBlank(queryDTO.getOrderBy()), isAsc, BiChart::getCreateTime);

        Page<BiChart> chartPage = new Page<>(queryDTO.getCurrPage(), queryDTO.getPageSize());
        chartPage = biChartMapper.selectPage(chartPage, queryWrapper);
        Integer totalCount = Integer.valueOf(String.valueOf(chartPage.getTotal()));
        Integer pageCount = Integer.valueOf(String.valueOf(chartPage.getPages()));
        List<BiChart> chartList = chartPage.getRecords();

        List<BiChartDTO> chartDTOList = new ArrayList<>();
        for (BiChart chart : chartList) {
            BiChartDTO chartDTO = new BiChartDTO();
            BeanUtils.copyProperties(chart, chartDTO);
            chartDTOList.add(chartDTO);
        }
        return ApiPageResultDTO.getSuccessPageResult(pageCount, chartDTOList);
    }

    private LambdaQueryWrapper<BiChart> getQueryWrapper(BiChartQueryDTO queryDTO) {
        LambdaQueryWrapper<BiChart> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(StrUtil.isNotBlank(queryDTO.getChartNo()), BiChart::getChartNo, queryDTO.getChartNo())
                .eq(StrUtil.isNotBlank(queryDTO.getChartName()), BiChart::getChartName, queryDTO.getChartName())
                .likeRight(StrUtil.isNotBlank(queryDTO.getChartNameLike()), BiChart::getChartName, queryDTO.getChartNameLike())
                .eq(StrUtil.isNotBlank(queryDTO.getTableNo()), BiChart::getTableNo, queryDTO.getTableNo())
                .in(CollectionUtil.isNotEmpty(queryDTO.getTableNoIn()), BiChart::getTableNo, queryDTO.getTableNoIn())
                .eq(StrUtil.isNotBlank(queryDTO.getChartType()), BiChart::getChartType, queryDTO.getChartType())
                .in(CollectionUtil.isNotEmpty(queryDTO.getChartTypeIn()), BiChart::getChartType, queryDTO.getChartTypeIn())
                .eq(ObjectUtil.isNotNull(queryDTO.getChartStatus()), BiChart::getChartStatus, queryDTO.getChartStatus())
                .in(CollectionUtil.isNotEmpty(queryDTO.getChartStatusIn()), BiChart::getChartStatus, queryDTO.getChartStatusIn())
                .eq(StrUtil.isNotBlank(queryDTO.getCreateUser()), BiChart::getCreateUser, queryDTO.getCreateUser());
        return wrapper;
    }
}
