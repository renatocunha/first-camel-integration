Simple project to learn Apache Camel

Start local stance of Minio (user and pass can be configured in resources/application.properties)

```docker run \
    -p 9000:9000 \
    -p 9090:9090 \
    -e "MINIO_ROOT_USER=puces" \
    -e "MINIO_ROOT_PASSWORD=puces123"  \
    quay.io/minio/minio server /data  \
    --console-address ":9090" 
```

Compile the project
```mvn compile ```

Start the application, it will generate 5 random json objects and update then in the Minio.
```mvn camel:run ``` will generate 
