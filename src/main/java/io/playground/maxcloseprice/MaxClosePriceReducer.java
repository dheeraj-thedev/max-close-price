package io.playground.maxcloseprice;

import java.io.IOException;

import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

/**
 * This is a reducer program to calculate Max Close Price from stock dataset using MapReduce
 */
public class MaxClosePriceReducer extends Reducer<Text, FloatWritable, Text, FloatWritable> {

    @Override
    protected void reduce(Text key, Iterable<FloatWritable> values,
            Reducer<Text, FloatWritable, Text, FloatWritable>.Context context)
            throws IOException, InterruptedException {
        float maxClosePrice = Float.MIN_VALUE;
        for (FloatWritable value : values) {
            maxClosePrice = Math.max(maxClosePrice, value.get());
        }
        context.write(key, new FloatWritable(maxClosePrice));
    }

}
