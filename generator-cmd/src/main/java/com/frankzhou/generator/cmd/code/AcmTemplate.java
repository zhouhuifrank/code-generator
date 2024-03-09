package com.frankzhou.generator.cmd.code;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description ACM代码模板
 * @date 2024-01-21
 */
public class AcmTemplate {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            int n = scanner.nextInt();

            // 读入数据
            List<Integer> numList = new ArrayList<>();
            for (int i=0;i<n;i++) {
                int num = scanner.nextInt();
                numList.add(num);
            }

            // 循环计算
            int sum = 0;
            for (Integer num : numList) {
                sum += num;
            }

            // 打印输出
            System.out.println("数组总和为" + sum);
        }
    }
}
