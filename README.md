# Maximum Close Price

1. SSH to linux machine for Hadoop cluster:
```
    ssh -i ~/cluster_key/hirwuser150430.pem hirwuser150430@54.85.143.224
```

2. Submit Hadoop job:
```
    hadoop jar /hirw-starterkit/mapreduce/stocks/MaxClosePrice-1.0.jar com.hirw.maxcloseprice.MaxClosePrice /user/hirw/input/stocks output/mapreduce/ak_stocks
```
### Pig Script To Compute Max Close Price By Stock Symbol ###
HDFS Input Location: `/user/hirw/input/stocks`
HDFS Output Location (relative to user): `output/pig/stocks`
Delete Output Directory: `hadoop fs -rm -r output/pig/stocks`
Submit Pig Script: `pig /hirw-starterkit/pig/stocks/max-closeprice.pig`
View Result: `hadoop fs -cat output/pig/stocks/part-r-00000`

