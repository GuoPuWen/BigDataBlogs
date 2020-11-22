package com.java;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;

import java.io.IOException;


public class Mapper extends org.apache.hadoop.mapreduce.Mapper<LongWritable, Text, SortBean, NullWritable> {

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String[] split = value.toString().split("\t");
        SortBean sortBean = new SortBean();
        sortBean.setNum(Integer.parseInt(split[1]));
        sortBean.setWord(split[0]);
        context.write(sortBean,NullWritable.get());
    }
}
