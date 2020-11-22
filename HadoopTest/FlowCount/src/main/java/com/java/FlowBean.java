package com.java;

import com.sun.corba.se.spi.ior.Writeable;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.io.WritableComparable;
import org.omg.CORBA_2_3.portable.OutputStream;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class FlowBean implements WritableComparable<FlowBean> {
    private Integer upPackageCount;
    private Integer downPackageCount;
    private Integer upFlowCount;
    private Integer downFlowCount;

    public Integer getUpPackageCount() {
        return upPackageCount;
    }

    public void setUpPackageCount(Integer upPackageCount) {
        this.upPackageCount = upPackageCount;
    }

    public Integer getDownPackageCount() {
        return downPackageCount;
    }

    public void setDownPackageCount(Integer downPackageCount) {
        this.downPackageCount = downPackageCount;
    }

    public Integer getUpFlowCount() {
        return upFlowCount;
    }

    public void setUpFlowCount(Integer upFlowCount) {
        this.upFlowCount = upFlowCount;
    }

    public Integer getDownFlowCount() {
        return downFlowCount;
    }

    public void setDownFlowCount(Integer downFlowCount) {
        this.downFlowCount = downFlowCount;
    }

    @Override
    public void write(DataOutput out) throws IOException {
        out.writeInt(upPackageCount);
        out.writeInt(downPackageCount);
        out.writeInt(upFlowCount);
        out.writeInt(downFlowCount);
    }

    @Override
    public void readFields(DataInput in) throws IOException {
        this.upPackageCount = in.readInt();
        this.downPackageCount = in.readInt();
        this.upFlowCount = in.readInt();
        this.downFlowCount = in.readInt();
    }

    @Override
    public String toString() {
        return
                "" + upPackageCount +
                " " + downPackageCount +
                " " + upFlowCount +
                " " + downFlowCount ;
    }

    @Override
    public int compareTo(FlowBean o) {
        return o.getUpFlowCount() - this.upFlowCount;
    }
}
