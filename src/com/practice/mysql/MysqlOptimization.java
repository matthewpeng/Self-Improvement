package com.practice.mysql;

/**
 * @Description:
 * @author: matthew Mysql 优化
 * @Date: 2020/3/3 13:52
 */
public class MysqlOptimization {

    /**
     *  索引是帮助MySQL高效过去数据的 排好序 的 数据结构
     *
     *  索引的数据结构
     *
     *  二叉树(单边增长就不合适)
     *  红黑树(平衡二叉树 单边增长之后 会自动平衡 数据量大 高度没法控制)
     *  Hash表(一次运算定位磁盘指针 基本不用 范围查询就又全表扫描了gg)
     *
     *  B-Tree
     *  B+Tree(MySQL官方索引用的是这个99% 3层)
     *  非叶子节点不存储data 只存储索引 可以放更多的索引
     *  叶子节点不存储指针
     *  顺序访问指针 提高区间访问的性能
     *
     *  MySQL Innodb 数据页 16kb 支撑千万级搜索
     *  索引 bigint 索引8b 指针6b 总计14b(字节)  16kb/14b=1170
     *
     *  全部存满 1170*1170*16=2000W+
     *  根节点会放入内存
     *
     *  Innodb 必须有主见 要自增不要树会分裂
     *
     *
     */

}
