package com.java;

import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.yarn.webapp.hamlet.HamletSpec;

import java.io.IOException;


public class Mapper extends org.apache.hadoop.mapreduce.Mapper<LongWritable, Text, FlowBean, Text> {

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String[] split = value.toString().split("\\s");
        String phoneNum = split[0];
        FlowBean flowBean = new FlowBean();
        flowBean.setUpPackageCount(Integer.parseInt(split[1]));
        flowBean.setDownPackageCount(Integer.parseInt(split[2]));
        flowBean.setUpFlowCount(Integer.parseInt(split[3]));
        flowBean.setDownFlowCount(Integer.parseInt(split[4]));
        context.write(flowBean,new Text(phoneNum));
    }
}
