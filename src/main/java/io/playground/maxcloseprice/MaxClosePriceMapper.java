package io.playground.maxcloseprice;

import java.io.IOException;
import java.util.List;

import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import com.google.common.base.Splitter;
import com.google.common.collect.Lists;

/**
 * This is a mapper program to calculate Max Close Price from stock dataset using MapReduce
 */
public class MaxClosePriceMapper extends Mapper<LongWritable, Text, Text, FloatWritable> {

  @Override
  protected void map(LongWritable key, Text value,
      Mapper<LongWritable, Text, Text, FloatWritable>.Context context)
      throws IOException, InterruptedException {
    String line = value.toString();
    List<String> items = Lists.newArrayList(Splitter.on(',').split(line));
    String stock = items.get(1);
    Float closePrice = Float.parseFloat(items.get(6));

    context.write(new Text(stock), new FloatWritable(closePrice));

  }
}
