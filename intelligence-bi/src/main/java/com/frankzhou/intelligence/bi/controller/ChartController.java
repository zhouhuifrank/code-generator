package com.frankzhou.intelligence.bi.controller;

import com.frankzhou.common.base.ApiPageResultDTO;
import com.frankzhou.common.base.ApiResultDTO;
import com.frankzhou.common.base.DeleteRequest;
import com.frankzhou.intelligence.bi.domain.dto.chart.BiChartDTO;
import com.frankzhou.intelligence.bi.domain.dto.chart.BiChartQueryDTO;
import com.frankzhou.intelligence.bi.service.BiChartService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description BI分析和图表管理
 * @date 2024-03-01
 */
@Slf4j
@RestController
@Api(tags = "BI分析和图表管理")
@RequestMapping("/char")
public class ChartController {

    @Resource
    private BiChartService biChartService;

    @ApiOperation(value = "BI图表生成")
    @PostMapping("/gen/chart")
    public ApiResultDTO<Boolean> genBiChart(@RequestPart MultipartFile multipartFile, BiChartDTO biChartDTO, HttpServletRequest request) {
        return null;
    }

    @ApiOperation(value = "分页查询图表")
    @GetMapping("/page")
    public ApiPageResultDTO<List<BiChartDTO>> getChartPage(BiChartQueryDTO queryDTO) {
        return null;
    }

    @ApiOperation(value = "删除图表")
    @PostMapping("/delete")
    public ApiResultDTO<Boolean> deleteChart(@RequestBody DeleteRequest deleteRequest) {
        return null;
    }


}
