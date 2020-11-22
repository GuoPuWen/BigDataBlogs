package com.java;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

public class JobMain extends Configured implements Tool {
    @Override
    public int run(String[] strings) throws Exception {
        //获取job
        Job job = Job.getInstance(super.getConf(), "Flow_Job");
        //设置输入格式
        job.setInputFormatClass(TextInputFormat.class);
        TextInputFormat.addInputPath(job, new Path(("file:///D:\\input")));
        //TextInputFormat.addInputPath(job, new Path(("hdfs://hadoop101:8020/input")));
        //设置mapper类
        job.setMapperClass(Mapper.class);
        job.setMapOutputKeyClass(FlowBean.class);
        job.setMapOutputValueClass(Text.class);
        //设置分区



        //排序，规约，分组默认
        //设置reduce类
        job.setReducerClass(Reduce.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(FlowBean.class);

        //设置输出格式
        job.setOutputFormatClass(TextOutputFormat.class);
        //TextOutputFormat.setOutputPath(job, new Path("hdfs://hadoop101:8020/out"));
        TextOutputFormat.setOutputPath(job, new Path("file:///D:\\out"));

        //等待进程结束
        boolean b = job.waitForCompletion(true);
        return b ? 1 : 0;

    }

    public static void main(String[] args) throws Exception {
        Configuration conf = new Configuration();
        ToolRunner.run(conf, new JobMain(), args);
    }

}
