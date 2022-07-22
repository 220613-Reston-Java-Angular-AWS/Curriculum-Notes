# Setting Logging Threshold

A logger can be assigned a threshold level. All logging requests with level lower than this threshold will be ignored.

For example, setting logger threshold to `INFO` means that logging requests with levels `TRACE` and `DEBUG` will not be logged by this logger.

An example of setting the root logger threshold to `INFO`:
```
<configuration xmlns="http://logging.apache.org/log4php/">
    <appender name="default" class="LoggerAppenderConsole" />
    <root>
        <level value="info" />
        <appender_ref ref="default" />
    </root>
</configuration>
````

If not explicitly configured, loggers will have their threshold level set to `DEBUG` by default.