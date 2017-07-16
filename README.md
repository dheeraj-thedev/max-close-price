# Maximum Close Price

1. SSH to linux machine for Hadoop cluster:
```
    ssh -i ~/cluster_key/hirwuser150430.pem hirwuser150430@54.85.143.224
```

2. Submit Hadoop job:
```
    hadoop jar /hirw-starterkit/mapreduce/stocks/MaxClosePrice-1.0.jar com.hirw.maxcloseprice.MaxClosePrice /user/hirw/input/stocks output/mapreduce/ak_stocks
```

